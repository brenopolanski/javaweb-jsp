package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Usuario;

public class JDBCUsuarioDAO implements UsuarioDAO {
    
    Connection conexao;
    
    public JDBCUsuarioDAO(Connection conexao){
        this.conexao = conexao;
    }

    @Override
    public boolean inserir(Usuario usuario) {
        String comando = "INSERT INTO usuarios (nome, email, password, sexo, idade) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement p = this.conexao.prepareStatement(comando);
            p.setString(1, usuario.getNome());
            p.setString(2, usuario.getEmail());
            p.setString(3, usuario.getPassword());
            p.setString(4, usuario.getSexo());
            p.setString(5, usuario.getIdade());
            p.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
        public Usuario logar(String email, String password) {
        Usuario usuario = new Usuario();
        String comando = "SELECT * FROM usuarios where email=? and password=?";
        try {
            PreparedStatement p = this.conexao.prepareStatement(comando);
            p.setString(1, email);
            p.setString(2, password);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setIdade(rs.getString("idade"));
            }
            rs.close();
            p.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        List usuarios = new ArrayList<Usuario>();
        String comando = "SELECT * FROM usuarios";
        try {
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String sexo = rs.getString("sexo");
                String idade = rs.getString("idade");
                
                usuario.setId(id);
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setPassword(password);
                usuario.setSexo(sexo);
                usuario.setIdade(idade);
                
                usuarios.add(usuario);
            }
        } catch (Exception e) {
        }
        return usuarios;
    }
    
    
}
