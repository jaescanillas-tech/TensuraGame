package dev.game.modelo.habilities;

import dev.game.modelo.entidades.Personaje;
import dev.game.modelo.enums.CategoriaHabilidad;
import dev.game.modelo.enums.DiciplinaHabilidad;
import dev.game.modelo.enums.Elementos;

import java.util.ArrayList;

public class HabilidadFisica extends Habilidad{
    private double danoFisico;
    private double multiplicador;

    public HabilidadFisica(String nombre, CategoriaHabilidad tipo, Elementos elementos, DiciplinaHabilidad disciplina, int costeMagicura, int costeEstamina, String descripcion, double danoFisico, double multiplicador) {
        super(nombre, tipo, elementos, disciplina, costeMagicura, costeEstamina, descripcion);
        this.danoFisico = danoFisico;
        this.multiplicador = multiplicador;
    }

    public double getDanoFisico() {
        return danoFisico;
    }

    public double getMultiplicador() {
        return multiplicador;
    }

    @Override
    public void aplicarEfecto(Personaje atacante, Personaje objetivo){
        double danoBruto = atacante.getAtaqueFisico() * this.multiplicador;
        double danoFinal = Math.max(1.0, danoBruto - objetivo.getDefensaFisica());
        objetivo.recibirDano(danoFinal);
        System.out.println(atacante.getNombre() + " uso [" + this.nombre + "] e inflingio " + Math.round(danoFinal) + " de dano.");
    }

    @Override
    public void detallesHabilidad() {
        System.out.println("Detalles de la habilidad: " + this.nombre);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Elemento: " + this.elementos);
        System.out.println("Disciplina: " + this.disciplina);
        System.out.println("Coste de Magicura: " + this.costeMagicura);
        System.out.println("Coste de Estamina: " + this.costeEstamina);
        System.out.println("Descripción: " + this.descripcion);
        System.out.println("Daño Físico: " + this.danoFisico);
        System.out.println("Multiplicador: " + this.multiplicador);
    }
}
