package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ListarMusicasController;
import model.Dados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe responsavel por gerar a janela de listar musicas.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see controller.ListarMusicasController
 * @see model.Musica
 */
public class ListarMusicasView extends JFrame implements ActionListener {
    ListarMusicasController controller = new ListarMusicasController();

    private JScrollPane scroll = new JScrollPane();
    private JButton btnVerLetra = new JButton("Ver Letra");
    private JButton btnUpdate = new JButton("Atualizar Musica");
    private String[] header = { "  ", "Nome", "Genero Musical", "Artista" };

    /**
     * Implementacao da janela de listar musicas.
     */
    public ListarMusicasView() {
        setTitle("Listar Musicas");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        add(btnVerLetra);
        btnVerLetra.setBounds(10, 5, 150, 20);
        btnVerLetra.addActionListener(this);

        add(btnUpdate);
        btnUpdate.setBounds(170, 5, 150, 20);
        btnUpdate.addActionListener(this);

        scroll.setViewportView(
                new JTable(this.controller.genMusicasTable(Dados.getMusicas(), header, false)));

        scroll.setBounds(0, 30, 800, 520);

        add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVerLetra) {
            if (((JTable) scroll.getViewport().getView()).getSelectedRow() > -1) {
                new LetraView(scroll);
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Selecione uma musica para ver sua letra!");
            }
        } else {
            if (e.getSource() == btnUpdate) {
                if (((JTable) scroll.getViewport().getView()).getSelectedRow() > -1) {
                    new UpdateMusicaView(scroll);
                } else {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Selecione uma musica para atualizar!");
                }
            }
        }
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JButton getBtnVerLetra() {
        return btnVerLetra;
    }

    public void setBtnVerLetra(JButton btnVerLetra) {
        this.btnVerLetra = btnVerLetra;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }
}
