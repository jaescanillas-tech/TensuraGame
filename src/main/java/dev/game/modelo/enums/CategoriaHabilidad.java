package dev.game.modelo.enums;

public enum CategoriaHabilidad {
    Comun(1),
    Extras(4),
    Resistencia(3),
    Intrinseca(2),
    Unica(5),
    Definitiva(6);

    private final int prioridad;
    CategoriaHabilidad(int p) {
        this.prioridad = p;
    }
    public int getPrioridad() { return prioridad; }


}
