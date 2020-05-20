package br.com.rafaelbarao.objetos;

public class Cenario extends Objeto {
    public Cenario(int posicao) {
        super(posicao);
    }

    @Override
    public String getDescricaoPosicao() {
        return "Cenario na posição " + posicao + " " + toString().split("[@]")[1];
    }
}
