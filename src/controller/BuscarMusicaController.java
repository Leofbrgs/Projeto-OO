package controller;

import java.util.ArrayList;

import model.Dados;
import model.Musica;

/**
 * Classe responsavel por controlar a janela de buscar musicas. Busca musicas
 * pelo nome.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see view.BuscarMusicaView
 * @see model.Musica
 */
public class BuscarMusicaController {

    /**
     * Construtor da classe.
     */
    public BuscarMusicaController() {
    }

    /**
     * Metodo responsavel por buscar musicas pelo nome.
     * 
     * @param nome
     * @return ArrayList<Musica>
     */
    public ArrayList<Musica> buscarMusica(String nome) {
        ArrayList<Musica> musicas = new ArrayList<Musica>();

        for (Musica musica : Dados.getMusicas()) {
            if (musica.getNome().toLowerCase().contains(nome.toLowerCase())) {
                musicas.add(musica);
            }
        }

        return musicas;
    }
}
