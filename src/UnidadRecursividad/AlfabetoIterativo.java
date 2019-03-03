package UnidadRecursividad;

public class AlfabetoIterativo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c ='a';
		while(c<='d')
		{	
			System.out.print(c++);
			if(c=='d')
			{
				System.out.println("Entro");
			}
		}
		/*int count=0;
		char c [][] = new char[3][3];
		for(int i=0; i<c.length; i++)
		{
			for(int j=0; j<c[i].length; j++)
			{
				
			}
		}*/
	}

}
