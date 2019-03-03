package problema1;

import java.util.Arrays;
/**
 * Programa que sirve para insertar numeros enteros.
 * @author ALEJANDRO
 *
 */
/**
 * @author ALEJANDRO
 *
 */
public class ConjuntoDeEnteros {
	//Declaracion de atributos.
	private boolean [] conjunto;
	private int numero;
	public ConjuntoDeEnteros()
	{
		conjunto = new boolean[101];
		for(int b=0; b<conjunto.length;b++) {
			conjunto[b] = false; 
		}
	}
	/** Metodo para agregar un numero
	 * @param numero : ingresdo por el usuario.
	 */
	public void setNumero(int numero)
	{
		this.numero=numero;
	}
	public int getNumero()
	{
		return numero;
	}
	
	/**Metodo que me perimte inserar un numero en el conjunto, lo establezco en false.
	 * @param numero: valor ingresado por el usuario en entero.
	 */
	public void insertarElemento(int numero)
	{
		conjunto[numero]=true;
	}
	
	/**Metodo que me permite borrar un elemento del arreglo.
	 * @param numero: valor ingresado por el usuario en entero, sirve para borrar.
	 */
	public void borrarElemento(int numero)
	{
		conjunto[numero]=false;
	}
	/** Metodo statico pretenece a la clase, con paramteros de objetos a y b.
	 * @param a: Objeto utilizado para la union del conjunto.
	 * @param b: objeto uyilizado para la union del conjunto.
	 * @return c: regresa un objeto con la union del conjunto a y el conjunto b.
	 */
	public static ConjuntoDeEnteros union(ConjuntoDeEnteros a,ConjuntoDeEnteros b)
	{
		ConjuntoDeEnteros c= new ConjuntoDeEnteros();
		for(int i=0;i<a.conjunto.length;i++)
		{
			if(a.conjunto[i]==true||b.conjunto[i]==true)
			{
				c.conjunto[i]=true;
			}
			else {}
		}
		return c;
	}
	
	/**
	 * @param b: objeto utilizado para comparar si los dos conjuntos son iguales.
	 * @return q: regresa un booleano true si el conjunto a y b son iguales y un false si no los son.
	 */
	public boolean isEqualTo(ConjuntoDeEnteros b)
	{
		boolean q=false;
		q=Arrays.equals(conjunto, b.conjunto);
		return q;
	}
	
	/**Metodo estatico de la clase de objetos Con parameetros de objetos a y b.
	 * @param a: objeto utilizado para ser interseccion con b.
	 * @param b: objeto utilizado para ser interseccion con a.
	 * @return c: retorna un objeto creado en el proipio metodo llamado c, con los numeros que se interesctan.
	 */
	public static ConjuntoDeEnteros interseccion(ConjuntoDeEnteros a,ConjuntoDeEnteros b)
	{
		ConjuntoDeEnteros c=new ConjuntoDeEnteros();
		for(int i=0;i<101;i++)
		{
			if(a.conjunto[i]&&b.conjunto[i])
				c.conjunto[i]=true;
		}
		
		return c;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String cadena =" ";
		for(int i=0;i<conjunto.length;i++)
		{
			if(conjunto[i]==true) {
				cadena+=i+" ";
			}
		}
		return cadena;
	}
}