package dev.game.datos;
import dev.game.modelo.*;
import java.util.List;

public class CatalogoHabilidades {

    //Habilidades Fisicas
    public static final HabilidadFisica COMBO = new HabilidadFisica(
            "golpe puño", "Ataque con el puño", CategoriaHabilidad.Comun, 2.0, 0, List.of("Fisico"), List.of("Golpe"),
            1, 2.0, 5, 0.0, 0.0);
}
