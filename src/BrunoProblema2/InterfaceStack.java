package BrunoProblema2;

/**Clase interfcae la cual sera utilizada en PilaEnArreglo
 * Con métodos public abstract
 * boolean isEmpty();
 * boolean isFull();
 * Object verSuperior();
 * void agregar(Object ob);
 * Object borrar();
 * @author ALEJANDRO
 *
 */
public interface InterfaceStack {
	boolean isEmpty();
	boolean isFull();
	Object verSuperior();
	void agregar(Object ob);
	Object borrar();

}
