import javax.swing.*;
import java.awt.event.*;


public  class CrearBotones implements ActionListener{

    JFrame ventana;
    JButton btn_boton, btn_temp, btn_inicio;
    int i;
    JLabel lbl_valor;
    JTextField tf_valor;
    public static void main(String []arg)
    {
        new CrearBotones ();
    }
    CrearBotones()
    {
        ventana = new JFrame("Crear Botones");
        ventana.setBounds(100,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (i=0; i<5; i++)
        {
            btn_boton = new JButton(String.valueOf(i));
            btn_boton.setBounds(50+85*i,50,80,20);
            btn_boton.addActionListener(this);
            ventana.add(btn_boton);
        }

        btn_inicio = new JButton ();
        

        lbl_valor = new JLabel("Valor");
        lbl_valor.setBounds(50,75,80,20);
        ventana.add(lbl_valor);

        tf_valor = new JTextField ();
        tf_valor.setBounds(135,75,80,20);
        ventana.add(tf_valor);


        ventana.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        btn_temp = (JButton)e.getSource();
        System.out.println(btn_temp.getText());
        btn_temp.setText("B"+btn_temp.getText());
       // btn_temp.setEnabled(false);
        
        if(e.getSource() == btn_boton)
        System.out.println("en actionPerformed");
    }    
}
