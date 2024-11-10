public class Planeta {
    private String nombre = null;
    private int cantidadSatelites = 0;
    private double masa = 0.0;
    private double volumen = 0.0;
    private int diametro = 0;
    private int distanciaMediaSol = 0;
    private final TipoPlaneta tipo;
    private boolean observable = false;
    private double periodoOrbital = 0.0;
    private double periodoRotacion = 0.0;

    public enum TipoPlaneta {
        GASEOSO, TERRESTRE, ENANO
    }

    public Planeta(String nombre, int cantidadSatelites, double masa, double volumen, int diametro,
                int distanciaMediaSol, TipoPlaneta tipo, boolean observable, double periodoOrbital, double periodoRotacion) {
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaMediaSol = distanciaMediaSol;
        this.tipo = tipo;
        this.observable = observable;
        this.periodoOrbital = periodoOrbital;
        this.periodoRotacion = periodoRotacion;
    }

    public double calcularDensidad() {
        if (volumen != 0) {
            return masa / volumen;
        }
        return 0.0;
    }

    public boolean esPlanetaExterior() {
        final int UNIDAD_ASTRONOMICA = 149_597_870; // UA en kilómetros
        double distanciaUA = (distanciaMediaSol * 1_000_000.0) / UNIDAD_ASTRONOMICA;
        return distanciaUA > 3.4;
    }

    public void imprimir() {
        System.out.println();
        System.out.println("- Nombre: " + nombre);
        System.out.println("- Cantidad de Satélites: " + cantidadSatelites);
        System.out.println("- Masa (kg): " + masa);
        System.out.println("- Volumen (km³): " + volumen);
        System.out.println("- Diámetro (km): " + diametro);
        System.out.println("- Distancia Media al Sol (millones de km): " + distanciaMediaSol);
        System.out.println("- Tipo de Planeta: " + tipo);
        System.out.println("- Observable a simple vista: " + observable);
        System.out.println("- Periodo Orbital (años): " + periodoOrbital);
        System.out.println("- Periodo de Rotación (días): " + periodoRotacion);
        System.out.println("- Densidad (kg/km³): " + calcularDensidad());
        System.out.println("- ¿Es planeta exterior? " + (esPlanetaExterior() ? "Sí" : "No"));
        System.out.println();
    }

    public static void main(String[] args) {
        Planeta tierra = new Planeta("Tierra", 1, 5.972E24, 1.08321E12, 12742, 149, TipoPlaneta.TERRESTRE, true, 1.0, 1.0);
        Planeta jupiter = new Planeta("Júpiter", 79, 1.898E27, 1.43128E15, 139820, 778, TipoPlaneta.GASEOSO, false, 11.86, 0.41);

        tierra.imprimir();
        jupiter.imprimir();
    }
}