package dev.game.modelo.habilities;
import dev.game.modelo.entidades.Personaje;
import dev.game.modelo.enums.CategoriaHabilidad;
import dev.game.modelo.enums.DiciplinaHabilidad;
import dev.game.modelo.enums.EfectosEstado;
import dev.game.modelo.enums.Elementos;

import java.util.ArrayList;
import java.util.List;

public abstract class Habilidad {
    protected String nombre;
    protected CategoriaHabilidad tipo;
    protected Elementos elementos;
    protected DiciplinaHabilidad disciplina;
    protected int costeMagicura;
    protected int costeEstamina;
    protected String descripcion;
    protected List<EfectosEstado> efectosEstados;

    public Habilidad(String nombre, CategoriaHabilidad tipo, Elementos elementos, DiciplinaHabilidad disciplina, int costeMagicura, int costeEstamina, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.elementos = elementos;
        this.disciplina = disciplina;
        this.costeMagicura = costeMagicura;
        this.costeEstamina = costeEstamina;
        this.descripcion = descripcion;
        this.efectosEstados = new ArrayList<>();
    }

    public DiciplinaHabilidad getDisciplina() {
        return disciplina;
    }

    public String getNombre() {
        return nombre;
    }

    public CategoriaHabilidad getTipo() {
        return tipo;
    }

    public Elementos getElementos() {
        return elementos;
    }

    public int getCosteMagicura() {
        return costeMagicura;
    }

    public int getCosteEstamina() {
        return costeEstamina;
    }

    public String getDescripcion() {
        return descripcion;
    }

   public void ejecutar(Personaje usuario, Personaje objetivo) {

   }

   public abstract void detallesHabilidad();

    public abstract void aplicarEfecto(Personaje atacante, Personaje objetivo);
}
