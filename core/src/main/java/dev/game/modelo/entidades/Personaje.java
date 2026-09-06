package dev.game.modelo.entidades;
import dev.game.modelo.enums.Elementos;
import dev.game.modelo.enums.Razas;
import dev.game.modelo.habilities.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje{
    protected String nombre;
    protected double vidaMax;
    protected double vidaActual;
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

    public Personaje(String nombre, Razas raza) {
        //Stats obligatorias
        this.nombre = nombre;
        this.raza = raza;
        //Estadisticas del enum, stats base
        this.vidaMax = raza.getVidaBase();
        this.estaminaMaxima = raza.getEstaminaBase();
        this.magicuraMaxima = raza.getMagicuraBase();
        this.ataqueFisico = raza.getAtcFisicoBase();
        this.ataqueMagico = raza.getAtcMagicoBase();
        this.defensaFisica = raza.getDefFisicaBase();
        this.defensaMagica = raza.getDefMagicaBase();
        //stats cambiables
        this.vidaActual = vidaMax;
        this.magicuraActual = magicuraMaxima;
        this.estaminaActual = estaminaMaxima;
        //stats elemental modificable de acuerdo a la raza
        this.defensaElemental = 0;
        this.ataqueElemental = 0.0;

        //listas
        this.afinidad = new ArrayList<>();
        this.habilidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public double getVidaActual() {
        return vidaActual;
    }

    public double getVidaMax() {
        return vidaMax;
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

    public void habilidadInicial(){
        this.habilidades.add(CatalogoHabilidades.GOLPE_COMUN);
        this.habilidades.add(CatalogoHabilidades.GOLPE_FUERTE);
        this.habilidades.add(CatalogoHabilidades.GOLPE_RAPIDO);
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
            this.habilidades.get(i).detallesHabilidad();
            System.out.println("--------------------------------------------------");
        }
    }

    public void aprenderHabilidad(Habilidad habilidad){
        if (habilidad == null){
            System.out.println("No se puede aprender una habilidad nula.");
            return;
        }
        if (this.habilidades.contains(habilidad)){
            System.out.println("Ya conoces la habilidad: " + habilidad.getNombre());
            return;
        }
        this.habilidades.add(habilidad);
        System.out.println("Has aprendido la habilidad: " + habilidad.getNombre());
    }

    public void consumirMagicura(int costeMagicura) {
    }

    public void consumirEstamina(int costeEstamina) {
    }

    public void recibirDano(double danoFinal) {
    }
}
