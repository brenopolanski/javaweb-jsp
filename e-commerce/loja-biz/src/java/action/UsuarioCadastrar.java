package action;

import dao.FabricaConexao;
import dao.JDBCUsuarioDAO;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

public class UsuarioCadastrar extends HttpServlet {
private static final long serialVersionUID =1L;
    
    public UsuarioCadastrar(){
        super();
    }
    
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException{

    }
    
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String nome = request.getParameter("newuser-name");
        String email = request.getParameter("newuser-email");
        String password = request.getParameter("newuser-password");
        String idade = request.getParameter("newuser-idade");
        String sexo = request.getParameter("newuser-sexo");
        
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setPassword(password);
        novoUsuario.setIdade(idade);
        novoUsuario.setSexo(sexo);
        
        FabricaConexao fabrica = new FabricaConexao();
        Connection conexao = fabrica.fazConexao();
        
        JDBCUsuarioDAO dao = new JDBCUsuarioDAO(conexao);
        if (dao.inserir(novoUsuario)){
            request.setAttribute("sucesso", "Usuário cadastrado com sucesso");
            forward("welcome.jsp",request, response);
        } else {
            request.setAttribute("error", "usuario não cadastrado");
            forward("index.jsp", request, response);
        }
    }
    
        private void forward(String viewPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/"+viewPage);
        rd.forward(request, response);
    }
}
