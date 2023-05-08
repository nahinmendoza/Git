import javax.swing.*;
import java.awt.event.*;

public class Calculadora
{
	JFrame ventana;
	JLabel lbl_num1, lbl_num2, lbl_resp;
	JTextField tf_num1, tf_num2, tf_resp;
	JButton btn_sumar;

	public static void main (String [] args)
	{
		new Calculadora();
	}
	Calculadora ()
	{
		ventana = new JFrame("Calculadora");
		ventana.setBounds(100,100,500,500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);

		lbl_num1 = new JLabel("Num1");
		lbl_num1.setBounds(20,20,50,20);
		ventana.add(lbl_num1);
		
		tf_num1 = new JTextField();
		tf_num1.setBounds(75,20,50,20);
		ventana.add(tf_num1);
		
		lbl_num2 = new JLabel("Num2");
		lbl_num2.setBounds(50,30,50,20);
		ventana.add(lbl_num2);
		
		tf_num2 = new JTextField();
		tf_num2.setBounds(75,45,50,20);
		ventana.add(tf_num2);
		
		lbl_resp = new JLabel("Resp");
		lbl_resp.setBounds(20,70,50,20);
		ventana.add(lbl_resp);
		
		tf_resp = new JTextField();
		tf_resp.setBounds(75,70,50,20);
		ventana.add(tf_resp);

		
		btn_sumar = new JButton("Sumar");
		btn_sumar.setBounds(20,95,70,20);
		btn_sumar.addActionListener(this);
		ventana.add(btn_sumar);

	



		ventana.setVisible(true);

	}
	
}