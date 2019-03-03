package BrunoProblema2;

/**Inteferce cola la cual servira para ser usada en la clse ColaEnArreglo.
 * Con metodos public abstract.
 * Object obtenerPrimero(); 
 * void agregar(Object objeto);
 * Object sacar();
 * @author ALEJANDRO
 *
 */
public interface  Cola {
	Object obtenerPrimero();
	void agregar(Object objeto);
	Object sacar();
}
