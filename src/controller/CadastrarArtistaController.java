package controller;

import model.Artista;
import model.Dados;

/**
 * Classe responsavel por controlar a logica da tela de cadastro de artistas.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see view.CadastrarArtistaView
 * @see model.Artista
 */
public class CadastrarArtistaController {

    /**
     * Construtor da classe.
     */
    public CadastrarArtistaController() {
    }

    /**
     * Metodo responsavel por verificar se o artista ja esta cadastrado.
     * 
     * @param nome
     * @return boolean
     */
    public boolean cadastrado(String nome) {
        for (String name : Dados.getArtistasNames()) {
            if (name.equals(nome)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo responsavel por cadastrar um artista.
     * 
     * @param artista
     */
    public void cadastrarArtista(Artista artista) {

        if (this.cadastrado(artista.getNomeArtistico())) {
            return;
        }

        Dados.getArtistas().add(artista);
    }
}
