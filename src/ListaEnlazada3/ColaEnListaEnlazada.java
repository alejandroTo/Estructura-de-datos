package ListaEnlazada3;

import listasEnlazadas2.LinkedList;

public class ColaEnListaEnlazada implements Cola{
	protected int contar;
	protected LinkedList list;
	public ColaEnListaEnlazada()
	{
		list = new LinkedList();
	}
	/**Metodo getContar el cual regresa el valor acutual del contador en un entero.
	 * @return Contar:regresa el valor actual del contador
	 */
	//limpiar o purgar los datos. Igualando a null.
	public void purge()
	{
		list.purge();
		contar=0;
	}
	//Clase Element
	//
	public Object getHead()
	{
		if(contar == 0)
		{
			return null;
		}
		else
		{
			return list.getFirst();
		}
	}
	public void enqueue(Object ob)
	{
		list.append(ob);
		++contar;
	}
	public Object dequeue()
	{
		if(contar==0)
		{
			return null;
		}
		else
		{
			Object result = list.getFirst();
			list.extract(result);
			--contar;
			return result;
		}
	}
	public int size()
	{
		return list.size();
	}
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	public String toString()
	{
		return list.toString();
	}
	@Override
	public Object getFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

}
