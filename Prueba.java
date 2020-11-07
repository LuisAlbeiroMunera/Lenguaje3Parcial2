package lenguaje3Parcial2;

import java.util.ArrayList;

import java.util.Scanner;

public class Prueba {
	public Utilidades utilidades = new Utilidades();
	Scanner teclado = new Scanner(System.in);

	public void crearEstudiante() {
		String textoAMostrar = "Crear estudiante \n";
		System.out.println(textoAMostrar);

		ArrayList<Double> notas = new ArrayList<>();

		System.out.println("Ingrese su documento: ");
		String documento = teclado.nextLine();

		System.out.println("Ingrese su nombre:");
		String nombre = teclado.nextLine();

		System.out.println("Notas");

		for (int i = 0; i < 4; i++) {
			System.out.println("Ingrese nota " + (i + 1) + ":");
			Double nota = teclado.nextDouble();
			teclado.nextLine();
			notas.add(nota);
		}

		Estudiante estudiante = new Estudiante(nombre, documento, notas);
		utilidades.crearEstudiante(estudiante);

	}

	public void actualizarEstudiante() {

		if (!validarEstudiantesExistentes()) {
			return;
		}

		System.out.println("Escriba el documento del estudiante");
		String documento = teclado.nextLine();

		if (utilidades.buscarEstudiantes(documento) < 0) {
			System.out.println("Documento incorrecto");
			return;
		}

		String textoAMostrar = "Actualizar estudiante \n";
		System.out.println(textoAMostrar);

		String textoActualizarEstudiante = "Ingrese la opción 1 para actualizar nombre: \n"
				+ "Ingrese la opción 2 para actualizar notas: \n";
		System.out.println(textoActualizarEstudiante);
		String opcionElegida = teclado.nextLine();

		int opcion = Integer.parseInt(opcionElegida);

		switch (opcion) {
		case 1:
			System.out.println("Nuevo nombre:");
			String nombre = teclado.nextLine();
			utilidades.actualizarNombreEstudiante(documento, nombre);
			break;
		case 2:
			ArrayList<Double> notas = new ArrayList<Double>();
			for (int i = 0; i < 4; i++) {
				System.out.println("Ingrese nota " + (i + 1) + ":");
				Double nota = teclado.nextDouble();
				teclado.nextLine();
				notas.add(nota);
			}
			utilidades.actualizarNotaEstudiante(documento, notas);
			break;
		default:
			System.out.println("Opción incorrecta, seleccione una opción correcta");
		}
	}

	public void menu() {
		String textoMenu = "MENU \n"
				+ "Porfavor ingrese la opcion que desea realizar \n"
				+ " 1 ingresar un estudiante: \n"
				+ " 2 eliminar un estudiante: \n"
				+ " 3 actualizar un estudiante: \n"
				+ " 4 ver los 3 mejores estudiantes: \n"
				+ " 5 ver el promedio y los estudiantes que ganaron: \n"
				+ " 6 Listar los estudiantes: \n" 
				+ " 7 salir: \n";

		System.out.println(textoMenu);
		try {
			String opcionElegida = teclado.nextLine();
			llamarFuncionElegida(opcionElegida);
		} catch (Exception e) {
			String opcionElegida = "0";
			llamarFuncionElegida(opcionElegida);
		}

	}

	public void llamarFuncionElegida(String opcionElegida) {
		int opcion = Integer.parseInt(opcionElegida);

		switch (opcion) {
		case 1:
			crearEstudiante();
			break;
		case 2:
			eliminarEstudiante();
			break;
		case 3:
			actualizarEstudiante();
			break;
		case 4:
			mejoresEstudiantes();
			break;
		case 5:
			estudiantesGanados();
			break;
		case 6:
			verEstudiantes();
			break;
		case 7:
			System.out.println("fué un plaser");
			System.exit(0);
			break;
		default:
			System.out.println("Opción incorrecta, seleccione una opción correcta");
		}

		menu();
		System.out.println("Termina");

	}

	public void verEstudiantes() {
		utilidades.estudiantes.forEach(estudiante -> System.out.println(estudiante.toString()));
		validarEstudiantesExistentes();
	}

	public void eliminarEstudiante() {
		if (!validarEstudiantesExistentes()) {
			return;
		}

		String textoAMostrar = "Eliminar ";
		System.out.println(textoAMostrar);

		System.out.println("Ingrese documento ");
		String documento = teclado.nextLine();
		if (utilidades.buscarEstudiantes(documento) < 0) {
			System.out.println("Este documento no existe, porfavor ingrese nuevamente el documento");
			return;
		}

		utilidades.eliminarEstudiante(documento);
	}

	public void mejoresEstudiantes() {
		String textoAMostrar =" Los 3 mejores estudiantes son: ";
		System.out.println(textoAMostrar);

		utilidades.podioEstudiantes();

		if (!validarEstudiantesExistentes()) {
			return;
		}
	}

	public void estudiantesGanados() {
		String textoAMostrar = " Los estudiantes que ganaron fueron: ";
		System.out.println(textoAMostrar);

		utilidades.notaPromedio();
	}

	public boolean validarEstudiantesExistentes() {
		if (utilidades.estudiantes.size() < 1) {
			System.out.println("No hay estudiantes");
			return false;
		}

		return true;
	}
}
