import java.sql.*;

public class BD {

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
    public void abrir ()
    {
        try
        {
            con = DriverManager.getConnection(URL,user,pass);
            stmt = con.createStatement();
        } 
    catch(Exception e)
       {
           System.out.println("error listar " + e.toString());
       }   
    }

    public ResultSet executeQuery(String sql)
    {
        try 
        {
            abrir();
            ResultSet rs = stmt.executeQuery(sql);
        }
        catch(Exception e)
       {
           System.out.println("error listar " + e.toString());
       }   
       return rs;
    } 
    public void cerrar()
    {
        try
        {
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
       {
           System.out.println("error listar " + e.toString());
       } 
    }
}
