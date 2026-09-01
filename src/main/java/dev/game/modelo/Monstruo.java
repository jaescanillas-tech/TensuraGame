package dev.game.modelo;

import java.util.List;

public class Monstruo extends Personaje{
    private RangoPeligro nivelPeligro;

    public Monstruo(String nombre, double vida, int nivel, double ataqueFisico, double defensaFisica, double ataqueMagico, double defensaMagica, int magicuraMaxima, int magicuraActualues, String evolucion, List<String> afinidad, int estaminaMaxima, int estaminaActual, RangoPeligro nivelPeligro) {
        super(nombre, vida, nivel, ataqueFisico, defensaFisica, ataqueMagico, defensaMagica, magicuraMaxima, magicuraActualues, evolucion, afinidad, estaminaMaxima, estaminaActual);
        this.nivelPeligro = nivelPeligro;
    }

    public RangoPeligro getNivelPeligro() {
        return nivelPeligro;
    }

    public void setNivelPeligro(RangoPeligro nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    @Override
    public void mostrarEstadisticas() {
        System.out.println("=== Ficha Monstruo ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Vida: " + getVida());
        System.out.println("Nivel: " + getNivel());
        System.out.println("Estamina Maxima: " + getEstaminaMaxima());
        System.out.println("Estamina Actual: " + getEstaminaActual());
        System.out.println("Magicura Maxima: " + getMagicuraMaxima());
        System.out.println("Magicura Actual: " + getMagicuraActualues());
        System.out.println("Nivel de Peligro: " + getNivelPeligro());
        System.out.println("Ataque Fisico: " + getAtaqueFisico());
        System.out.println("Defensa Fisica: " + getDefensaFisica());
        System.out.println("Ataque Magico: " + getAtaqueMagico());
        System.out.println("Defensa Magica: " + getDefensaMagica());
        System.out.println("Evolucion: " + getEvolucion());
        System.out.println("Afinidad: " + getAfinidad());
    }
}
