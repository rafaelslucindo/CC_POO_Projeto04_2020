package br.com.rafaelbarao;

import br.com.rafaelbarao.controladores.*;
import br.com.rafaelbarao.interface_usuario.Console;
import br.com.rafaelbarao.interface_usuario.Menu;
import br.com.rafaelbarao.interface_usuario.OpcaoMenu;
import br.com.rafaelbarao.objetos.Objeto;

import java.util.ArrayList;
import java.util.List;

public class Program implements EventoCadastro {
    private static final List<OpcaoMenu> MENU_PRINCIPAL = new ArrayList<>();
    private static final Console console = new Console();
    private static final Menu menu = new Menu(console);
    private static final ControladorCadastro controladorCadastro = new ControladorCadastro(console);
    private static final ControladorAudio controladorAudio = new ControladorAudio();
    private static final ControladorMovimentacao controladorMovimentacao = new ControladorMovimentacao();
    private static final ControladorImagem controladorImagem = new ControladorImagem(console);

    public void run() {
        inicializaMenu();
        controladorCadastro.adicionaObservador(controladorImagem);
        controladorCadastro.adicionaObservador(this);
        exibeMenuPrincipal();
    }

    private void inicializaMenu()
    {
        MENU_PRINCIPAL.add(new OpcaoMenu(1, "Cadastrar Personagem"));
        MENU_PRINCIPAL.add(new OpcaoMenu(2, "Cadastrar Cenario"));
        MENU_PRINCIPAL.add(new OpcaoMenu(3, "Cadastrar Animal"));
        MENU_PRINCIPAL.add(new OpcaoMenu(4, "Emitir Sons dos Objetos"));
        MENU_PRINCIPAL.add(new OpcaoMenu(5, "Movimenta Objetos"));
        MENU_PRINCIPAL.add(new OpcaoMenu(6, "Desenha Objetos"));
        MENU_PRINCIPAL.add(new OpcaoMenu(99, "SAIR"));
    }

    private static void exibeMenuPrincipal() {
        OpcaoMenu opcaoSelecionada;
        do {
            opcaoSelecionada = menu.imprimeMenuLeOpcaoValida(MENU_PRINCIPAL);
            switch (opcaoSelecionada.getOpcao()) {
                case 1:
                    controladorCadastro.cadastraPersonagem();
                    break;
                case 2:
                    controladorCadastro.cadastraCenario();
                    break;
                case 3:
                    controladorCadastro.cadastraAnimal();
                    break;
                case 4:
                    controladorAudio.emiteSonsObjetos(controladorCadastro.getListaObjetosQueEmitemSom());
                    break;
                case 5:
                    controladorMovimentacao.movimentaObjetos(controladorCadastro.getListaObjetosQueMovimentam());
                    break;
                case 6:
                    controladorImagem.desenhaObjetos(controladorCadastro.getListaObjetos());
                    break;
            }
        } while (!opcaoSelecionada.getOpcao().equals(99));
    }

    @Override
    public void onNovoCadastroRealizado(List<Objeto> listObjetos) {
        console.escreveConsole("UHU UM NOVO OBJETO FOI INSERIDO");
    }
}
