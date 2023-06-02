import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Mendoza950Proy1 implements ActionListener{
    JFrame ventana;
    JButton btn_boton;
    JLabel lbl_x, lbl_y, lbl_norte, lbl_sur, lbl_este, lbl_oeste;
    JTextField txt_posicion;
    int i, j, number;
    Random rnd;
    Peces cardumen;
    int intentos;

    public static void main(String[] args){
        new Mendoza950Proy1();
    }

    Mendoza950Proy1() {
        ventana = new JFrame("ATRAPA EL CARDUMEN");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_norte = new JLabel("NORTE");
        lbl_norte.setBounds(1000, 200, 55, 25);
        ventana.add(lbl_norte);

        lbl_sur = new JLabel("SUR");
        lbl_sur.setBounds(1000, 550, 55, 25);
        ventana.add(lbl_sur);

        lbl_este = new JLabel("ESTE");
        lbl_este.setBounds(1400, 375, 55, 25);
        ventana.add(lbl_este);

        lbl_oeste = new JLabel("OESTE");
        lbl_oeste.setBounds(600, 375, 55, 25);
        ventana.add(lbl_oeste);

        txt_posicion = new JTextField();
        txt_posicion.setBounds(950, 700, 200, 30);
        txt_posicion.setEditable(false);
        ventana.add(txt_posicion);

        for (int number = 0; number < 100; number++) {
            int i = number / 10;
            int j = number % 10;

            btn_boton = new JButton(String.valueOf(number));
            btn_boton.setBounds(750 + (40 + 15) * i, 250 + (10 + 15) * j, 55, 25);
            btn_boton.addActionListener(this);
            ventana.add(btn_boton);
        }

        for (int number = 0; number < 10; number++) {
            int i = number / 10;
            int j = number % 10;
            lbl_x = new JLabel(String.valueOf(number));
            lbl_x.setBounds(730 + (40 + 15) * i, 250 + (10 + 15) * j, 55, 25);
            ventana.add(lbl_x);

            lbl_y = new JLabel(String.valueOf(number));
            lbl_y.setBounds(775 + (40 + 15) * j, 500 + (10 + 15) * i, 55, 25);
            ventana.add(lbl_y);
        }

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = (JButton) e.getSource();
            int numeroBoton = Integer.parseInt(boton.getText());
            cardumen.mover(numeroBoton);
            txt_posicion.setText("Posición del cardumen: " + cardumen.getPosicionX() + ", " + cardumen.getPosicionY());
            intentos++;
            System.out.println("Intento: " + intentos);
            if (cardumen.estaAtrapado()) {
                JOptionPane.showMessageDialog(ventana, "¡Felicidades! Has atrapado al cardumen en " + intentos + " intentos.");
                iniciarJuego();
            }
        }
    }

    public void iniciarJuego() {
        cardumen = new Peces();
        intentos = 0;
        txt_posicion.setText("Posición del cardumen: " + cardumen.getPosicionX() + ", " + cardumen.getPosicionY());
    }

    public class Peces {
        private int posicionX;
        private int posicionY;

        public Peces() {
            rnd = new Random();
            posicionX = rnd.nextInt(10);
            posicionY = rnd.nextInt(10);
        }

        public int getPosicionX() {
            return posicionX;
        }

        public int getPosicionY() {
            return posicionY;
        }

        public void mover(int numeroBoton) {
            int i = numeroBoton / 10;
            int j = numeroBoton % 10;

            if (i == posicionX && j == posicionY) {
                posicionX = rnd.nextInt(10);
                posicionY = rnd.nextInt(10);
            }
        }

        public boolean estaAtrapado() {
            return posicionX == 0 && posicionY == 0;
        }
    }
}
