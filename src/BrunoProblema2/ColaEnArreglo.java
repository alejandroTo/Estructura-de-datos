package BrunoProblema2;

import Unidad2Tareas.ContenedorVacioException;

/**
 * @author ALEJANDRO
 *
 */
public class ColaEnArreglo {
	protected Object[]arreglo;
	protected int primero;
	protected int ultimo;
	protected int cantidad;
	public ColaEnArreglo()
	{
		this.arreglo = new Object[50];
		primero=0;
		ultimo = -1;
	}
	/**Construtor el cual sirve para darle un tamaño inicial a los atributos.
	 * @param tamaño: sirve para que el usuario ingrese un tamaño en especifico a la cola.
	 */
	public ColaEnArreglo(int tamaño)
	{
		this.arreglo = new Object[tamaño];
		primero=0;
		ultimo = tamaño-1;
	}
	/**
	 * 
	 */
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
	/**Metodo para agregar un objeto
	 * @param objeto : encargado de agregar el objeto a la cola.
	 */
	public void agregar(Object objeto)
	{
		if(cantidad == arreglo.length)
		{
			try {
				throw new ContainerFullException();
			} catch (ContainerFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(++ultimo == arreglo.length)
		{
			ultimo=0;
		}		
		arreglo[ultimo] = objeto;
		++cantidad;
	}
	/**Método encargado de elimniar un objeto el primero de la cola.
	 * (primeros que entran, primeros que salen).
	 * @return result: regresa el objeto acutual ya desencolado.
	 */
	public Object desencolar()
	{
		if(cantidad == 0)
		{
			return null;
		}
		else {
			Object result = arreglo[primero];
			arreglo[primero] = null;
		
			if(++primero == arreglo.length)
			{
				primero=0;
			}
			--cantidad;
			return result;
		}
	}
	/**Metodo size, encargado de saber el tamaño acutual de la cola.
	 * @return cantidad: regresa el valor actual de la cola, en tipo entero.
	 */
	public int size()
	{	
		return cantidad;
	}
	/**Meotod utilizado para saber si la cola esta vacia.
	 * @return regresa true si la cola esta vacia o false si no lo esta
	 */
	public boolean isEmpty() {
		return cantidad==0;
	}
	public String toString()
	{
		String cadena = "";
		for(int i=0; i<this.arreglo.length; i++)
		{
			if(arreglo[i]!=null)
			{
				cadena+=this.arreglo[i]+",";
				
			}
		}
		return cadena;
	}
}