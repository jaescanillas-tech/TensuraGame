package dev.game.modelo;

public abstract class Personaje{
    private String nombre;
    private double vida;
    private int nivel;
    private double ataque;
    private int magicuraMaxima;
    private int magicuraActualues;
    private double defensa;

    public Personaje(String nombre, double vida, int nivel, double ataque, int magicuraMaxima, int magicuras, double defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivel = nivel;
        this.ataque = ataque;
        this.magicuraMaxima = magicuraMaxima;
        this.magicuraActualues = magicuras;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public int getMagicuraMaxima() {
        return magicuraMaxima;
    }

    public void setMagicuraMaxima(int magicuraMaxima) {
        this.magicuraMaxima = magicuraMaxima;
    }

    public int getMagicuraActualues() {
        return magicuraActualues;
    }

    public void setMagicuraActualues(int magicuraActualues) {
        this.magicuraActualues = magicuraActualues;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public abstract void mostrarEstadisticas();
}
