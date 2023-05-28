package programa;

public abstract class Oferta {
	protected double precio;
	protected double tiempo;
	protected boolean disponible;

	public enum tipoAtraccion {
		Aventura, Paisaje, Degustacion
	}
	protected tipoAtraccion tipo;

	public double getPrecio() {
		return precio;
	}

	public double getTiempo() {
		return tiempo;
	}

	public String getTipo() {
		return tipo.toString();
	}

	public abstract void vender();
	public abstract boolean estaDisponible();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tiempo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oferta other = (Oferta) obj;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		if (Double.doubleToLongBits(tiempo) != Double.doubleToLongBits(other.tiempo))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

}
