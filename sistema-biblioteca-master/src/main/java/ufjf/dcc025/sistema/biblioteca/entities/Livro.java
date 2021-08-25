// JOÃO PAULO DE CARVALHO ARAÚJO - 202065564C

package ufjf.dcc025.sistema.biblioteca.entities;

/**
 *
 * @author Michel
 */
public class Livro {
    private static int idCount = 1;
    private int id;
    private String titulo;
    private String editora;
    private String ano;
    private String edicao;
    private int numPaginas;
    private String isbn;
    private String idioma;


public Livro(){

}

public Livro(String titulo, String editora, String ano, String edicao, int numPaginas, String isbn, String idioma){
    this.id = idCount;
    this.titulo = titulo;
    this.editora = editora;
    this.ano = ano;
    this.edicao = edicao;
    this.numPaginas = numPaginas;
    this.isbn = isbn;
    this.idioma = idioma;
    
 }

    /**
     * @return the idCount
     */
    public static int getIdCount() {
        return idCount;
    }

    /**
     * @param aIdCount the idCount to set
     */
    public static void setIdCount(int aIdCount) {
        idCount = aIdCount;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the edicao
     */
    public String getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the numPaginas
     */
    public int getNumPaginas() {
        return numPaginas;
    }

    /**
     * @param numPaginas the numPaginas to set
     */
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

  
}