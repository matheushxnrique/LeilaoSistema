/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
    String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        
        try {
            conn = new conectaDAO().connectDB();
            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setDouble(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            
            prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ProdutosDAO Cadastrar: " + erro.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();  // Fechar a conexão
                }
                if (prep != null) {
                    prep.close();  // Fechar o PreparedStatement
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    
    
        
    }
    
   public ArrayList<ProdutosDTO> listarProdutos() {
    ArrayList<ProdutosDTO> lista = new ArrayList<>();
    String sql = "SELECT * FROM produtos";

    try {
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement(sql);
        resultset = prep.executeQuery();

        while (resultset.next()) {
            ProdutosDTO produto = new ProdutosDTO(
                resultset.getInt("id"),
                resultset.getString("nome"), (int) resultset.getDouble("valor"),
                resultset.getString("status")
            );
            lista.add(produto);
        }

    } catch (Exception erro) {
        JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + erro.getMessage());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
            if (prep != null) {
                prep.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage());
        }
    }

    return lista;
}

    
    
    
        
}

