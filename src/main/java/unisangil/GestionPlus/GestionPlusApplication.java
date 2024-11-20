package unisangil.GestionPlus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import unisangil.GestionPlus.modelo.Egreso;
import unisangil.GestionPlus.modelo.Ingreso;
import unisangil.GestionPlus.modelo.Totales;
import unisangil.GestionPlus.servicio.IEgresoServicio;
import unisangil.GestionPlus.servicio.IIngresoServicio;
import unisangil.GestionPlus.servicio.ITotalesServicio;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class GestionPlusApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(GestionPlusApplication.class, args);

		// Obtener los servicios del contexto de Spring
		IIngresoServicio ingresoServicio = context.getBean(IIngresoServicio.class);
		IEgresoServicio egresoServicio = context.getBean(IEgresoServicio.class);
		ITotalesServicio totalesServicio = context.getBean(ITotalesServicio.class);

		// Menú interactivo
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		while (continuar) {
			System.out.println("\n***** Sistema de Gestión Financiera *****");
			System.out.println("1. Registrar ingreso");
			System.out.println("2. Registrar egreso");
			System.out.println("3. Ver totales");
			System.out.println("4. Ver todos los ingresos");
			System.out.println("5. Ver todos los egresos");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
				case 1 -> registrarIngreso(scanner, ingresoServicio);
				case 2 -> registrarEgreso(scanner, egresoServicio);
				case 3 -> mostrarTotales(totalesServicio);
				case 4 -> listarIngresos(ingresoServicio);
				case 5 -> listarEgresos(egresoServicio);
				case 6 -> {
					System.out.println("¡Gracias por usar el sistema!");
					continuar = false;
				}
				default -> System.out.println("Opción inválida. Intente nuevamente.");
			}
		}
	}

	private static void registrarIngreso(Scanner scanner, IIngresoServicio ingresoServicio) {
		System.out.println("\n***** Registro de Ingreso *****");

		System.out.print("-> Ingrese el monto: ");
		double monto = scanner.nextDouble();
		scanner.nextLine();

		System.out.print("-> Ingrese la descripción: ");
		String descripcion = scanner.nextLine();

		Ingreso nuevoIngreso = new Ingreso();
		nuevoIngreso.setMonto(monto);
		nuevoIngreso.setDescripcion(descripcion);
		nuevoIngreso.setFecha(java.time.LocalDate.now());

		ingresoServicio.guardarIngreso(nuevoIngreso);

		System.out.println("-> Ingreso registrado exitosamente.");
	}

	private static void registrarEgreso(Scanner scanner, IEgresoServicio egresoServicio) {
		System.out.println("\n***** Registro de Egreso *****");

		System.out.print("-> Ingrese el monto: ");
		double monto = scanner.nextDouble();
		scanner.nextLine();

		System.out.print("-> Ingrese la descripción: ");
		String descripcion = scanner.nextLine();

		Egreso nuevoEgreso = new Egreso();
		nuevoEgreso.setMonto(monto);
		nuevoEgreso.setDescripcion(descripcion);
		nuevoEgreso.setFecha(java.time.LocalDate.now());

		egresoServicio.guardarEgreso(nuevoEgreso);

		System.out.println("-> Egreso registrado exitosamente.");
	}

	private static void mostrarTotales(ITotalesServicio totalesServicio) {
		System.out.println("\n***** Totales Financieros *****");

		Totales totales = totalesServicio.obtenerTotales();

		System.out.println("-> Total Ingresos: " + totales.getTotalIngresos());
		System.out.println("-> Total Egresos: " + totales.getTotalEgresos());
		System.out.println("-> Total Neto: " + totales.getTotalNeto());
	}

	private static void listarIngresos(IIngresoServicio ingresoServicio) {
		System.out.println("\n***** Lista de Ingresos *****");

		List<Ingreso> ingresos = ingresoServicio.listarIngresos();
		if (ingresos.isEmpty()) {
			System.out.println("-> No hay ingresos registrados.");
		} else {
			for (Ingreso ingreso : ingresos) {
				System.out.println("ID: " + ingreso.getId() + ", Monto: " + ingreso.getMonto() +
						", Descripción: " + ingreso.getDescripcion() + ", Fecha: " + ingreso.getFecha());
			}
		}
	}

	private static void listarEgresos(IEgresoServicio egresoServicio) {
		System.out.println("\n***** Lista de Egresos *****");

		List<Egreso> egresos = egresoServicio.listarEgresos();
		if (egresos.isEmpty()) {
			System.out.println("-> No hay egresos registrados.");
		} else {
			for (Egreso egreso : egresos) {
				System.out.println("ID: " + egreso.getId() + ", Monto: " + egreso.getMonto() +
						", Descripción: " + egreso.getDescripcion() + ", Fecha: " + egreso.getFecha());
			}
		}
	}
}

