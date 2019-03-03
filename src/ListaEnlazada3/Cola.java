package ListaEnlazada3;

public interface Cola {
	Object getFirst();
	void enqueue (Object object);
	Object dequeue();
	boolean isEmpty();
	boolean isFull();

}
