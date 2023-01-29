package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.CadastrarMusicaController;
import model.Artista;
import model.Dados;
import model.Musica;
import model.enums.GeneroMusicalEnum;
import utils.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Janela do cadastro de musica.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see controller.CadastrarMusicaController
 * @see model.Musica
 */
public class CadastrarMusicaView extends JFrame implements ActionListener {

    private CadastrarMusicaController controller = new CadastrarMusicaController();

    private JLabel lblNome = new JLabel("Nome:");
    private JLabel lblArtista = new JLabel("Artista:");
    private JLabel lblLetra = new JLabel("Letra");
    private JLabel lblGeneroMusical = new JLabel("Genero Musical");
    private JButton btnCadastrarMusica = new JButton("Confirmar cadastro");
    private JTextField txtNome = new JTextField();
    private JComboBox<String> cbxArtista = new JComboBox<>(
            Utils.createComboBoxModel(Dados.getArtistasNames()));
    private JComboBox<String> cbxGeneroMusical = new JComboBox<>(
            Utils.createComboBoxModel(Utils.getNomeGenerosMusicais()));
    private JTextArea txtLetra = new JTextArea();

    /**
     * Construtor da classe extende JFrame e implementa ActionListener.
     */
    public CadastrarMusicaView() {
        setTitle("Cadastrar Musica");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setBounds(0, 0, 400, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        add(this.lblNome);
        add(this.lblArtista);
        add(this.lblLetra);
        add(this.btnCadastrarMusica);
        add(this.txtNome);
        add(this.cbxArtista);
        add(this.cbxGeneroMusical);
        add(this.txtLetra);
        add(this.lblGeneroMusical);

        this.lblNome.setBounds(10, 10, 300, 20);
        this.txtNome.setBounds(10, 30, 300, 20);
        this.lblArtista.setBounds(10, 60, 300, 20);
        this.cbxArtista.setBounds(10, 80, 300, 20);
        this.lblGeneroMusical.setBounds(10, 110, 300, 20);
        this.cbxGeneroMusical.setBounds(10, 130, 300, 20);
        this.lblLetra.setBounds(10, 160, 300, 20);
        this.txtLetra.setBounds(10, 180, 300, 300);
        this.btnCadastrarMusica.setBounds(10, 490, 300, 20);

        this.btnCadastrarMusica.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.btnCadastrarMusica) {
            if (this.txtNome.getText().length() > 0 && this.txtLetra.getText().length() > 0
                    && this.cbxArtista.getSelectedItem() != null && this.cbxGeneroMusical.getSelectedItem() != null) {
                GeneroMusicalEnum generoEnum = this.controller
                        .findGeneroMusical(this.cbxGeneroMusical.getSelectedItem().toString());
                Artista artista = Dados.getArtistaByName(this.cbxArtista.getSelectedItem().toString());

                this.controller.cadastrarMusica(new Musica(this.txtNome.getText(), generoEnum, this.txtLetra.getText()),
                        artista);

                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,
                        "Musica cadastrada com sucesso!\n\n" + "Nome:"
                                + artista.getMusicas().get(artista.getMusicas().size() - 1).getNome() + "\n"
                                + "Artista:" + artista.getNomeArtistico() + "\n" + "Genero Musical:"
                                + artista.getMusicas().get(artista.getMusicas().size() - 1).getGeneroMusical().valueOf()
                                + "\n"
                                + "Letra:\n" + artista.getMusicas().get(artista.getMusicas().size() - 1).getLetra());
                this.dispose();

            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
            }
        }
    }

    public JButton getBtnCadastrarMusica() {
        return btnCadastrarMusica;
    }

    public void setBtnCadastrarMusica(JButton btnCadastrarMusica) {
        this.btnCadastrarMusica = btnCadastrarMusica;
    }

    public JComboBox<String> getCbxArtista() {
        return cbxArtista;
    }

    public void setCbxArtista(JComboBox<String> cbxArtista) {
        this.cbxArtista = cbxArtista;
    }

    public JComboBox<String> getCbxGeneroMusical() {
        return cbxGeneroMusical;
    }

    public void setCbxGeneroMusical(JComboBox<String> cbxGeneroMusical) {
        this.cbxGeneroMusical = cbxGeneroMusical;
    }

    public JLabel getLblArtista() {
        return lblArtista;
    }

    public void setLblArtista(JLabel lblArtista) {
        this.lblArtista = lblArtista;
    }

    public JLabel getLblGeneroMusical() {
        return lblGeneroMusical;
    }

    public void setLblGeneroMusical(JLabel lblGeneroMusical) {
        this.lblGeneroMusical = lblGeneroMusical;
    }

    public JLabel getLblLetra() {
        return lblLetra;
    }

    public void setLblLetra(JLabel lblLetra) {
        this.lblLetra = lblLetra;
    }

    public JLabel getLblNome() {
        return lblNome;
    }

    public void setLblNome(JLabel lblNome) {
        this.lblNome = lblNome;
    }

    public JTextArea getTxtLetra() {
        return txtLetra;
    }

    public void setTxtLetra(JTextArea txtLetra) {
        this.txtLetra = txtLetra;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
    }

}
