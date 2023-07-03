import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PuzzleGame implements ActionListener {

    JFrame ventana;
    JButton[] btn_boton;
    JButton btn_iniciar, btn_iniciar2, btn_verificar, btn_consultar;
    JLabel lbl_tiempo, lbl_movimientos, lbl_mejoresJugadores;
    JTextField tf_tiempo, tf_movimientos;
    Timer timer;
    int tiempo;
    int movimientos;
    List<Jugador> mejoresJugadores;
    private Component tf_mensaje;
    private JLabel lbl_mensaje;

    public static void main(String[] args) {
        new PuzzleGame();
    }

    PuzzleGame() {
        ventana = new JFrame("PuzzleGame");
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
        ventana.add(btn_iniciar2);

        btn_verificar = new JButton("VERIFICAR");
        btn_verificar.setBounds(995, 600, 95, 55);
        ventana.add(btn_verificar);

        btn_consultar = new JButton("Consultar Mejores Jugadores");
        btn_consultar.setBounds(795, 675, 295, 55);
        btn_consultar.addActionListener(this);
        ventana.add(btn_consultar);

        lbl_tiempo = new JLabel("TIEMPO");
        lbl_tiempo.setBounds(800, 150, 70, 75);
        ventana.add(lbl_tiempo);

        tf_tiempo = new JTextField();
        tf_tiempo.setBounds(850, 175, 70, 25);
        ventana.add(tf_tiempo);

        lbl_movimientos = new JLabel("MOVIMIENTOS");
        lbl_movimientos.setBounds(950, 175, 100, 25);
        ventana.add(lbl_movimientos);

        tf_movimientos = new JTextField();
        tf_movimientos.setBounds(1050, 175, 75, 25);
        tf_movimientos.setVisible(true);
        ventana.add(tf_movimientos);

        lbl_mejoresJugadores = new JLabel("MEJORES JUGADORES");
        lbl_mejoresJugadores.setBounds(800, 250, 300, 25);
        ventana.add(lbl_mejoresJugadores);

        lbl_mensaje = new JLabel("MENSAJE");
        lbl_mensaje.setBounds(530, 760, 100, 25);
        ventana.add(lbl_mensaje);

        tf_mensaje = new JTextField();
        tf_mensaje.setBounds(600, 760, 350, 25);
        tf_mensaje.setVisible(true);
        ventana.add(tf_mensaje);

        tiempo = 0;
        movimientos = 0;
        mejoresJugadores = new ArrayList<>();
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tiempo++;
                String tiempoFormateado = formatTiempo(tiempo);
                tf_tiempo.setText(tiempoFormateado);
            }
        });

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn_actual = (JButton) e.getSource();
        if (btn_actual.equals(btn_iniciar)) {
            iniciarJuego();
        } else if (btn_actual.equals(btn_iniciar2)) {
            iniciarJuego2();
        } else if (btn_actual.equals(btn_verificar)) {
            verificarJuego();
        } else if (btn_actual.equals(btn_consultar)) {
            consultarMejoresJugadores();
        } else {
            moverPieza(btn_actual);
        }
    }

    private void iniciarJuego() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros);

        for (int i = 0; i < 15; i++) {
            btn_boton[i].setText(String.valueOf(numeros.get(i)));
        }
        btn_boton[15].setText("");
        timer.start();
        movimientos = 0;
        tf_movimientos.setText(String.valueOf(movimientos));
    }

    private void iniciarJuego2() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros);

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = numeros.get(index);
                btn_boton[num - 1].setText(String.valueOf(num));
                btn_boton[num - 1].setBounds(800 + 70 * j, 250 + 70 * i, 70, 70);
                index++;
            }
        }
        btn_boton[15].setText("");
        timer.start();
        movimientos = 0;
        tf_movimientos.setText(String.valueOf(movimientos));
    }

    private void verificarJuego() {
        List<Integer> valores = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            valores.add(Integer.parseInt(btn_boton[i].getText()));
        }
        if (valores.equals(getNumerosOrdenados())) {
            timer.stop();
            String nombre = JOptionPane.showInputDialog(null, "¡Felicidades! Has ganado el juego.\nIntroduce tu nombre:", "¡Ganador!", JOptionPane.INFORMATION_MESSAGE);
            if (nombre != null && !nombre.isEmpty()) {
                Jugador jugador = new Jugador(nombre, tiempo);
                mejoresJugadores.add(jugador);
                Collections.sort(mejoresJugadores);
                if (mejoresJugadores.size() > 5) {
                    mejoresJugadores = mejoresJugadores.subList(0, 5);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aún no has resuelto el juego.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultarMejoresJugadores() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mejoresJugadores.size(); i++) {
            Jugador jugador = mejoresJugadores.get(i);
            sb.append(i + 1).append(". ").append(jugador.getNombre()).append(" - ").append(formatTiempo(jugador.getTiempo())).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Mejores Jugadores", JOptionPane.INFORMATION_MESSAGE);
    }

    private void moverPieza(JButton boton) {
        int filaVacia = 0;
        int columnaVacia = 0;
        int filaBoton = 0;
        int columnaBoton = 0;

        for (int i = 0; i < 16; i++) {
            if (btn_boton[i].getText().isEmpty()) {
                filaVacia = i / 4;
                columnaVacia = i % 4;
            } else if (btn_boton[i].equals(boton)) {
                filaBoton = i / 4;
                columnaBoton = i % 4;
            }
        }

        if ((filaBoton == filaVacia && Math.abs(columnaBoton - columnaVacia) == 1) ||
                (columnaBoton == columnaVacia && Math.abs(filaBoton - filaVacia) == 1)) {
            String textoVacio = btn_boton[filaVacia * 4 + columnaVacia].getText();
            btn_boton[filaVacia * 4 + columnaVacia].setText(boton.getText());
            boton.setText(textoVacio);
            movimientos++;
            tf_movimientos.setText(String.valueOf(movimientos));
        }
    }

    private List<Integer> getNumerosOrdenados() {
        List<Integer> numerosOrdenados = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            numerosOrdenados.add(i);
        }
        numerosOrdenados.add(0);
        return numerosOrdenados;
    }

    private String formatTiempo(int tiempo) {
        int minutos = tiempo / 60;
        int segundos = tiempo % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    class Jugador implements Comparable<Jugador> {
        private String nombre;
        private int tiempo;

        public Jugador(String nombre, int tiempo) {
            this.nombre = nombre;
            this.tiempo = tiempo;
        }

        public String getNombre() {
            return nombre;
        }

        public int getTiempo() {
            return tiempo;
        }

        public int compareTo(Jugador jugador) {
            return Integer.compare(this.tiempo, jugador.getTiempo());
        }
    }
}
