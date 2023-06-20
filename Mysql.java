import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Mysql implements ActionListener
{

   JFrame ventana;
   JButton btn_listar;
   DefaultListModel<String> listModel;
   JList<String> lst_lista;
   JScrollPane sp_lista;

   String URL, user, pass;
   String cedula, nombre, apellido;
   String sql;

   JLabel lbl_cedula,lbl_nombre, lbl_apellido;
   JTextField tf_cedula, tf_nombre, tf_apellido;
   JButton btn_buscar, btn_agregar, btn_modificar, btn_borrar;

   public static void main(String[] args)
   {
      new Mysql();
   }

   Mysql()
   {
      ventana = new JFrame("Mysql");
      ventana.setBounds(50,50,800,800);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(null);

      btn_listar = new JButton("Listar");
      btn_listar.setBounds(50,50,80,20);
      btn_listar.addActionListener(this);
      ventana.add(btn_listar);

      listModel = new DefaultListModel<String>();
      lst_lista = new JList<String>(listModel);
      sp_lista = new JScrollPane(lst_lista);
      sp_lista.setBounds(50,75,200,200);
      ventana.add(sp_lista);

      lbl_cedula = new JLabel("Cedula:");
      lbl_cedula.setBounds(260,75,80,20);
      ventana.add(lbl_cedula);

      tf_cedula = new JTextField();
      tf_cedula.setBounds(345,75,80,20);
      ventana.add(tf_cedula);

      lbl_nombre = new JLabel("Nombre:");
      lbl_nombre.setBounds(260,100,80,20);
      ventana.add(lbl_nombre);

      tf_nombre = new JTextField();
      tf_nombre.setBounds(345,100,80,20);
      ventana.add(tf_nombre);

      lbl_apellido = new JLabel("Apellido:");
      lbl_apellido.setBounds(260,125,80,20);
      ventana.add(lbl_apellido);

      tf_apellido = new JTextField();
      tf_apellido.setBounds(345,125,80,20);
      ventana.add(tf_apellido);

      btn_buscar = new JButton("Buscar");
      btn_buscar.setBounds(430,75,80,20);
      btn_buscar.addActionListener(this);
      ventana.add(btn_buscar);

      btn_agregar = new JButton("Agregar");
      btn_agregar.setBounds(430,100,80,20);
      btn_agregar.addActionListener(this);
      ventana.add(btn_agregar);

      btn_modificar = new JButton("Modificar");
      btn_modificar.setBounds(430,125,80,20);
      btn_modificar.addActionListener(this);
      ventana.add(btn_modificar);

      btn_borrar = new JButton("Borrar");
      btn_borrar.setBounds(430,150,80,20);
      btn_borrar.addActionListener(this);
      ventana.add(btn_borrar);

      ventana.setVisible(true);
   }

   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == btn_listar)
         listar();
      if (e.getSource() == btn_buscar)
         buscar();
      if (e.getSource() == btn_agregar)
         agregar();
      if (e.getSource() == btn_modificar)
         modificar();
      if (e.getSource() == btn_borrar)
         borrar();
   }

   public void listar()
   {
      BD bd = new BD();

      cedula = "";
      nombre = "";
      apellido = "";

      sql = "";

      try
      {
         sql = "select * from cliente";
         bd.executeQuery(sql);
         listModel.clear();
         while (rs.next())
         {
            cedula = rs.getString("cedula");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            listModel.addElement(cedula + "  " + nombre + "  " + apellido);
         }
         bd.listar();
       }
       catch(Exception e)
       {
           System.out.println("error listar " + e.toString());
       }

   }

   public void buscar()
   {
      BD bd = new BD();

      cedula = "";
      nombre = "";
      apellido = "";

      sql = "";

      try
      {
         //sql = "select * from cliente where cedula = '8-2'";
         sql = "select * from cliente where cedula = '" + tf_cedula.getText() + "'";

         System.out.println(sql);

         ResultSet rs = bd.executeQuery(sql);

         if (rs.next())
         {
            cedula = rs.getString("cedula");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            tf_nombre.setText(nombre);
            tf_apellido.setText(apellido);
         }
         else
         {
            tf_nombre.setText("");
            tf_apellido.setText("");
         }
         bd.cerrar();
       }
       catch(Exception e)
       {
           System.out.println("error buscar " + e.toString());
       }

   }

   public void agregar()
   {
      URL = "jdbc:mysql://127.0.0.1/1ls221";
      user = "root";
      pass = "root";

      cedula = "";
      nombre = "";
      apellido = "";

      sql = "";

      try
      {
         Connection con = DriverManager.getConnection(URL,user,pass);
         Statement stmt = con.createStatement();
         //sql = "insert into cliente (cedula,nombre, apellido) values('8-5','Ricardo','Chan')";
         sql = "insert into cliente (cedula,nombre, apellido) values('"+ tf_cedula.getText() + "','" + tf_nombre.getText() + "','" + tf_apellido.getText() + "')";

         System.out.println(sql);

         stmt.executeUpdate(sql);

         stmt.close();
         con.close();
       }
       catch(Exception e)
       {
           System.out.println("error agregar " + e.toString());
       }

   }

   public void modificar()
   {
      URL = "jdbc:mysql://127.0.0.1/1ls221";
      user = "root";
      pass = "root";

      cedula = "";
      nombre = "";
      apellido = "";

      sql = "";

      try
      {
         Connection con = DriverManager.getConnection(URL,user,pass);
         Statement stmt = con.createStatement();
         //sql = "update cliente set nombre = 'Pedro', apellido = 'Castro' where cedula = '8-5'";
         sql = "update cliente set nombre = '" + tf_nombre.getText() + "', apellido = '" + tf_apellido.getText() + "' where cedula = '" + tf_cedula.getText() + "'";

         System.out.println(sql);

         stmt.executeUpdate(sql);

         stmt.close();
         con.close();
       }
       catch(Exception e)
       {
           System.out.println("error agregar " + e.toString());
       }
   }


   public void borrar()
   {
      URL = "jdbc:mysql://127.0.0.1/1ls221";
      user = "root";
      pass = "root";

      cedula = "";
      nombre = "";
      apellido = "";

      sql = "";

      try
      {
         Connection con = DriverManager.getConnection(URL,user,pass);
         Statement stmt = con.createStatement();
         //sql = "delete from cliente where cedula = '8-5'";
         sql = "delete from cliente where cedula = '" + tf_cedula.getText() + "'";

         System.out.println(sql);

         stmt.executeUpdate(sql);

         stmt.close();
         con.close();
       }
       catch(Exception e)
       {
           System.out.println("error agregar " + e.toString());
       }

   }
}












  