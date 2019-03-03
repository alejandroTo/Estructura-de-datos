package BadPairsCorrecion;

import java.util.ArrayList;

public class RemoveBadPairs {
	
	public void removeBadPairs(ArrayList<Integer> lista) {
		if (lista.size() % 2 != 0) {
			lista.remove(lista.size() - 1);
		}
		for (int i = 0; i < lista.size(); i += 2)
		{
			if (lista.get(i) > lista.get(i + 1))
			{
				lista.remove(i);
				lista.remove(i);
				i -= 2;
			}
		}
	}
}
