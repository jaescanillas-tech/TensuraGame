package dev.game.modelo;

public abstract class Personaje{
    private String nombre;
    private double vida;
    private int nivel;
    private double ataque;
    private int magicuraMaxima;
    private int magicuraMinima;
    private double defensa;

    public Personaje(String nombre, double vida, int nivel, double ataque, int magicuraMaxima, int magicuraMinima, double defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivel = nivel;
        this.ataque = ataque;
        this.magicuraMaxima = magicuraMaxima;
        this.magicuraMinima = magicuraMinima;
        this.defensa = defensa;
    }

    public int getMagicuraMaxima() {
        return magicuraMaxima;
    }

    public int getMagicuraMinima() {
        return magicuraMinima;
    }

    public double getDefensa() {
        return defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public double getVida() {
        return vida;
    }

    public int getNivel() {
        return nivel;
    }

    public double getAtaque() {
        return ataque;
    }

    public abstract void mostrarEstadisticas();
}
