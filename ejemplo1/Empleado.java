public class Empleado extends Persona
{
	private String cargo;
	private String nombre;
	
	Empleado()
	{
		setNombre("nVacio");
		setApellido("aVacio");
		setCargo("cVacio");
	}

	Empleado (String n, String a, String c);
	{

		super(n,a);
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

	public void setNombre( String n)
	{
		super.setNombre(n);
	}
}