package died.guia06;

public class App {

	public static void main(String[] args) {
		//2 alumnos construidos con distintos metodos
		Alumno a1= new Alumno(01,"Felipe");
		Alumno a2= new Alumno();
		a2.setLibreta(14);
		a2.setNombre("Pedro");
		//2 cursos construidos con distintos metodos
		Curso b1= new Curso();
		Curso b2= new Curso(1,1,2,"Matematicas",01,12);
		b1.setCred(1);
		b1.setCredNec(0);
		b1.setCupo(2);
		b1.setNombre("Economia");
		//inscripcion de un alumno a un curso
		System.out.println("Inscribiendo alumno "+a1.getNombre()+" a curso "+b1.getNombre());
		if(b1.inscribir(a1)) {
			System.out.println("Alumno "+a1.getNombre()+" inscripto\n");
		}
		else System.out.println("No se ha podido inscribir al alumno\n");
		//el alumno aprueba el curso, lo que le otorga 1 credito
		a1.aprobar(b1);
		//inscripcion de un alumno a un curso que requiere 1 credito
		System.out.println("Inscribiendo alumno "+a1.getNombre()+" a curso "+b2.getNombre());
		if(b2.inscribir(a1)) {
			System.out.println("Alumno "+a1.getNombre()+" inscripto\n");
		}
		else System.out.println("No se ha podido inscribir al alumno\n");
		//intento de inscripcion de un alumno sin creditos suficientes
		System.out.println("Inscribiendo alumno "+a2.getNombre()+" a curso "+b2.getNombre());
		if(b2.inscribir(a2)) {
			System.out.println("Alumno "+a2.getNombre()+" inscripto\n");
		}
		else System.out.println("No se ha podido inscribir al alumno\n");
		//inscripcion de un segundo alumno a un curso
		if(b1.inscribir(a2)) {
			System.out.println("Alumno "+a2.getNombre()+" inscripto\n");
		}
		else System.out.println("No se ha podido inscribir al alumno\n");
		
		//impresiones de la lista de alumnos de un curso
		System.out.println("Lista alfabetica de alumnos:");
		b1.imprimirInscriptos(1);
		System.out.println("Lista por creditos de alumnos:");
		b1.imprimirInscriptos(2);
		System.out.println("Lista por numero de libreta de alumnos:");
		b1.imprimirInscriptos(3);
	}
}