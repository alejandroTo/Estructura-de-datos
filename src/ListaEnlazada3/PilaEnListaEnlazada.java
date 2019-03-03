package ListaEnlazada3;


public class PilaEnListaEnlazada  implements Stack{
	protected int contar;
	protected LinkedList list;
	public PilaEnListaEnlazada()
	{
		list = new LinkedList();
	}
	public void purge()
	{
		list.purge();
		contar=0;
	}
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
	public void push(Object ob)
	{
		list.prepend(ob);
		++contar;
	}
	public Object pop()
	{
		if(contar== 0)
			return null;
		Object result = list.getFirst();
		list.extract(result);
		--contar;
		return result;
		
	}
	public Object getTop()
	{
		if(contar==0)
		{
			return null;
		}
		else
		{
			return list.getFirst();
		}
	}
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isEmpty()
	{
		return contar==0;
	}
	public String toString()
	{
		return list.toString();
	}
	public int size()
	{
		return contar;
	}
}
