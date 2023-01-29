package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ListarArtistasController;
import model.Dados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe responsavel por gerar a janela de listar artistas.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see controller.ListarArtistasController
 * @see model.Artista
 */
public class ListarArtistasView extends JFrame implements ActionListener {

    ListarArtistasController controller = new ListarArtistasController();

    private JScrollPane scroll = new JScrollPane();
    private JButton btnVerArtista = new JButton("Ver Artista");
    private JButton btnUpdateArtista = new JButton("Atualizar Artista");

    /**
     * Implementacao da janela de listar artistas.
     */
    public ListarArtistasView() {
        setTitle("Listar Artistas");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        add(btnVerArtista);
        btnVerArtista.setBounds(10, 5, 150, 20);
        btnVerArtista.addActionListener(this);

        add(btnUpdateArtista);
        btnUpdateArtista.setBounds(170, 5, 150, 20);
        btnUpdateArtista.addActionListener(this);

        String[] header = { "  ", "Nome Artistico", "Nome Real", "Descricao" };
        scroll.setViewportView(
                new JTable(this.controller.genArtistasTable(Dados.getArtistas(), header, false)));

        scroll.setBounds(0, 30, 800, 520);

        add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVerArtista) {

            if ((((JTable) scroll.getViewport().getView())).getSelectedRow() > -1) {
                new ArtistaView(scroll);
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Selecione um artista para ver suas informacoes!");
            }

        } else if (e.getSource() == btnUpdateArtista) {
            if ((((JTable) scroll.getViewport().getView())).getSelectedRow() > -1) {
                new UpdateArtistaView(scroll);
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Selecione um artista para atualizar suas informacoes!");
            }
        }
    }

    public JButton getBtnVerArtista() {
        return btnVerArtista;
    }

    public void setBtnVerArtista(JButton btnVerArtista) {
        this.btnVerArtista = btnVerArtista;
    }

}
