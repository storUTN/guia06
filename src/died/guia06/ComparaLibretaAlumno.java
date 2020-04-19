package died.guia06;

import java.util.Comparator;

public class ComparaLibretaAlumno implements Comparator<Alumno> {
	public int compare(Alumno o1, Alumno o2) {
		return o1.getNroLib()-o2.getNroLib();
	}

}
