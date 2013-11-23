<%@page import="model.Usuario"%>
<%@page import="dao.JDBCUsuarioDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.FabricaConexao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
	</head>
	<body>
		<div class="container">
			<div class="bg-biz"></div>
			<form action="UsuarioLogin" class="form-signin" method="post">
				<h2 class="form-signin-heading">BIZ<sup>&reg;</sup></h2>
                                <% String erro = (String)request.getAttribute("erro"); %>
                                <div><% if(erro!=null )%><%=erro %></div>
				<a href="#" id="new-user" class="form-signin-newuser">Novo usuário?</a>
				<div class="input-group">
					<span class="input-group-addon glyphicon glyphicon-user"> </span>
					<input type="email" name="email" id="email" class="form-control" placeholder="Digite seu email" required autofocus>
				</div>
				<div class="input-group">
					<span class="input-group-addon glyphicon glyphicon-lock"> </span>
					<input type="password" name="password" id="password" class="form-control" placeholder="Digite sua senha" required>
				</div>
				<label class="checkbox">
					<input type="checkbox" name="" id="" value=""> Lembre-me
				</label>
				<button class="btn btn-lg btn-primary btn-block" type="submit" id="submit">Acessar</button>
			</form>
			<div class="social">
				<nav>
					<ul>
						<li><a href="#">Facebook</a></li>
						<li>&bull;</li>
						<li><a href="#">Twitter</a></li>
						<li>&bull;</li>
						<li><a href="#">Google+</a></li>
					</ul>
				</nav>
			</div>
		</div>

		<!-- Modal Novo Usuário -->
		<div class="modal fade" id="modal-new-user" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content modal-newuser">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">Novo Usuário</h4>
					</div>
					<form action="UsuarioCadastrar" class="form-newuser" method="post">
						<div class="modal-body">							
							<div class="form-group">
								<label for="nome">Nome</label>
								<input type="text" name="newuser-name" id="newuser-name" class="form-control" placeholder="Digite seu nome" required autofocus>			
							</div>
							<div class="form-group">
								<label for="email">Email</label>
								<input type="email" name="newuser-email" id="newuser-email" class="form-control" placeholder="Digite seu email" required>					
							</div>
                                                        <div class="form-group">
								<label for="password">Senha</label>
								<input type="password" name="newuser-password" id="newuser-password" class="form-control" placeholder="Digite sua senha" required>					
							</div>
							<div class="form-group">
								<label for="idade">Idade</label>
								<select name="newuser-idade" id="newuser-idade" class="form-control" required>
									<option value="">-- Selecione -- </option>
									<option value="C">0-11</option>
									<option value="J">12-49</option>
									<option value="A">50 até morrer</option>
								</select>
							</div>
							<div class="form-group">
								<label for="sexo">Sexo</label>
								<div class="radio">
									<label>
										<input type="radio" name="newuser-sexo" id="newuser-sexo" value="M" required> Masculino
									</label>
								</div>
								<div class="radio">
									<label>
										<input type="radio" name="newuser-sexo" id="newuser-sexo" value="F" required> Feminino
									</label>
								</div>
							</div>				
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success">Cadastrar</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		                    
		<!-- JavaScript -->
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.js"></script>
		<script src="js/main.js"></script>
	</body>
</html>
