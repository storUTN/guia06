package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CursoTest {
	Curso a1;
	Curso a2;
	Curso a3;
	Curso a4;
	Alumno b1;
	Alumno b2;
	@Test
	void testInscribir() {
		a1= new Curso(1,0,1,"Matematicas",0,1);
		a2= new Curso(1,0,1,"Fisica",0,1);
		a3= new Curso(1,0,1,"Programacion",0,1);
		a4= new Curso(1,1,1,"Ingles",0,1);
		b1= new Alumno(1,"Juan");
		b2= new Alumno(2,"Pedro");
		assertFalse(a4.inscribir(b1),"No deberia inscribirse sin creditos suficientes");
		assertTrue(a1.inscribir(b1),"Deberia poder inscribirse");
		assertFalse(a1.inscribir(b2),"El curso no deberia tener cupos");
		b1.aprobar(a1);
		assertTrue(a4.inscribir(b1),"Deberia poder inscribirse ahora");
		a2.inscribir(b1);
		a3.inscribir(b1);
		a4= new Curso(1,0,1,"Ingles",0,1);
		assertFalse(a4.inscribir(b1),"El alumno ya esta cursando 3 materias");
		
	}
	@Test
	void testInscribirAlumno() {
		a1= new Curso(1,0,1,"Matematicas",0,1);
		a2= new Curso(1,0,1,"Fisica",0,1);
		a3= new Curso(1,0,1,"Programacion",0,1);
		a4= new Curso(1,1,1,"Ingles",0,1);
		b1= new Alumno(1,"Juan");
		b2= new Alumno(2,"Pedro");
		assertThrows(ExcCreditos.class,()->a4.inscribirAlumno(b1));
		a1.inscribir(b1);
		assertThrows(ExcCupo.class,()->a1.inscribirAlumno(b2));
		a2.inscribir(b1);
		a3.inscribir(b1);
		a4= new Curso(1,0,1,"Ingles",0,1);
		assertThrows(ExcCursado.class,()->a4.inscribirAlumno(b1),"El alumno ya esta cursando 3 materias");
	}
	@Test
	void testImprimirInscriptos() {
		a1= new Curso(1,0,2,"Matematicas",0,1);
		b1= new Alumno(21,"AJuan");
		b2= new Alumno(12,"BPedro");
		a1.inscribir(b1);
		a1.inscribir(b2);
		b1.aprobar(a1);
		//Ordena segun nombre:
		a1.imprimirInscriptos(1);
		//Ordena segun creditos(orden ascendente):
		a1.imprimirInscriptos(2);
		//Ordena segun Libreta (orden ascendente)
		a1.imprimirInscriptos(3);
		//Utiliza el ultimo orden usado:
		a1.imprimirInscriptos(10);
	}

}
