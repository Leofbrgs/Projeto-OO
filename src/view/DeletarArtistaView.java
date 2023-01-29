package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.DeletarArtistaController;
import model.Dados;
import utils.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Janela de deletar artista.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see controller.DeletarArtistaController
 * @see model.Artista
 */
public class DeletarArtistaView extends JFrame implements ActionListener {

    private DeletarArtistaController controller = new DeletarArtistaController();

    private JComboBox<String> cbxArtista = new JComboBox<>(
            Utils.createComboBoxModel(Dados.getArtistasNames()));

    private JLabel lblArtista = new JLabel("Artista:");

    private JLabel lblDadosArtista = new JLabel("Dados do artista:");
    private JTextArea txtDadosArtista = new JTextArea();
    private JButton btnDeletarArtista = new JButton("Deletar artista selecionado");

    /**
     * Implementa a janela de deletar artista.
     */
    public DeletarArtistaView() {

        setTitle("Deletar Artista");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setBounds(0, 0, 400, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        add(this.lblArtista);
        add(this.cbxArtista);
        add(this.lblDadosArtista);

        this.lblArtista.setBounds(10, 10, 300, 20);
        this.cbxArtista.setBounds(10, 30, 300, 20);
        this.lblDadosArtista.setBounds(10, 60, 300, 20);

        this.txtDadosArtista.setEditable(false);
        this.txtDadosArtista.setText(Dados.getArtistaByName(this.cbxArtista.getSelectedItem().toString()).toString());
        JScrollPane scroll = new JScrollPane(this.txtDadosArtista);
        scroll.setBounds(10, 80, 375, 450);
        add(scroll);

        add(this.btnDeletarArtista);
        this.btnDeletarArtista.setBounds(10, 530, 375, 20);
        this.btnDeletarArtista.addActionListener(this);

        this.cbxArtista.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnDeletarArtista && Dados.getArtistas().size() > 0) {
            this.controller.deletarArtista(this.cbxArtista.getSelectedItem().toString());

            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Artista deletado com sucesso!");

            this.cbxArtista.setModel(Utils.createComboBoxModel(Dados.getArtistasNames()));
        }

        if (Dados.getArtistas().size() == 0) {
            this.txtDadosArtista.setText("Nenhum artista cadastrado.");
        }

        if (this.cbxArtista.getSelectedItem() != null) {
            this.txtDadosArtista
                    .setText(Dados.getArtistaByName(this.cbxArtista.getSelectedItem().toString()).toString());
        }

    }

}
