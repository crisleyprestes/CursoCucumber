package br.com.linhares.crisley.servicos;

import br.com.linhares.crisley.entidades.Filme;
import br.com.linhares.crisley.entidades.NotaAluguel;
import br.com.linhares.crisley.entidades.TipoAlugel;
import br.com.linhares.crisley.utils.DateUtils;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, TipoAlugel tipoAlugel) {
        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque!");

        NotaAluguel nota = new NotaAluguel();

        switch (tipoAlugel){
            case COMUM:
                nota.setPreco(filme.getAluguel());
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
                nota.setPontuacao(1);
                break;
            case EXTENDIDO:
                nota.setPreco(filme.getAluguel() * 2);
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
                nota.setPontuacao(2);
                break;
            case SEMANAL:
                nota.setPreco(filme.getAluguel() * 3);
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
                nota.setPontuacao(3);
                break;
        }
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
