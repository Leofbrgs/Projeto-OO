package controller;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Artista;
import model.Dados;
import model.Musica;

/**
 * Classe responsavel por controlar a logica da tela de deletar musicas.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see view.DeletarMusicaView
 * @see model.Musica
 */
public class DeletarMusicaController extends ListarMusicasController {

    public DeletarMusicaController() {
    }

    /**
     * Deleta a musica selecionada na tabela.
     * 
     * @param scroll
     * @return
     */
    public boolean deletarMusica(JScrollPane scroll) {
        int index = ((JTable) scroll.getViewport().getView()).getSelectedRow();
        String nomeArtista = ((JTable) scroll.getViewport().getView()).getValueAt(index, 3).toString();

        Musica musica = Dados.getMusicas().get(index);

        Artista artista = Dados.getArtistaByName(nomeArtista);

        if (artista != null) {
            artista.getMusicas().remove(musica);
            return true;
        }

        return false;
    }
}
