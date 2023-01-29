package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ListarMusicasPorArtistaController;
import model.Dados;
import utils.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Janela de listagem de musicas filtrada por artista.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see controller.ListarMusicasPorArtistaController
 * @see model.Musica
 */
public class ListarMusicasPorArtistaView extends JFrame implements ActionListener {

    private ListarMusicasPorArtistaController controller = new ListarMusicasPorArtistaController();

    private JComboBox<String> cbxArtista = new JComboBox<>(
            Utils.createComboBoxModel(Dados.getArtistasNames()));

    private JScrollPane scroll = new JScrollPane();

    private JButton btnVerLetra = new JButton("Ver Letra");

    /**
     * Implementa a janela de listagem de musicas filtrada por artista.
     */
    public ListarMusicasPorArtistaView() {

        setTitle("Listar Musicas Por Artista");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setSize(800, 600);
        setBounds(0, 0, 800, 600);

        setLocationRelativeTo(null);
        setLayout(null);

        add(this.cbxArtista);
        this.cbxArtista.setBounds(10, 5, 300, 20);
        this.cbxArtista.addActionListener(this);

        add(btnVerLetra);
        btnVerLetra.setBounds(320, 5, 150, 20);
        btnVerLetra.addActionListener(this);

        this.updateTable();

        scroll.setBounds(0, 30, 800, 520);
        add(scroll);
    }

    /**
     * Atualiza a tabela de musicas.
     */
    private void updateTable() {
        String[] header = { "  ", "Nome", "Genero Musical", "Artista" };
        scroll.setViewportView(
                new JTable(this.controller.genMusicasTable(
                        Dados.getArtistaByName(this.cbxArtista.getSelectedItem().toString()).getMusicas(), header,
                        false)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cbxArtista) {
            this.updateTable();
        } else {
            if (e.getSource() == btnVerLetra) {
                if (((JTable) scroll.getViewport().getView()).getSelectedRow() > -1) {
                    new LetraView(scroll);
                } else {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Selecione uma musica para ver sua letra!");
                }
            }
        }

    }
}
