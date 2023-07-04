import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

public class PuzzleGame implements ActionListener {

    JFrame ventana;
    JButton[] btn_boton;
    JButton btn_iniciar, btn_iniciar2, btn_verificar;
    JLabel lbl_tiempo, lbl_presentacion, lbl_presentacion2, lbl_presentacion3, lbl_presentacion4, lbl_presentacion5,
            lbl_presentacion6, lbl_presentacion7, lbl_presentacion8, lbl_presentacion9, lbl_intentos;
    JTextField tf_tiempo, tf_intentos;
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
        ventana.getContentPane().setBackground(Color.GRAY);
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
        btn_iniciar2.addActionListener(this);
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

        lbl_intentos = new JLabel("INTENTOS");
        lbl_intentos.setBounds(800, 220, 70, 25);
        ventana.add(lbl_intentos);

        tf_intentos = new JTextField();
        tf_intentos.setBounds(860, 220, 75, 25);
        tf_intentos.setVisible(true);
        ventana.add(tf_intentos);

        tiempo = 0;
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tiempo++;
                String tiempoFormateado = formatTiempo(tiempo);
                tf_tiempo.setText(tiempoFormateado);
            }
        });

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
        if (e.getSource() == btn_iniciar || e.getSource() == btn_iniciar2) {
            tiempo = 0;
            tf_tiempo.setText("00:00:00");
            timer.start();
            revolver();
        }
        if (e.getSource() == btn_boton)
        {
            int x, y;
            x = btn_boton[0].getLocation().x;
            y = btn_boton[0].getLocation().y;
            btn_boton[0].setLocation(x,y+50);
        }
    }
}
