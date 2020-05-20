package br.com.rafaelbarao.controladores;

import br.com.rafaelbarao.interface_usuario.Console;
import br.com.rafaelbarao.objetos.Objeto;

import java.util.List;

public class ControladorImagem implements EventoCadastro {
    private Console console;

    public ControladorImagem(Console console) {
        this.console = console;
    }

    public void desenhaObjetos(List<Objeto> listaObjetos)
    {
        console.escreveConsole("DESENHO");
        for(Objeto objeto : listaObjetos)
        {
            console.escreveConsole(objeto.getDescricaoPosicao());
        }
        console.escreveConsole("FIM DESENHO");
    }

    @Override
    public void onNovoCadastroRealizado(List<Objeto> listObjetos) {
        desenhaObjetos(listObjetos);
    }
}
