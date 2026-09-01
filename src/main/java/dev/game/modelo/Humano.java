package dev.game.modelo;
import java.util.ArrayList;

public class Humano extends Personaje{

    @Override
    public void mostrarEstadisticas() {
        System.out.println("=== Ficha Humano ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Vida: " + getVida());
        System.out.println("Nivel: " + getNivel());
    }
}
