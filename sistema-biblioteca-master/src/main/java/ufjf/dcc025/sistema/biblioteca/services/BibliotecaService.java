// JOÃO PAULO DE CARVALHO ARAÚJO - 202065564C

package ufjf.dcc025.sistema.biblioteca.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import ufjf.dcc025.sistema.biblioteca.entities.Emprestimo;
import ufjf.dcc025.sistema.biblioteca.entities.Funcionario;
import ufjf.dcc025.sistema.biblioteca.entities.Livro;
import ufjf.dcc025.sistema.biblioteca.entities.Usuario;

public class BibliotecaService {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static ObjectMapper mapper = new ObjectMapper();
    
    private static List<Usuario> usuarios = new ArrayList<Usuario>();
    private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private static List<Livro> livros = new ArrayList<Livro>();
    private static List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    
    private static Usuario usrLogado;
    private static Funcionario funcLogado;

    public static void startUp() {
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        loadIdCountUsuarios();
        loadFuncionarios();
        loadUsuarios();
        loadLivros();
        loadEmprestimos();
    }
    
    public static void loadIdCountUsuarios() {
        File f = new File("idCountUsuarios.txt");
        String data = "";
        
        if(f.exists() && !f.isDirectory()) {             
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                data = br.readLine();    
                if (!data.equals("")) {
                    Usuario.setIdCount(Integer.parseInt(data));
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo idCountUsuarios.txt!");
            }
        } else {
            seedIdCountUsuarios();
        }        
    }
    
    public static void loadUsuarios() {
        File f = new File("usuarios.txt");
        String json = "";
        
        if(f.exists() && !f.isDirectory()) {             
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                json = br.readLine();    
                if (!json.equals("")) {
                    Usuario [] u = mapper.readValue(json, Usuario[].class);                
                    usuarios = new ArrayList<Usuario>(Arrays.asList(u));
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo usuarios.txt!");
            }
        } else {
            seedUsuarios();
        }        
    }
    
    public static void loadFuncionarios() {
        File f = new File("funcionarios.txt");
        String json = "";
        
        if(f.exists() && !f.isDirectory()) {             
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                json = br.readLine();          
                if (!json.equals("")) {
                    Funcionario [] func = mapper.readValue(json, Funcionario[].class);                
                    funcionarios = new ArrayList<Funcionario>(Arrays.asList(func));
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo funcionarios.txt!");
            }
        } else {
            seedFuncionarios();
        } 
    }
    
    public static void loadLivros() {
        File f = new File("livros.txt");
        String json = "";
        
        if(f.exists() && !f.isDirectory()) {             
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                json = br.readLine();    
                if (!json.equals("")) {
                    Livro [] l = mapper.readValue(json, Livro[].class);                
                    livros = new ArrayList<Livro>(Arrays.asList(l));
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo livros.txt!");
            }
        } else {
            seedLivros();
        } 
    }
    
    public static void loadEmprestimos() {
        File f = new File("emprestimos.txt");
        String json = "";
        
        if(f.exists() && !f.isDirectory()) {             
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                json = br.readLine();
                if (!json.equals("")) {
                    Emprestimo [] e = mapper.readValue(json, Emprestimo[].class);                
                    emprestimos = new ArrayList<Emprestimo>(Arrays.asList(e));
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage()/*"Não foi possível abrir o arquivo emprestimos.txt!"*/);
            }
        } else {
            seedEmprestimos();
        } 
    }
    
    public static List<Livro> getLivros() {
        return livros;
    }
    
    public static List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public static Usuario getUsrLogado() {
        return usrLogado;
    }

    public static Funcionario getFuncLogado() {
        return funcLogado;
    } 

    public static void setUsrLogado(Usuario usrLogado) {
        BibliotecaService.usrLogado = usrLogado;
    }

    public static void setFuncLogado(Funcionario funcLogado) {
        BibliotecaService.funcLogado = funcLogado;
    }
    
    public static void updateIdCountUsuarios() {
        try {
            mapper.writeValue(new File("idCountUsuarios.txt"), Usuario.getIdCount());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o arquivo idCountUsuarios.txt!");
        }
    }
    
    public static void updateUsuarios() {
        try {
            mapper.writeValue(new File("usuarios.txt"), usuarios);
            updateIdCountUsuarios();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o arquivo usuarios.txt!");
        }
    }
    
    public static void updateLivros() {
        try {
            mapper.writeValue(new File("livros.txt"), livros);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o arquivo livros.txt!");
        }
    }
    
    public static void updateFuncionarios() {
        try {
            mapper.writeValue(new File("funcionarios.txt"), funcionarios);
            updateIdCountUsuarios();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o arquivo funcionarios.txt!");
        }
    }
    
    public static void updateEmprestimos() {
        try {
            mapper.writeValue(new File("emprestimos.txt"), emprestimos);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o arquivo emprestimos.txt!");
        }
    }

    public static List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    
    public static void seedIdCountUsuarios() {
        Usuario.setIdCount(1);
        updateIdCountUsuarios();
    }
    
    public static void seedUsuarios() {
        Usuario novoUsr = new Usuario("João Paulo", "12345678901", "03/02/1997", "123");
        usuarios.add(novoUsr);
        novoUsr = new Usuario("Pedro", "99999999999", "01/01/1997", "1234");
        usuarios.add(novoUsr);
        updateUsuarios();
    }
    
    public static void seedFuncionarios() {
        Funcionario novoFunc = new Funcionario("admin", "00000000000", "01/01/2000", "admin");
        funcionarios.add(novoFunc);
        updateFuncionarios();
    }
    
    public static void seedLivros() {
        for(int i =1;i<9;i++){
            int acervo = i+3;
            int emprestado = i+1;
            Livro l = new Livro("nome"+i,"autor"+ i,"editora"+i,acervo,emprestado,"199"+i,"edição"+i);
            livros.add(l);
        }
        updateLivros();
    }
    
    public static void seedEmprestimos() {
        updateEmprestimos();
    }
}
