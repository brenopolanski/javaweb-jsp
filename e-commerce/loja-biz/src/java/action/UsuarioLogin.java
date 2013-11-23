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

public class UsuarioLogin extends HttpServlet {
    
    private static final long serialVersionUID =1L;
    
    public UsuarioLogin(){
        super();
    }
    
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException{

    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        FabricaConexao fabrica = new FabricaConexao();
        Connection conexao = fabrica.fazConexao();
        
        JDBCUsuarioDAO dao = new JDBCUsuarioDAO(conexao);
        Usuario usuario = dao.logar(email, password);
        if (usuario.getEmail()!=null){
            request.setAttribute("nome", usuario.getNome());
            request.setAttribute("sexo", usuario.getSexo());
            request.setAttribute("idade", usuario.getIdade());
            forward("welcome.jsp",request, response);
        } else {
            request.setAttribute("erro", "usuario ou senha inválidos");
            forward("index.jsp", request, response);
        }
    }
    
        private void forward(String viewPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/"+viewPage);
        rd.forward(request, response);
    }

}
