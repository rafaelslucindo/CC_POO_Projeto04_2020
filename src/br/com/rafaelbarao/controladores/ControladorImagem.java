package br.com.rafaelbarao.controladores;

import br.com.rafaelbarao.interface_usuario.Console;
import br.com.rafaelbarao.objetos.Objeto;

import java.util.List;

public class ControladorImagem implements EventoCadastro, EventoMovimentacao {
    private Console console;
    private ControladorCadastro controladorCadastro;

    public ControladorImagem(Console console, ControladorCadastro controladorCadastro) {
        this.console = console;
        this.controladorCadastro = controladorCadastro;
    }

    public void desenhaObjetos(List<Objeto> listaObjetos)
    {
        console.escreveConsole("");
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

    @Override
    public void onMovimentacao() {
        desenhaObjetos(controladorCadastro.getListaObjetos());
    }
}
