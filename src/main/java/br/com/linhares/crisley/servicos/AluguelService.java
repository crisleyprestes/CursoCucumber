package br.com.linhares.crisley.servicos;

import br.com.linhares.crisley.entidades.Filme;
import br.com.linhares.crisley.entidades.NotaAluguel;
import br.com.linhares.crisley.utils.DateUtils;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme) {
        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque!");

        NotaAluguel nota = new NotaAluguel();
        nota.setPreco(filme.getAluguel());
        nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
