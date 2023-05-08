import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Aleatorio implements ActionListener
{
	JFrame ventana;
	JLabel lbl_numero;
	JTextField tf_numero;
	JButton btn_generar, btn_limpiar;
	Random rnd;

	public static void main (String []args)
	{
		new Aleatorio();
	}
	Aleatorio()
	{
		ventana = new JFrame ("Aleatorio");
		ventana.setSize(600,300);
		ventana.setLocation(200,200);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbl_numero = new JLabel("Numero");
		lbl_numero.setBounds(50,50,80,20);
		ventana.add(lbl_numero);
		
		tf_numero = new JTextField();
		tf_numero.setBounds(135,50,80,20);
		ventana.add(tf_numero);

		btn_generar = new JButton("Generar");
		btn_generar.setBounds(50,75,80,20);
		btn_generar.addActionListener(this);
		ventana.add(btn_generar);

		btn_limpiar = new JButton("Limpiar");
		btn_limpiar.setBounds(135,75,82,20);
		btn_limpiar.addActionListener(this);
		ventana.add(btn_limpiar);
		
		rnd = new Random();
			
		ventana.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("en actionPerformed");
		if(e.getSource() == btn_generar)
		tf_numero.setText(String.valueOf(rnd.nextInt(100)));
		if (e.getSource() == btn_limpiar)
			tf_numero.setText("");
	}

	
}
