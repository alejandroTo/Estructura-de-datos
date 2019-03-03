package ListaEnlazada3;

public interface Stack {
	boolean isEmpty();
	boolean isFull();
	Object getTop();
	void push (Object ob);
	Object pop();
}
