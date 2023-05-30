import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Menu implements ActionListener{
    JFrame ventana;
    JMenuBar menuBar;
    JMenu mArchivo, mEdicion, mFormato, mVer, mAyuda;
    JMenuItem maAbrir, maSalir;
    JMenuItem meCopiar, mePegar;
    DefaultListModel<String>listModel;
    JList<String>lst_lista;
    JScrollPane scrollPane;


    public static void main (String []args)
    
    {
        new Menu();
    }
    Menu()
    {
        //VENTANA
        ventana = new JFrame ("MENU");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

        //MENU
        menuBar = new JMenuBar();

        //ARCHIVO
        mArchivo = new JMenu("Archivo");

        maAbrir = new JMenuItem("Abrir");
        maSalir = new JMenuItem("Salir");

        mArchivo.add(maAbrir);
        mArchivo.add(maSalir);

        //EDICION
        mEdicion = new JMenu("Edicion");

        meCopiar = new JMenuItem("Copiar");
        mePegar = new JMenuItem("Pegar");

        mEdicion.add(meCopiar);
        mEdicion.add(mePegar);

       
        //AGREGAR AL MENU
        menuBar.add(mArchivo);
        menuBar.add(mEdicion);
        //menuBar.add(mFormato);
       // menuBar.add(mVer);

        listModel = newDefaultListModel<String>();
        lst_lista = new JList<String>(listModel);
        scrollPane = new JScrollPane(lst_lista);
        scrollPane.setBounds(50,100,200,100);
        ventana.add(scrollPane);
  
       
        ventana.setJMenuBar(menuBar);

        ventana.setVisible(true); 
    }
    public void actionPerfomed (ActionEvent e)
    {
        if(e.getSource() == maSalir)
        System.exit(0);
        if(e.getSource() == maAbrir)
        abrir();
    }
    private void abrir(){
        String archivo;
        FileDialog fd = new FileDialog(ventana);
        fd.setVisible(true);
        archivo = fd.getDirectory()+fd.getFile();
        
        try {
            File f = new File(archivo);
            Scanner sc = new Scanner(f);
            while(sc.hastNextLilne())
            {
                linea = sc.nextLine();
                listModel.addElement(linea);
            }
            sc.close()
        }
        catch(Exeption e)
        {
             System.out.println("error leer");
        }
       

    }
    
}