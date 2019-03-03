package listasEnlazadas2;

import javax.swing.JOptionPane;

public class MainList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList listaE = new LinkedList();
		int opc;
		do
		{
			opc = menu();
			switch(opc)
			{
			case 1:
				String add;
				int res=0;
				while(res==0)
				{
					add=(JOptionPane.showInputDialog("A={"+listaE.toString()+"}"+"\nn(a)="+listaE.size()+
							"\nAgregar numero"));	
					if(res==0)
					{
						if(listaE.contains(add))
						{
							JOptionPane.showMessageDialog(null, "Ya existe el numero","Aviso", JOptionPane.OK_OPTION);
						}
						else
						{
							listaE.append(add);
						}
						res =JOptionPane.showConfirmDialog(null,"\n¿Desea agregar otro numero?","Aviso",JOptionPane.YES_NO_OPTION);
					}
					else
					{
						if(listaE.contains(add))
						{
							JOptionPane.showMessageDialog(null, "Ya existe el numero","Aviso", JOptionPane.OK_OPTION);
						}
						else
						{
							listaE.append(add);
						}
					}
				}
			break;
			case 2:
				JOptionPane.showMessageDialog(null, "\nn(a)="+listaE.size());
				break;
			case 3:
				String numB = JOptionPane.showInputDialog("Ingresa numero a buscar");
				if(listaE.contains(numB))
				{
					JOptionPane.showMessageDialog(null,"El numero{"+numB+"} Pertenece a el conjunto");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"El numero{"+numB+"} no pertenece a el conjunto");
				}
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "A={"+listaE.toString()+"}"+"\nn(a)="+listaE.size());
				break;
			}
		}while(opc!=5);
	}
	public static int menu()
	{
		int opc = Integer.parseInt(JOptionPane.showInputDialog("1.Anadir elemento"
				+ "\n2.Cardinalidad del conjunto"
				+ "\n3.Buscar elemento"
				+ "\n4.Mostrar"
				+ "\n5.Salir"));
		return opc;
	}
}