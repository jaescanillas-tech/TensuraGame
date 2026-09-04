package dev.game.modelo.criaturas;
import dev.game.modelo.habilities.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje{
    protected String nombre;
    protected double vida;
    protected int nivel;
    protected Razas raza;
    protected double ataqueFisico;
    protected double ataqueMagico;
    protected double ataqueElemental;
    protected int defensaFisica;
    protected int defensaMagica;
    protected int defensaElemental;
    protected int magicuraMaxima;
    protected int magicuraActual;
    protected List<Elementos> afinidad;  // Afinidad para los tipos de magia
    protected int estaminaMaxima;
    protected int estaminaActual;
    protected List<Habilidad> habilidades; // Lista de habilidades del personaje ( Posiblemente se pueda aumentar a mas )

    public Personaje(String nombre, Razas raza, int nivel) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        //Estadisticas del enum
        this.vida = raza.getVidaBase();
        this.estaminaMaxima = raza.getEstaminaBase();
        this.magicuraMaxima = raza.getMagicuraBase();
        this.ataqueFisico = raza.getAtcFisicoBase();
        this.ataqueMagico = raza.getAtcMagicoBase();
        this.defensaFisica = raza.getDefFisicaBase();
        this.defensaMagica = raza.getDefMagicaBase();

        this.magicuraActual = magicuraMaxima;
        this.estaminaActual = estaminaMaxima;

        this.defensaElemental = 0;
        this.ataqueElemental = 0.0;

        //listas
        this.afinidad = new ArrayList<>();
        this.habilidades = new ArrayList<>();
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

    public Razas getRaza() {
        return raza;
    }

    public double getAtaqueFisico() {
        return ataqueFisico;
    }

    public double getAtaqueMagico() {
        return ataqueMagico;
    }

    public double getAtaqueElemental() {
        return ataqueElemental;
    }

    public int getDefensaFisica() {
        return defensaFisica;
    }

    public int getDefensaMagica() {
        return defensaMagica;
    }

    public int getDefensaElemental() {
        return defensaElemental;
    }

    public int getMagicuraMaxima() {
        return magicuraMaxima;
    }

    public int getMagicuraActual() {
        return magicuraActual;
    }

    public List<Elementos> getAfinidad() {
        return afinidad;
    }

    public int getEstaminaMaxima() {
        return estaminaMaxima;
    }

    public int getEstaminaActual() {
        return estaminaActual;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void evolucionar(){

    }

    public abstract void mostrarEstadisticas();

    public void mostrarLibroHabilidades(){
        System.out.println("\n===== Libro de Habilidades de " + this.getNombre() + " =====");
        if (this.habilidades == null || this.habilidades.isEmpty()){
            System.out.println("   No Posee habilidades Registradas.");
            return;
        }

        for (int i = 0; i < this.habilidades.size(); i++) {
            System.out.println("habilidad #" + (i + 1) + ":");
            this.habilidades.get(i).DetallesHabilidad();
            System.out.println("--------------------------------------------------");
        }
    }
}
