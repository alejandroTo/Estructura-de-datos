package UnidadRecursividad;

import java.util.Scanner;

public class Practica3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pos = 0;
        int size=0;
        int array [];
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingresa tamaño del vector: ");
        size = leer.nextInt();
        array = new int[size];
        for(int i=0; i<size; i++)
        {
            System.out.print("Numero: ");
            array[i] = leer.nextInt();
        }
        if(Practica3.contieneun6(array,pos))
        {
            System.out.println("Contiene un 6");
        }
        else
        {
            System.out.println("No contiene un 6");
        }
        leer.close();
    }
    public static boolean contieneun6(int []nums, int index)
    {
        if(index!= nums.length)
        {
        	if(nums[index]==6)
        	{
        		return true;
        	}
        	else
        	{
        		index++;
        		return contieneun6(nums,index);
        	}
        }
        return false;
        
    }
}