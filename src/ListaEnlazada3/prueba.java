package ListaEnlazada3;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PilaEnListaEnlazada pila = new PilaEnListaEnlazada();
		ColaEnListaEnlazada cola = new ColaEnListaEnlazada();
		pila.push(10);
		pila.push(20);
		pila.push(30);
		pila.pop();
		System.out.println(pila.size()+" Elementos: "+pila.toString());
		cola.enqueue(10);
		cola.enqueue(20);
		cola.enqueue(30);
		cola.dequeue();
		System.out.println(cola.size()+" Elementos: "+cola.toString());
	}

}
