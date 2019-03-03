package UnidadRecursividad;

/**Mostrar en pantalla el alfabeto; utilizando recursion indirecta.
 * El m�todo main() llama a metodoA(), con el argumento 'z'(la ultima letr
 * del alfabeto), Este examina su par�metro c, si c est� en ordem alfabetico
 * despu�s qu'a', llama a metodoB(), que inmediantamente invoca al medodoA()
 * pasandole un paramtetro predecesor de c;
 * Esta accion hace que metodoA(), vuelva a examinar c: 
 * y nuevamente llame a metodoB(), las llamadas continuan hasta que c sea igual a 'a'
 * En este momento, la recursion termina ejecutando System.out.print() veintises
 * veces y visualiza el alfabeto, caracter a caracter.
 * @author ALEJANDRO
 */
public class Alfabeto { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		metodoA('Z');
		System.out.println(); 
	}
	static void metodoA(char c)
	{
		if(c>'A')
		{
			metodoB(c);
		}
		System.out.println(c);
	}
	static void metodoB(char c)
	{
		metodoA(--c);
	}
}