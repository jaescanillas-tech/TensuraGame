package dev.game.modelo;

import java.util.List;

public abstract class Habilidad {
    private String nombre;
    private String descripcion;
    private CategoriaHabilidad categoria;
    private double cooldown;
    private int costeMagicura;
    private List<String> elementos;
    private List<String> efectos;
    private int areaDeImpacto;

    public Habilidad(String nombre, String descripcion, CategoriaHabilidad categoria, double cooldown, int costeMagicura, List<String> elementos, List<String> efectos, int areaDeImpacto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.cooldown = cooldown;
        this.costeMagicura = costeMagicura;
        this.elementos = elementos;
        this.efectos = efectos;
        this.areaDeImpacto = areaDeImpacto;
    }

    public List<String> getEfectos() {
        return efectos;
    }

    public void setEfectos(List<String> efectos) {
        this.efectos = efectos;
    }

    public int getAreaDeImpacto() {
        return areaDeImpacto;
    }

    public void setAreaDeImpacto(int areaDeImpacto) {
        this.areaDeImpacto = areaDeImpacto;
    }

    public List<String> getElementos() {
        return elementos;
    }

    public void setElementos(List<String> elementos) {
        this.elementos = elementos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaHabilidad getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaHabilidad categoria) {
        this.categoria = categoria;
    }

    public double getCooldown() {
        return cooldown;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    public int getCosteMagicura() {
        return costeMagicura;
    }

    public void setCosteMagicura(int costeMagicura) {
        this.costeMagicura = costeMagicura;
    }

    public abstract void detallehabilidad();

}
