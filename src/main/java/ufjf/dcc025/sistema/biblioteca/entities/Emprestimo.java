// JOÃO PAULO DE CARVALHO ARAÚJO - 202065564C

package ufjf.dcc025.sistema.biblioteca.entities;

import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
    
    private static int idCount = 1;
    private int id;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean statusDevolucao;
    
    private Livro livro;
    private Funcionario funcionario;
    private Usuario usuario;
    
    public Emprestimo() {
        
    }

    public Emprestimo(Livro livro, Funcionario funcionario, Usuario usuario, int diasDevolucao) {
        Calendar cal = Calendar.getInstance();
        
        this.id = idCount;
        this.dataEmprestimo = cal.getTime();
        
        cal.add(Calendar.DAY_OF_MONTH, diasDevolucao);
        cal.set(Calendar.HOUR, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        this.dataDevolucao = cal.getTime();
        
        this.statusDevolucao = false;
        this.livro = livro;
        livro.setTotalDisponivel(livro.getTotalDisponivel() - 1);
        this.funcionario = funcionario;
        this.usuario = usuario;
        
        idCount++;
    }

    public int getId() {
        return id;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean getStatusDevolucao() {
        return statusDevolucao;
    }

    public void setStatusDevolucao(boolean statusDevolucao) {
        if (this.statusDevolucao != statusDevolucao) {
            if (statusDevolucao) {
                livro.setTotalDisponivel(livro.getTotalDisponivel() + 1);
            } else {
                livro.setTotalDisponivel(livro.getTotalDisponivel() - 1);
            }
        }
        this.statusDevolucao = statusDevolucao;
        
    }

    public Livro getLivro() {
        return livro;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }   
}
