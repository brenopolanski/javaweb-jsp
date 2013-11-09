/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
@WebServlet(urlPatterns = {"/RetornaResultado"})
public class RetornaResultado extends HttpServlet {

public void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException, IOException {
    
    response.setContentType("text/html");
		
	
	String nome = request.getParameter("nome");
	String sexo = request.getParameter("sexo");
	String idade = request.getParameter("idade");
		
	String resposta = "Olá " + nome + ", estamos muito felizes de ";
	if(sexo.equals("masculino")) {
		resposta = resposta + "te-lo";
	} else {
		resposta = resposta + "te-la";
	}
	
	resposta = resposta + " conosco. Temos uma promoção muito interessante para você: Venha conferir ";
	
	if(idade.equals("crianca")){
		resposta = resposta + "nossos brinquedos!!!!";
	} else if(idade.equals("adolescente")){
		resposta = resposta + "nossa promoção de MP3 Players!!!";
	} else if (idade.equals("adulto")){
		resposta = resposta +  "nossa promoção de CDs!!!";
	}	else {
		resposta = resposta + "nossas esteiras de descanso!!!";
	}             
            
    request.setAttribute("resposta", resposta);
    forward("resposta.jsp", request, response);
    	
    	
}

private void forward(String viewPage, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	RequestDispatcher rd = req.getRequestDispatcher("/"+viewPage);
		rd.forward(req,res);
	}

}
