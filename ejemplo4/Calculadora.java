import javax.swing.*;
import java.awt.event.*;

public class Calculadora implements ActionListener
{

   JFrame ventana;
   JLabel lbl_num1, lbl_num2, lbl_res;
   JTextField tf_num1, tf_num2, tf_res;
   JButton btn_sumar;

   public static void main(String[] args)
   {
      new Calculadora();
   }

   Calculadora()
   {
      ventana = new JFrame("Calculadora");
      ventana.setBounds(100,100,500,500);
      ventana.setLayout(null);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      lbl_num1 = new JLabel("Num1");
      lbl_num1.setBounds(20,20,50,20);
      ventana.add(lbl_num1);

      tf_num1 = new JTextField();
      tf_num1.setBounds(75,20,50,20);
      ventana.add(tf_num1);

      lbl_num2 = new JLabel("Num2");
      lbl_num2.setBounds(20,45,50,20);
      ventana.add(lbl_num2);

      tf_num2 = new JTextField();
      tf_num2.setBounds(75,45,50,20);
      ventana.add(tf_num2);

      lbl_res = new JLabel("Res");
      lbl_res.setBounds(20,70,50,20);
      ventana.add(lbl_res);

      tf_res = new JTextField();
      tf_res.setBounds(75,70,50,20);
      ventana.add(tf_res);

      btn_sumar = new JButton("Sumar");
      btn_sumar.setBounds(20,95,80,20);
      btn_sumar.addActionListener(this);
      ventana.add(btn_sumar);

      ventana.setVisible(true);

   }

   public void actionPerformed(ActionEvent e)
   {
      int num1, num2, res=0;
      num1 = Integer.parseInt(tf_num1.getText());
      num2 = Integer.parseInt(tf_num2.getText());
      if (e.getSource() == btn_sumar)
         res = num1 + num2;
         tf_res.setText(String.valueOf(res));
   }
   
}