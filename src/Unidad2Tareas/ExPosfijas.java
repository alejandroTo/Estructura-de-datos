package Unidad2Tareas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class ExPosfijas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader entrada = new BufferedReader(new FileReader("src\\Unidad2Tareas\\entrada.txt"));
		PrintWriter salida = new PrintWriter(new FileWriter("src\\Unidad2Tareas\\salida.txt"));
		Deque<Integer> stack = new ArrayDeque<>();
		int a=0;
		int b=0;
		String str = "";
		while (entrada.ready()) {
			str = entrada.readLine();
			String [] partes= str.split(",");
			for(int i=0;i<partes.length;i++)
			{
				if(partes[i].equals("-"))
				{
					b = (stack.pop());
					a = (stack.pop());
					stack.push(a-b);
				}
				else if(partes[i].equals("+"))
				{
					b = (stack.pop());
					a = (stack.pop());
					stack.push(a+b);
				}
				else if(partes[i].equals("/"))
				{
					b = (stack.pop());
					a = (stack.pop());
					stack.push(a/b);
				}
				else if(partes[i].equals("*"))
				{
					b = (stack.pop());
					a = (stack.pop());
					stack.push(a*b);
				}
				else {
					stack.push(Integer.parseInt(partes[i]));
				}
			}
			//Mostrar resultados:
			System.out.println(str+" = "+stack.peek());
			salida.println(str + " = "+stack.pop());
		}
		entrada.close();
		salida.close();
	}
}