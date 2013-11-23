package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {
    
    public List<Usuario> listar();
    
    public boolean inserir(Usuario usuario);
    
    public Usuario logar(String email, String password);
    
}
