package BrunoProblema2;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/**Clase instanciable PilaEnArreglo la cual implementa una interface llamada IntefaceStack.
 * En la cúal se hacen los metodos de agregar datos a la pila, borrarle datos a la pila,
 * ver si esta vacia la pila y saber cual es el tamaño de esta.
 * @author ALEJANDRO
 *
 */
public class PilaEnArreglo implements InterfaceStack {
	
	protected Object []array;
	protected int primero;
	protected int ultimo;
	protected int contar;
	public PilaEnArreglo()
	{
		array = new Object[5];
	}
	/**Constructor de PilaEnarreglo con un parametro tamaño
	 * @param tam: sirve para que el usuario pueda darle un tamaño en especifico a la pila.
	 */
	public PilaEnArreglo(int tam)
	{
		array = new Object[tam];
	}
	/**Metodo getContar el cual regresa el valor acutual del contador en un entero.
	 * @return Contar:regresa el valor actual del contador
	 */
	public int getContar() {
		return contar;
	}
	public void setContar(int contar) {
		this.contar = contar;
	}
	public void reiniciar()
	{
		while(this.contar>0)
		{
			array[--this.contar] = null;
		}
	}
	public void agregar(Object objeto)
	{
		if(this.contar == this.array.length)
		{
			try {
				throw new ContainerFullException();
			} catch (ContainerFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			array[contar++] = objeto;
		}
	}
	public Object borrar()
	{
		if(contar==0)
		{
			try {
				throw new ContainerEmptyException();
			} catch (ContainerEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Object result = array[--contar];
		array[contar] = null;
		return result;
	}
	public Object verSuperior()
	{
		if(contar == 0)
		{
			try {
				throw new ContainerEmptyException();
			} catch (ContainerEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			return this.array[contar - 1];
		}
		return this.array[contar - 1];
	}
	/*public void aceptar(Visitor visitor)
	{
		
	}*/
	public Enumeration<?> getEnumeracion()
	{
		return new Enumeration<Object>()
		{
			protected int posicion=0;
			
			@Override
			public boolean hasMoreElements() {
				// TODO Auto-generated method stub
				return posicion < getContar();
			}
			@Override
			public Object nextElement() {
				// TODO Auto-generated method stub
				if(posicion>=getContar())
				{
					throw new NoSuchElementException();
				}
				return array [posicion++];
			}
		};
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return contar==0;
	}
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return contar == array.length;
	}
	/**Metodo size.El cual sireve para saber el tamaño de la pila.
	 * @return contar: regresa el tamaño actual de la pila, de tipo entero.
	 */
	public int size()
	{
		return contar;
	}
	public String toString()
	{
		String cadena = "";
		for(int i=0; i<this.array.length; i++)
		{
			cadena+=this.array[i]+",";
		}
		return cadena;
	}
}