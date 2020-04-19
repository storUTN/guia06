package died.guia06;

import java.util.Comparator;

public class ComparaCreditosAlumno implements Comparator<Alumno>{

	public int compare(Alumno o1, Alumno o2) {
		return o1.creditosObtenidos()-o2.creditosObtenidos();
	}

}
