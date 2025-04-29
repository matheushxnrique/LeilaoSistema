import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;  // Adicionada importação do SQLException
import java.util.ArrayList;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        try {
            conn = new conectaDAO().connectDB();
            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setDouble(2, produto.getValor());  // Garantido que o valor é um double
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
                // Corrigido cast do valor para double
                ProdutosDTO produto = new ProdutosDTO(
                        resultset.getInt("id"),
                        resultset.getString("nome"),
                        resultset.getDouble("valor"),  // valor como double
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

    public void venderProduto(int id) {
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";

        try {
            conn = new conectaDAO().connectDB();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.executeUpdate();
            pstm.close();
            conn.close();

            System.out.println("Produto vendido com sucesso!");
        } catch (SQLException erro) {
            System.out.println("Erro ao vender produto: " + erro.getMessage());
        }
    }
    
    
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
    ArrayList<ProdutosDTO> listaVendidos = new ArrayList<>();
    String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";

    try {
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement(sql);
        resultset = prep.executeQuery();

        while (resultset.next()) {
            ProdutosDTO produto = new ProdutosDTO(
                    resultset.getInt("id"),
                    resultset.getString("nome"),
                    resultset.getDouble("valor"),
                    resultset.getString("status")
            );
            listaVendidos.add(produto);
        }
    } catch (Exception erro) {
        JOptionPane.showMessageDialog(null, "Erro ao listar produtos vendidos: " + erro.getMessage());
    } finally {
        try {
            if (conn != null) conn.close();
            if (prep != null) prep.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage());
        }
    }

    return listaVendidos;
}

    
    
    
}
