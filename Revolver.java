import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Revolver implements ActionListener
{

   JFrame ventana;
   JButton[] btn_boton;
   JButton btn_revolver, btn_mover;

   public static void main(String[] args)
   {
      new Revolver();
   }
   Revolver()
   {
      ventana = new JFrame("Revolver");
      ventana.setBounds(50,50,500,500);
      ventana.setLayout(null);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      btn_revolver = new JButton("Revolver");
      btn_revolver.setBounds(50,20,80,20);
      btn_revolver.addActionListener(this);
      ventana.add(btn_revolver);

      btn_mover = new JButton("Mover");
      btn_mover.setBounds(135,20,80,20);
      btn_mover.addActionListener(this);
      ventana.add(btn_mover);


      btn_boton = new JButton[5];
      int i;
      for (i=0;i<5;i++)
      {
         btn_boton[i] = new JButton(String.valueOf(i));
         btn_boton[i].setBounds(50+55*i,50,50,50);
         ventana.add(btn_boton[i]);  
      }

      ventana.setVisible(true);

   }

   private void revolver()
   {
      int i,j, x, y;
      Random rnd = new Random();

      for (i=0;i<5;i++)
      {
         j = rnd.nextInt(5);
      
         x = btn_boton[i].getLocation().x;
         y = btn_boton[i].getLocation().y;

         btn_boton[i].setLocation(btn_boton[j].getLocation().x,btn_boton[j].getLocation().y);
         btn_boton[j].setLocation(x,y);
      }
      ventana.repaint();

   }

   public void actionPerformed(ActionEvent e)
   {
     
      if (e.getSource() == btn_revolver)
         revolver();

      if (e.getSource() == btn_mover)
      {
         int x, y;
         x = btn_boton[0].getLocation().x;
         y = btn_boton[0].getLocation().y;
         btn_boton[0].setLocation(x,y+20);
      }    
   }
}