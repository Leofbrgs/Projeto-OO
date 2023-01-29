package model;

import java.util.ArrayList;

/**
 * Classe responsavel por representar um banco de dados.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see model.Artista
 * @see model.Musica
 * 
 */
public class Dados {
    private static final ArrayList<Artista> artistas = new ArrayList<Artista>();

    /**
     * Construtor da classe. Privado para evitar instaciacao
     */
    private Dados() {
    }

    /**
     * Metodos de acesso aos dados cadastrados
     */
    public static ArrayList<Artista> getArtistas() {
        return artistas;
    }

    /**
     * Metodos que agrupar o nome de todos os artistas em uma unica lista
     * para facilitar a busca
     * 
     * @return ArrayList<String> - Lista de nomes dos artistas
     */
    public static ArrayList<String> getArtistasNames() {
        ArrayList<String> artistsName = new ArrayList<String>();

        for (Artista artista : artistas) {
            artistsName.add(artista.getNomeArtistico());
        }

        return artistsName;
    }

    /**
     * Metodo responsavel por buscar um artista pelo nome
     * 
     * @param nome Nome do artista
     * @return Artista
     */
    public static Artista getArtistaByName(String nome) {
        for (Artista artista : artistas) {
            if (artista.getNomeArtistico().equals(nome)) {
                return artista;
            }
        }

        return null;
    }

    /**
     * Metodo responsavel por agrupar todas as musicas de todos os artistas em uma
     * unica lista
     * 
     * @return ArrayList<Musica> - Lista de todas as musicas
     */
    public static ArrayList<Musica> getMusicas() {
        ArrayList<Musica> musicas = new ArrayList<Musica>();

        for (Artista artista : artistas) {
            musicas.addAll(artista.getMusicas());
        }

        return musicas;
    }

}
