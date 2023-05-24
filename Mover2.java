import javax.swing.*;
import java.awt.event.*;

public class Mover2 
{
    JFrame ventana;
    JButton btn_boton, btn_bajar, btn_subir, btn_izq, btn_der;
    int diry = 0;

    Timer timer = new Timer(500, new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            int x,y;
        x = btn_boton.getLocation().x;
        y = btn_boton.getLocation().y;

         btn_boton.setLocation(x,y+diry);

        }
    });
    public static void main (String []args)
    {
        new Mover2();
    }
    Mover2()
    {
        ventana = new JFrame ("Mover");
        ventana.setBounds(100,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);

        btn_boton = new JButton("Boton");
        btn_boton.setBounds(300,300,80,20);
        ventana.add(btn_boton);

        btn_bajar = new JButton("Bajar");
        btn_bajar.setBounds(1000,300,80,20);
        ventana.add(btn_bajar);

        btn_subir = new JButton("Subir");
        btn_subir.setBounds(1000,250,80,20);
        ventana.add(btn_subir);

        btn_izq = new JButton("Izquierda");
        btn_izq.setBounds(910,275,80,20);
        ventana.add(btn_izq);

        btn_der = new JButton("Derecha");
        btn_der.setBounds(1085,275,80,20);
        ventana.add(btn_der);

        timer.start();
    }
    public void actionPerformed (ActionEvent e)
    {
       // int x,y;
        //x = btn_boton.getLocation().x;
        //y = btn_boton.getLocation().y;

        if(e.getSource() == btn_bajar)
            //btn_boton.setLocation(x,y+10);
            diry = 10;

        if(e.getSource() == btn_subir)
            //btn_boton.setLocation(x,y-10);
            diry = -10;

        //if(e.getSource() == btn_izq)
           // btn_boton.setLocation(x-10,y);

        //if(e.getSource() == btn_der)
            //btn_boton.setLocation(x+10,y);
    }
}


