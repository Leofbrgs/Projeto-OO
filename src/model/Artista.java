package model;

import java.util.ArrayList;

/**
 * Classe responsavel por representar um artista.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see model.Musica
 */
public class Artista {

    private String nomeArtistico;
    private String nomeReal;
    private String descricao;
    private ArrayList<Musica> musicas;

    /**
     * Construtor da classe.
     *
     * @param nome      Nome artistico do artista.
     * @param nomeReal  Nome real do artista.
     * @param descricao Descricao do artista.
     */
    public Artista(String nome, String nomeReal, String descricao) {
        this.nomeArtistico = nome;
        this.nomeReal = nomeReal;
        this.descricao = descricao;
        this.musicas = new ArrayList<Musica>();
    }

    /**
     * Metodo responsavel por adicionar uma musica ao artista.
     * 
     * @param musica Musica a ser adicionada.
     */
    public void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
        musica.setArtista(this);
    }

    /**
     * Metodo responsavel por remover uma musica.
     * 
     * @param musica Musica a ser removida.
     */
    public void removerMusica(Musica musica) {
        this.musicas.remove(musica);
    }

    /**
     * Metodo responsavel por remover uma musica pelo index.
     * 
     * @param index Index da musica.
     */
    public void removerMusica(int index) {
        this.musicas.remove(index);
    }

    /**
     * Metodo responsavel por buscar uma musica pelo nome.
     * 
     * @param nome Nome da musica.
     * @return Musica encontrada.
     */
    public ArrayList<Musica> buscarMusica(String nome) {

        if (nome == null || nome.isEmpty()) {
            return this.musicas;
        }

        ArrayList<Musica> musicasEncontradas = new ArrayList<Musica>();
        for (Musica musica : this.musicas) {
            if (musica.getNome().toLowerCase().contains(nome.toLowerCase())) {
                musicasEncontradas.add(musica);
            }
        }
        return musicasEncontradas;
    }

    /**
     * Metodo responsavel por atualizar os dados do artista.
     * 
     * @param nomeReal      Nome real do artista.
     * @param nomeArtistico Nome artistico do artista.
     * @param descricao     Descricao do artista.
     */
    public void updateArtista(String nomeReal, String nomeArtistico, String descricao) {
        this.nomeReal = nomeReal;
        this.nomeArtistico = nomeArtistico;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Nome Artistico:" + nomeArtistico + "\nNome Real:" + nomeReal + "\nDescricao:\n" + descricao;
    }

    public String getNomeArtistico() {
        return nomeArtistico;
    }

    public void setNomeArtistico(String nome) {
        this.nomeArtistico = nome;
    }

    public String getNomeReal() {
        return nomeReal;
    }

    public void setNomeReal(String nacionalidade) {
        this.nomeReal = nacionalidade;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
