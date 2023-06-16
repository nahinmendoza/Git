import javax.swing.*;

public class Puzzle {

    JFrame ventana;

    public void main (String []args) {
        new Puzzle();
    }

    Puzzle()
    {
         // VENTANA DEL JUEGO
         ventana = new JFrame("ATRAPA EL CARDUMEN");
         ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
         ventana.setLayout(null);
         ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         ventana.setVisible(true);
    }
}

