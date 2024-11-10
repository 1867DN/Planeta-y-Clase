import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String nombre;
    private String apellidos;
    private String numeroDocumento;
    private LocalDate fechaNacimiento;
    private String paisNacimiento;
    private char genero;

    public Persona(String nombre, String apellidos, String numeroDocumento, int añoNacimiento, String paisNacimiento, char genero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = LocalDate.of(añoNacimiento, 1, 1); // Asume día y mes como 1 si solo tenemos el año
        this.paisNacimiento = paisNacimiento;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int añoNacimiento) {
        this.fechaNacimiento = LocalDate.of(añoNacimiento, 1, 1);
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int calcularEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public void imprimir() {
        System.out.println("Nombre = " + nombre);
        System.out.println("Apellidos = " + apellidos);
        System.out.println("Número de documento de identidad = " + numeroDocumento);
        System.out.println("Fecha de nacimiento = " + fechaNacimiento.getYear());
        System.out.println("Edad = " + calcularEdad());
        System.out.println("País de nacimiento = " + paisNacimiento);
        System.out.println("Género = " + (genero == 'H' ? "Hombre" : "Mujer"));
        System.out.println();
    }

    public static void main(String[] args) {
        Persona p1 = new Persona("Pedro", "Pérez", "1053121010", 1998, "Argentina", 'H');
        Persona p2 = new Persona("Luis", "León", "1053223344", 2001, "México", 'M');
        p1.imprimir();
        p2.imprimir();
    }
}