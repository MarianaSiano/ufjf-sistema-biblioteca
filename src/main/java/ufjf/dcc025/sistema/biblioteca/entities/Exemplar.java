package ufjf.dcc025.sistema.biblioteca.entities;

import java.util.*;
import java.lang.*;

public class Exemplar extends Livro {

    private Integer idExemplar;
    private boolean ehNaoCircula;
    private boolean disponivel;
    private Livro livro;

    public Exemplar(String nome, String autor, String editora, int quantAcervo, int quantEmprestimo, String ano, String edicao, Livro livro) {
        super(nome, autor, editora, quantAcervo, quantEmprestimo, ano, edicao);
        this.livro = livro;
    }
    
    public Integer getIdExemplar() {
        return idExemplar;
    }

    public boolean getEhAcervo() {
        if (ehNaoCircula == true && disponivel == true) {
            return true;
        } 
        
        else {
            return false;
        }
    }

    public void setEhAcervo(boolean ehAcervo) {
        boolean acervo = false;
        acervo = getEhAcervo();

        ehAcervo = acervo;
    }

    public boolean getDisponivel() {
        if (disponivel == true) {
            return disponivel;
        } else {
            return !disponivel;
        }
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Livro getLivro() {
        return livro;
    }
}