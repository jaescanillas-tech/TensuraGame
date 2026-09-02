package dev.game.datos;
import dev.game.modelo.habilities.*;
import java.util.HashMap;
import java.util.List;

public class CatalogoHabilidades {
    private static final HashMap<Integer, Habilidad> Repositorio = new HashMap<>();
    //Habilidades id 100 para arriba
    public static final HabilidadFisica GOLPE = registrar(new HabilidadFisica(
            100,
            "Golpe",
            "Un golpe con el puño o un arma simple",
            CategoriaHabilidad.Comun,
            List.of(DiciplinaHabilidad.Artes),
            List.of(Elementos.Ninguno),
            List.of(EfectosEstado.Ninguno),
            1,
            0,
            1,
            0,
            false,
            10.0,
            5
    ));
    public static final HabilidadMagica FIRE_BALL = registrar(new HabilidadMagica(
            101,
            "Bola de Fuego",
            "Lanza una bola de fuego que explota al impactar",
            CategoriaHabilidad.Comun,
            List.of(DiciplinaHabilidad.MagiaElemental),
            List.of(Elementos.Fuego),
            List.of(EfectosEstado.Quemadura),
            3,
            0,
            1,
            0,
            true,
            20,
            10
    ));

    private static <T extends Habilidad> T registrar(T habilidad) {
        Repositorio.put(habilidad.getId(), habilidad);
        return habilidad;
    }
    public static Habilidad obtenerHabilidad(int id) {
        return Repositorio.get(id);
    }
}
