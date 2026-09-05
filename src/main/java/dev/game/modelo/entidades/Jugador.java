package dev.game.modelo.entidades;

import dev.game.modelo.enums.Razas;

public class Jugador extends Personaje{
    private int dinero;
    private int destreza;
    private int capInventario;
    private boolean reqEvolucion;

    public Jugador(String nombre, Razas raza){
        super(nombre, raza);
        this.dinero = 0;
        this.destreza = 10;
        this.capInventario = 20;
        this.reqEvolucion = false;
        habilidadInicial();
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getCapInventario() {
        return capInventario;
    }

    public void setCapInventario(int capInventario) {
        this.capInventario = capInventario;
    }

    public boolean isReqEvolucion() {
        return reqEvolucion;
    }

    public void setReqEvolucion(boolean reqEvolucion) {
        this.reqEvolucion = reqEvolucion;
    }


    @Override
    public void mostrarEstadisticas() {
        System.out.println("=== Estadisticas Jugador ===");
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Vida: " + this.getVidaMax() + " / " + this.vidaActual);
        System.out.println("Estamina: " + this.getEstaminaActual() + " / " + this.getEstaminaMaxima());
        System.out.println("Magicura: " + this.getMagicuraActual() + " / " + this.getMagicuraMaxima());
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
