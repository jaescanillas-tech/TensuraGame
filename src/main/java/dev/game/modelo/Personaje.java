package dev.game.modelo;
import java.util.List;

public abstract class Personaje{
    private String nombre;
    private double vida;
    private int nivel;
    private double ataqueFisico;
    private double defensaFisica;
    private double AtaqueMagico;
    private double defensaMagica;
    private int magicuraMaxima;
    private int magicuraActualues;
    private String evolucion;
    private List<String> afinidad;
    private int estaminaMaxima;
    private int estaminaActual;
    private List<Habilidad> habilidades;

    public Personaje(String nombre, double vida, int nivel, double ataqueFisico, double defensaFisica, double ataqueMagico, double defensaMagica, int magicuraMaxima, int magicuraActualues, String evolucion, List<String> afinidad, int estaminaMaxima, int estaminaActual) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivel = nivel;
        this.ataqueFisico = ataqueFisico;
        this.defensaFisica = defensaFisica;
        this.AtaqueMagico = ataqueMagico;
        this.defensaMagica = defensaMagica;
        this.magicuraMaxima = magicuraMaxima;
        this.magicuraActualues = magicuraActualues;
        this.evolucion = evolucion;
        this.afinidad = afinidad;
        this.estaminaMaxima = estaminaMaxima;
        this.estaminaActual = estaminaActual;
    }

    public int getEstaminaMaxima() {
        return estaminaMaxima;
    }

    public void setEstaminaMaxima(int estaminaMaxima) {
        this.estaminaMaxima = estaminaMaxima;
    }

    public int getEstaminaActual() {
        return estaminaActual;
    }

    public void setEstaminaActual(int estaminaActual) {
        this.estaminaActual = estaminaActual;
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

    public double getAtaqueFisico() {
        return ataqueFisico;
    }

    public void setAtaqueFisico(double ataqueFisico) {
        this.ataqueFisico = ataqueFisico;
    }

    public double getDefensaFisica() {
        return defensaFisica;
    }

    public void setDefensaFisica(double defensaFisica) {
        this.defensaFisica = defensaFisica;
    }

    public double getAtaqueMagico() {
        return AtaqueMagico;
    }

    public void setAtaqueMagico(double ataqueMagico) {
        AtaqueMagico = ataqueMagico;
    }

    public double getDefensaMagica() {
        return defensaMagica;
    }

    public void setDefensaMagica(double defensaMagica) {
        this.defensaMagica = defensaMagica;
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

    public String getEvolucion() {
        return evolucion;
    }

    public void setEvolucion(String evolucion) {
        this.evolucion = evolucion;
    }

    public List<String> getAfinidad() {
        return afinidad;
    }

    public void setAfinidad(List<String> afinidad) {
        this.afinidad = afinidad;
    }

    public abstract void mostrarEstadisticas();
}
