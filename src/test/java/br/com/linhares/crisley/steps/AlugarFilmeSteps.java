package br.com.linhares.crisley.steps;

import br.com.linhares.crisley.entidades.Filme;
import br.com.linhares.crisley.entidades.NotaAluguel;
import br.com.linhares.crisley.servicos.AluguelService;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

import java.util.Calendar;
import java.util.Date;

public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;

    @Dado("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(int estoque) {
        filme = new Filme();
        filme.setEstoque(estoque);
    }

    @Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
    public void queOPreçoDoAluguelSejaR$(int preco) {
        filme.setAluguel(preco);
    }

    @Quando("^alugar$")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme);
        } catch (RuntimeException e){
            erro = e.getMessage();
        }

    }

    @Então("^o preço do aluguel será R\\$ (\\d+)$")
    public void oPreçoDoAluguelSeráR$(int valorAluguel) {
        Assert.assertEquals(valorAluguel, nota.getPreco());
    }

    @Então("^a data de entrega será no dia seguinte$")
    public void aDataDeEntregaSeráNoDiaSeguinte() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        Date dataRetorno = nota.getDataEntrega();
        Calendar calendarRetorno = Calendar.getInstance();
        calendarRetorno.setTime(dataRetorno);

        Assert.assertEquals(calendar.get(Calendar.DAY_OF_MONTH), calendarRetorno.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(calendar.get(Calendar.MONTH), calendarRetorno.get(Calendar.MONTH));
        Assert.assertEquals(calendar.get(Calendar.YEAR), calendarRetorno.get(Calendar.YEAR));
    }

    @Então("^o estoque do filme será (\\d+) unidade$")
    public void oEstoqueDoFilmeSeráUnidade(int estoque) {
        Assert.assertEquals(estoque, filme.getEstoque());
    }

    @Então("^não será possível por falta de estoque$")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assert.assertEquals("Filme sem estoque!", erro);
    }
}
