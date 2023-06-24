import javax.swing.JFrame;

public class PuzzleGame {
    
    JFrame ventana;
    public static void main(String[] args) 
    {
        new PuzzleGame();
    }

    PuzzleGame() 
    {
        // VENTANA DEL JUEGO
        ventana = new JFrame("ATRAPA EL CARDUMEN");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
