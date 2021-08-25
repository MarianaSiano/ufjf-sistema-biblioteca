// JOÃO PAULO DE CARVALHO ARAÚJO - 202065564C

package ufjf.dcc025.sistema.biblioteca.entities;

public class Usuario {
    
    private static int idCount;
    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String senha;
    
    public Usuario() {
        
    }

    public Usuario(String nome, String cpf, String dataNascimento, String senha) {
        this.id = idCount;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        
        idCount++;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Usuario.idCount = idCount;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", senha=" + senha + '}';
    }
}
