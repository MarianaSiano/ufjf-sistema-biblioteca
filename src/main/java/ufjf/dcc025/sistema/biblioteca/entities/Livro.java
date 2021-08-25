// JOÃO PAULO DE CARVALHO ARAÚJO - 202065564C

package ufjf.dcc025.sistema.biblioteca.entities;

public class Livro {
    
    private static int idCount = 1;
    private int id;
    private String nome;
    private String autor;
    private String editora;
    private String ano;
    private int quantAcervo;
    private int quantEmprestimo;
    private int totalDisponivel;
    private String edicao;
    
    public Livro() {
        
    }

    public Livro(String nome, String autor, String editora, int quantAcervo, int quantEmprestimo, String ano, String edicao) {
        this.id = idCount;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.quantAcervo = quantAcervo;
        this.quantEmprestimo = quantEmprestimo;
        this.totalDisponivel = quantEmprestimo;
        this.ano = ano;
        this.edicao = edicao;
        idCount++;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public int getId() {
        return id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getTotalDisponivel() {
        return  this.totalDisponivel;
    }

    public void setTotalDisponivel(int totalDisponivel) {
        this.totalDisponivel = totalDisponivel;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getQuantAcervo() {
        return quantAcervo;
    }

    public void setQuantAcervo(int quantAcervo) {
        this.quantAcervo = quantAcervo;
    }

    public int getQuantEmprestimo() {
        return quantEmprestimo;
    }

    public void setQuantEmprestimo(int quantEmprestimo) {
        this.quantEmprestimo = quantEmprestimo;
    }
}
