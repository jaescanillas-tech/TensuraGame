package dev.game.modelo.habilities;
import java.util.List;

public abstract class Habilidad {
    protected int id;
    protected String nombre;
    protected String descripcion;
    protected CategoriaHabilidad categoria;
    protected List<DiciplinaHabilidad> diciplinas;
    protected List<Elementos> elementos;
    protected List<EfectosEstado> efectos;
    protected int cooldown;
    protected int duracion;
    protected int rango;
    protected double costoVida;
    protected boolean requerimiento; // Si requiere un requisito breve

    public Habilidad(int id, String nombre, String descripcion, CategoriaHabilidad categoria, List<DiciplinaHabilidad> diciplinas, List<Elementos> elementos, List<EfectosEstado> efectos, int cooldown, int duracion, int rango, double costoVida, boolean requerimiento) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.diciplinas = diciplinas;
        this.elementos = elementos;
        this.efectos = efectos;
        this.cooldown = cooldown;
        this.duracion = duracion;
        this.rango = rango;
        this.costoVida = costoVida;
        this.requerimiento = requerimiento;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public CategoriaHabilidad getCategoria() {
        return categoria;
    }

    public List<DiciplinaHabilidad> getDiciplinas() {
        return diciplinas;
    }

    public List<Elementos> getElementos() {
        return elementos;
    }

    public List<EfectosEstado> getEfectos() {
        return efectos;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getRango() {
        return rango;
    }

    public double getCostoVida() {
        return costoVida;
    }

    public boolean isRequerimiento() {
        return requerimiento;
    }

    public String toString() {
        return "Habilidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria=" + categoria +
                ", diciplinas=" + diciplinas +
                ", elementos=" + elementos +
                ", efectos=" + efectos +
                ", cooldown=" + cooldown +
                ", duracion=" + duracion +
                ", rango=" + rango +
                ", costoVida=" + costoVida +
                ", requerimiento=" + requerimiento +
                '}';
    }

    public abstract void DetallesHabilidad();

}
