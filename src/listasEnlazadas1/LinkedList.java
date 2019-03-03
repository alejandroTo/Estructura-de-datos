package listasEnlazadas1;

import javax.swing.JOptionPane;

/**
 * @author ALEJANDRO
 *
 */
public class LinkedList {
	protected Element head;//Primer element.se peude utilizar desde cualquier clase o subclase.
	protected Element tail;//ultimo element. se puede utilziar desdde cualquier clase o sublclase.
	
	//Constructor de la clase LinkedList.
	public LinkedList() {
		//sin poner nada, equivale a poner null a head y tail.
	}
	//limpiar o purgar los datos. Igualando a null.
	public void purge()
	{
		head 	= null;
		tail = null;
	}
	
	//Clase Element
	public final class Element
	{
		Object datum;//dato.Informacion.
		Element next;//promixo dato.
		/**Constructor de la clase Element 
		 * @param datum : Parametro para leer el dato.
		 * @param next : parametro para saber el proximo elemento.
		 */
		Element(Object datum , Element next)
		{
			this.datum = datum;//atributos datum es igual al paramtero datum.
			this.next = next;//atributo next es igual al paramteros next.
		}
		public Object getDatum()
		{
			return datum;
		}
		public Element getNext()
		{
			return next;
		}
		public void insertAfter(Object item)
		{
			next = new Element(item,next);
			if(tail == this)
			{
				tail = next;
			}
			
		}
		public void insertBefore(Object item)
		{
			Element tmp = new Element(item,this);
			if(this == head)
			{
				head = tmp;
			}
			else
			{
				Element prevPtr = head;
				while(prevPtr != null && prevPtr.next!=this)
				{
					prevPtr = prevPtr.next;
				}
				prevPtr.next = tmp;
			}
			
		}
	}
	//
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
		return head==null;
	}
	public Object getFirst()
	{
		if(head == null)
		{
			return null;
		}
		else
		{
			return head.datum;
		}
	}
	public Object getLast()
	{
		if(tail == null)
		{
			return null;
		}
		else
		{
			return tail.datum;
		}
	}
	public void prepend(Object item)
	{
		Element tmp = new Element(item,head);
		if(head == tail)
		{
			tail = tmp;
		}
		else
		{
			head = tmp;
		}	
	}
	public void append(Object item)
	{
		Element tmp = new Element(item,null);
		if(head == null)
		{
			head = tmp;
		}
		else
		{
			tail.next = tmp;
		}
		tail = tmp;
	}
	public void assign(LinkedList list)
	{
		if(list!=this)
		{
			purge();
			for(Element ptr = list.head; ptr!=null; ptr = ptr.next)
			{
				append(ptr.datum);
			}
		}
	}
	public void extract(Object item)
	{
		Element ptr = head;
		Element prevPtr = null;
		try
		{
			while(ptr!=null && !ptr.datum.equals(item))
			{
				prevPtr =ptr;
				ptr =ptr.next;
			}
			if(ptr == head)
			{
				head = ptr.next;
			}
			else
			{
				prevPtr.next = ptr.next;
			}
			if(ptr == tail)
			{
				tail = prevPtr;
			}
		}
		catch(java.lang.NullPointerException e)
		{
			JOptionPane.showMessageDialog(null,"Item no encontrado");
		}
	
	}
	public String toString()
	{
		Element referencia = head;
		String salida="";
		while(referencia !=null)
		{
			salida+=referencia.getDatum()+"\r\n";
			referencia= referencia.getNext();
		}
		return salida;
	}
}	