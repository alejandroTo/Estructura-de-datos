package Practica4;

/**
 * @author ALEJANDRO Torres Ramirez
 *
 */
public class ListaDoblementeEnlazada {
	public final class CElemento
	{
		int informacion; 
		CElemento anterior; 
		CElemento siguiente;
		public CElemento(int dato)
		{
			informacion = dato; 
			anterior = null; 
			siguiente = null;
		}
	}
	CElemento cabeza; 
	CElemento fin;
	 /**
	 * constructor que crea una LDE vacia.
	 */
	public ListaDoblementeEnlazada() 
	 { 
		 cabeza = null; 
		 fin = null; 
	 }
	 
	 /**Método que indica si la lista está vacia
	 * @return boolean vacia:(de estar vacia true, de tener datos false)
	 */
	public boolean isEmpty() 
	 {
		 boolean vacia = false; 
		 if ( cabeza == null ) 
		 { 
			 vacia = true; 	 
		 }
		 return vacia;  
	 }
	//enlaza dos nodos mediante enlace doble
	 private void enlazar(CElemento nodoA, CElemento nodoB) 
	 { 
		 nodoA.siguiente = nodoB;
		 nodoB.anterior = nodoA; 	 
	 }
	 /**Método para insertar un nuevo nodo al inicio de la lista
	 * @param ndato
	 */
	public void insertarInicio(int ndato) 
	 { 
		 CElemento nuevo = new CElemento (ndato);
		 
		 if( isEmpty())
		 { 
			 cabeza = nuevo; 
			 fin = nuevo; 	 
		 }
		 else
		 { 
			enlazar(nuevo, cabeza); 
			cabeza = nuevo; 
		
		 } 
	 }
	 /** Método que inserta un nuevo nodo al final de la lista
	 * @param ndato
	 */
	public void insertarFinal(int ndato) 
	 { 
		 CElemento nuevo = new CElemento(ndato);
		 if( isEmpty())
		 {
			 cabeza = nuevo; 
			 fin = nuevo; 
		 }
		 else
		 { 
			 enlazar(fin, nuevo); 
			 fin = nuevo; 		 
		 } 
	 }
	 /**
	 *Método que elimina el nodo del frente de la lista 
	 */
	public void  eliminarInicio() 
	 {
		 if( !isEmpty()) 
		 { 
			 CElemento primero = cabeza.siguiente;
			 if( primero == null ) 
			 { 
				 cabeza = null; fin = null;
			 }
			 else
			 {
				 primero.anterior = null; cabeza = primero;
		
			 }
			 
		 }
	 }
	 /**
	 * Método que elimina el nodo del final de la lista
	 */
	public void eliminarFinal() 
	 {
		 if( !isEmpty() ) 
		 { 
			 CElemento ultimo = fin.anterior;
			 if ( ultimo == null ) 
			 { 
				 cabeza = null; 
				 fin = null; 
			 
			 }
			 else
			 { 
				 ultimo.siguiente = null; 
				 fin = ultimo; 		 
			 }
		 }
	 }
	 
	 //devuelve una referencia al nodo buscado, si no se encuentra devuelve null 
	 public CElemento buscar(int dato) 
	 { 
		 CElemento buscado = null; 
		 CElemento iterador = cabeza;
		 while( buscado == null && iterador != null ) 
		 {
			 if( iterador.informacion == dato ) 
			 { 
				 buscado = iterador; 
				 
			 } 
			 iterador = iterador.siguiente; 	
		 }
		 return buscado; 
	}
	 /* muestra los valores en la lista
	 * toString()
	 */
	public String toString() 
	 { 
		 CElemento iterador = cabeza;
		 String salida = "";
		 while( iterador != null ) 
		 { 
			 salida+=iterador.informacion+" "; 
			 iterador = iterador.siguiente; 
		 } 
		 return salida;  
	 }
}