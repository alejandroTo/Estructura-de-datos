package Unidad2Tareas;

public class ColaEnArreglo {
	protected Object[]arreglo;
	protected int primero;
	protected int ultimo;
	protected int cantidad;

	public ColaEnArreglo(int tam)
	{
		arreglo = new Object[tam];
		primero = 0;
		ultimo = tam-1;
	}
	public void reiniciar()
	{
		while(cantidad >0)
		{
			arreglo[primero] = null;
			if(++primero ==arreglo.length)
			{
				primero = 0;
			}
			else
			{
				--cantidad;
			}
		}
	}
	public boolean isVacia()
	{
		return cantidad ==0;
	}
	public Object getPrimero()
	{
		if(cantidad==0)
		{
			try {
				throw new ContenedorVacioException();
			} catch (ContenedorVacioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return arreglo[primero];
	}
	public void agregar(Object objeto)
	{
		if(cantidad == arreglo.length)
		{
			
		}
	}
	
}