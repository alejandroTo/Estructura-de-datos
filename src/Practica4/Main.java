package Practica4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDoblementeEnlazada lista =new ListaDoblementeEnlazada(); 
		for(int i=0; i<10; i++)
		{
			lista.insertarInicio(i); //1.2.3.4.5.6.7.8.9.10. 
		}
		for(int i=0; i<5; i++)
		{
			lista.insertarFinal(i); //1.2.3.4.5
		}
		lista.insertarInicio(34); //34
		lista.eliminarFinal(); //elimina el 4
		lista.eliminarInicio(); //Eliminar el 34
		System.out.print("Datos: \n"+lista.toString()+"\n¿la lista esta vacía? "+lista.isEmpty());
	}
}