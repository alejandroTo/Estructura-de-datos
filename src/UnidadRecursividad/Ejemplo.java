package UnidadRecursividad;

import javax.swing.JOptionPane;

public class Ejemplo {

	public int factorialRecursivo(int n)
	{
		if(n<=1)
		{
			return 1;
		}
		else
		{ 
			return n*factorialRecursivo(n-1);
		}
	}
	public int factorialIterativo(int n)
	{
		int fact=1;
		for(int i=2; i<=n; i++)
		{
			fact = fact * i;
		}
		return fact;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*recursion
		 * 4! = 4!*3!
		 * */
		/*itereciones
		 * 4! = 4x3x2x1
		 * 
		 * */
		Ejemplo ob1 = new Ejemplo();
		int n = Integer.parseInt(JOptionPane.showInputDialog(
				"Ingresa n"));
		JOptionPane.showMessageDialog(
				null, ob1.factorialRecursivo(n),"Recursivo"
				,JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(
				null, ob1.factorialIterativo(n));
	}
}