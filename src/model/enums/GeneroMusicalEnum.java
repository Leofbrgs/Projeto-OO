package model.enums;

/**
 * Enum responsavel por representar os generos musicais.
 * 
 * @author 4.4 - Leonardo Ferreira
 * 
 * @see model.Musica
 */
public enum GeneroMusicalEnum {
    ROCK("Rock"),
    POP("Pop"),
    MPB("MPB"),
    CLASSICA("Classica"),
    FUNK("Funk"),
    SAMBA("Samba"),
    PAGODE("Pagode"),
    AXE("Axe"),
    FORRO("Forro"),
    REGGAE("Reggae"),
    SERTANEJO("Sertanejo"),
    ELETRONICA("Eletronica");

    /**
     * Genero musica por extenso.
     */
    private String value;

    /**
     * Construtor da classe.
     * 
     * @param value
     *              - Genero musica por extenso.
     */
    private GeneroMusicalEnum(String value) {
        this.value = value;
    }

    /**
     * Metodo responsavel por retornar o genero musical por extenso.
     * 
     * @return Genero musical por extenso.
     */
    public String valueOf() {
        return this.value;
    }
}
