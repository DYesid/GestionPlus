package unisangil.GestionPlus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import unisangil.GestionPlus.modelo.Egreso;
import unisangil.GestionPlus.modelo.Ingreso;
import unisangil.GestionPlus.servicio.IEgresoServicio;
import unisangil.GestionPlus.servicio.IIngresoServicio;

import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class GestionPlusApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(GestionPlusApplication.class, args);

		// Obtener los servicios del contexto de Spring
		IIngresoServicio ingresoServicio = context.getBean(IIngresoServicio.class);
		IEgresoServicio egresoServicio = context.getBean(IEgresoServicio.class);

		// Crear el menú interactivo
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		while (continuar) {
			System.out.println("\n=== Sistema de Gestión Financiera ===");
			System.out.println("1. Registrar ingreso");
			System.out.println("2. Registrar egreso");
			System.out.println("3. Salir");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer

			switch (opcion) {
				case 1 -> registrarIngreso(scanner, ingresoServicio);
				case 2 -> registrarEgreso(scanner, egresoServicio);
				case 3 -> {
					System.out.println("¡Gracias por usar el sistema!");
					continuar = false;
				}
				default -> System.out.println("Opción inválida. Intente nuevamente.");
			}
		}
	}

	private static void registrarIngreso(Scanner scanner, IIngresoServicio ingresoServicio) {
		System.out.println("\n=== Registro de Ingreso ===");

		System.out.print("Ingrese el monto: ");
		double monto = scanner.nextDouble();
		scanner.nextLine(); // Limpiar el buffer

		System.out.print("Ingrese la descripción: ");
		String descripcion = scanner.nextLine();

		LocalDate fecha = LocalDate.now();

		Ingreso nuevoIngreso = new Ingreso();
		nuevoIngreso.setMonto(monto);
		nuevoIngreso.setDescripcion(descripcion);
		nuevoIngreso.setFecha(fecha);

		ingresoServicio.guardarIngreso(nuevoIngreso);

		System.out.println("Ingreso registrado exitosamente.");
	}

	private static void registrarEgreso(Scanner scanner, IEgresoServicio egresoServicio) {
		System.out.println("\n=== Registro de Egreso ===");

		System.out.print("Ingrese el monto: ");
		double monto = scanner.nextDouble();
		scanner.nextLine(); // Limpiar el buffer

		System.out.print("Ingrese la descripción: ");
		String descripcion = scanner.nextLine();

		LocalDate fecha = LocalDate.now();

		Egreso nuevoEgreso = new Egreso();
		nuevoEgreso.setMonto(monto);
		nuevoEgreso.setDescripcion(descripcion);
		nuevoEgreso.setFecha(fecha);

		egresoServicio.guardarEgreso(nuevoEgreso);

		System.out.println("Egreso registrado exitosamente.");
	}
}
