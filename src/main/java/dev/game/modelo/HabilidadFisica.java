package dev.game.modelo;

import java.util.List;

public class HabilidadFisica extends Habilidad {
    private double danoFisico;
    private int costeEstamina;
    private double penetracionFisica;

    public HabilidadFisica(String nombre, String descripcion, CategoriaHabilidad categoria, double cooldown, int costeMagicura, List<String> elementos, List<String> efectos, int areaDeImpacto, double danoFisico, int costeEstamina, double penetracionFisica) {
        super(nombre, descripcion, categoria, cooldown, costeMagicura, elementos, efectos, areaDeImpacto);
        this.danoFisico = danoFisico;
        this.costeEstamina = costeEstamina;
        this.penetracionFisica = penetracionFisica;
    }

    public double getPenetracionFisica() {
        return penetracionFisica;
    }

    public void setPenetracionFisica(double penetracionFisica) {
        this.penetracionFisica = penetracionFisica;
    }

    public double getDanoFisico() {
        return danoFisico;
    }

    public void setDanoFisico(double danoFisico) {
        this.danoFisico = danoFisico;
    }

    public int getCosteEstamina() {
        return costeEstamina;
    }

    public void setCosteEstamina(int costeEstamina) {
        this.costeEstamina = costeEstamina;
    }

    @Override
    public void detallehabilidad() {
        System.out.println("=== Detalle de Habilidad Física ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Descripción: " + getDescripcion());
        System.out.println("Categoría: " + getCategoria());
        System.out.println("Cooldown: " + getCooldown() + " segundos");
        System.out.println("Coste de Magicura: " + getCosteMagicura());
        System.out.println("Daño Físico: " + danoFisico);
        System.out.println("Coste de Estamina: " + costeEstamina);
        System.out.println("Elementos: " + getElementos());
        System.out.println("Efectos: " + getEfectos());
        System.out.println("Área de Impacto: " + getAreaDeImpacto());
        System.out.println("Penetración Física: " + penetracionFisica);
    }
}
