package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.CadastrarMusicaController;
import controller.ListarMusicasController;
import controller.UpdateMusicaController;

import model.Dados;
import model.Musica;
import model.enums.GeneroMusicalEnum;

import java.awt.event.ActionEvent;

/**
 * Janela de atualizar musica.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see controller.UpdateMusicaController
 * @see model.Musica
 */
public class UpdateMusicaView extends CadastrarMusicaView {

    private UpdateMusicaController controller = new UpdateMusicaController();
    private ListarMusicasController controllerList = new ListarMusicasController();
    private CadastrarMusicaController controllerCadastro = new CadastrarMusicaController();

    private JScrollPane scroll;
    private Musica musicaSelecionada;

    /**
     * Implementa a janela de atualizar musica.
     * 
     * @param scroll JScrollPane contem a musica selecionada
     */
    public UpdateMusicaView(JScrollPane scroll) {
        super();

        this.scroll = scroll;
        this.musicaSelecionada = this.controller.getMusicaSelecionada(scroll);

        setTitle("Atualizar Musica");
        getBtnCadastrarMusica().setText("Atualizar Musica");

        getTxtNome().setText(musicaSelecionada.getNome());
        getTxtLetra().setText(musicaSelecionada.getLetra());
        getCbxGeneroMusical().setSelectedItem(musicaSelecionada.getGeneroMusical().valueOf());
        getCbxArtista().setSelectedItem(musicaSelecionada.getArtista().getNomeArtistico());
        getCbxArtista().setEnabled(false);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getBtnCadastrarMusica()) {
            if (getTxtNome().getText().length() > 0 && getTxtLetra().getText().length() > 0
                    && getCbxArtista().getSelectedItem() != null && getCbxGeneroMusical().getSelectedItem() != null) {
                GeneroMusicalEnum generoEnum = this.controllerCadastro
                        .findGeneroMusical(getCbxGeneroMusical().getSelectedItem().toString());

                this.controller.updateMusica(musicaSelecionada, getTxtNome().getText(), generoEnum,
                        getTxtLetra().getText());

                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,
                        "Musica atualizada com sucesso!");

                this.scroll.setViewportView(
                        new JTable(this.controllerList.genMusicasTable(Dados.getMusicas(),
                                new String[] { "  ", "Nome", "Genero Musical", "Artista" }, false)));
                this.dispose();

            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
            }
        }
    }

}
