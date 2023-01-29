package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ListarArtistasController;
import controller.UpdateArtistaController;
import model.Artista;
import model.Dados;

import java.awt.event.ActionEvent;

/**
 * Janela de atualizar artista.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see controller.UpdateArtistaController
 * @see model.Artista
 */
public class UpdateArtistaView extends CadastrarArtistaView {

    private UpdateArtistaController controller = new UpdateArtistaController();
    private ListarArtistasController controllerList = new ListarArtistasController();

    private JScrollPane scroll;
    private Artista artistaSelecionado;

    /**
     * Implementa a janela de atualizar artista.
     * 
     * @param scroll
     */
    public UpdateArtistaView(JScrollPane scroll) {
        super();
        this.scroll = scroll;
        this.artistaSelecionado = this.controller.getArtistaSelecionado(scroll);

        this.setTitle("Atualizar Artista");

        this.getBtnCadastrarArtista().setText("Confirmar atualizacao");

        this.getTxtNomeReal().setText(artistaSelecionado.getNomeReal());
        this.getTxtNomeArtistico().setText(artistaSelecionado.getNomeArtistico());
        this.getTxtDescricao().setText(artistaSelecionado.getDescricao());

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.getBtnCadastrarArtista() && this.getTxtDescricao().getText().length() > 0
                && this.getTxtNomeArtistico().getText().length() > 0 && this.getTxtNomeReal().getText().length() > 0) {

            if (this.controller.updateArtista(this.artistaSelecionado, this.getTxtNomeReal().getText(),
                    this.getTxtNomeArtistico().getText(),
                    this.getTxtDescricao().getText())) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Artista atualizado com sucesso!");

                this.scroll.setViewportView(new JTable(this.controllerList.genArtistasTable(Dados.getArtistas(),
                        new String[] { "  ", "Nome Artistico", "Nome Real", "Descricao" }, false)));

                this.dispose();
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Erro ao atualizar artista!");
            }
        }
    }
}
