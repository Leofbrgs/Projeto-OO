package controller;

import model.Dados;

/**
 * Classe responsavel por controlar a logica da tela de deletar artistas.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see view.DeletarArtistaView
 * @see model.Artista
 */
public class DeletarArtistaController {

    /**
     * Construtor da classe.
     */
    public DeletarArtistaController() {
    }

    /**
     * Metodo responsavel por deletar um artista.
     * 
     * @param nome
     */
    public void deletarArtista(String nome) {
        Dados.getArtistas().remove((Dados.getArtistaByName(nome)));
    }
}
