import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Garante que a interface gráfica será criada na Thread correta
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                cadastroVIEW tela = new cadastroVIEW();
                tela.setVisible(true); // Torna a tela visível
                tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
                tela.setLocationRelativeTo(null); // Centraliza a janela na tela
            }
        });
    }
}
