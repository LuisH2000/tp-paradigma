package programa;

import java.util.ArrayList;

public class Itinerario {
	private ArrayList<String> compras;
	private double precioTotal;
	private double tiempoTotal;
	
	public void agregar(Atraccion atr) {
		
	}
	
	public void agregar(Promocion prom) {
		
	}

	@Override
	public String toString() {
		return "Itinerario [compras=" + compras + ", precioTotal=" + precioTotal + ", tiempoTotal=" + tiempoTotal + "]";
	}
	
	
}
