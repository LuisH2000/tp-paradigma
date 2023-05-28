package programa;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Atraccion extends Oferta{

	private String nombre;
	private int cupo;

	public Atraccion(String nombre, double precio, double tiempo, int cupo, String tipo) {
		this.nombre = nombre;
		this.precio = precio;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.disponible = true;
		try {
			this.tipo = tipoAtraccion.valueOf(tipo);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public Atraccion(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCupo() {
		return cupo;
	}
	
	public void setDisponible(boolean b) {
		this.disponible = b;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", cupo=" + cupo + ", precio=" + precio + ", tiempo=" + tiempo
				+ ", tipo=" + tipo + "]";
	}

	@Override
	public void vender() {
		this.cupo--;
		if(this.cupo == 0)
			this.disponible = false;
	}
	
	@Override
	public boolean estaDisponible() {
		if(!this.disponible && this.cupo > 0) {
			this.disponible = true;
			return false;
		}
			
		return this.disponible;
	}

	static public void crearArraysPreferencias(ArrayList<Atraccion> general,
			ArrayList<Atraccion> prefAventura, ArrayList<Atraccion> prefDegustacion, ArrayList<Atraccion> prefPaisaje) {
		Set<Atraccion> aventura = new TreeSet<Atraccion>(new ComparatorXPref(Oferta.tipoAtraccion.Aventura));
		Set<Atraccion> degustacion = new TreeSet<Atraccion>(new ComparatorXPref(Oferta.tipoAtraccion.Degustacion));
		Set<Atraccion> paisaje = new TreeSet<Atraccion>(new ComparatorXPref(Oferta.tipoAtraccion.Paisaje));
		
		for(Atraccion atr: general) {
			aventura.add(atr);
			degustacion.add(atr);
			paisaje.add(atr);
		}
		
		prefAventura.addAll(aventura);
		prefDegustacion.addAll(degustacion);
		prefPaisaje.addAll(paisaje);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cupo;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		if (nombre.equals(other.nombre))
			return true;
		if (cupo != other.cupo)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (!super.equals(obj))
			return false;

		return true;
	}

}