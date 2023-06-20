public class Facturacion
{
   public static void main(String[] args)
   {
      new Facturacion();
   }

   Facturacion()
   {
       Empleado empleado = new Empleado();
       System.out.println(empleado.getNombre());
       System.out.println(empleado.getApellido());
       System.out.println(empleado.getCargo());
       System.out.println("============= 1");
       empleado.setNombre("Juan");
       empleado.setApellido("Perez");
       empleado.setCargo("vendedor");

       System.out.println(empleado.getNombre());
       System.out.println(empleado.getApellido());
       System.out.println(empleado.getCargo());
       System.out.println("=========== 2");
       System.out.println(empleado.getNombre()+" "+empleado.getApellido());
       System.out.println(empleado.getNombreCompleto());
       System.out.println("============ 3");
       empleado.setNombre();
       System.out.println(empleado.getNombre());
       System.out.println("=========== 4");

       Empleado empleado2 = new Empleado("Maria","Gonzalez","Gerente");
       System.out.println(empleado2.getNombre());
       System.out.println(empleado2.getApellido());
       System.out.println(empleado2.getCargo());
       System.out.println("=========== 5");
   }
}