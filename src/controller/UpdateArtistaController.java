package controller;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Artista;
import model.Dados;

/**
 * Classe responsavel por atualizar um artista.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see model.Artista
 * @see model.Dados
 */
public class UpdateArtistaController {

    /**
     * Construtor da classe.
     */
    public UpdateArtistaController() {
    }

    /**
     * Metodo responsavel por retornar o artista selecionado.
     * 
     * @param scroll
     *               - ScrollPane que contem a tabela de artistas.
     * @return Artista selecionado.
     */
    public Artista getArtistaSelecionado(JScrollPane scroll) {
        String nomeArtista = ((JTable) scroll.getViewport().getView())
                .getValueAt(((JTable) scroll.getViewport().getView()).getSelectedRow(), 1)
                .toString();

        Artista artista = Dados.getArtistaByName(nomeArtista);

        return artista;

    }

    /**
     * Metodo responsavel por atualizar um artista.
     * 
     * @param artista       Artista a ser atualizado.
     * @param nomeReal      Nome real do artista.
     * @param nomeArtistico Nome artistico do artista.
     * @param descricao     Descricao do artista.
     * @return True se o artista foi atualizado com sucesso, false caso contrario.
     */
    public boolean updateArtista(Artista artista, String nomeReal, String nomeArtistico, String descricao) {

        if (artista != null) {
            Dados.getArtistas().get(Dados.getArtistas().indexOf(artista)).updateArtista(nomeReal, nomeArtistico,
                    descricao);

            return true;
        }

        return false;
    }

}
