package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Figure Editor — Clique para inserir figuras");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            DrawingPanel panel = new DrawingPanel();
            
            JPanel botoes = new JPanel();
            JButton salvarBtn = new JButton("Exportar PNG");
            salvarBtn.addActionListener(e -> panel.exportarPNG("teste.png"));
            botoes.add(salvarBtn);

            
            frame.setLayout(new BorderLayout());
            frame.add(botoes, BorderLayout.NORTH);
            frame.add(panel, BorderLayout.CENTER);

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
