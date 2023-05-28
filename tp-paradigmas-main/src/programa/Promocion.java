package programa;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Promocion extends Oferta {

	private final ArrayList<Atraccion> atracciones;
	private double precioOrig;
	
	private Promocion(ArrayList<Atraccion> atracciones, double precio, double precioOrig, double tiempo, String tipo) {
		this.atracciones = new ArrayList<Atraccion>();
		this.atracciones.addAll(atracciones);
		this.precio = precio;
		this.precioOrig = precioOrig;
		this.tiempo = tiempo;
		this.disponible = true;
		try {
			this.tipo = tipoAtraccion.valueOf(tipo);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	static Promocion crearPromoDesc(ArrayList<Atraccion> atracciones, double descuento) {
		double tiempo = 0;
		double precioOrig = 0;
		for (Atraccion atr : atracciones) {
			precioOrig += atr.precio;
			tiempo += atr.tiempo;
		}
		return new Promocion(atracciones, precioOrig, precioOrig-=precioOrig*descuento/100, tiempo, atracciones.get(0).getTipo());
	}

	static Promocion crearPromoAbs(ArrayList<Atraccion> atracciones, double precio) {
		double tiempo = 0;
		double precioOrig = 0;
		for (Atraccion atr : atracciones) {
			precioOrig += atr.precio;
			tiempo += atr.tiempo;
		}
		return new Promocion(atracciones, precio, precioOrig, tiempo, atracciones.get(0).getTipo());
	}

	static Promocion crearPromoAxB(ArrayList<Atraccion> atracciones) {
		double tiempo = 0;
		double precioOrig = 0;
		for (Atraccion atr : atracciones) {
			precioOrig += atr.precio;
			tiempo += atr.tiempo;
		}

		return new Promocion(atracciones, precioOrig, precioOrig -= atracciones.get(atracciones.size()-1).precio, 
				tiempo, atracciones.get(0).getTipo());
	}

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}

	@Override
	public boolean estaDisponible() {
		if (!this.disponible)
			return false;

		for (Atraccion atr : this.atracciones) {
			if (atr.disponible) {
				this.disponible = false;
				return false;
			}
		}

		return true;
	}

	@Override
	public void vender() {
		for (Atraccion atr : this.atracciones) {
			atr.vender();
			atr.setDisponible(false);
		}
	}

	static public void crearArraysPreferencias(ArrayList<Promocion> general,
			ArrayList<Promocion> prefAventura, ArrayList<Promocion> prefDegustacion, ArrayList<Promocion> prefPaisaje) {
		Set<Promocion> aventura = new TreeSet<Promocion>(new ComparatorXPref(Oferta.tipoAtraccion.Aventura));
		Set<Promocion> degustacion = new TreeSet<Promocion>(new ComparatorXPref(Oferta.tipoAtraccion.Degustacion));
		Set<Promocion> paisaje = new TreeSet<Promocion>(new ComparatorXPref(Oferta.tipoAtraccion.Paisaje));
		
		for(Promocion prom: general) {
			aventura.add(prom);
			degustacion.add(prom);
			paisaje.add(prom);
		}
		
		prefAventura.addAll(aventura);
		prefDegustacion.addAll(degustacion);
		prefPaisaje.addAll(paisaje);
	}
	
	@Override
	public String toString() {
		String texto = "Promocion [atracciones=";
		for (Atraccion atr : this.atracciones) {
			texto += atr.getNombre() + ", ";
		}
		texto += "precio=" + precio + "precio orginal=" + this.precioOrig + ", tiempo=" + tiempo + ", tipo=" + tipo + "]";
		return texto;
	}
}