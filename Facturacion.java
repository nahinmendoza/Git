import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
public class Facturacion {
    
    JFrame v;
    JLabel lbl_titulo;
    Font font1;

    Facturacion(JFrame x)
    {
        v = x;
        v.getContentPane().removeAll();
        v.getContentPane().setBackground(Color.GREEN);
        v.revalidate();

        font1 = new Font("Edwardian Script ITC",Font.BOLD,50); // PLAIN, BOLD, ITALIC

        lbl_titulo = new JLabel ("Facturacion");
        lbl_titulo.setFont(font1);
        lbl_titulo.setForeground(Color.RED);
        lbl_titulo.setBounds(50,50,250,70);
        v.add(lbl_titulo);
        
        v.repaint();
    }

}
