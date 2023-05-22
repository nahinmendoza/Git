package PrJuego;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuadroBotones extends JFrame {

    public CuadroBotones() {
        setTitle("Cuadro de Botones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 350);
        setLayout(new GridLayout(10, 10));

        // Crear y agregar botones al cuadro
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                JButton button = new JButton(Integer.toString((i-1)*10 + j));
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton source = (JButton)e.getSource();
                        int buttonNumber = Integer.parseInt(source.getText());
                        System.out.println("Se hizo clic en el botón número: " + buttonNumber);
                    }
                });
                add(button);
            }
        }
    }

    public static void main(String[] args) {
        CuadroBotones cuadro = new CuadroBotones();
        cuadro.setVisible(true);
    }
}

