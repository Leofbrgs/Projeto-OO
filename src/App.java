import utils.Utils;
import view.MainMenuView;

/**
 * Classe principal do sistema. Responsavel por inicializar o sistema.
 */
public class App {
    public static void main(String[] args) throws Exception {
        Utils.seed(10);

        new MainMenuView();
    }
}
