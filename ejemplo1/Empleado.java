public class Empleado extends Persona
{
   private String cargo;
   Empleado()
   {
       setNombre("nVACIO");
       setApellido("aVACIO");
       setCargo("cVACIO");
   }

   Empleado(String n, String a, String c)
   {
      //setNombre(n);
      //setApellido(a);
      super(n, a);
      setCargo(c);
   }


   public void setCargo(String n)
   {
      cargo = n;
   }
   public String getCargo()
   {
      return cargo;
   }

   public void setNombre(String n)
   {
      super.setNombre(n);
   }

}