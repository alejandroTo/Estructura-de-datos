package listasEnlazadas1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class MainListasE {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader entrada = new BufferedReader(
				new FileReader("src\\listasEnlazadas1\\entrada.txt"));
		
		String dato;
		LinkedList listaEnlazada = new LinkedList();
		int opcion=0; 
		do
		{
			opcion = menu();
			while(entrada.ready())
			{
				dato = entrada.readLine();
				String p[]= dato.split(" ");
				for(String sig:p)
				{
					listaEnlazada.append(sig);
				}
			}
			switch(opcion)
			{
			case 1:
				int dialog=0;
				do
				{			
					String datoEntrante;
					datoEntrante = JOptionPane.showInputDialog("Datos guardados: "+"\n"+listaEnlazada.toString()+"Ingresa dato:");
					listaEnlazada.append(datoEntrante);
					dialog = (JOptionPane.showConfirmDialog(null,"¿Desea agregar otro dato?	","Aviso", JOptionPane.YES_NO_OPTION));
				}while(dialog==0);
				JOptionPane.showMessageDialog(null, "Datos Actuales: "+"\n"+listaEnlazada.toString());
				break;
			case 2:
				String datoSalida="";
				do
				{
					datoSalida = JOptionPane.showInputDialog("Datos almacenados: "+"\n"+listaEnlazada.toString()+"Ingresa dato a borrrar");
					listaEnlazada.extract(datoSalida);
					dialog=JOptionPane.showConfirmDialog(null, "¿Desea borrar otro dato?","Aviso",JOptionPane.YES_NO_OPTION);
				}while(dialog==0);
				JOptionPane.showMessageDialog(null, "Datos Actuales: "+"\n"+listaEnlazada.toString());
			}
		}while(opcion!=3);
		entrada.close();		
		PrintWriter salida = new PrintWriter(
				new FileWriter("src\\listasEnlazadas1\\entrada.txt"));
		salida.print(listaEnlazada.toString()+" ");
		salida.close();
	}
	public static int menu()
	{
		int opcion=0;
		try
		{
			opcion = Integer.parseInt(JOptionPane.showInputDialog("1.Añadir"
					+ "\n2.Borrar\n3.Salir..."));
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null,"añadir", 
					"error",JOptionPane.OK_OPTION);
		}
		return opcion;
	}
}