package Unidad1;

import javax.swing.JOptionPane;
public class PrimerPrograma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte numAlum;
        byte [] array;
        double promedio=0;
        byte cMenor=101;
        byte cMayor=-1;
        byte i=0;
        numAlum = Byte.parseByte(JOptionPane.showInputDialog("Numero de alumnos"));
        array = new byte[numAlum];
        for(i=0; i<array.length; i++)
        {
            array[i] = Byte.parseByte(JOptionPane.showInputDialog((i+1)+" "+"Calificacion"));
            promedio+=array[i];
            if(array[i]<cMenor)
                cMenor = array[i];
            if(array[i]>cMayor)
                cMayor = array[i];
        }
        JOptionPane.showMessageDialog(null,"El promedio es "+promedio/numAlum + "\nEl promedio mayor es "+cMayor+"\nEl promedio menor es "+cMenor);
        

	}

}
