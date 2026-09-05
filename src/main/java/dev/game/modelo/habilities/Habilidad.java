package dev.game.modelo.habilities;
import dev.game.modelo.entidades.Personaje;
import dev.game.modelo.enums.CategoriaHabilidad;
import dev.game.modelo.enums.Elementos;

public abstract class Habilidad {
    protected String nombre;
    protected CategoriaHabilidad tipo;
    protected Elementos elementos;
    protected int costeMagicura;
    protected int costeEstamina;
    protected String descripcion;

    public Habilidad(String nombre, CategoriaHabilidad tipo, Elementos elementos, int consteMagicura, int costeEstamina, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.elementos = elementos;
        this.costeMagicura = consteMagicura;
        this.costeEstamina = costeEstamina;
        this.descripcion = descripcion;
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

    public boolean ejecutar(Personaje usuario, Personaje objetivo){
        if (usuario.getMagicuraActual() < this.costeMagicura) {
            System.out.println(usuario.getNombre() + " no posee suficientes magicuras para activar la habilidad: ["+ this.nombre + "]");
            return false;
        }
        if (usuario.getEstaminaActual() < this.costeEstamina) {
            System.out.println(usuario.getNombre() + " no posee suficientes estaminas para activar la habilidad: ["+ this.nombre + "]");
            return false;
        }
        usuario.consumirMagicura(this.costeMagicura);
        usuario.consumirEstamina(this.costeEstamina);
        System.out.println(usuario.getNombre() + " activa [" + this.nombre + "] (" + this.tipo + ")!");
        if (esAnuladoPorDefensa(objetivo)) {
            System.out.println("«Voz del Mundo: La técnica fue completamente anulada por la barrera existencial de " + objetivo.getNombre() + ".»");
            return true;
        }
        aplicarEfecto(usuario, objetivo);
        return true;
    }
    protected boolean esAnuladoPorDefensa(Personaje objetivo) {
        if (objetivo.poseeHabilidadTipo(TipoHabilidad.DEFINITIVA) && this.tipo.getPrioridad() < TipoHabilidad.DEFINITIVA.getPrioridad()) {
            return true;
        }
        if (this.elemento != null && objetivo.esInmuneAElemento(this.elemento)) {
            return true;
        }
        return false;
    }

    protected abstract void aplicarEfecto(Personaje usuario, Personaje objetivo);
}
