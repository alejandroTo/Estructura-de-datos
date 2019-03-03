package UnidadRecursividad;

public class Bunny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=6;
		System.out.print(recursion(n));
	}
	 
	public static int recursion(int n)
	{
		if(n==0)
		{
			return n;
		}
		else
		{
			int v;
			v= 2+recursion(n-1);
			System.out.println(v);
			return v;
		}
	}

}
