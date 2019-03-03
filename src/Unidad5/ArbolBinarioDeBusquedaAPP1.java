package Unidad5;

public class ArbolBinarioDeBusquedaAPP1 {
	public static void main(String [] args) {
		ArbolBinarioDeBusqueda root = new ArbolBinarioDeBusqueda();
		int [] enteros = {25, 23,132, 32, 12, 22, 40, 21, 222,2222};
		for(int elemento: enteros)
		{
			root.insertar(elemento);
		}
		PrintingVisitor visitor = new PrintingVisitor();
		root.recorridoEnProfundidad(new PreOrder(visitor));
	}
}
