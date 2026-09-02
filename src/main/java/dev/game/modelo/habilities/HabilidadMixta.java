package dev.game.modelo.habilities;

import java.util.List;

public class HabilidadMixta extends Habilidad{
    private double atcMagico;
    private int costeMagicura;
    private double atcFisico;
    private int costeEnergia;

    public HabilidadMixta(int id, String nombre, String descripcion, CategoriaHabilidad categoria, List<DiciplinaHabilidad> diciplinas, List<Elementos> elementos, List<EfectosEstado> efectos, int cooldown, int duracion, int rango, double costoVida, boolean requerimiento, double atcMagico, int costeMagicura, double atcFisico, int costeEnergia) {
        super(id, nombre, descripcion, categoria, diciplinas, elementos, efectos, cooldown, duracion, rango, costoVida, requerimiento);
        this.atcMagico = atcMagico;
        this.costeMagicura = costeMagicura;
        this.atcFisico = atcFisico;
        this.costeEnergia = costeEnergia;
    }

    public double getAtcMagico() {
        return atcMagico;
    }

    public int getCosteMagicura() {
        return costeMagicura;
    }

    public double getAtcFisico() {
        return atcFisico;
    }

    public int getCosteEnergia() {
        return costeEnergia;
    }

    @Override
    public void DetallesHabilidad() {
        System.out.println("=== Detalles de la Habilidad Mixta ===");
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Descripción: " + this.descripcion);
        System.out.println("Categoría: " + this.categoria);
        System.out.println("Disciplinas: " + this.diciplinas);
        System.out.println("Ataque Mágico: " + this.atcMagico);
        System.out.println("Coste de Magicura: " + this.costeMagicura);
        System.out.println("Ataque Físico: " + this.atcFisico);
        System.out.println("Coste de Energía: " + this.costeEnergia);
        if (!this.elementos.isEmpty() && !this.elementos.contains(Elementos.Ninguno)) {
            System.out.println("Elementos: " + this.elementos);
        }
        if (!this.efectos.isEmpty() && !this.efectos.contains(EfectosEstado.Ninguno)) {
            System.out.println("Efectos de Estado: " + this.efectos);
        }
        System.out.println("Cooldown: " + this.cooldown);
        System.out.println("Duración: " + this.duracion);
        System.out.println("Rango: " + this.rango);
        if  (this.costoVida > 0) {
            System.out.println("Costo de Vida: " + this.costoVida);
        }
        if  (this.requerimiento) {
            System.out.println("Requiere un requisito breve.");
        }
    }
}
