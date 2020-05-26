package br.com.rafaelbarao.controladores;

import br.com.rafaelbarao.interfaces.Movimentacao;

import java.util.List;

public class ControladorMovimentacao {

    private EventoMovimentacao observador;

    public void movimentaObjetos(List<Movimentacao> listaParaMovimentacao) {
        for (Movimentacao movimentacao : listaParaMovimentacao) {
            movimentacao.movimenta();
        }
        //
        if (observador != null)
            observador.onMovimentacao();
    }

    public void setObservador(EventoMovimentacao observador) {
        this.observador = observador;
    }
}
