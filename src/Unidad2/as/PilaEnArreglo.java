package Unidad2.as;

/**
 * Programa que lee una pila de String
 *la invierte y muestra su original y invertida
 * La clase pilaArreglo utiliza un arreglo
 * de tamaño fijo de longitud 5 sis e inoca el 
 * constructor sin parametros en una pila
 * em una pila de mayor tamaño se debe
 * de utilizar el constructor con el 
 * paramteros tamaño.
 *
 * 
 * @author ALEJANDRO
 *
 */
 
 
public class PilaEnArreglo implements InterfaceStack {
	
	protected Object []array;
	
	public PilaEnArreglo()
	{
		array = new Object[5];
	}
	public PilaEnArreglo(int tam)
	{
		array = new Object[tam];
	}
	@Override
	public boolean isEmpety() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getTop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(Object ob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
