package dao;

import java.sql.Connection;

public class FabricaConexao {
    
    private java.sql.Connection conexao;
    
    public Connection fazConexao(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexao = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/MinhaLoja","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }
    
    public void fecharConexao(){
        try {
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
