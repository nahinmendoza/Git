import java.awt.Color;
import javax.swing.*;

public class Contabilidad 
{
    JFrame v;
    JLabel lbl_titulo;

    Contabilidad(JFrame x)
    {
        v = x;
        v.getContentPane().removeAll();
        v.getContentPane().setBackground(Color.YELLOW);
        v.revalidate();

        lbl_titulo = new JLabel ("Contabilidad");
        lbl_titulo.setBounds(50,50,150,20);
        v.add(lbl_titulo);
        
        v.repaint();
    }
    
}
