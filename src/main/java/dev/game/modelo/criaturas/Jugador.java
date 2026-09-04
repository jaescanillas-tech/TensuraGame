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

    public Jugador(String nombre, Razas raza){
        super(nombre, raza, 1);
        this.xpActual = 0;
        this.xpMaximo = 100;
        this.dinero = 0;
        this.destreza = 10;
        this.capInventario = 20;
        this.reqEvolucion = false;
    }

    public int getXpActual() {
        return xpActual;
    }

    public void setXpActual(int xpActual) {
        this.xpActual = xpActual;
    }

    public int getXpMaximo() {
        return xpMaximo;
    }

    public void setXpMaximo(int xpMaximo) {
        this.xpMaximo = xpMaximo;
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
        System.out.println("=== habilidades Aprendidas ===");
        if (this.habilidades.isEmpty()){
            System.out.println("No tienes habilidades aprendidas");
        } else {
            for (int i = 0; i < this.habilidades.size(); i++) {
                System.out.println("   " + (i + 1) + ".  " + this.habilidades.get(i));
            }
        }
        System.out.println("========================================");
    }
}
