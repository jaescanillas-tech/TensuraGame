package dev.game.modelo.Items;

import java.util.Random;

public class DropItem {
    private Item item;
    private double probabilidad;
    private int cantidadMax;
    private int cantidadMin;
    private static final Random random = new Random();

    public DropItem(Item item, double probabilidad, int cantidadMax, int cantidadMin) {
        this.item = item;
        this.probabilidad = probabilidad;
        this.cantidadMax = cantidadMax;
        this.cantidadMin = cantidadMin;
    }

    public Item getItem() {
        return item;
    }

    public double getProbabilidad() {
        return probabilidad;
    }

    public int calculardrop(){
        double tirada = random.nextDouble();
        if (tirada <= this.probabilidad) {
            return random.nextInt((cantidadMax - cantidadMin) + 1)  + cantidadMin;
        }
        return 0;
    }
}
