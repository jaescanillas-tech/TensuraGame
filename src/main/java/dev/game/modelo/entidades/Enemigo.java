package dev.game.modelo.entidades;

import dev.game.modelo.Items.DropItem;
import dev.game.modelo.Items.Item;
import dev.game.modelo.enums.RangoEnemigos;
import dev.game.modelo.enums.Razas;

import java.util.ArrayList;
import java.util.List;

public class Enemigo extends Personaje {
    private RangoEnemigos rango;
    private List<DropItem> tablaDrops;

    public Enemigo(String nombre, Razas raza, RangoEnemigos rango) {
        super(nombre, raza);
        this.rango = rango;
        this.tablaDrops = new ArrayList<>();

        //escalado x rango
        this.vidaMax *= rango.getMultVida();
        this.defensaFisica = (int) (this.defensaFisica * rango.getMultDefensa());
        this.defensaMagica = (int) (this.defensaMagica * rango.getMultDefensa());
        this.ataqueFisico *= rango.getMultAtaque();
        this.ataqueMagico *= rango.getMultAtaque();

        this.vidaActual = vidaMax;

        configurarTablaDrops();
    }

    public RangoEnemigos getRango() {
        return rango;
    }

    public List<DropItem> getTablaDrops() {
        return tablaDrops;
    }

    private void configurarTablaDrops(){
        switch (this.raza) {
            case Goblin -> {
                tablaDrops.add(new DropItem(new Item("Espada", 10, "espada de madera"), 1.0, 1, 1)); // prueba
            }
            case Humano -> {}
        }
    }

    @Override
    public void mostrarEstadisticas() {
        System.out.println("=== Estadisticas Enemigo "+ this.raza +" ===");
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Vida: " + this.getVidaMax() + " / " + this.vidaActual);
        System.out.println("Estamina: " + this.getEstaminaActual() + " / " + this.getEstaminaMaxima());
        System.out.println("Magicura: " + this.getMagicuraActual() + " / " + this.getMagicuraMaxima());
        System.out.println("=== Estadisticas Avanzadas "+ this.raza +" ===");
        System.out.println("Defensa Fisica: " + this.defensaFisica);
        System.out.println("Defensa Magica: " + this.defensaMagica);
        System.out.println("Defensa Elemental: " + this.defensaElemental);
        System.out.println("Ataque Fisico: " + this.ataqueFisico);
        System.out.println("Ataque Magico: " + this.ataqueMagico);
        System.out.println("Ataque Elemental: " + this.ataqueElemental);
        System.out.println(" === Lista Drops ===");
        for (DropItem drop : this.tablaDrops) {
            System.out.println("- " + drop.getItem().getNombre() + " (Probabilidad: " + drop.getProbabilidad() + ")");
        }
        System.out.println("=================================");
    }
}
