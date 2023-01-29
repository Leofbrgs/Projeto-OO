package controller;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Artista;
import model.Dados;
import model.Musica;
import model.enums.GeneroMusicalEnum;

/**
 * Classe responsavel por atualizar uma musica.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see model.Musica
 * @see model.Dados
 */
public class UpdateMusicaController {

    /**
     * Construtor da classe.
     */
    private Artista getArtista(JScrollPane scroll) {
        String nomeArtista = ((JTable) scroll.getViewport().getView())
                .getValueAt(((JTable) scroll.getViewport().getView()).getSelectedRow(), 3)
                .toString();

        return Dados.getArtistaByName(nomeArtista);
    }

    /**
     * Metodo responsavel por retornar a musica selecionada.
     * 
     * @param scroll ScrollPane que contem a tabela de musicas.
     * @return Musica selecionada.
     */
    public Musica getMusicaSelecionada(JScrollPane scroll) {
        int index = ((JTable) scroll.getViewport().getView()).getSelectedRow();

        Musica musica = Dados.getMusicas().get(index);

        Artista artista = this.getArtista(scroll);

        if (artista != null) {
            if (artista.getMusicas().contains(musica)) {
                return artista.getMusicas().get(artista.getMusicas().indexOf(musica));
            }
            return null;
        }

        return null;
    }

    /**
     * Metodo responsavel por atualizar uma musica.
     * 
     * @param musica Musica a ser atualizada.
     * @param nome   Nome da musica.
     * @param genero Genero musical da musica.
     * @param letra  Letra da musica.
     */
    public void updateMusica(Musica musica, String nome, GeneroMusicalEnum genero, String letra) {
        musica.update(nome, genero, letra);
    }

}
