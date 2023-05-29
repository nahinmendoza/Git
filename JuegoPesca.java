import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class JuegoPesca implements ActionListener {
    JFrame ventana;
    JButton btn_boton;
    JLabel lbl_x, lbl_y, lbl_norte, lbl_sur, lbl_este, lbl_oeste, lbl_ubicacion;
    JTextField tf_ubicacion;
    int i, j, number;
    Random rnd;
    Peces cardumen;

    public static void main(String[] args) {
        new JuegoPesca();
    }

    JuegoPesca() {
        //VENTANA DEL JUEGO
        ventana = new JFrame("ATRAPA EL CARDUMEN");
        //ventana.setBounds(500,100,500,500);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // LABELS DE LAS COORDENADAS
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

        // CICLO PARA GENERAR LOS 100 BOTONES
        for (int number = 0; number < 100; number++) {
            int i = number / 10;
            int j = number % 10;

            btn_boton = new JButton(String.valueOf(number));
            btn_boton.setBounds(750 + (40 + 15) * i, 250 + (10 + 15) * j, 55, 25);
            btn_boton.addActionListener(this);
            ventana.add(btn_boton);

        }

        // CICLO PARA GENERAR LOS BORDES
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

        lbl_ubicacion = new JLabel("UBICACION");
        lbl_ubicacion.setBounds(530,700,100,25);
        ventana.add(lbl_ubicacion);

        // TEXTFIELD PARA LA UBICACION DEL CARDUMEN
        tf_ubicacion = new JTextField();
        tf_ubicacion.setBounds(600, 700, 55, 25);
        tf_ubicacion.setVisible(true);
        ventana.add(tf_ubicacion);

        ventana.setVisible(true);

        //UBICACION DEL CARDUMEN
        rnd = new Random();
        cardumen = new Peces(rnd.nextInt(100));
        tf_ubicacion.setText(String.valueOf(cardumen.getUbicacion()));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            int buttonNumber = Integer.parseInt(clickedButton.getText());

            if (buttonNumber == cardumen.getUbicacion()) {
                JOptionPane.showMessageDialog(ventana, "¡Has atrapado al cardumen! Juega otra vez.");
                cardumen.setUbicacion(rnd.nextInt(100));
                tf_ubicacion.setText(String.valueOf(cardumen.getUbicacion()));
            } else {
                cardumen.mover();
            }
        }
    }

    class Peces {
        private int ubicacion;

        public Peces(int ubicacionInicial) {
            this.ubicacion = ubicacionInicial;
        }

        public int getUbicacion() {
            return ubicacion;
        }

        public void setUbicacion(int ubicacion) {
            this.ubicacion = ubicacion;
        }

        public void mover() {
            ubicacion = rnd.nextInt(100);
            tf_ubicacion.setText(String.valueOf(ubicacion));
        }
    }
}

//JOptionPane.showMessageDialog(frame, "El cardumen se movió hacia " + direccion);
//if (zona == peces.ubicarCardumen()) {
   //* int opcion = JOptionPane.showConfirmDialog(frame, "¡Has capturado al cardumen! ¿Deseas jugar de nuevo?", "¡Felicidades!", JOptionPane.YES_NO_OPTION);
   //if (opcion == JOptionPane.YES_OPTION) {
        //reiniciarJuego();
    //} else {
       // System.exit(0);