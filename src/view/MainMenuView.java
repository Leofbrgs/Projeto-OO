package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.MainMenuController;
import model.Dados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Janela principal do programa.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see controller.MainMenuController
 */
public class MainMenuView extends JFrame implements ActionListener {

    private MainMenuController controller = new MainMenuController(this);

    private JLabel lblBemVindo = new JLabel("Seja bem vindo ao catalogo de musicas!");
    private JLabel lblBackground = new JLabel();
    private JButton btnCadastrarArtista = new JButton("Cadastrar Artista");
    private JButton btnCadastrarMusica = new JButton("Cadastrar Musica");
    private JButton btnListarArtistas = new JButton("Listar Artistas");
    private JButton btnListarMusicas = new JButton("Listar Musicas");
    private JButton btnListarMusicasPorArtista = new JButton("Listar Musicas por Artista");
    private JButton btnBuscarMusica = new JButton("Buscar Musica");
    private JButton btnDelArtista = new JButton("Deletar Artista");
    private JButton btnDelMusica = new JButton("Deletar Musica");

    /**
     * Construtor da classe extende JFrame e implementa ActionListener.
     */
    public MainMenuView() {
        setTitle("4.4 - Catalogo de Letras de Musica");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1350, 750);
        setBounds(0, 0, 1350, 750);
        setLocationRelativeTo(null);
        setLayout(null);

        add(lblBemVindo);
        lblBemVindo.setBounds(10, 10, 600, 45);
        lblBemVindo.setForeground(Color.WHITE);
        lblBemVindo.setFont(new java.awt.Font("Arial", 1, 20));

        add(btnCadastrarArtista);
        btnCadastrarArtista.setBounds(10, 60, 300, 45);
        btnCadastrarArtista.addActionListener(this);

        add(btnCadastrarMusica);
        btnCadastrarMusica.setBounds(10, 110, 300, 45);
        btnCadastrarMusica.addActionListener(this);

        add(btnListarArtistas);
        btnListarArtistas.setBounds(10, 160, 300, 45);
        btnListarArtistas.addActionListener(this);

        add(btnListarMusicas);
        btnListarMusicas.setBounds(10, 210, 300, 45);
        btnListarMusicas.addActionListener(this);

        add(btnListarMusicasPorArtista);
        btnListarMusicasPorArtista.setBounds(10, 260, 300, 45);
        btnListarMusicasPorArtista.addActionListener(this);

        add(btnBuscarMusica);
        btnBuscarMusica.setBounds(10, 310, 300, 45);
        btnBuscarMusica.addActionListener(this);

        add(btnDelArtista);
        btnDelArtista.setBounds(10, 360, 300, 45);
        btnDelArtista.addActionListener(this);

        add(btnDelMusica);
        btnDelMusica.setBounds(10, 410, 300, 45);
        btnDelMusica.addActionListener(this);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("./resources/imgs/background.jpg")));
        add(lblBackground);
        lblBackground.setBounds(0, 0, 1600, 889);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Dados.getArtistas().isEmpty() && (e.getSource() == btnDelArtista || e.getSource() == btnDelMusica
                || e.getSource() == btnListarMusicasPorArtista || e.getSource() == btnCadastrarMusica)) {

            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Cadastre um artista antes de continuar!");
            return;
        }

        if (Dados.getMusicas().isEmpty() && e.getSource() == btnBuscarMusica) {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Cadastre uma musica antes de continuar!");
            return;
        }

        controller.execute(e.getSource());

    }

    public JLabel getLblBemVindo() {
        return lblBemVindo;
    }

    public void setLblBemVindo(JLabel lblBemVindo) {
        this.lblBemVindo = lblBemVindo;
    }

    public JLabel getLblBackground() {
        return lblBackground;
    }

    public void setLblBackground(JLabel lblBackground) {
        this.lblBackground = lblBackground;
    }

    public JButton getBtnCadastrarArtista() {
        return btnCadastrarArtista;
    }

    public void setBtnCadastrarArtista(JButton btnCadastrarArtista) {
        this.btnCadastrarArtista = btnCadastrarArtista;
    }

    public JButton getBtnCadastrarMusica() {
        return btnCadastrarMusica;
    }

    public void setBtnCadastrarMusica(JButton btnCadastrarMusica) {
        this.btnCadastrarMusica = btnCadastrarMusica;
    }

    public JButton getBtnListarArtistas() {
        return btnListarArtistas;
    }

    public void setBtnListarArtistas(JButton btnListarArtistas) {
        this.btnListarArtistas = btnListarArtistas;
    }

    public JButton getBtnListarMusicas() {
        return btnListarMusicas;
    }

    public void setBtnListarMusicas(JButton btnListarMusicas) {
        this.btnListarMusicas = btnListarMusicas;
    }

    public JButton getBtnListarMusicasPorArtista() {
        return btnListarMusicasPorArtista;
    }

    public void setBtnListarMusicasPorArtista(JButton btnListarMusicasPorArtista) {
        this.btnListarMusicasPorArtista = btnListarMusicasPorArtista;
    }

    public JButton getBtnDelArtista() {
        return btnDelArtista;
    }

    public void setBtnDelArtista(JButton btnDelArtista) {
        this.btnDelArtista = btnDelArtista;
    }

    public JButton getBtnDelMusica() {
        return btnDelMusica;
    }

    public void setBtnDelMusica(JButton btnDelMusica) {
        this.btnDelMusica = btnDelMusica;
    }

    public JButton getBtnBuscarMusica() {
        return btnBuscarMusica;
    }

    public void setBtnBuscarMusica(JButton btnBuscarMusica) {
        this.btnBuscarMusica = btnBuscarMusica;
    }

}
