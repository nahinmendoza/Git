import javax.swing.*;
import java.awt.*;

public class CuadroBotones {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tablero con Botones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(10, 10)); // Tablero de 10x10

        for (int i = 0; i < 100; i++) {
            JButton button = new JButton("Botón " + (i + 1));
            panel.add(button);
        }

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}