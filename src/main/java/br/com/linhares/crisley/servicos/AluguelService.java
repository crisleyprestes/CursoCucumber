package br.com.linhares.crisley.servicos;

import br.com.linhares.crisley.entidades.Filme;
import br.com.linhares.crisley.entidades.NotaAluguel;
import br.com.linhares.crisley.utils.DateUtils;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, String tipoAlugel) {
        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque!");

        NotaAluguel nota = new NotaAluguel();
        if("extendido".equals(tipoAlugel)) {
            nota.setPreco(filme.getAluguel() * 2);
            nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
            nota.setPontuacao(2);
        }
        else {
            nota.setPreco(filme.getAluguel());
            nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
            nota.setPontuacao(1);
        }
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
