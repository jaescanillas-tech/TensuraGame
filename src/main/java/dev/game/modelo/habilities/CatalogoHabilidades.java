package dev.game.modelo.habilities;

import dev.game.modelo.entidades.Personaje;
import dev.game.modelo.enums.CategoriaHabilidad;
import dev.game.modelo.enums.DiciplinaHabilidad;
import dev.game.modelo.enums.Elementos;

public class CatalogoHabilidades {
    public static final Habilidad GOLPE_COMUN = new HabilidadFisica(
            "Golpe comun",
            CategoriaHabilidad.Comun,
            Elementos.Ninguno,
            DiciplinaHabilidad.Artes,
            0, 10,
            "Golpea con tu fuerza base",
            10, 1.0);
    public static final Habilidad GOLPE_FUERTE = new HabilidadFisica(
            "Golpe Fuerte",
            CategoriaHabilidad.Comun,
            Elementos.Ninguno,
            DiciplinaHabilidad.Artes,
            0, 20,
            "Golpea con toda tu fuerza!",
            15, 1.2);
    public static final Habilidad GOLPE_RAPIDO = new HabilidadFisica(
            "Golpe Rapido",
            CategoriaHabilidad.Comun,
            Elementos.Ninguno,
            DiciplinaHabilidad.Artes,
            0, 15,
            "Golpea con rapidez a cambio de la fuerza",
            10, 0.8);
}
