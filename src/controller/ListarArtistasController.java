package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Artista;

/**
 * Classe responsavel por controlar a janela de listar artistas. Gera a tabela
 * de artistas.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see view.ListarArtistasView
 * @see model.Artista
 */
public class ListarArtistasController {

    /**
     * Construtor da classe.
     */
    public ListarArtistasController() {
    }

    /**
     * Metodo responsavel por gerar a tabela de artistas.
     * 
     * @param artistas
     * @param header
     * @param isEditable
     * @return DefaultTableModel
     */
    public DefaultTableModel genArtistasTable(ArrayList<Artista> artistas, Object[] header, Boolean isEditable) {
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

        for (int i = 0; i < artistas.size(); i++) {
            Object[] data = { i + 1, artistas.get(i).getNomeArtistico(), artistas.get(i).getNomeReal(),
                    artistas.get(i).getDescricao() };
            tableModel.addRow(data);
        }

        return tableModel;
    }
}
