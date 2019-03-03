package Unidad5;

public class ArbolBinarioAPP1 {

	public static void main(String[] args) {
		ArbolBinario e = new ArbolBinario("E");
		ArbolBinario k = new ArbolBinario("K");
		ArbolBinario s = new ArbolBinario("S");
		ArbolBinario c = new ArbolBinario("C");
		ArbolBinario h = new ArbolBinario("H", e, k);
		ArbolBinario v = new ArbolBinario("V", s, new ArbolBinario());
		ArbolBinario d = new ArbolBinario("D", c, h);
		ArbolBinario r = new ArbolBinario("R", new ArbolBinario(), v);
		ArbolBinario root = new ArbolBinario("M", d, r);
		
		PrintingVisitor visitor = new PrintingVisitor();
		
		root.recorridoEnProfundidad(new PreOrder(visitor));
		
	}

}
