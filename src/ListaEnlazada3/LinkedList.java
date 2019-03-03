package ListaEnlazada3;


public class LinkedList {

	protected Element head;
	protected Element tail;
	
	public LinkedList() 
	{
		
	}
	
	public void purge () 
	{
		head = null;
		tail = null;
	}
	
	public Element getHead() 
	{
		return head;
	}
	
	public Element getTail() 
	{
		return tail;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public Object getFirst() 
	{
		if (head == null)
			return null;
		return head.datum;
	}
	
	public Object getLast()
	{
		if (tail == null)
			return  null;
		return tail.datum;
	}
	
	public void prepend(Object item) 
	{
		Element tmp = new Element(item, head);
		if (head == null)
			tail = tmp;
		head = tmp;
		/*Element tmp = new Element(item, head);
		if(head == null)
			tail = tmp;
		head = tmp;*/
	}
	
	public void append (Object item)
	{
		Element tmp = new Element(item, null);
		if (head == null)
			head = tmp;
		else
			tail.next = tmp;
		tail = tmp;
	}
	
	public void assign (LinkedList List)
	{
		if (List != this) 
		{
			purge();
			for (Element ptr = List.head; ptr != null; ptr = ptr.next) 
			{
				append(ptr.datum);
			}
		}	
	}
	
	public void extract (Object item) 
	{
		Element ptr = head;
		Element prevPtr = null;
		
		while(!ptr.equals(null) && !ptr.datum.equals(item)) 
		{
			prevPtr = ptr;
			ptr = ptr.next;
		}
		if(ptr.equals(null))
			throw new IllegalArgumentException("Item not found");
		if(ptr.equals(head))
			head = ptr.next;
		else
			prevPtr.next = ptr.next;
		if(ptr.equals(tail))
			tail = prevPtr;
	}
	public int size()
	{
		Element referencia = head;
		int cont=0;
		while(referencia !=null)
		{
			referencia.getDatum();
			referencia= referencia.getNext();
			cont++;
		}
		return cont;
	}
	public boolean contains(String compara)
	{
		Element referencia = head;
		while(referencia !=null)
		{
			if(compara.equals(referencia.getDatum()))
			{
				return true;
			}
			else
			{
				referencia= referencia.getNext();
			}
		}
		return false;
	}
	
	public String toString() 
	{
		Element ptr = head;
		String salida = " ";
		while(ptr != null) 
		{
			salida += ptr.getDatum() + " , ";
			ptr = ptr.getNext();
		}
		return salida;
	}
	public final class Element
	{
		Object datum;
		Element next;
		
		Element (Object datum, Element next)
		{
			this.datum = datum;
			this.next = next;
		}
		
		public void insertAfter (Object item) 
		{
			next = new Element (item, next);
			if (tail == this)
				tail = next;
		}
		
		public void insertBefore (Object item)
		{
			Element tmp = new Element (item, this);
			if (this == head)
				head = tmp;
			else {
				Element prevPtr = head;
				while (prevPtr != null && prevPtr.next != this)
					prevPtr = prevPtr.next;
				prevPtr.next = tmp;
			}
		}
		
		public Object getDatum() 
		{
			return datum;
		}
		
		public Element getNext() 
		{
			return next;
		}
	}
}
