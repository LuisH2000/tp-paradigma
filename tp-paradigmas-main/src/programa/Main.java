package programa;

import java.util.ArrayList;
import java.util.Queue;

public class Main {
	
	static public void ofrecerAtracciones(Usuario cliente, ArrayList<Atraccion> atracciones, ArrayList<Promocion> promociones) {
		
	}
	
	public static void main(String[] args) {
		Archivo arc = new Archivo();

		Queue<Usuario> usuarios = arc.leerUsuarios();
		System.out.println(usuarios);
		ArrayList<Atraccion> atracciones = arc.leerAtracciones();
		System.out.println(atracciones);
		ArrayList<Promocion> promociones = arc.leerPromociones(atracciones);
		System.out.println(promociones);

		ArrayList<Atraccion> prefAtrAventura = new ArrayList<Atraccion>();
		ArrayList<Atraccion> prefAtrDegustacion = new ArrayList<Atraccion>();
		ArrayList<Atraccion> prefAtrPaisaje = new ArrayList<Atraccion>();
		
		ArrayList<Promocion> prefPromAventura = new ArrayList<Promocion>();
		ArrayList<Promocion> prefPromDegustacion = new ArrayList<Promocion>();
		ArrayList<Promocion> prefPromPaisaje = new ArrayList<Promocion>();
		
		System.out.println(" ");
		Atraccion.crearArraysPreferencias(atracciones, prefAtrAventura, prefAtrDegustacion, prefAtrPaisaje);
		Promocion.crearArraysPreferencias(promociones, prefPromAventura, prefPromDegustacion, prefPromPaisaje);
		System.out.println(prefAtrAventura);
		System.out.println(prefAtrPaisaje);
		System.out.println(prefAtrDegustacion);
		
		Usuario cliente;
		
		while(usuarios.peek() != null) {
			cliente = usuarios.poll();
			
			if(cliente.getPref() == Oferta.tipoAtraccion.Aventura) {
				ofrecerAtracciones(cliente, prefAtrAventura, prefPromAventura);
			}else if(cliente.getPref() == Oferta.tipoAtraccion.Degustacion) {
				ofrecerAtracciones(cliente, prefAtrDegustacion, prefPromDegustacion);
			}else{
				ofrecerAtracciones(cliente, prefAtrPaisaje, prefPromPaisaje);
			}
			
			System.out.println(cliente.getItinerario());
			arc.generarArchUsuario(cliente);
		}
	
		// ALGORITMO
//		for(Usuario usuario : usuarios){

//	private double dinero = getdinero;
//	private double tiempo = gettiempo;
//	int i;
//	int j;

//	if(usuario.pref==tipoXi)
//
//	mostrarPrefTipoAventura() tipo que le gusta -> los otros dos tipos restantes
//				else
//					mostrarPrefTipoFantasia
//		    
//		    while(promociones tenga el tipo que le gusta)
//		    	promo = segerirPromocion(promociones, i)
//		    	if(promo tiene algo)
//		    		sugerimos
//		    	else
//		    		continue
//		    			
//		    while(atracciones que le gusta)
//		    	
//		    		
//		 
//		    }

//		Archivo arc = new Archivo();
//		
//		ArrayDeque<Usuario> usuarios = arc.leerUsuarios();
//		ArrayList<Atraccion> atracciones = arc.leerAtracciones();
//		ArrayList<Promocion> promociones = arc.leerPromociones();
//		Scanner scanner = new Scanner(System.in);
//		
//		
//	
//		
//		//ALGORITMO
//		while(!usuarios.isEmpty()){
//		    Usuario usuario = usuarios.removeFirst();
//		    ComparadorXUsuario cmp = new ComparadorXUsuario(usuario);
//		    Set<Atraccion> arbolAtraccionesPref = new TreeSet<Atraccion>(new ComparadorXUsuario(usuario));
//		    Set<Atraccion> arbolAtraccionesNoPref = new TreeSet<Atraccion>(new ComparadorXUsuario(usuario));
//		    Atraccion atracMasBarata = atracciones.get(0);
//
//		    // 1)Recorro la lista de atracciones para clasificar en preferidos y no preferidos, además busco la atraccion con menor tiempo y dinero
//		    for(Atraccion atr : atracciones){
//		        if(atr.getTipo() != usuario.getPref())
//                    arbolAtraccionesNoPref.add(atr);
//                else
//                    arbolAtraccionesPref.add(atr);
//                    
//                if(atracMasBarata.getTiempo() < atr.getTiempo() && atracMasBarata.getPrecio() < atr.getTiempo())
//                    atracMasBarata=atr;
//		        
//		    }
//		        
//            
//            
//		    
//		    
//		    // 2)le ofrezo al usuario que compre las atracciones que son de su preferencia siempre y cuando tenga dinero aún
//		    while(usuario.puedePagar(atracMasBarata) && (!arbolAtraccionesPref.isEmpty() || !arbolAtraccionesNoPref.isEmpty())){
//		        
//		        System.out.println("==============Comienzo de la compra para " + usuario.getNombre().toUpperCase() + "===================");
//    		    char respuesta = '\0';
//    		    // le ofrezo al usuario que compre las atracciones que son de su preferencia
//                for(Atraccion atr : arbolAtraccionesPref){
//                    do{
//                        
//                        System.out.println("Atraccion: " + atr.getNombre());
//                        System.out.print("¿Desea comprar? S/N: ");
//                        respuesta = scanner.next().toUpperCase().charAt(0);
//                        
//                        if(respuesta == 'S')
//                            usuario.comprarAtraccion(atr);
//                        
//                    }while(respuesta != 'S' && respuesta != 'N');
//                }
//                
//                
//                // le ofrezo al usuario que compre las atracciones que NO son de su preferencia
//                for(Atraccion atr : arbolAtraccionesNoPref){
//                    do{
//                        System.out.println("Atraccion: " + atr.getNombre());
//                        System.out.print("¿Desea comprar? S/N: ");
//                        respuesta = scanner.next().toUpperCase().charAt(0);
//                        
//                        if(respuesta == 'S')
//                            usuario.comprarAtraccion(atr);
//                        
//                    }while(respuesta != 'S' && respuesta != 'N');
//                }
//                
//                
//                //Saco de las listas las atracciones ya compradas por el usuario para no ofrecerselas nuevamente
//                for(Atraccion atr : usuario.getAtraccionesCompradas()){
//                    if(arbolAtraccionesNoPref.contains(atr))
//                        arbolAtraccionesNoPref.remove(atr);
//                        
//                    if(arbolAtraccionesPref.contains(atr))
//                        arbolAtraccionesPref.remove(atr);
//                    
//                    //si la atraccion mas barata necesito sacarla, se calcula la nuevea atraccion mas barata
//                    if(atr == atracMasBarata)    
//                    {
//                        Atraccion atrac1 = Atraccion.buscarAtraccionMasBarata(arbolAtraccionesPref);
//                        Atraccion atrac2 = Atraccion.buscarAtraccionMasBarata(arbolAtraccionesNoPref);
//                        
//                        if(atrac1 != null && atrac2 != null && atrac1.getTiempo() <= atrac2.getTiempo() && atrac1.getPrecio() <= atrac2.getPrecio())
//                            atracMasBarata = atrac1;
//                        else if(atrac1 != null && atrac2 != null && atrac1.getTiempo() >= atrac2.getTiempo() && atrac1.getPrecio() >= atrac2.getPrecio())
//                            atracMasBarata = atrac2;
//                        else if(atrac1 == null && atrac2 != null)
//                            atracMasBarata = atrac2;
//                        else if(atrac1 != null && atrac2 == null)
//                            atracMasBarata = atrac1;
//                    }
//                }
//		        
//		    }
//		    
//		    
//		    
//		    
//            //3) imprimo por pantalla las compras del usuario y pido confirmación (Mas adelante se escribiran en un archivo)
//            System.out.println("==============Atracciones compradas por " + usuario.getNombre().toUpperCase() + ": ===================");
//            for(Atraccion atr : usuario.getAtraccionesCompradas())
//                System.out.println(atr);
//            
//            char respuesta = '\0';
//            do{
//                System.out.println("¿Confirmas compra? S/N");
//                respuesta = scanner.next().toUpperCase().charAt(0);
//                
//                if(respuesta == 'N'){
//                    usuario.borrarCompras();
//                    usuarios.addFirst(usuario);
//                }
//                
//                if(respuesta=='S')
//                {
//                    //CODIGO DE CONFIRMACIÓN DE LA COMPRA
//                }
//                
//                
//            }while(respuesta != 'S' && respuesta != 'N');
//		}
//		    
//		
//	}
	}
}
