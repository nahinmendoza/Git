import java.sql.*;

public class Cliente
{

   String cedula, nombre, apellido;

   Cliente()
   {
      iniciar();
   }

   public void setCedula(String c)
   {
      cedula = c;
   }
   public String getCedula()
   {
      return cedula;
   }
  
   public void setNombre(String c)
   {
      nombre= c;
   }
   public String getNombre()
   {
      return nombre;
   }

   public void setApellido(String c)
   {
      apellido=c;
   }
   public String getApellido()
   {
      return apellido;
   }

   public void iniciar()
   {
      cedula = "";
      nombre = "";
      apellido = "";

   }

   public void buscar(String ced)
   {
      BD bd = new BD();
      iniciar();
      String sql = "";
      try
      {
         //sql = "select * from cliente where cedula = '8-2'";
         sql = "select * from cliente where cedula = '" + ced + "'";

         System.out.println(sql);
         System.out.println("en CLIENTE");

         ResultSet rs = bd.executeQuery(sql);

         if (rs.next())
         {
            cedula = rs.getString("cedula");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
         }

        bd.cerrar();
       }
       catch(Exception e)
       {
           System.out.println("error buscar " + e.toString());
       }

   }



}