package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ListarMusicasController;
import model.Dados;
import model.Musica;

/**
 * Classe que implementa a janela que apresenta as informacoes de um artista
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see javax.swing.JFrame
 */
public class ArtistaView extends JFrame {

        private ListarMusicasController controllerList = new ListarMusicasController();

        private JTextField txtNome = new JTextField();
        private JTextField txtNomeReal = new JTextField();
        private JTextArea txtDescricao = new JTextArea();

        private JScrollPane scrollMusicas = new JScrollPane();
        private JScrollPane scrollDescricao = new JScrollPane();

        /**
         * Construtor da classe.
         * 
         * @param scroll ScrollPane que contem a tabela de artistas.
         */
        public ArtistaView(JScrollPane scroll) {
                setTitle("Artista");
                setResizable(false);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                setSize(800, 600);
                setLocationRelativeTo(null);
                setLayout(null);

                String nome = ((JTable) scroll.getViewport().getView())
                                .getValueAt(((JTable) scroll.getViewport().getView()).getSelectedRow(), 1).toString();

                String nomeReal = ((JTable) scroll.getViewport().getView())
                                .getValueAt(((JTable) scroll.getViewport().getView()).getSelectedRow(), 2).toString();

                String descricao = ((JTable) scroll.getViewport().getView())
                                .getValueAt(((JTable) scroll.getViewport().getView()).getSelectedRow(), 3).toString();

                ArrayList<Musica> musicas = Dados.getArtistaByName(nome).getMusicas();

                if (musicas.size() > 0) {
                        String[] header = { "  ", "Nome", "Genero Musical", "Artista" };
                        scrollMusicas.setViewportView(
                                        new JTable(this.controllerList.genMusicasTable(musicas, header, false)));

                        scrollMusicas.setBounds(0, 120, 800, 500);

                        add(scrollMusicas);
                }

                txtNome.setBounds(10, 5, 800, 20);
                txtNomeReal.setBounds(10, 30, 800, 20);
                scrollDescricao.setBounds(10, 55, 600, 60);

                txtNome.setEditable(false);
                txtNomeReal.setEditable(false);
                txtDescricao.setEditable(false);

                scrollDescricao.setViewportView(txtDescricao);

                add(txtNome);
                add(txtNomeReal);
                add(scrollDescricao);

                txtNome.setText(nome);
                txtNomeReal.setText(nomeReal);
                txtDescricao.setText(descricao);

                setVisible(true);
        }
}
