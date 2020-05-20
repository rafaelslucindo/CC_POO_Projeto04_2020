package br.com.rafaelbarao.objetos;

public abstract class Objeto {
    protected int posicao;

    public Objeto(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return posicao;
    }

    public abstract String getDescricaoPosicao();
}
