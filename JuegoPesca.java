import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class JuegoPesca implements ActionListener {
    JFrame ventana;
    JButton btn_boton;
    JLabel lbl_x, lbl_y, lbl_norte, lbl_sur, lbl_este, lbl_oeste, lbl_ubicacion, lbl_intentos, lbl_presentacion, lbl_presentacion2, lbl_presentacion3, lbl_presentacion4, lbl_presentacion5, lbl_presentacion6, lbl_presentacion7, lbl_presentacion8, lbl_presentacion9;
    JLabel lbl_mensaje;
    JTextField tf_ubicacion, tf_intentos, tf_mensaje;
    int i, j, number;
    Random rnd;
    Peces cardumen;
    int intentos;

    public static void main(String[] args) {
        new JuegoPesca();
    }

    JuegoPesca() {
        // VENTANA DEL JUEGO
        ventana = new JFrame("ATRAPA EL CARDUMEN");
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
        for (int number = 1; number <= 10; number++) {
            int i = number - 1;

            lbl_x = new JLabel(String.valueOf(number));
            lbl_x.setBounds(730, 250 + (20 + 5) * i, 55, 25);
            ventana.add(lbl_x);

            lbl_y = new JLabel(String.valueOf(number));
            lbl_y.setBounds(770 + (40 + 15) * i, 510, 55, 25);
            ventana.add(lbl_y);
        }

        // LABEL PARA MOSTRAR LA UBICACION
        lbl_ubicacion = new JLabel("UBICACION");
        lbl_ubicacion.setBounds(530, 700, 100, 25);
        ventana.add(lbl_ubicacion);

        // TEXTFIELD PARA LA UBICACION DEL CARDUMEN
        tf_ubicacion = new JTextField();
        tf_ubicacion.setBounds(600, 700, 55, 25);
        tf_ubicacion.setVisible(false);
        ventana.add(tf_ubicacion);

        // LABEL PARA MOSTRAR INTENTOS
        lbl_intentos = new JLabel("INTENTOS");
        lbl_intentos.setBounds(530, 730, 100, 25);
        ventana.add(lbl_intentos);

        // TEXTFIELD PARA LOS INTENTOS
        tf_intentos = new JTextField();
        tf_intentos.setBounds(600, 730, 55, 25);
        tf_intentos.setVisible(true);
        ventana.add(tf_intentos);

        // LABEL PARA LA PRESENTACION
        lbl_presentacion = new JLabel("UNIVERSIDAD TECNOLOGICA DE PANAMA\n");
        lbl_presentacion.setBounds(160, 150, 450, 200);
        ventana.add(lbl_presentacion);

        lbl_presentacion2 = new JLabel("FACULTAD DE INGENIERIA DE SISTEMAS COMPUTACIONALES\n");
        lbl_presentacion2.setBounds(100, 170, 450, 200);
        ventana.add(lbl_presentacion2);

        lbl_presentacion3 = new JLabel("LIC. EN DESARROLLO DE SOFTWARE\n");
        lbl_presentacion3.setBounds(180, 190, 450, 200);
        ventana.add(lbl_presentacion3);

        lbl_presentacion4 = new JLabel("DESARROLLO DE SOFTWARE 3\n");
        lbl_presentacion4.setBounds(195, 210, 450, 200);
        ventana.add(lbl_presentacion4);

        lbl_presentacion5 = new JLabel("RICARDO CHAN\n");
        lbl_presentacion5.setBounds(240, 230, 450, 200);
        ventana.add(lbl_presentacion5);

        lbl_presentacion6 = new JLabel("NAHIN MENDOZA\n");
        lbl_presentacion6.setBounds(235, 250, 450, 200);
        ventana.add(lbl_presentacion6);

        lbl_presentacion7 = new JLabel("8-989-50\n");
        lbl_presentacion7.setBounds(255, 270, 450, 200);
        ventana.add(lbl_presentacion7);

        lbl_presentacion8 = new JLabel("1LS221\n");
        lbl_presentacion8.setBounds(260, 290, 450, 200);
        ventana.add(lbl_presentacion8);

        lbl_presentacion9 = new JLabel("02/06/2023\n");
        lbl_presentacion9.setBounds(250, 310, 450, 200);
        ventana.add(lbl_presentacion9);

        // DIRECCION
        lbl_mensaje = new JLabel("MENSAJE");
        lbl_mensaje.setBounds(530, 760, 100, 25);
        ventana.add(lbl_mensaje);

        tf_mensaje = new JTextField();
        tf_mensaje.setBounds(600, 760, 350, 25);
        tf_mensaje.setVisible(true);
        ventana.add(tf_mensaje);

        ventana.setVisible(true);

        // UBICACION DEL CARDUMEN
        rnd = new Random();
        cardumen = new Peces(rnd.nextInt(100));
        tf_ubicacion.setText(String.valueOf(cardumen.getUbicacion()));
        intentos = 0;
        tf_intentos.setText(String.valueOf(intentos));

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            int btn_boton = Integer.parseInt(clickedButton.getText());
    
            intentos++;
            tf_intentos.setText(String.valueOf(intentos));
    
            if (btn_boton == cardumen.getUbicacion()) {
                tf_mensaje.setText("¡Has atrapado al cardumen! Juega otra vez.");
                cardumen.setUbicacion(rnd.nextInt(100));
                tf_ubicacion.setText(String.valueOf(cardumen.getUbicacion()));
                intentos = 0;
                tf_intentos.setText(String.valueOf(intentos));
            } else if (esAdyacente(btn_boton, cardumen.getUbicacion())) {
                cardumen.setUbicacion(rnd.nextInt(100));
                tf_ubicacion.setText(String.valueOf(cardumen.getUbicacion()));
                tf_mensaje.setText("Asustastes al cardumen. Sigue intentando");
            } else {
                String direccion = determinarDireccion(btn_boton);
                tf_mensaje.setText("El cardumen está hacia el " + direccion);
            }
        }
    }
    
    
    private boolean esAdyacente(int btn_boton, int cardumenPosition) {
        int buttonRow = btn_boton / 10;
        int buttonColumn = btn_boton % 10;
        int cardumenRow = cardumenPosition / 10;
        int cardumenColumn = cardumenPosition % 10;
    
        // Verificar si las posiciones son adyacentes en fila o columna
        return Math.abs(buttonRow - cardumenRow) <= 1 && Math.abs(buttonColumn - cardumenColumn) <= 1;
    }
    

    private String determinarDireccion(int btn_boton) {
        int cardumenPosition = cardumen.getUbicacion();
        int buttonRow = btn_boton / 10;
        int buttonColumn = btn_boton % 10;
        int cardumenRow = cardumenPosition / 10;
        int cardumenColumn = cardumenPosition % 10;
    
        String direccion = "";
    
        if (buttonRow < cardumenRow) {
            direccion += "Norte ";
        } else if (buttonRow > cardumenRow) {
            direccion += "Sur ";
        }
    
        if (buttonColumn < cardumenColumn) {
            direccion += "Este";
        } else if (buttonColumn > cardumenColumn) {
            direccion += "Oeste";
        }
    
        if (direccion.isEmpty()) {
            direccion = "Misma ubicación";
        }
    
        return direccion;
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
    }
}



