package lenguaje3Parcial2;
import java.util.*;

import java.util.ArrayList;

public class Estudiante {
    String nombre;
    String documento;
    ArrayList<Double> notas;

    public Estudiante(String nombre, String documento, ArrayList<Double> notas) {
        this.nombre = nombre;
        this.documento = documento;
        this.notas = notas;
    }

    @Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", documento=" + documento + ", notas=" + notas + "]";
	}

	public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    public double obtenerPromedio() {
        OptionalDouble promedio;
        promedio = notas.stream()
                .mapToDouble(e -> e)
                .average();

        return promedio.isPresent() ? promedio.getAsDouble() : null;
    }
}