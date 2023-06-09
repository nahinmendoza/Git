import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Menu implements ActionListener{
    JFrame ventana;
    JMenuBar menuBar;
    JMenu mArchivo, mEdicion, mFormato, mVer, mAyuda, mModulo;
    JMenuItem maAbrir, maSalir;
    JMenuItem meCopiar, mePegar;
    JMenuItem mmContabilidad, mmFacuturacion;
    
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
        maAbrir.addActionListener(this);
        maSalir = new JMenuItem("Salir");
        maSalir.addActionListener(this);

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
        menuBar.add(mModulo);
        //menuBar.add(mFormato);
       // menuBar.add(mVer);

        mModulo = new JMenu("Modulo");
        mmContabilididad = new JMenuItem ("Contabilidad");
        mmContabilidad.addActionListener(this);
        mmFacturacion = new JMenuItem("Facturacion");
        mmFacturacion.addActionListener(this);

        mModulo.add(mmContabilididad);
        mModulo.add(mmFacturacion);
        
        
        ventana.setJMenuBar(menuBar);

        listModel = new DefaultListModel <String>();
        lst_lista = new JList<String>(listModel);
        scrollPane = new JScrollPane(lst_lista);
        scrollPane.setBounds(50,100,200,100);
        ventana.add(scrollPane);
        

        
        


       
        

        ventana.setVisible(true); 
    }
    public void actionPerfomed (ActionEvent e)
    {
        if(e.getSource() == maSalir)
        System.exit(0);
        if(e.getSource() == maAbrir)
        abrir();
        if(e.getSource() == mmContabilidad)
        new Contabilidad(ventana);
        Object mmFacturacion;
        if(e.getSource() == mmFacturacion)
        new Facturacion();


    }
    private void abrir(){
        String archivo, linea;
        FileDialog fd = new FileDialog(ventana);
        fd.setVisible(true);
        archivo = fd.getDirectory()+fd.getFile();
        
        try {
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