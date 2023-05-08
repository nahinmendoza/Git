import javax.swing.*;
import java.awt.event.*;

public class Grafico11 implements ActionListener
{
	JFrame ventana;
	JLabel lbl_nombre, lbl_apellido, lbl_button;
	JTextField tf_nombre, tf_apellido, tf_button;
	JButton btn_escribir, btn_copiar, btn_doble;

	public static void main (String[] args)
	{
		new Grafico11 ();
	}

	Grafico11 ()
	{
		ventana = new JFrame ("Mi ventana");
		ventana.setSize(600,300);
		ventana.setLocation(200,200);
		ventana.setLayout(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lbl_nombre = new JLabel("Nombre:");
		//lbl_nombre.setLocation(50,50);
		//lbl_nombe.setSize(70,20);
		lbl_nombre.setBounds(50,50,70,20);

		ventana.add(lbl_nombre);

		tf_nombre = new JTextField();
		tf_nombre.setBounds(125,50,100,20);
		ventana.add(tf_nombre);

		lbl_apellido = new JLabel("Apellido:");
		lbl_apellido.setBounds(50,75,70,20);
		ventana.add(lbl_apellido);
		
		tf_apellido = new JTextField();
		tf_apellido.setBounds(125,75,100,20);
		ventana.add(tf_apellido);		


		btn_escribir = new JButton("Escribir");
		btn_escribir.setBounds(50,100,80,20);
		btn_escribir.addActionListener(this);
		ventana.add(btn_escribir);
		
		btn_copiar = new JButton("Copiar");
		btn_copiar.setBounds(135,100,80,20);
		btn_copiar.addActionListener(this);
		ventana.add(btn_copiar);


		btn_doble = new JButton("Doble");
		btn_doble.setBounds(220,100,80,20);
		btn_doble.addActionListener(this);
		ventana.add(btn_doble);

				


		ventana.setVisible (true);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn_escribir)
			tf_nombre.setText("Juan");	
		
		if(e.getSource() == btn_copiar)
			tf_apellido.setText(tf_nombre.getText());
		if (e.getSource() == btn_doble)
		{
			int valor;
			valor = Integer.parseInt(tf_nombre.getText());
			tf_apellido.setText(String.valueOf(valor*2));
		}
				
	}


}






//public void ActionPerformed(ActionEvent e)
	//{
		//if(e.getSource() == btn_sumar)
			//{
				//int valor;
				//valor = Integer.parseInt(tf_num1.getText());
				//tf_num2.setText(String.valueOf(num1+num2));
			//}
	//}