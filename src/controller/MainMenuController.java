package controller;

import view.BuscarMusicaView;
import view.CadastrarArtistaView;
import view.CadastrarMusicaView;
import view.DeletarArtistaView;
import view.DeletarMusicaView;
import view.ListarArtistasView;
import view.ListarMusicasPorArtistaView;
import view.ListarMusicasView;
import view.MainMenuView;

/**
 * Classe responsavel por controlar a view MainMenuView
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see view.MainMenuView
 */
public class MainMenuController {

    private MainMenuView view;
    private CadastrarArtistaView cadastrarArtistaView;
    private CadastrarMusicaView cadastrarMusicaView;
    private ListarArtistasView listarArtistasView;
    private ListarMusicasView listarMusicasView;
    private ListarMusicasPorArtistaView listarMusicasPorArtistaView;

    /**
     * Construtor da classe.
     * 
     * @param view MainMenuView
     */
    public MainMenuController(MainMenuView view) {
        this.view = view;
    }

    /**
     * Metodo responsavel por executar acoes de acordo com o botao clicado e abrir
     * novas janelas.
     * 
     * @param source
     */
    public void execute(Object source) {
        if (source == view.getBtnCadastrarArtista()) {
            this.cadastrarArtistaView = new CadastrarArtistaView();
            this.cadastrarArtistaView.setVisible(true);

        } else if (source == view.getBtnCadastrarMusica()) {
            this.cadastrarMusicaView = new CadastrarMusicaView();
            this.cadastrarMusicaView.setVisible(true);

        } else if (source == view.getBtnListarArtistas()) {
            this.listarArtistasView = new ListarArtistasView();
            this.listarArtistasView.setVisible(true);

        } else if (source == view.getBtnListarMusicas()) {
            this.listarMusicasView = new ListarMusicasView();
            this.listarMusicasView.setVisible(true);

        } else if (source == view.getBtnListarMusicasPorArtista()) {
            this.listarMusicasPorArtistaView = new ListarMusicasPorArtistaView();
            this.listarMusicasPorArtistaView.setVisible(true);

        } else if (source == view.getBtnBuscarMusica()) {
            BuscarMusicaView buscarMusicaView = new BuscarMusicaView();
            buscarMusicaView.setVisible(true);

        } else if (source == view.getBtnDelArtista()) {
            DeletarArtistaView deletarArtistaView = new DeletarArtistaView();
            deletarArtistaView.setVisible(true);

        } else if (source == view.getBtnDelMusica()) {
            DeletarMusicaView deletarMusicaView = new DeletarMusicaView();
            deletarMusicaView.setVisible(true);

        }
    }
}
