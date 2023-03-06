package br.com.linhares.crisley.steps;

import br.com.linhares.crisley.entidades.Filme;
import br.com.linhares.crisley.entidades.NotaAluguel;
import br.com.linhares.crisley.entidades.TipoAlugel;
import br.com.linhares.crisley.servicos.AluguelService;
import br.com.linhares.crisley.utils.DateUtils;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private TipoAlugel tipoAlugel;

    @Dado("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(int estoque) {
        filme = new Filme();
        filme.setEstoque(estoque);
    }

    @Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
    public void queOPreçoDoAluguelSejaR$(int preco) {
        filme.setAluguel(preco);
    }

    @Dado("^um filme$")
    public void umFilme(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        filme = new Filme();
        filme.setEstoque(Integer.parseInt(map.get("estoque")));
        filme.setAluguel(Integer.parseInt(map.get("preço")));
        String tipo = map.get("tipo");
        tipoAlugel = tipo.equals("semanal")? TipoAlugel.SEMANAL: tipo.equals("extendido")? TipoAlugel.EXTENDIDO: TipoAlugel.COMUM;
    }

    @Quando("^alugar$")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme, tipoAlugel);
        } catch (RuntimeException e){
            erro = e.getMessage();
        }

    }

    @Então("^o preço do aluguel será R\\$ (\\d+)$")
    public void oPreçoDoAluguelSeráR$(int valorAluguel) {
        Assert.assertEquals(valorAluguel, nota.getPreco());
    }

    @Então("^o estoque do filme será (\\d+) unidade$")
    public void oEstoqueDoFilmeSeráUnidade(int estoque) {
        Assert.assertEquals(estoque, filme.getEstoque());
    }

    @Então("^não será possível por falta de estoque$")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assert.assertEquals("Filme sem estoque!", erro);
    }

    @Dado("^que o tipo do aluguel seja (.*)$")
    public void queOTipoDoAluguelSeja(String tipo) {
        tipoAlugel = tipo.equals("semanal")? TipoAlugel.SEMANAL: tipo.equals("extendido")? TipoAlugel.EXTENDIDO: TipoAlugel.COMUM;
    }

    @Então("^a data de entrega será em (\\d+) dias?$")
    public void aDataDeEntregaSeráEmDias(int dias) {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(dias);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Então("^a pontuação recebida será de (\\d+) pontos?$")
    public void aPontuaçãoRecebidaSeráDePontos(int pontos) {
        Assert.assertEquals(pontos, nota.getPontuacao());
    }

}
