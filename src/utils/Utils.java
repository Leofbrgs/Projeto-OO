package utils;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import model.Artista;
import model.Dados;
import model.Musica;
import model.enums.GeneroMusicalEnum;

/**
 * Classe responsavel por agrupar metodos utilitarios
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 */
public class Utils {

    /**
     * Construtor da classe.
     */
    private Utils() {
    }

    /**
     * Metodo responsavel por popular o programa com dados genericos para fins de
     * teste
     * 
     * @param qtd Quantidade de artistas a serem registrados
     * 
     */
    public static void seed(int qtd) {
        for (int i = 0; i < qtd; i++) {
            Dados.getArtistas().add(new Artista("Artista" + i, String.valueOf(i),
                    "Descricao muito extensa para testar o limite de caracteres\nDescricao muito extensa para testar o limite de caracteres\nDescricao muito extensa para testar o limite de caracteres\nDescricao muito extensa para testar o limite de caracteres\nDescricao muito extensa para testar o limite de caracteres\nDescricao muito extensa para testar o limite de caracteres\nDescricao muito extensa para testar o limite de caracteres\nDescricao muito extensa para testar o limite de caracteres\nDescricao muito extensa para testar o limite de caracteres\nDescricao muito extensa para testar o limite de caracteres\nDescricao muito extensa para testar o limite de caracteres\nDescricao muito extensa para testar o limite de caracteres\n"));
            for (int j = 0; j < 5; j++) {
                Dados.getArtistas().get(i)
                        .adicionarMusica(new Musica("Musica" + j, GeneroMusicalEnum.values()[j],
                                "Letra da musica\nLetra da musica\nLetra da musica\nLetra da musica\nLetra da musica\n"));
            }
        }
    }

    /**
     * Metodo responsavel por agrupar os nomes de todos os generos musicais em uma
     * unica lista
     * 
     * @return ArryaList<String> - Lista de nomes dos generos musicais
     */
    public static ArrayList<String> getNomeGenerosMusicais() {
        ArrayList<String> generos = new ArrayList<String>();

        for (GeneroMusicalEnum genero : GeneroMusicalEnum.values()) {
            generos.add(genero.valueOf());
        }

        return generos;
    }

    /**
     * Metodo que cria uma DefaultComboBoxModel a partir de uma lista de Strings
     * 
     * @param items
     * @return DefaultComboBoxModel<String> - Modelo de ComboBox
     */
    public static DefaultComboBoxModel<String> createComboBoxModel(ArrayList<String> items) {
        var defaultCombo = new DefaultComboBoxModel<String>();
        for (String item : items) {
            defaultCombo.addElement(item);
        }

        return defaultCombo;
    }

}
