package br.com.linhares.crisley.servicos;

import br.com.linhares.crisley.entidades.Filme;
import br.com.linhares.crisley.entidades.NotaAluguel;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme) {
        NotaAluguel nota = new NotaAluguel();
        nota.setPreco(filme.getAluguel());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        nota.setDataEntrega(calendar.getTime());
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
