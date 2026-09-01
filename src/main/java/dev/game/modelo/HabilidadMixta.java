package dev.game.modelo;

import java.util.List;

public class HabilidadMixta extends Habilidad{
    private double danoFisico;
    private double danoMagico;
    private double penetracionFisica;
    private double penetracionMagica;
    private int costeEstamina;

    public HabilidadMixta(String nombre, String descripcion, CategoriaHabilidad categoria, double cooldown, int costeMagicura, List<String> elementos, List<String> efectos, int areaDeImpacto, double danoFisico, double danoMagico, double penetracionFisica, double penetracionMagica, int costeEstamina) {
        super(nombre, descripcion, categoria, cooldown, costeMagicura, elementos, efectos, areaDeImpacto);
        this.danoFisico = danoFisico;
        this.danoMagico = danoMagico;
        this.penetracionFisica = penetracionFisica;
        this.penetracionMagica = penetracionMagica;
        this.costeEstamina = costeEstamina;
    }

    public double getDanoFisico() {
        return danoFisico;
    }

    public void setDanoFisico(double danoFisico) {
        this.danoFisico = danoFisico;
    }

    public double getDanoMagico() {
        return danoMagico;
    }

    public void setDanoMagico(double danoMagico) {
        this.danoMagico = danoMagico;
    }

    public double getPenetracionFisica() {
        return penetracionFisica;
    }

    public void setPenetracionFisica(double penetracionFisica) {
        this.penetracionFisica = penetracionFisica;
    }

    public double getPenetracionMagica() {
        return penetracionMagica;
    }

    public void setPenetracionMagica(double penetracionMagica) {
        this.penetracionMagica = penetracionMagica;
    }

    public int getCosteEstamina() {
        return costeEstamina;
    }

    public void setCosteEstamina(int costeEstamina) {
        this.costeEstamina = costeEstamina;
    }

    @Override
    public void detallehabilidad() {
        System.out.println("=== Detalle de Habilidad Mixta ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Descripción: " + getDescripcion());
        System.out.println("Categoría: " + getCategoria());
        System.out.println("Cooldown: " + getCooldown() + " segundos");
        System.out.println("Coste de Magicura: " + getCosteMagicura());
        System.out.println("Daño Físico: " + danoFisico);
        System.out.println("Daño Mágico: " + danoMagico);
        System.out.println("Coste de Estamina: " + costeEstamina);
        System.out.println("Elementos: " + getElementos());
        System.out.println("Efectos: " + getEfectos());
        System.out.println("Área de Impacto: " + getAreaDeImpacto());
        System.out.println("Penetración Física: " + penetracionFisica);
        System.out.println("Penetración Mágica: " + penetracionMagica);
    }

}
