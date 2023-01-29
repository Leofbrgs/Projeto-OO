package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.CadastrarArtistaController;
import model.Artista;
import model.Dados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Janela do cadastro de artista.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see controller.CadastrarArtistaController
 * @see model.Artista
 */
public class CadastrarArtistaView extends JFrame implements ActionListener {

    private CadastrarArtistaController controller = new CadastrarArtistaController();

    private JLabel lblNomeArtistico = new JLabel("Nome Artistico:");
    private JLabel lblNomeReal = new JLabel("Nome Real:");
    private JLabel lblDescricao = new JLabel("Descricao:");
    private JButton btnCadastrarArtista = new JButton("Confirmar cadastro");
    private JTextField txtNomeArtistico = new JTextField();
    private JTextField txtNomeReal = new JTextField();
    private JTextArea txtDescricao = new JTextArea();

    /**
     * Construtor da classe extende JFrame e implementa ActionListener.
     */
    public CadastrarArtistaView() {
        setTitle("Cadastrar Artista");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setBounds(0, 0, 400, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        add(lblNomeArtistico);
        lblNomeArtistico.setBounds(10, 10, 300, 30);

        add(txtNomeArtistico);
        txtNomeArtistico.setBounds(10, 40, 300, 30);

        add(lblNomeReal);
        lblNomeReal.setBounds(10, 70, 300, 30);

        add(txtNomeReal);
        txtNomeReal.setBounds(10, 100, 300, 30);

        add(lblDescricao);
        lblDescricao.setBounds(10, 130, 300, 30);

        add(txtDescricao);
        txtDescricao.setBounds(10, 160, 300, 80);

        add(btnCadastrarArtista);
        btnCadastrarArtista.setBounds(10, 250, 300, 30);

        btnCadastrarArtista.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnCadastrarArtista) {
            if (this.txtNomeArtistico.getText().length() > 0 && this.txtDescricao.getText().length() > 0) {
                if (this.controller.cadastrado(this.txtNomeArtistico.getText())) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Artista de mesmo nome ja cadastrado!");
                    return;
                }

                this.controller
                        .cadastrarArtista(new Artista(this.txtNomeArtistico.getText(), this.txtNomeReal.getText(),
                                this.txtDescricao.getText()));
                JOptionPane.showMessageDialog(this, "Artista cadastrado com sucesso!\n"
                        + Dados.getArtistas().get(Dados.getArtistas().size() - 1).toString());
                this.dispose();

            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
            }
        }
    }

    public JButton getBtnCadastrarArtista() {
        return btnCadastrarArtista;
    }

    public void setBtnVerArtista(JButton btnVerArtista) {
        this.btnCadastrarArtista = btnVerArtista;
    }

    public JTextField getTxtNomeArtistico() {
        return txtNomeArtistico;
    }

    public void setTxtNomeArtistico(JTextField txtNomeArtistico) {
        this.txtNomeArtistico = txtNomeArtistico;
    }

    public JTextField getTxtNomeReal() {
        return txtNomeReal;
    }

    public void setTxtNomeReal(JTextField txtNomeReal) {
        this.txtNomeReal = txtNomeReal;
    }

    public JTextArea getTxtDescricao() {
        return txtDescricao;
    }

    public void setTxtDescricao(JTextArea txtDescricao) {
        this.txtDescricao = txtDescricao;
    }

    public CadastrarArtistaController getController() {
        return controller;
    }

}
