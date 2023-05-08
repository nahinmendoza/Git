import javax.swing.*;

public class Grafico

{
	JFrame ventana;
	JLabel lbl_texto;
	public static void main (String[] args)
	{
		new Grafico();
	}
	
	Grafico()
	{
		ventana = new JFrame("Mi Primera Ventana");
		ventana.setSize(600,300);
		ventana.setLocation(200,200);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lbl_texto = new JLabel("Hola Mundo");
		lbl_texto.setSize(120,20);
		lbl_texto.setLocation(40,40);
		ventana.add(lbl_texto);

		
		ventana.setVisible(true);
	}

}
