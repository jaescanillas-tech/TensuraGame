package dev.game.modelo;

public class Monstruo extends Personaje{
    private String rangoEvolucion;
    private int magia;

    public Monstruo(String nombre, double vida, int nivel, double ataque, int magicuraMaxima, int magicuraActualues, double defensa, int magia, String rangoEvolucion) {
        super(nombre, vida, nivel, ataque, magicuraMaxima, magicuraActualues, defensa);
        this.rangoEvolucion = rangoEvolucion;
        this.magia = magia;
    }

    public String getRangoEvolucion() {
        return rangoEvolucion;
    }

    public void setRangoEvolucion(String rangoEvolucion) {
        this.rangoEvolucion = rangoEvolucion;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    @Override
    public void mostrarEstadisticas() {
        System.out.println("=== Ficha Monstruo ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Vida: " + getVida());
        System.out.println("Nivel: " + getNivel());
        System.out.println("Ataque: " + getAtaque());
        System.out.println("Defensa: " + getDefensa());
        System.out.println("Magia: " + getMagia());
        System.out.println("Evolucion: " + getRangoEvolucion());
    }
}
