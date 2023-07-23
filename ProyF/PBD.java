package ProyF;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class PBD {

   private String driver = "com.mysql.jdbc.Driver";
   private String URL = "jdbc:mysql://8.0.31/hospital";
   private String usuario = "root";
   private String contra = "241002";
   public Connection con;

PBD()
{
   try {
      Class.forName(driver);
      con=DriverManager.getConnection(URL, usuario, contra);
      JOptionPane.showMessageDialog(null, "Conectado con la BD");
   }catch(Exception e){
      JOptionPane.showMessageDialog(null, "No se ha podido conectar con la BD");
      
   }
}


}
