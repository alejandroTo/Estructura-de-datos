package problema2;

import java.util.ArrayList;
public class BadPairs {
	private ArrayList<Integer> list1;//Se crea
	private int numero;
	public BadPairs()
	{
		this.setNumero(0);
		this.list1=new ArrayList<Integer>();//Se inicializa por default
	}
	public int getNumero() { 
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void insertarElemento(int numero)
	{
		this.list1.add(numero);
	}
	public void removeList()
	{
		if(list1.size() % 2 != 0)//si es impar el tamaño del ArrayList
		{
			list1.remove(list1.size()-1);//remueve el ultimo valor
		}
		for (int i = 0; i < list1.size(); i += 2) {
			if (list1.get(i) > list1.get(i + 1))
			{
				list1.remove(i);
				list1.remove(i);
				i -= 2;
			}
		}
	}
		/*int j=0;
		int k=1;
		for(int i=0;i<list1.size();i++)
		{
			int par=list1.get(j);
			int impar=list1.get(k);
			if(i%2==0) {
				if(par>impar) {
					list1.remove(par);
					list1.remove(impar);
					j++;
				}
			}
				else {
					j++;
				}
		}*/
	public String toString()
	{
		return ""+list1;
	}
	
}
