import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mendoza950Proy2 extends JFrame implements ActionListener {
    private JButton[] btn_boton;
    private JButton btn_iniciar;
    private JButton btn_iniciar2;
    private JButton btn_verificar;
    private JTextField nombreField;
    private JButton btn_guardar;
    private JButton btn_consultar;
    private Timer timer;
    private int movimientos;
    private int seg;
    private JLabel lbl_tiempo;
    private JLabel lbl_movimientos;
    private List<jugador> jugador;
    JFrame ventana;

    private static final int tamano = 16;
    private static final int dimension = 4;

    public Mendoza950Proy2() {
        ventana = new JFrame("Rompecabeza");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel rompecabeza= new JPanel(new GridLayout(dimension, dimension));

        btn_boton = new JButton[tamano];

        for (int i = 0; i < tamano; i++) {
            btn_boton[i] = new JButton();
            btn_boton[i].addActionListener(this);
            btn_boton[i].setPreferredSize(new Dimension(80, 80)); // Cambiar tamaño de los botones
            rompecabeza.add(btn_boton[i]);
        }

        add(rompecabeza, BorderLayout.CENTER);

        JPanel ventana = new JPanel(new FlowLayout());

        btn_iniciar = new JButton("Iniciar");
        btn_iniciar.addActionListener(this);
        ventana.add(btn_iniciar);

        btn_iniciar2 = new JButton("Iniciar2");
        btn_iniciar2.addActionListener(this);
        ventana.add(btn_iniciar2);

        btn_verificar = new JButton("Verificar");
        btn_verificar.addActionListener(this);
        ventana.add(btn_verificar);

        nombreField = new JTextField(10);
        ventana.add(nombreField);

        btn_guardar = new JButton("Guardar");
        btn_guardar.addActionListener(this);
        ventana.add(btn_guardar);

        btn_consultar = new JButton("Consultar archivo");
        btn_consultar.addActionListener(this);
        ventana.add(btn_consultar);

        lbl_tiempo = new JLabel("Tiempo: 0 segundos");
        ventana.add(lbl_tiempo);

        lbl_movimientos = new JLabel("Movimientos: 0");
        ventana.add(lbl_movimientos);

        add(ventana, BorderLayout.SOUTH);

        timer = new Timer(1000, new TimerListener());

        jugador = new ArrayList<>();

        // LABEL PARA LA PRESENTACION
        JPanel presentaciion = new JPanel(new GridLayout(9, 2));
        presentaciion.setBounds(50, 150, 200, 350); // Posicionar el panel de presentación
        presentaciion.setBackground(Color.WHITE); // Cambiar el color de fondo del panel

        JLabel lbl_presentacion1 = new JLabel("UNIVERSIDAD TECNOLOGICA DE PANAMA");
        presentaciion.add(lbl_presentacion1);

        JLabel lbl_presentacion2 = new JLabel("FACULTAD DE INGENIERIA DE SISTEMAS COMPUTACIONALES");
        presentaciion.add(lbl_presentacion2);

        JLabel lbl_presentacion3 = new JLabel("LIC. EN DESARROLLO DE SOFTWARE");
        presentaciion.add(lbl_presentacion3);

        JLabel lbl_presentacion4 = new JLabel("DESARROLLO DE SOFTWARE 3");
        presentaciion.add(lbl_presentacion4);

        JLabel lbl_presentacion5 = new JLabel("RICARDO CHAN");
        presentaciion.add(lbl_presentacion5);

        JLabel lbl_presentacion6 = new JLabel("NAHIN MENDOZA");
        presentaciion.add(lbl_presentacion6);

        JLabel lbl_presentacion7 = new JLabel("8-989-50");
        presentaciion.add(lbl_presentacion7);

        JLabel lbl_presentacion8 = new JLabel("1LS221");
        presentaciion.add(lbl_presentacion8);

        JLabel lbl_presentacion9 = new JLabel("03/07/2023");
        presentaciion.add(lbl_presentacion9);

        ventana.add(presentaciion);

        setVisible(true);
    }

    private void iniciar() {
        timer.start();

        List<Integer> numero = new ArrayList<>();
        for (int i = 1; i < tamano; i++) {
            numero.add(i);
        }
        Collections.shuffle(numero);

        for (int i = 0; i < tamano - 1; i++) {
            btn_boton[i].setText(String.valueOf(numero.get(i)));
        }
        btn_boton[tamano - 1].setText("");

        movimientos = 0;
        seg = 0;
    }

    private void iniciar2() {
        iniciar();
        int vacio = posc_vacia();
        if (vacio == tamano - 1 || vacio == -1) {
            return;
        }
        int lastIndex = tamano - 2;
        btn_cambios(vacio, lastIndex);
    }

    private void mover_btn(int buttonIndex) {
        int vacio = posc_vacia();

        if (adjac(buttonIndex, vacio)) {
            btn_cambios(buttonIndex, vacio);
            movimientos++;
            updatelbl_movimientos();

            if (resuelto()) {
                timer.stop();
                String nombre = nombreField.getText();
                jugador jugador_act = new jugador(nombre, seg);
                jugador.add(jugador_act);
                Collections.sort(jugador);
                if (jugador.size() > 5) {
                    jugador = jugador.subList(0, 5);
                }
                JOptionPane.showMessageDialog(this, "¡Felicidades, has resuelto el rompecabezas!");
            }
        }
    }

    private int posc_vacia() {
        for (int i = 0; i < tamano; i++) {
            if (btn_boton[i].getText().equals("")) {
                return i;
            }
        }
        return -1;
    }

    private boolean adjac(int buttonIndex, int vacio) {
        int row1 = buttonIndex / dimension;
        int col1 = buttonIndex % dimension;
        int row2 = vacio / dimension;
        int col2 = vacio % dimension;

        return (row1 == row2 && Math.abs(col1 - col2) == 1) || (col1 == col2 && Math.abs(row1 - row2) == 1);
    }

    private void btn_cambios(int index1, int index2) {
        String tempText = btn_boton[index1].getText();
        btn_boton[index1].setText(btn_boton[index2].getText());
        btn_boton[index2].setText(tempText);
    }

    private boolean resuelto() {
        for (int i = 0; i < tamano - 1; i++) {
            if (!btn_boton[i].getText().equals(String.valueOf(i + 1))) {
                return false;
            }
        }
        return btn_boton[tamano - 1].getText().equals("");
    }

    private void updatelbl_movimientos() {
        lbl_movimientos.setText("Movimientos: " + movimientos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_iniciar) {
            iniciar();
        } else if (e.getSource() == btn_iniciar2) {
            iniciar2();
        } else if (e.getSource() == btn_verificar) {
            if (resuelto()) {
                JOptionPane.showMessageDialog(this, "¡El rompecabezas está en orden!");
            } else {
                JOptionPane.showMessageDialog(this, "El rompecabezas aún no está en orden.");
            }
        } else if (e.getSource() == btn_guardar) {
            String nombre = nombreField.getText();
            jugador jugador_act = new jugador(nombre, seg);
            jugador.add(jugador_act);
            Collections.sort(jugador);
            if (jugador.size() > 5) {
                jugador = jugador.subList(0, 5);
            }
            JOptionPane.showMessageDialog(this, "Jugador guardado correctamente.");
        } else if (e.getSource() == btn_consultar) {
            StringBuilder jugadorList = new StringBuilder("Lista de jugadores:\n");
            for (jugador jugador : jugador) {
                jugadorList.append(jugador.getName()).append(": ").append(jugador.getTime()).append(" segundos\n");
            }
            JOptionPane.showMessageDialog(this, jugadorList.toString());
        } else {
            for (int i = 0; i < tamano; i++) {
                if (e.getSource() == btn_boton[i]) {
                    mover_btn(i);
                    break;
                }
            }
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            seg++;
            lbl_tiempo.setText("Tiempo: " + seg + " segundos");
        }
    }

    private static class jugador implements Comparable<jugador> {
        private String name;
        private int time;

        public jugador(String name, int time) {
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(jugador o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Mendoza950Proy2();
            }
        });
    }
}
