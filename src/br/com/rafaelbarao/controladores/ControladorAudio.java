package br.com.rafaelbarao.controladores;

import br.com.rafaelbarao.interfaces.Audio;

import java.util.List;

public class ControladorAudio {

    public void emiteSonsObjetos(List<Audio> listaDeObjetosQueTemAudio)
    {
        for(Audio objetoAudio : listaDeObjetosQueTemAudio)
        {
            objetoAudio.emiteSom();
        }
    }
}
