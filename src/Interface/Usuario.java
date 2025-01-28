package Interface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String email;
    private String login;
    private String senha;
    
    //Construtor
    public Usuario(String nome, String email, String login, String senha){
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    Usuario() {

    }
    
    /**
     * Cadastra essa instância de usuario
     * em arquivo de texto CSV
     */
    public void cadastrar() throws IOException {
        File file = new File("usuario.csv");
        FileWriter arquivo;
        //verificando se o arquivo não existe
        //pois só iremos escrever
        //o cabeçalho uma vez.
        if (!file.exists()) {
            file.createNewFile();
            arquivo = new FileWriter(file, true);
            String cabecalho = "nome;email;login;senha";
            arquivo.write(cabecalho+"\r\n");
            arquivo.close();
        }
        //finalmente cadastrando o usuário
        arquivo = new FileWriter(file, true);
        arquivo.write(this.nome+";"+this.email+";"
                +this.login+";"+this.senha+"\r\n");
        arquivo.close();
    }
    
    //Retorna uma lista de objetos do tipo Usuario
    public List<Usuario> getListaUsuarios() throws FileNotFoundException {
        ArrayList<Usuario> lista = new ArrayList<>();
        //arquivo de texto
        File file = new File("usuario.csv");
        //verificando se o arquivo não existe
        //se o arquivo não existir, retorna
        //uma linha vazia
        if(!file.exists()) { return lista; }
        //lendo linha por linha o arquivo
        Scanner scan = new Scanner(file);
        String linha;
        String[] coluna;
        while(scan.hasNextLine()) {
            linha = scan.nextLine();
            coluna = linha.split(";");
            String nome = coluna[0];
            String email = coluna[1];
            String login = coluna[2];
            String senha = coluna[3];
            //instanciando o objeto Usuario
            Usuario user = new Usuario(nome, email, login, senha);
            //adicionando o objeto à lista de usuarios
            lista.add(user);
        }
        return lista;
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
