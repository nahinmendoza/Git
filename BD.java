import java.sql.*;

public class BD
{
   String URL, user, pass;
   Connection con;
   Statement stmt;
   ResultSet rs;

   BD()
   {
      URL = "jdbc:mysql://127.0.0.1/1ls221";
      user = "root";
      pass = "root";
   }

   public void abrir()
   {
       try
       {
         con = DriverManager.getConnection(URL,user,pass);
         stmt = con.createStatement();
       }
       catch(Exception e)
       {
           System.out.println("error abrir " + e.toString());
       }
   }

   public ResultSet executeQuery(String sql)
   {
       System.out.println("En BD");
       try
       {
          abrir();
          rs = stmt.executeQuery(sql);    
       }
       catch(Exception e)
       {
           System.out.println("error Query " + e.toString());
       }  
       return rs;
   }

   public void executeUpdate(String sql)
   {
       System.out.println("En BD");
       System.out.println(sql);
       try
       {
          abrir();
          stmt.executeUpdate(sql);    
       }
       catch(Exception e)
       {
           System.out.println("error Update " + e.toString());
       }  
   }

   public void cerrar()
   {
       try
       {
        if (rs != null)
            rs.close();
         stmt.close();
         con.close();
       }
       catch(Exception e)
       {
           System.out.println("error cerrar " + e.toString());
       }  
      
   }

}