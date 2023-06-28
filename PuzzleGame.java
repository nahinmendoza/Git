import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.event.*;
import java.util.Random;

public class PuzzleGame implements ActionListener {
    
    JFrame ventana;
    JButton[] btn_boton;
    JButton btn_iniciar, btn_iniciar2, btn_verificar;
    JLabel lbl_tiempo;
    JTextField tf_tiempo;
    Timer timer;
    int tiempo;

    public static void main(String[] args) {
        new PuzzleGame();
    }

    PuzzleGame() {
        // VENTANA DEL JUEGO
        ventana = new JFrame("ATRAPA EL CARDUMEN");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_boton = new JButton[16]; 
        int i;
        for (i = 0; i < 15; i++) {
            btn_boton[i] = new JButton(String.valueOf(i + 1));
            int fila = i / 4; 
            int columna = i % 4; 
            btn_boton[i].setBounds(800 + 70 * columna, 250 + 70 * fila, 70, 70);
            btn_boton[i].addActionListener(this); 
            ventana.add(btn_boton[i]);
        }
        
        btn_iniciar = new JButton("INICIAR");
        btn_iniciar.setBounds(795, 600, 95, 55);
        btn_iniciar.addActionListener(this);
        ventana.add(btn_iniciar);
        
        btn_iniciar2 = new JButton("INICIAR 2");
        btn_iniciar2.setBounds(895, 600, 95, 55);
        ventana.add(btn_iniciar2);

        btn_verificar = new JButton("VERIFICAR");
        btn_verificar.setBounds(995, 600, 95, 55);
        ventana.add(btn_verificar);

        lbl_tiempo = new JLabel("TIEMPO");
        lbl_tiempo.setBounds(800, 150, 70, 75);
        ventana.add(lbl_tiempo);

        tf_tiempo = new JTextField();
        tf_tiempo.setBounds(850, 175, 70, 25);
        ventana.add(tf_tiempo);
        
        tiempo = 0;
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tiempo++;
                String tiempoFormateado = formatTiempo(tiempo);
                tf_tiempo.setText(tiempoFormateado);
            }
        });

        ventana.setVisible(true);
    }

    private void revolver() {
        int i, j, x, y;
        Random rnd = new Random();

        for (i = 0; i < 16; i++) {
            j = rnd.nextInt(16); 

            x = btn_boton[i].getLocation().x;
            y = btn_boton[i].getLocation().y;

            btn_boton[i].setLocation(btn_boton[j].getLocation().x, btn_boton[j].getLocation().y);
            btn_boton[j].setLocation(x, y);
        }
        ventana.repaint();
    }
    
    private String formatTiempo(int segundos) {
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segs = segundos % 60;
        
        return String.format("%02d:%02d:%02d", horas, minutos, segs);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == btn_iniciar) 
        {
            tiempo = 0;
            tf_tiempo.setText("00:00:00");
            timer.start();
            revolver(); 
        }
    }
}
