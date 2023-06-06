package databases;

/**
 *
 * @author alan
 */
public class Usuario {

    private String email;
    private String senha;
    private Integer fkEmpresa;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", "
                + "senha=" + senha + ", fkEmpresa=" + fkEmpresa + '}';
    }
}
