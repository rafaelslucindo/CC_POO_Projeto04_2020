package br.com.rafaelbarao.objetos;

import br.com.rafaelbarao.interface_usuario.Console;
import br.com.rafaelbarao.interfaces.Audio;
import br.com.rafaelbarao.interfaces.Movimentacao;

public class Personagem extends Objeto implements Audio, Movimentacao {
    public Personagem(int posicao) {
        super(posicao);
    }

    @Override
    public void emiteSom() {
        new Console().escreveConsole("BLABLABLABLA");
    }

    @Override
    public int movimenta() {
        posicao++;
        return posicao;
    }

    @Override
    public String getDescricaoPosicao() {
        return "Personagem na posição " + posicao + " " + toString().split("[@]")[1];
    }
}
