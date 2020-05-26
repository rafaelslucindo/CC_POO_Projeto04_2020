package br.com.rafaelbarao.objetos;

import br.com.rafaelbarao.interface_usuario.Console;
import br.com.rafaelbarao.interfaces.Audio;
import br.com.rafaelbarao.interfaces.Movimentacao;

public class Animal extends Objeto implements Audio, Movimentacao {
    public Animal(int posicao) {
        super(posicao);
    }

    @Override
    public String getDescricaoPosicao() {
        return "Animal na posição " + posicao + " " + toString().split("[@]")[1];
    }

    @Override
    public void emiteSom() {
        new Console().escreveConsole("BARULHO DO ANIMAL! AHHHHH!");
    }

    @Override
    public int movimenta() {
        posicao = posicao + 2;
        return 0;
    }
}
