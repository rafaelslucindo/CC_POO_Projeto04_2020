package br.com.rafaelbarao.controladores;

import br.com.rafaelbarao.interfaces.Movimentacao;

import java.util.List;

public class ControladorMovimentacao {
    public void movimentaObjetos(List<Movimentacao> listaParaMovimentacao) {
        for (Movimentacao movimentacao : listaParaMovimentacao) {
            movimentacao.movimenta();
        }
    }
}
