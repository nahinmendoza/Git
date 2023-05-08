import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Adivina implements ActionListener
{
	JFrame ventana;
	JLabel lbl_computadora, lbl_usuario, lbl_mensaje, lbl_intento;
	JTextField tf_computadora, tf_usuario, tf_mensaje, tf_intento;
	JButton btn_iniciar, btn_validar;
	Random rnd;
	public static void main (String[]args)
	{
		new Adivina();
	}
	Adivina()
	{
		ventana = new JFrame("Adivina");
		ventana.setBounds(100,100,500,500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		lbl_computadora = new JLabel("Computadora");
		lbl_computadora.setBounds(50,50,100,20);
		ventana.add(lbl_computadora);

		lbl_usuario = new JLabel("Usuario");
		lbl_usuario.setBounds(50,75,100,20);
		ventana.add(lbl_usuario);

		lbl_mensaje = new JLabel("Mensaje");
		lbl_mensaje.setBounds(50,100,100,20);
		ventana.add(lbl_mensaje);
		
		lbl_intento = new JLabel("Intento");
		lbl_intento.setBounds(50,125,100,20);
		ventana.add(lbl_intento);

		tf_computadora = new JTextField();
		tf_computadora.setBounds(155,50,50,20);
		tf_computadora.setVisible(true);
		ventana.add(tf_computadora);

		tf_usuario = new JTextField();
		tf_usuario.setBounds(155,75,50,20);
		ventana.add(tf_usuario);
		
		tf_mensaje = new JTextField();
		tf_mensaje.setBounds(155,100,50,20);
		ventana.add(tf_mensaje);
		
		tf_intento = new JTextField();
		tf_intento.setBounds(155,125,50,20);
		//tf_intento.setText("0");
		ventana.add(tf_intento);

		btn_iniciar = new JButton("Iniciar");
		btn_iniciar.setBounds(210,50,80,20);
		btn_iniciar.addActionListener(this);
		ventana.add(btn_iniciar);
		
		btn_validar = new JButton("Validar");
		btn_validar.setBounds(210,75,80,20);
		btn_validar.addActionListener(this);
		ventana.add(btn_validar);

		rnd = new Random();
		ventana.setVisible(true);

	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==btn_iniciar)
		{	
			tf_computadora.setText(String.valueOf(rnd.nextInt(100)+1));
			btn_iniciar.setEnabled(false);
		}
			if(e.getSource()==btn_validar)
			{
				System.out.println("u:"+tf_usuario.getText());
				System.out.println("c:"+tf_computadora.getText());
				System.out.print("alto:");
				System.out.println(tf_usuario.getText().compareTo(tf_computadora.getText()) > 0));
				System.out.println("bajo:");
				System.out.prinln(tf_usuario.getText().compareTo(tf_computadora.getText()) > 0));
				//if(tf_usuario.getText().compareTo(tf_computadora.getText()) > 0)
				if(Integer.parseInt(tf_usuario.getText()) > Integer.parseInt(tf_computadora.getText()))
					tf_mensaje.setText("Muy Alto");
				else 
					//if(tf_usuario.getText().compareTo(tf_computadora.getText()) < 0)
					if(Integer.parseInt(tf_usuario.getText() < Integer.parseInt(tf_computadora.getText()))
						tf_mensaje.setText("Muy Bajo");
				else
				{	
					tf_mensaje.setText("Correcto");
					btn_iniciar.setEnable(true);
				}
				tf_intento.setText(String.valueOf(Integer.parseInt(tf_intento.getText())+1));
			}
	}
}