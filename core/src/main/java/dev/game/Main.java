package dev.game;

import com.badlogic.gdx.Game;
import dev.game.gui.CharacterCreationScreen;
import dev.game.gui.TitleScreen;

public class Main extends Game {
    @Override
    public void create() {
        // Esta es la primera pantalla que se muestra al abrir el juego.
        // Para cambiar la pantalla inicial, reemplaza TitleScreen por otra clase.
        setScreen(new CharacterCreationScreen(this));
    }
}
