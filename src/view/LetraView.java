package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Dados;

/**
 * Classe que implementa a janela que apresenta a letra de uma musica
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see javax.swing.JFrame
 */
public class LetraView extends JFrame {

        /**
         * Construtor da classe.
         * 
         * @param scroll ScrollPane que contem a tabela de musicas.
         */
        public LetraView(JScrollPane scroll) {

                setTitle("Letra da Musica");
                setResizable(false);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                setSize(320, 600);
                setLocationRelativeTo(null);
                setLayout(null);

                JTextField txtFieldNome = new JTextField();
                JTextField txtFieldArtista = new JTextField();
                JTextField txtGeneroMusical = new JTextField();
                JTextArea txtAreaLetra = new JTextArea();

                JScrollPane scrollLetra = new JScrollPane();

                String nomeMusica = ((JTable) scroll.getViewport().getView())
                                .getValueAt(((JTable) scroll.getViewport().getView()).getSelectedRow(), 1).toString();
                String nomeArtista = ((JTable) scroll.getViewport().getView())
                                .getValueAt(((JTable) scroll.getViewport().getView()).getSelectedRow(), 3).toString();

                String genero = ((JTable) scroll.getViewport().getView())
                                .getValueAt(((JTable) scroll.getViewport().getView()).getSelectedRow(), 2).toString();

                txtFieldNome.setBounds(10, 5, 300, 20);
                txtFieldArtista.setBounds(10, 30, 300, 20);
                txtGeneroMusical.setBounds(10, 55, 300, 20);

                txtFieldNome.setEditable(false);
                txtFieldArtista.setEditable(false);
                txtAreaLetra.setEditable(false);
                txtGeneroMusical.setEditable(false);

                scrollLetra.setBounds(10, 85, 300, 400);
                scrollLetra.setViewportView(txtAreaLetra);

                add(txtFieldNome);
                add(txtFieldArtista);
                add(txtGeneroMusical);
                add(scrollLetra);

                txtFieldNome.setText(nomeMusica);
                txtFieldArtista.setText(nomeArtista);
                txtAreaLetra.setText(
                                Dados.getMusicas().get(((JTable) scroll.getViewport().getView()).getSelectedRow())
                                                .getLetra());
                txtGeneroMusical.setText(genero);

                setVisible(true);
        }

}
