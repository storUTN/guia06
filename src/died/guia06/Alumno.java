package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	//Metodos de negocio:
	
	/* Defino un metodo en Curso para poder obtener el valor
	 * de los creditos de cada curso.
	 */
	public int creditosObtenidos() {
		int credTotales=0;
		for(Curso aprobado: aprobados) {
			credTotales=credTotales+aprobado.getCreditos();
		}
		return credTotales;
	}

	public void aprobar(Curso c) {
		aprobados.add(c);
		cursando.remove(c);
	}

	public void inscripcionAceptada(Curso c) {
		cursando.add(c);
	}
	
	//Constructores:
	
	public Alumno(int num,String nombre) {
		this.nroLibreta=num;
		this.nombre=nombre;
		this.aprobados= new ArrayList<Curso>();
		this.cursando= new ArrayList<Curso>();
	}
	public Alumno(int num) {
		this.nroLibreta=num;
		this.aprobados= new ArrayList<Curso>();
		this.cursando= new ArrayList<Curso>();
	}
	public Alumno(String nombre) {
		this.nombre=nombre;
		this.aprobados= new ArrayList<Curso>();
		this.cursando= new ArrayList<Curso>();
	}
	public Alumno() {
		this.aprobados= new ArrayList<Curso>();
		this.cursando= new ArrayList<Curso>();
	}
	
	
	//Metodo que facilita un valor usado para registrar a un alumno:
	
	public int cantCursando() {
		return cursando.size();
	}
	
	//Metodos equals y compareTo:
	
	public boolean equals(Alumno a) {
		return a.nombre.equals(this.nombre);
	}
	public int compareTo(Alumno a) {
		return this.nombre.compareTo(a.nombre);
	}
}
