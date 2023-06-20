import javax.swing.JFrame;

public class PuzzleProy {
    
    JFrame ventana;
    public static void main(String[] args) 
    {
        new PuzzleProy();
    }

    PuzzleProy() 
    {
        // VENTANA DEL JUEGO
        ventana = new JFrame("ATRAPA EL CARDUMEN");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
