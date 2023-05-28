package programa;

public class Usuario {
	private String nombre;
	private double dinero;
	private double tiempo;
	private Itinerario itinerario;

	private Oferta.tipoAtraccion pref;

	public Usuario(String nombre, double dinero, double tiempo, String pref) {
		this.nombre = nombre;
		this.dinero = dinero;
		this.tiempo = tiempo;
		this.itinerario = new Itinerario();
		try {
			this.pref = Oferta.tipoAtraccion.valueOf(pref);
		} catch (IllegalArgumentException e) {
			System.out.println("Tipo de preferencia incorrecta");
			e.printStackTrace();
		}

	}

	public Oferta.tipoAtraccion getPref() {
		return pref;
	}


    public String getNombre() {
		return this.nombre;
	}
    
    public Itinerario getItinerario() {
 		return this.itinerario;
 	}
    
    public void puedeComprar(Oferta of) {
    	
    }
	
	public void comprar(Atraccion atrac){

	}
	
	public void comprar(Promocion promo) {

	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dinero=" + dinero + ", tiempo=" + tiempo + ", pref=" + pref + "]";
	}

}
