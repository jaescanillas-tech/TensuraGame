package dev.game.modelo.Items;

public class Item {
    private String nombre;
    private int valorV;
    private String descripcion;

    public Item(String nombre, int valorV, String descripcion) {
        this.nombre = nombre;
        this.valorV = valorV;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValorV() {
        return valorV;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
