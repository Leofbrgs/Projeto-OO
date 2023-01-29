package controller;

import model.Artista;
import model.Musica;
import model.enums.GeneroMusicalEnum;

/**
 * Classe responsavel por controlar a logica da tela de cadastro de musicas.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see view.CadastrarMusicaView
 * @see model.Musica
 */
public class CadastrarMusicaController {

    /**
     * Construtor da classe.
     */
    public CadastrarMusicaController() {
    }

    /**
     * Metodo responsavel por verificar se a musica ja esta cadastrada.
     * 
     * @param Musica,Artista
     */
    public void cadastrarMusica(Musica musica, Artista artista) {
        artista.adicionarMusica(musica);
    }

    /**
     * Metodo que acha o genero musical de acordo com o nome passado por parâmetro.
     * 
     * @param nome
     * @return GeneroMusicalEnum
     */
    public GeneroMusicalEnum findGeneroMusical(String nome) {
        for (GeneroMusicalEnum genero : GeneroMusicalEnum.values()) {
            if (genero.valueOf().equals(nome)) {
                return genero;
            }
        }
        return null;
    }

}
