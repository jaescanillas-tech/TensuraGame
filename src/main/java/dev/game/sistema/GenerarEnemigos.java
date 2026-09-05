package dev.game.sistema;

import dev.game.modelo.entidades.Enemigo;
import dev.game.modelo.enums.RangoEnemigos;
import dev.game.modelo.enums.Razas;

import java.util.Random;

public class GenerarEnemigos {
    private static final Random random = new Random();
    public static Enemigo spawnearEnemigo(Razas raza){
        double tirada = random.nextDouble();
        RangoEnemigos rango;

        if (tirada < 0.01){
            rango  = RangoEnemigos.LIDER;
        } else if (tirada < 0.05) {
            rango = RangoEnemigos.MUTADO;
        } else if (tirada < 0.09) {
            rango = RangoEnemigos.RARO;
        } else {
            rango = RangoEnemigos.COMUN;
        }

        String nombreCompleto = raza.name() + " ["+rango.getEtiqueta()+"]";
        return new Enemigo(nombreCompleto, raza, rango);
    }
}
