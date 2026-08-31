package dev.game.modelo;

public class Humano extends Personaje{
    private int magia;

    public Humano(String nombre, double vida, int nivel, double ataque, int magicuraMaxima, int magicuraActual, double defensa, int magia) {
        super(nombre, vida, nivel, ataque, magicuraMaxima, magicuraActual, defensa);
        this.magia = magia;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    @Override
    public void mostrarEstadisticas() {
        System.out.println("=== Ficha Humano ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Vida: " + getVida());
        System.out.println("Nivel: " + getNivel());
        System.out.println("Ataque: " + getAtaque());
        System.out.println("Defensa: " + getDefensa());
        System.out.println("Magia: " + getMagia());
    }
}
