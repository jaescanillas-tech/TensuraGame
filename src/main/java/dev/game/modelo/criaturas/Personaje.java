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
        this.magicuraActual = this.magicuraMaxima;
        this.estaminaActual = this.estaminaMaxima;
        this.ataqueFisico = 0.0;


        //Estadisticas del enum
        this.vida = raza.getVidaBase();
        this.estaminaMaxima = raza.getEstaminaBase();
        this.magicuraMaxima = raza.getMagicuraBase();
        this.ataqueFisico = raza.getAtcFisicoBase();
        this.ataqueMagico = raza.getAtcMagicoBase();
        this.defensaFisica = raza.getDefFisicaBase();
        this.defensaMagica = raza.getDefMagicaBase();

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

    public List<Razas> getRaza() {
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

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public abstract void mostrarEstadisticas();

}
