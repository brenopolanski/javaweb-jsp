package dao;

import java.util.List;
import model.Produto;

public interface ProdutoDAO {
    
    public List<Produto> listar();
    
    public List<Produto> listar(String idade, String sexo);
    
    public boolean inserir(Produto produto);
}
