package dev.game.modelo.criaturas;

public class Humano extends Personaje {

    @Override
    public void mostrarEstadisticas() {
        System.out.println("=== Ficha Humano ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Vida: " + getVida());
        System.out.println("Nivel: " + getNivel());
    }
}
