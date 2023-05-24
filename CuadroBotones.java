import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CuadroBotones implements ActionListener {
    JFrame frame;
    JButton[][] buttons;
    JLabel messageLabel;
    int cardumenX;
    int cardumenY;

    public static void main(String[] args) {
        new CuadroBotones();
    }

    CuadroBotones() {
        frame = new JFrame("Pesca de Sardinas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(11, 10));

        buttons = new JButton[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new JButton(i + "," + j);
                buttons[i][j].addActionListener(this);
                frame.add(buttons[i][j]);
            }
        }

        messageLabel = new JLabel("Lance la red en una zona");
        frame.add(messageLabel);

        frame.setSize(500, 550);
        frame.setVisible(true);

        // Generar posición inicial del cardumen
        Random random = new Random();
        cardumenX = random.nextInt(10) + 1;
        cardumenY = random.nextInt(10) + 1;
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String[] coordenadas = button.getText().split(",");
        int x = Integer.parseInt(coordenadas[0]);
        int y = Integer.parseInt(coordenadas[1]);

        if (x == cardumenX && y == cardumenY) {
            messageLabel.setText("¡Pescaste el cardumen de sardinas!");
        } else {
            int deltaX = cardumenX - x;
            int deltaY = cardumenY - y;

            String direccion;
            if (deltaX > 0 && deltaY == 0)
                direccion = "norte";
            else if (deltaX < 0 && deltaY == 0)
                direccion = "sur";
            else if (deltaX == 0 && deltaY > 0)
                direccion = "oeste";
            else if (deltaX == 0 && deltaY < 0)
                direccion = "este";
            else if (deltaX > 0 && deltaY > 0)
                direccion = "noroeste";
            else if (deltaX > 0 && deltaY < 0)
                direccion = "noreste";
            else if (deltaX < 0 && deltaY > 0)
                direccion = "suroeste";
            else if (deltaX < 0 && deltaY < 0)
                direccion = "sureste";
            else
                direccion = "movido";

            messageLabel.setText("El cardumen se ha " + direccion + " del área actual");
        }
    }
}
