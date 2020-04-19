package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso(int creditos,int credReq,int cupo,String nombre,int id,int cicloLect) {
		this.creditosRequeridos=id;
		this.nombre=nombre;
		this.cicloLectivo=cicloLect;
		this.creditos=creditos;
		this.creditosRequeridos=credReq;
		this.cupo=cupo;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		try{
			if(creditosRequeridos!=null)
			if((cupo>inscriptos.size())&&(a.creditosObtenidos()>=creditosRequeridos)&&(a.cantCursando()<3)) {
			log.registrar(this, "inscribir ",a.toString());
			a.inscripcionAceptada(this);
			inscriptos.add(a);
			return true;
			}
			else return false;
			else return false;
		}
		catch(IOException e1){
		System.out.printf("Ha ocurrido un error: "+e1.getMessage()+"\n");
		return false;
		}
	}
	
	public void inscribirAlumno(Alumno a) throws ExcCursado,ExcCreditos,ExcCupo {
		if(cupo<inscriptos.size()) {
			throw new ExcCupo();
		}
		if(a.creditosObtenidos()<creditosRequeridos) {
			throw new ExcCreditos();
		}
		if(a.cantCursando()>2) {
			throw new ExcCursado();
		}
		try {
			log.registrar(this, "inscribir ",a.toString());
			a.inscripcionAceptada(this);
			inscriptos.add(a);
		}
		catch(IOException e){
			System.out.printf("Ha ocurrido un error: "+e.getMessage()+"\n");
		}
	}
	
	
	
	
	/**
	 * imprime los inscriptos en orden alfabetico,
	 * por sus creditos o por sus numeros de libreta
	 */
	//Puede imprimir los incriptos en distintos ordenes segun x
	public void imprimirInscriptos(int x) {
	try {
		/* El default no ordena la lista y la imprime como
		 * se encuentre actualmente*/
		switch(x) {
		case 1:
		Collections.sort(inscriptos);
		break;
		case 2:
		Collections.sort(inscriptos, new ComparaCreditosAlumno());
		break;
		case 3:
		Collections.sort(inscriptos,new ComparaLibretaAlumno());
		break;
		default:
		}
		for(Alumno a: inscriptos) {
			System.out.printf("%s %d %d \n",a.getNombre(),a.getNroLib(),a.creditosObtenidos());
		}
	log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
	} catch (IOException e) {
		System.out.printf("Ha ocurrido un error: "+e.getMessage()+"\n");
	}
	}
	public int getCreditos() {
		return creditos; 
	}
	public String getNombre() {
		return nombre;
	}
	public void setCupo(int num) {
		cupo=num;
	}
	public void setCiclo(int num) {
		cicloLectivo= num;
	}
	public void setCredNec(int num) {
		creditosRequeridos= num;
	}
	public void setCred(int num) {
		creditos=num;
	}
	public void setId(int num) {
		id=num;
	}
	public void setNombre(String name) {
		nombre=name;
	}
}
