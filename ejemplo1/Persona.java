public class Persona
{

	private String nombre;
	private String apellido;

	Persona(String n, String a);
	{
		nombre = n;
		apellido = a;
	}
	
	public void setNombre()
	{
		nombre = "VACIO";
	}


	public void setNombre(String n)
	{
		nombre = n;
	}	

	public getNombre()
	{
		return nombre;
	}

	public void setApellido(String n)
	{
		apellido = n;
	}	

	public String getApellido()
	{
		return apellido;
	}

	public String setNombreCompleto()
	{
		return nombre+apellido;
	}
}