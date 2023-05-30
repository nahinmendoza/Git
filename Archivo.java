import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Archivo implements ActionListener
{

   JFrame ventana;

   JLabel lbl_nombre, lbl_apellido;
   JTextField tf_nombre, tf_apellido;
   JButton btn_grabar, btn_leer;
   DefaultListModel<String>listmodel;
   JList<String>lst_lista;
   JScrollPane scrollPane;

   public static void main(String[] args)
   {
      new Archivo();
   }
   Archivo()
   {
      ventana = new JFrame("Archivo");
      ventana.setBounds(100,100,500,500);
      ventana.setLayout(null);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      lbl_nombre = new JLabel("Nombre");
      lbl_nombre.setBounds(50,50,80,20);
      ventana.add(lbl_nombre);

      tf_nombre = new JTextField();
      tf_nombre.setBounds(135,50,80,20);
      ventana.add(tf_nombre);

      lbl_apellido = new JLabel("Apellido");
      lbl_apellido.setBounds(50,75,80,20);
      ventana.add(lbl_apellido);

      tf_apellido = new JTextField();
      tf_apellido.setBounds(135,75,80,20);
      ventana.add(tf_apellido);

      btn_grabar = new JButton("Grabar");
      btn_grabar.setBounds(220,50,80,20);
      btn_grabar.addActionListener(this);
      ventana.add(btn_grabar);

      btn_leer = new JButton("Leer");
      btn_leer.setBounds(220,75,80,20);
      btn_leer.addActionListener(this);
      ventana.add(btn_leer);

      listmodel = new DefaultListModel<String>();
      lst_lista = new JList<String>(listmodel);
      //lt_lista.setBounds(50,100,200,100);
      //ventana.add(lst_lista);

      scrollPane = new JScrollPane(lst_lista);
      scrollPane.setBounds(50,100,200,100);
      ventana.add(scrollPane);

      ventana.setVisible(true);

   }
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == btn_grabar)
          grabar();
      if (e.getSource() == btn_leer)
          leer();
   }


   private void grabar()
   {
      FileWriter fw;
      try
     {
         fw = new FileWriter("cliente.txt",true); // true=append false=overwrite
         fw.write(tf_nombre.getText()+"\n");
         fw.write(tf_apellido.getText()+"\n");
         fw.close();
     }
      catch(Exception e)
     {
         System.out.println("Error grabando "+e.toString());
     }
   } 
   
   private void leer()
   {
      File f = new File("cliente.txt");
      Scanner sc;
      String nombre, apellido;
      try
      {
        listmodel.clear(); 
        sc = new Scanner(f);
         while (sc.hasNextLine())
         {
            nombre = sc.nextLine();
            apellido = sc.nextLine();
            System.out.println(nombre+" "+apellido);
            listmodel.addElement(nombre+" "+apellido);
         }
      }
      catch(Exception e)
      {
          System.out.println("Error leer " + e.toString());
      }

   }

}





