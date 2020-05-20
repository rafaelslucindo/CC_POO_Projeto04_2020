package br.com.rafaelbarao.controladores;

import br.com.rafaelbarao.interface_usuario.Console;
import br.com.rafaelbarao.interfaces.Audio;
import br.com.rafaelbarao.interfaces.Movimentacao;
import br.com.rafaelbarao.objetos.Animal;
import br.com.rafaelbarao.objetos.Cenario;
import br.com.rafaelbarao.objetos.Objeto;
import br.com.rafaelbarao.objetos.Personagem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorCadastro {
    private List<Objeto> listaObjetos;
    private List<EventoCadastro> listaObservadores;
    private Console console;

    public ControladorCadastro(Console console) {
        listaObjetos = new ArrayList<>();
        listaObservadores = new ArrayList<>();
        this.console = console;
    }

    public void cadastraCenario() {
        listaObjetos.add(new Cenario(getPosicaoInicial()));
        avisaSucessoCadastro();
    }

    public void cadastraPersonagem() {
        listaObjetos.add(new Personagem(getPosicaoInicial()));
        avisaSucessoCadastro();
    }

    public void cadastraAnimal() {
        listaObjetos.add(new Animal(getPosicaoInicial()));
        avisaSucessoCadastro();
    }

    private void avisaSucessoCadastro() {
        console.escreveConsole("Cadastro Realizado com Sucesso");
        notificaNovoCadastro();
    }

    private int getPosicaoInicial() {
        console.escreveConsole("Informe a posicao inicial");
        return console.leNumeroInteiro();
    }

    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public List<Audio> getListaObjetosQueEmitemSom() {
        List<Audio> retorno = new ArrayList<>();
        for (Objeto objeto : listaObjetos) {
            if(objeto instanceof Audio)
                retorno.add((Audio) objeto);
        }
        return retorno;
    }

    public List<Movimentacao> getListaObjetosQueMovimentam() {
        List<Movimentacao> retorno = new ArrayList<>();
        for (Objeto objeto : listaObjetos) {
            if(objeto instanceof Movimentacao)
                retorno.add((Movimentacao) objeto);
        }
        return retorno;
    }

    private void notificaNovoCadastro()
    {
        for(EventoCadastro observador : listaObservadores)
        {
            observador.onNovoCadastroRealizado(listaObjetos);
        }
    }

    public void adicionaObservador(EventoCadastro eventoCadastro)
    {
        listaObservadores.add(eventoCadastro);
    }

    public void removeObservador(EventoCadastro eventoCadastro)
    {
        listaObservadores.remove(eventoCadastro);
    }
}
