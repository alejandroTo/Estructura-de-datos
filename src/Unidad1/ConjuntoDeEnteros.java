package Unidad1;

import javax.swing.JOptionPane;
public class ConjuntoDeEnteros {
	private byte[] conjuntoA;
	private byte[] conjuntoB;
	private byte sizeA;
    private byte sizeB;
	public ConjuntoDeEnteros(byte sizeA,byte sizeB)
	{
		this.sizeA = sizeA;
		this.sizeB = sizeB;
	}
	
	public void setSizeA(byte sizeA)
	{
		this.sizeA=sizeA;
	}
	public byte getSizeA()
	{
		return sizeA;
	}
	public void setSizeB(byte sizeB)
	{
		this.sizeB=sizeB;
	}
	public byte getSizeB()
	{
		return sizeB;
	}
	public void llenarA()
	{
		conjuntoA = new byte [this.sizeA];
		for(int i=0;i<getSizeA(); i++)
		{
			conjuntoA[i] = Byte.parseByte(JOptionPane.showInputDialog(i+1+" Ingresa numeros ConjuntoA"));
		}
	}
	public void llenarB()
	{
		conjuntoB = new byte [this.sizeB];
		for(int i=0;i<getSizeB(); i++)
		{
			conjuntoB[i] = Byte.parseByte(JOptionPane.showInputDialog(i+1+" Ingresa numeros Conjunto B"));
		}
	}
	public void union()
	{
		byte conjuntoUnion[];
		conjuntoUnion = new byte[conjuntoA.length+conjuntoB.length];
		String cadena="";
		for(int i=0;i<conjuntoA.length;i++)
		{
			conjuntoUnion[i]=conjuntoA[i];
			cadena+=conjuntoUnion[i];
		}
		for(int j=0; j<conjuntoB.length;j++)
		{
			conjuntoUnion[j]=conjuntoB[j];
			cadena+=conjuntoUnion[j];
		}
		System.out.print(cadena);
	}
	public void isEqualsTo()
	{
		boolean equalsTo = true;
		for(int k=0;k<conjuntoA.length&&equalsTo;k++)
		{
			if(conjuntoA[k]!=conjuntoB[k]) {
				equalsTo = false;
				System.out.println(" No son iguales.");
			}
			else
				System.out.println("\nSon iguales.");				
		}
	}
	int a=0;
	public void inter()
	{
		byte j=0;
		byte array[] = null;
		for(int k=0;k<conjuntoA.length;k++)
		{
			if(conjuntoA[k]!=conjuntoB[a]) {
				j++;
				array = new byte[j];
				array[a]=conjuntoA[k];
			}
				
		}
		String cadena="";
		for(int i=0;i<conjuntoA.length; i++)
		{
			cadena+=array[i];
		}
		System.out.println(cadena);
	}
	public String toString()
	{
		return super.toString();
	}
}