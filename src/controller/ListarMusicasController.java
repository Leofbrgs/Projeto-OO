package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Musica;

/**
 * Classe responsavel por controlar a janela de listar musicas. Gera a tabela de
 * musicas.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see view.ListarMusicasView
 * @see model.Musica
 */
public class ListarMusicasController {

    /**
     * Construtor da classe.
     */
    public ListarMusicasController() {
    }

    /**
     * Metodo responsavel por gerar a tabela de musicas.
     * 
     * @param musicas
     * @param header
     * @param isEditable
     * @return DefaultTableModel
     */
    public DefaultTableModel genMusicasTable(ArrayList<Musica> musicas, Object[] header, Boolean isEditable) {
        DefaultTableModel tableModel;

        if (isEditable) {
            tableModel = new DefaultTableModel(header, 0);
        } else {
            tableModel = new DefaultTableModel(header, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        }

        for (int i = 0; i < musicas.size(); i++) {
            Object[] data = { i + 1, musicas.get(i).getNome(), musicas.get(i).getGeneroMusical().valueOf(),
                    musicas.get(i).getArtista().getNomeArtistico() };
            tableModel.addRow(data);
        }

        return tableModel;
    }
}
