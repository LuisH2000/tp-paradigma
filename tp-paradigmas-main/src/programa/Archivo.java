package programa;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

public class Archivo {

	private final String archUsuarios;
	private final String archAtracciones;
	private final String archPromociones;

	public Archivo() {
		this.archUsuarios = "usuarios";
		this.archAtracciones = "atracciones";
		this.archPromociones = "promociones";
	}

	public Archivo(String archUsuarios, String archAtracciones, String archPromociones) {
		this.archUsuarios = archUsuarios;
		this.archAtracciones = archAtracciones;
		this.archPromociones = archPromociones;
	}

	public Queue<Usuario> leerUsuarios() {

		Queue<Usuario> usuarios = new LinkedList<Usuario>();

		File file = null;
		Scanner scanner = null;

		try {

			file = new File("archivos/" + this.archUsuarios + ".in");
			scanner = new Scanner(file);

			scanner.useLocale(Locale.ENGLISH);

			int cantRegistros = scanner.nextInt();

			for (int i = 0; i < cantRegistros; i++) {
				String nombre = scanner.next();
				double dinero = scanner.nextDouble();
				double tiempo = scanner.nextDouble();
				String preferencia = scanner.next();

				usuarios.add(new Usuario(nombre, dinero, tiempo, preferencia));

			}

		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		} finally {
			scanner.close();
		}

		return usuarios;

	}

	public ArrayList<Atraccion> leerAtracciones() {

		File file = null;
		Scanner scanner = null;
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

		try {
			file = new File("archivos/" + this.archAtracciones + ".in");
			scanner = new Scanner(file);

			scanner.useLocale(Locale.ENGLISH);

			int cantRegistros = scanner.nextInt();

			for (int i = 0; i < cantRegistros; i++) {

				String nombre = scanner.next();

				while (!scanner.hasNextDouble())
					nombre += " " + scanner.next();

				double precio = scanner.nextDouble();
				double tiempo = scanner.nextDouble();
				int cupo = scanner.nextInt();
				String tipoAtraccion = scanner.next();

				atracciones.add(new Atraccion(nombre, precio, tiempo, cupo, tipoAtraccion));

			}

		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		} finally {
			scanner.close();
		}

		return atracciones;
	}

	public ArrayList<Promocion> leerPromociones(ArrayList<Atraccion> atr) {
		ArrayList<Promocion> promociones = new ArrayList<Promocion>();
		ArrayList<Atraccion> atrPromo = new ArrayList<Atraccion>();
		File file = null;
		Scanner scanner = null;

		try {
			file = new File("archivos/" + this.archPromociones + ".in");
			scanner = new Scanner(file);

			scanner.useLocale(Locale.ENGLISH);
			// Promos Descuento
			int cantReg = scanner.nextInt();
			for (int i = 0; i < cantReg; i++) {
				int cantAtracciones = scanner.nextInt();
				scanner.nextLine();

				for (int j = 0; j < cantAtracciones; j++) {
					Atraccion nombre = new Atraccion(scanner.nextLine());
					atrPromo.add(atr.get(atr.indexOf(nombre)));
				}
				double descuento = scanner.nextDouble();

				promociones.add(Promocion.crearPromoDesc(atrPromo, descuento));
				atrPromo.clear();
			}
			// Promos Abs
			cantReg = scanner.nextInt();
			for (int i = 0; i < cantReg; i++) {
				int cantAtracciones = scanner.nextInt();
				scanner.nextLine();

				for (int j = 0; j < cantAtracciones; j++) {
					Atraccion nombre = new Atraccion(scanner.nextLine());
					atrPromo.add(atr.get(atr.indexOf(nombre)));
				}
				double precio = scanner.nextDouble();

				promociones.add(Promocion.crearPromoAbs(atrPromo, precio));
				atrPromo.clear();
			}
			// Promos AxB
			cantReg = scanner.nextInt();
			for (int i = 0; i < cantReg; i++) {
				int cantAtracciones = scanner.nextInt();
				scanner.nextLine();

				for (int j = 0; j < cantAtracciones; j++) {
					Atraccion nombre = new Atraccion(scanner.nextLine());
					atrPromo.add(atr.get(atr.indexOf(nombre)));
				}

				promociones.add(Promocion.crearPromoAxB(atrPromo));
				atrPromo.clear();
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (scanner != null)
				scanner.close();
		}

		return promociones;
	}

	public void generarArchUsuario(Usuario cliente) {
		
	}
	
}