package br.com.rafaelbarao.controladores;

import br.com.rafaelbarao.objetos.Objeto;

import java.util.List;

public interface EventoCadastro {
    public void onNovoCadastroRealizado(List<Objeto> listObjetos);
}
