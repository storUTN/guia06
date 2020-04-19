package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;

import org.junit.jupiter.api.Test;

class AlumnoTest {
    private Alumno a;
    private Curso b;
    
    
	@Test
	void testCreditosObtenidos() {
		a= new Alumno();
		assertNotNull(a);
		assertFalse(a.creditosObtenidos()!=0,"Deberia ser 0");
	}
	@Test
	void testAprobar() {
		a= new Alumno();
    	b= new Curso();
		a.inscripcionAceptada(b);
		a.aprobar(b);
		assertFalse(a.cantCursando()!=0,"Deberia ser 0");
	}
	@Test
	void testInscripcionAceptada() {
		a= new Alumno();
    	b= new Curso();
		a.inscripcionAceptada(b);
		assertFalse(a.cantCursando()==0,"No deberia ser 0");
	}

}
