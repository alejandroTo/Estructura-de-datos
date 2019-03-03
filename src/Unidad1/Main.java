package Unidad1;
import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConjuntoDeEnteros objeto1;
		byte sizeA;
		byte sizeB;
		sizeA=Byte.parseByte(JOptionPane.showInputDialog("Tamaño del conjunto A"));
		sizeB=Byte.parseByte(JOptionPane.showInputDialog("tamaño del conjunto B"));
		objeto1 = new ConjuntoDeEnteros (sizeA,sizeB);
		objeto1.llenarA();
		objeto1.llenarB();
		objeto1.union();
		objeto1.isEqualsTo();
		objeto1.inter();
	}

}
