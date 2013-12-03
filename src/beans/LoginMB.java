package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.commons.lang3.StringUtils;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    private String usuario;
    private String senha;
    private String msg = null;

    public LoginMB() {
        System.out.println("Construtor...");
    }

    public String controleAcesso() {
        System.out.println("+++++++++++++++++controleAcesso+++++++++++++++++");

//        Conectar con = new Conectar();
//        System.out.println("Conexao: " + con );

        if (validarUsuario(usuario, senha)) {
            return "paginas/impostos";
        }

        return "paginas/impostos"; // return "index";
    }

    private boolean validarUsuario(String usuario, String senha) {

        if ( StringUtils.isNotBlank(usuario) &&
             StringUtils.isNotBlank(senha)) {

            if (usuario.equals("biroska") && senha.equals("2904Pior")) {
                return true;
            } else {
                msg = "Usuário ou senha inválidos";
            }
        }
        return false;
    }

    /* Getters and Setters */
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}