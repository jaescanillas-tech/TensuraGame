package dev.game.modelo;

import java.util.List;

public class HabilidadMagica extends Habilidad {
    private double danoMagico;
    private double penetracionMagica;

    public HabilidadMagica(String nombre, String descripcion, CategoriaHabilidad categoria, double cooldown, int costeMagicura, List<String> elementos, List<String> efectos, int areaDeImpacto, double danoMagico, double penetracionMagica) {
        super(nombre, descripcion, categoria, cooldown, costeMagicura, elementos, efectos, areaDeImpacto);
        this.danoMagico = danoMagico;
        this.penetracionMagica = penetracionMagica;
    }

    public double getDanoMagico() {
        return danoMagico;
    }

    public void setDanoMagico(double danoMagico) {
        this.danoMagico = danoMagico;
    }

    public double getPenetracionMagica() {
        return penetracionMagica;
    }

    public void setPenetracionMagica(double penetracionMagica) {
        this.penetracionMagica = penetracionMagica;
    }

    @Override
    public void detallehabilidad() {
        System.out.println("=== Detalle de Habilidad Mágica ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Descripción: " + getDescripcion());
        System.out.println("Categoría: " + getCategoria());
        System.out.println("Cooldown: " + getCooldown() + " segundos");
        System.out.println("Coste de Magicura: " + getCosteMagicura());
        System.out.println("Daño Mágico: " + danoMagico);
        System.out.println("Elementos: " + getElementos());
        System.out.println("Efectos: " + getEfectos());
        System.out.println("Área de Impacto: " + getAreaDeImpacto());
        System.out.println("Penetración Mágica: " + penetracionMagica);
    }
}
