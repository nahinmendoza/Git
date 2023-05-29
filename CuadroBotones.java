import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CuadroBotones implements ActionListener{
    JFrame ventana;
    JButton btn_boton;
    JLabel lbl_nombre;
    int i,j;

    public static void main(String []args){
        new CuadroBotones();
    }
    CuadroBotones()
    {
        ventana = new JFrame ("ENCUENTRA EL CARDUMEN");
        ventana.setBounds(500,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        for (int i = 0; i < 5; i++) 
        {
            for (int j = 0; j < 5; j++)
            {  
                btn_boton = new JButton(String.valueOf(i));
                btn_boton.setBounds(50+85*i,50,80,20);
                btn_boton.addActionListener(this);
                ventana.add(btn_boton);
            }
        }
           
       
        //lbl_nombre = new JLabel("Nahin Mendoza");
        //lbl_nombre.setBounds(135,75,80,20);
        //ventana.add(lbl_nombre);


        ventana.setVisible(true);


    }
    public void actionPerformed(ActionEvent e)
    {    

    }
} 
