import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Peces {
    private int cardumen;
    private int intentos;

    public Peces() {
        Random random = new Random();
        cardumen = random.nextInt(100);
        intentos = 0;
    }

    public int ubicarCardumen() {
        return cardumen;
    }

    public void moverCardumen() {
        Random random = new Random();
        cardumen = random.nextInt(100);
    }

    public int contarIntentos() {
        return intentos;
    }

    public void incrementarIntentos() {
        intentos++;
    }
}

class Juego implements ActionListener {
    private Peces peces;
    private JFrame frame;
    private JTextField zonaTextField;
    private JButton[] zonaButtons;
    private JButton mostrarUbicacionButton;
    private JLabel intentosLabel;
    private JLabel ubicacionLabel;
    private boolean mostrarUbicacion;

    public Juego() {
        peces = new Peces();
        mostrarUbicacion = false;

        // Configurar la interfaz gráfica
        frame = new JFrame("Pesca de Sardinas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);

        // Crear la cuadrícula de botones
        panel.setLayout(new GridLayout(10, 10));
        zonaButtons = new JButton[100];
        for (int i = 0; i < 100; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(this);
            panel.add(button);
            zonaButtons[i] = button;
        }

        mostrarUbicacionButton = new JButton("Mostrar Ubicación");
        panel.add(mostrarUbicacionButton);
        mostrarUbicacionButton.addActionListener(this);

        zonaTextField = new JTextField(10);
        panel.add(zonaTextField);

        intentosLabel = new JLabel("Intentos: 0");
        panel.add(intentosLabel);

        ubicacionLabel = new JLabel("Ubicación del cardumen: -");
        panel.add(ubicacionLabel);

        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            int zona = Integer.parseInt(button.getText());

            if (zona == peces.ubicarCardumen()) {
                int opcion = JOptionPane.showConfirmDialog(frame, "¡Has capturado al cardumen! ¿Deseas jugar de nuevo?", "¡Felicidades!", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    reiniciarJuego();
                } else {
                    System.exit(0);
                }
            } else if (estaCercaCardumen(zona)) {
                JOptionPane.showMessageDialog(frame, "El cardumen se movió. No se puede determinar la dirección en este lanzamiento.");
                peces.moverCardumen();
            } else {
                String direccion = determinarDireccion(zona, peces.ubicarCardumen());
                JOptionPane.showMessageDialog(frame, "El cardumen se movió hacia " + direccion);
            }

            peces.incrementarIntentos();
            intentosLabel.setText("Intentos: " + peces.contarIntentos());
            zonaTextField.setText("");
        } else if (e.getSource() == mostrarUbicacionButton) {
            mostrarUbicacion = !mostrarUbicacion;

            if (mostrarUbicacion) {
                ubicacionLabel.setText("Ubicación del cardumen: " + peces.ubicarCardumen());
            } else {
                ubicacionLabel.setText("Ubicación del cardumen: -");
            }
        }
    }

    public boolean estaCercaCardumen(int zona) {
        return Math.abs(zona - peces.ubicarCardumen()) == 1;
    }

    public String determinarDireccion(int zona, int cardumen) {
        int diferencia = zona - cardumen;

        if (diferencia == -11) {
            return "noroeste";
        } else if (diferencia == -10) {
            return "norte";
        } else if (diferencia == -9) {
            return "noreste";
        } else if (diferencia == -1) {
            return "oeste";
        } else if (diferencia == 1) {
            return "este";
        } else if (diferencia == 9) {
            return "suroeste";
        } else if (diferencia == 10) {
            return "sur";
        } else if (diferencia == 11) {
            return "sureste";
        }

        return "";
    }

    public void reiniciarJuego() {
        peces = new Peces();
        intentosLabel.setText("Intentos: 0");
        ubicacionLabel.setText("Ubicación del cardumen: -");
        zonaTextField.setText("");
        for (JButton button : zonaButtons) {
            button.setEnabled(true);
        }
    }
}

public class PescaSardinas {
    public static void main(String[] args) {
        new Juego();
    }
}
