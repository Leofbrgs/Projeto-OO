package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.BuscarMusicaController;
import controller.ListarMusicasController;
import model.Musica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Janela de busca de musicas.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see controller.BuscarMusicaController
 * @see model.Musica
 */
public class BuscarMusicaView extends JFrame implements ActionListener {
    private BuscarMusicaController controller = new BuscarMusicaController();
    private ListarMusicasController controllerList = new ListarMusicasController();

    JTextField txtNomeMusica = new JTextField();
    JLabel lblNomeMusica = new JLabel("Nome da Musica:");
    JButton btnBuscarMusica = new JButton("Buscar");
    JButton btnVerLetra = new JButton("Ver Letra");

    private JScrollPane scroll = new JScrollPane();

    /**
     * Implementa a janela de busca de musicas.
     */
    public BuscarMusicaView() {
        setTitle("Buscar Musica");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);

        setBounds(0, 0, 800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        add(lblNomeMusica);
        lblNomeMusica.setBounds(10, 10, 300, 30);

        add(txtNomeMusica);
        txtNomeMusica.setBounds(10, 40, 300, 30);

        add(btnBuscarMusica);
        btnBuscarMusica.setBounds(10, 80, 300, 30);

        add(btnVerLetra);
        btnVerLetra.setBounds(450, 80, 300, 30);
        btnVerLetra.setEnabled(false);

        btnBuscarMusica.addActionListener(this);
        btnVerLetra.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscarMusica) {
            if (txtNomeMusica.getText().length() > 0) {
                ArrayList<Musica> matches = controller.buscarMusica(txtNomeMusica.getText());

                if (matches.size() > 0) {
                    String[] header = { "  ", "Nome", "Genero Musical", "Artista" };
                    scroll.setViewportView(
                            new JTable(this.controllerList.genMusicasTable(matches, header, false)));

                    scroll.setBounds(0, 120, 800, 400);

                    btnVerLetra.setEnabled(true);

                    add(scroll);
                } else {
                    scroll.setViewportView(null);
                    btnVerLetra.setEnabled(false);

                }
            }
        } else if (e.getSource() == btnVerLetra) {
            if (((JTable) scroll.getViewport().getView()).getSelectedRow() > -1) {
                new LetraView(scroll);
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Selecione uma musica para ver sua letra!");
            }
        }

    }
}
