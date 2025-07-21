package model;

/**
 * Classe que representa um usuário do sistema.
 * Contém login, senha e tipo de usuário (Administrador, Atendente).
 */
public class Usuario {
    private int id; 
    private String login;
    private String senha;
    private String tipoUsuario;

    public Usuario() {}

    public Usuario(int id, String login, String senha, String tipoUsuario) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    // Construtor sem o id (caso use para inserção)
    public Usuario(String login, String senha, String tipoUsuario) {
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}


