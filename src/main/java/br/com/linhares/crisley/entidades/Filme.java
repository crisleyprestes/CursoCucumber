package br.com.linhares.crisley.entidades;

public class Filme {

    private int estoque;
    private int preco;

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setAluguel(int preco) {
        this.preco = preco;
    }

    public int getAluguel(){
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }
}
