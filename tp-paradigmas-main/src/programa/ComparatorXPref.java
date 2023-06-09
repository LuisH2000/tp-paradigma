package programa;

import java.util.Comparator;

public class ComparatorXPref implements Comparator<Oferta>{
	
	protected Oferta.tipoAtraccion tipo;

	public ComparatorXPref(Oferta.tipoAtraccion tipo) {
		this.tipo = tipo;
	}
	
	public int compare(Oferta of1, Oferta of2) {

		if (of1.tipo == this.tipo && of2.tipo != this.tipo)
			return -1;
		if (of2.tipo == this.tipo && of1.tipo != this.tipo)
			return 1;

		if (of1.precio != of2.precio)
			return Double.compare(of2.precio, of1.precio);

		if(of1.tiempo != of2.tiempo)
			return Double.compare(of2.tiempo, of1.tiempo);
		
		return 1;
	}
}
