package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;

public class JDBCProdutoDAO implements ProdutoDAO{
    
    Connection conexao;
    
    public JDBCProdutoDAO (Connection conexao){
        this.conexao = conexao;
    }

    @Override
    public List<Produto> listar() {
        List produtos = new ArrayList<Produto>();
        String comando = "SELECT * FROM produtos";
        try {
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);
            
            while(rs.next()){
                Produto produto = new Produto();
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                String imagem = rs.getString("imagem");
                double preco = rs.getDouble("preco");
                String sexo = rs.getString("sexo");
                String idade = rs.getString("idade");
                String marca = rs.getString("marca");
                String obs = rs.getString("obs");
                String pagamento = rs.getString("pagamento");
                
                produto.setId(id);
                produto.setDescricao(descricao);
                produto.setImagem(imagem);
                produto.setPreco(preco);
                produto.setSexo(sexo);
                produto.setIdade(idade);
                produto.setMarca(marca);
                produto.setObs(obs);
                produto.setPagamento(pagamento);
                
                produtos.add(produto);
            }
        } catch (Exception e) {
        }
        return produtos;
    }
    
        @Override
    public List<Produto> listar(String idade, String sexo) {
        List<Produto> produtos = new ArrayList<Produto>();
        String comando = "SELECT * FROM produtos where idade=? and sexo=?";
        try {
            PreparedStatement p = this.conexao.prepareStatement(comando);
            p.setString(1, idade);
            p.setString(2, sexo);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setImagem(rs.getString("imagem"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setSexo(rs.getString("sexo"));
                produto.setIdade(rs.getString("idade"));
                produto.setMarca(rs.getString("marca"));
                produto.setObs(rs.getString("obs"));
                produto.setPagamento(rs.getString("pagamento"));
                
                produtos.add(produto);
            }
            rs.close();
            p.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }


    @Override
    public boolean inserir(Produto produto) {
        String comando = "INSERT INTO produtos (descricao, imagem, preco, sexo, idade, marca, obs, pagamento) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement p = this.conexao.prepareStatement(comando);
            p.setString(1, produto.getDescricao());
            p.setString(2, produto.getImagem());
            p.setDouble(3, produto.getPreco());
            p.setString(4, produto.getSexo());
            p.setString(5, produto.getIdade());
            p.setString(6, produto.getMarca());
            p.setString(7, produto.getObs());
            p.setString(8, produto.getPagamento());
            p.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
