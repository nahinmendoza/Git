import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;


public class Menu implements ActionListener
{

   JFrame ventana;
   JMenuBar menuBar;
   JMenu mArchivo, mEdicion;
   JMenuItem maAbrir, maSalir;
   JMenuItem meCopiar, mePegar;

   DefaultListModel<String> listModel;
   JList<String> lst_lista;
   JScrollPane scrollPane;

   public static void main(String[] args)
   {
       new Menu();
   }

   Menu()
   {
      ventana = new JFrame("Menu");
      ventana.setBounds(100,100,500,500);
      ventana.setLayout(null);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       menuBar = new JMenuBar();
     
       mArchivo = new JMenu("Archivo");

       maAbrir = new JMenuItem("Abrir");
       maAbrir.addActionListener(this);
       maSalir = new JMenuItem("Salir");
       maSalir.addActionListener(this);

      mArchivo.add(maAbrir);
      mArchivo.add(maSalir);

      mEdicion = new JMenu("Edicion");

      meCopiar = new JMenuItem("Copiar");
      mePegar = new JMenuItem("Pegar");

      mEdicion.add(meCopiar);
      mEdicion.add(mePegar);

      menuBar.add(mArchivo);
      menuBar.add(mEdicion);
       
      ventana.setJMenuBar(menuBar);

      listModel = new DefaultListModel<String>();
      lst_lista = new JList<String>(listModel);
      scrollPane = new JScrollPane(lst_lista);
      scrollPane.setBounds(100,100,200,200);
      ventana.add(scrollPane);

      ventana.setVisible(true);
   }

   public void actionPerformed(ActionEvent e)
   {
       if (e.getSource() == maSalir)
          System.exit(0);
       if (e.getSource() == maAbrir)
          abrir();
   }

   private void abrir()
   {
      String archivo, linea;
      FileDialog fd = new FileDialog(ventana);
      fd.setVisible(true);
      archivo = fd.getDirectory()+fd.getFile();
      try
      {
         File f = new File(archivo);
         Scanner sc = new Scanner(f);
         while(sc.hasNextLine())
         {
            linea = sc.nextLine();
            listModel.addElement(linea);
         }
         sc.close();
      }
      catch(Exception e)
      {
         System.out.println("error leer");
      }
   }
}

