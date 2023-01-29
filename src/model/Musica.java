package model;

import model.enums.GeneroMusicalEnum;

/**
 * Classe responsavel por representar uma musica.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see model.Artista
 */
public class Musica {

    /* Atributos */
    private String nome;
    private GeneroMusicalEnum generoMusical;
    private Artista artista;
    private String letra;

    /**
     * Construtor da classe.
     * 
     * @param nome
     * @param generoMusical
     * @param letra
     */
    public Musica(String nome, GeneroMusicalEnum generoMusical, String letra) {
        this.nome = nome;
        this.generoMusical = generoMusical;
        this.letra = letra;
    }

    /**
     * Metodo responsavel por atualizar os dados da musica.
     * 
     * @param nome
     * @param generoMusical
     * @param letra
     */
    public void update(String nome, GeneroMusicalEnum generoMusical, String letra) {
        this.nome = nome;
        this.generoMusical = generoMusical;
        this.letra = letra;
    }

    /* Getters e Setters */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GeneroMusicalEnum getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(GeneroMusicalEnum generoMusical) {
        this.generoMusical = generoMusical;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    /* toString */
    @Override
    public String toString() {
        return this.nome + " - " + this.artista.getNomeArtistico();
    }
}
