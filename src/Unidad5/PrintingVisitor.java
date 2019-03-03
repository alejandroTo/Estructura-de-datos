package Unidad5;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintingVisitor implements Visitor {
	private boolean hecho;
	private String cadena="";
	public void visit(Object ob) {
		cadena+=ob+"\r\n";
		PrintStream salida = System.out;
		salida.print(ob+"\n");
		try {
			salida = new PrintStream
					("src\\Unidad5\\cadenasOrdenadas.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		salida.println(cadena);
		salida.close();	
	}
	public boolean hecho() {
		return hecho;
	}
}