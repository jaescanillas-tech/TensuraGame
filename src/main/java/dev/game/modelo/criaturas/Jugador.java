package dev.game.modelo.criaturas;

import dev.game.modelo.habilities.Elementos;
import dev.game.modelo.habilities.Habilidad;

import java.util.List;

public class Jugador extends Personaje{
    private int xpActual;
    private int xpMaximo;
    private int dinero;
    private int destreza;
    private int capInventario;
    private boolean reqEvolucion;



    @Override
    public void mostrarEstadisticas() {
        System.out.println("=== Estadisticas Jugador ===");
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Vida: " + this.getVida());
        System.out.println("Nivel: " + this.getNivel());
        System.out.println("Xp: " + this.getXpActual());
        System.out.println("Sig niv: " + this.getXpMaximo());
        System.out.println("Dinero: " + this.getDinero());
        System.out.println("Destreza: " + this.getDestreza());
        System.out.println("Cap inventario: " + this.getCapInventario());
        System.out.println("=== Estadisticas Avanzadas Jugador ===");
        System.out.println("Defensa Fisica: " + this.defensaFisica);
        System.out.println("Defensa Magica: " + this.defensaMagica);
        System.out.println("Defensa Elemental: " + this.defensaElemental);
        System.out.println("Ataque Fisico: " + this.ataqueFisico);
        System.out.println("Ataque Magico: " + this.ataqueMagico);
        System.out.println("Ataque Elemental: " + this.ataqueElemental);
        System.out.println("Evolucion: " +  this.reqEvolucion);
    }
}
