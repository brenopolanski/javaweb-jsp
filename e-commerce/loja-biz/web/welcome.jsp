<%@page import="java.sql.Connection"%>
<%@page import="dao.FabricaConexao"%>
<%@page import="dao.JDBCProdutoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nome = (String)request.getAttribute("nome");
    String sexo = (String)request.getAttribute("sexo");
    String idade = (String)request.getAttribute("idade");

    FabricaConexao fabrica = new FabricaConexao();
    Connection conexao = fabrica.fazConexao();
    
    JDBCProdutoDAO dao = new JDBCProdutoDAO(conexao);
     
%>
<!doctype html>
<html lang="pt-br">
	<head>
		<title>BIZ</title>

		<!-- Meta -->
		<meta charset="utf-8">
		<meta name="description" content="Tópicos Avançados em Programação">
		<meta name="author" content="Breno Polanski, Ely Richardson">

		<!-- CSS -->
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/custom.css">
		<style>
			body {
				padding-top: 20px;
				padding-bottom: 200px;
			}
		</style>
	</head>
	<body>

		<div class="container">
			<div class="row">
				<div class="col-lg-6"	>
					<header>
						<a href="welcome.jsp"><div class="entypo-paper-plane logo"></div></a>
					</header>
				</div>
				<div class="col-lg-3">
					<div class="box-user">
                                            <% if (sexo.equals("M")){%>
						<figure class="user-icon icon-male"></figure>
                                            <%} else {%>
                                                <figure class="user-icon icon-female"></figure>
                                            <%}%>
						<span class="user-name"><%=nome %></span>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="box-sale">
						<button type="button" class="btn btn-default btn-large">
							<span class="glyphicon glyphicon-shopping-cart"></span> Meu Carrinho
							<span class="badge badge-success">2</span>
						</button>
					</div>
				</div>
				<!-- <div class="col-lg-3" style="border: 1px solid #000">
					<div class="box-new-shirt">
						<button type="button" class="btn btn-default btn-large">
							<span class="glyphicon glyphicon-plus"></span> Camisas
						</button>
					</div>
				</div> -->
			</div>
		</div>

		<!-- SHOWCASE -->

		<!-- #1 -->
		<div class="container container-showcase">
			<div class="row">
                            <% for(Produto produto: dao.listar(idade, sexo)){%>
                                    <div class="col-lg-4">
					<div class="showcase">
						<div class="shirt-back">
							<span class="glyphicon glyphicon-share-alt"></span>
						</div>
						<div class="shirt-show"><img class="center-block" src="imgProdutos/<%=produto.getImagem()%>" width="300" height="" alt="<%=produto.getDescricao()%>"></div>
						<div class="misc">
							<div class="misc-box-tool"><span class="glyphicon glyphicon-search glyphicon-up"></span></div>
							<div class="misc-box-tool"><span class="glyphicon glyphicon-heart-empty glyphicon-up"></span></div>
							<div class="misc-box-tool"><span class="tam-shirt glyphicon-up">G</span></div>
							<div class="misc-box-tool"><span class="glyphicon glyphicon-stop glyphicon-up"></span></div>
							<div class="misc-box-tool"><span class="glyphicon glyphicon-shopping-cart glyphicon-up"></span></div>
						</div>
					</div>
				</div>
                            <%}%>	
			</div>
		</div>

        	<!-- JavaScript -->
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.js"></script>
		<script src="js/main.js"></script>
	</body>
</html>