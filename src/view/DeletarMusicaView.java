package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import controller.DeletarMusicaController;
import model.Dados;

import java.awt.event.ActionEvent;

/**
 * Janela de deletar musicas.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see controller.DeletarMusicaController
 * @see view.ListarMusicasView
 * @see model.Musica
 */
public class DeletarMusicaView extends ListarMusicasView {

    private DeletarMusicaController controller = new DeletarMusicaController();

    private JButton btnDeletarMusica = new JButton("Deletar Musica");

    /**
     * Implementa a janela de deletar musicas.
     */
    public DeletarMusicaView() {
        super();
        setTitle("Deletar Musica");

        add(btnDeletarMusica);
        btnDeletarMusica.setBounds(160, 5, 150, 20);
        btnDeletarMusica.addActionListener(this);

        getBtnUpdate().setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDeletarMusica) {
            if (((JTable) getScroll().getViewport().getView()).getSelectedRow() > -1) {
                if (controller.deletarMusica(getScroll())) {
                    JFrame frame = new JFrame();

                    getScroll().setViewportView(
                            new JTable(controller.genMusicasTable(Dados.getMusicas(), getHeader(), false)));

                    JOptionPane.showMessageDialog(frame, "Musica deletada com sucesso!");
                } else {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Erro ao deletar musica!");
                }
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Selecione uma musica para deletar!");
            }
        } else {
            super.actionPerformed(e);
        }
    }
}
