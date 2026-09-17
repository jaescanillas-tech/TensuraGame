package dev.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dev.game.Main;
import dev.game.modelo.entidades.Jugador;

/**
 * Primera pantalla del mundo general.
 *
 * El Jugador recibido ya fue creado. Aqui podras agregar despues mapa,
 * personaje, NPC, inventario, combate y misiones.
 */
public class WorldScreen extends ScreenAdapter {

    private final Main game;
    private final Jugador jugador;

    private SpriteBatch batch;
    private ShapeRenderer shapes;
    private BitmapFont font;
    private BitmapFont smallFont;
    private Texture background;
    private GameViewport gameViewport;

    public WorldScreen(Main game, Jugador jugador) {
        this.game = game;
        this.jugador = jugador;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        shapes = new ShapeRenderer();
        font = new BitmapFont();
        smallFont = new BitmapFont();
        gameViewport = new GameViewport();
        background = new Texture(Gdx.files.internal(
            "imagenes/fondo/FondoTensuraGame.jpg"
        ));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.04f, 0.06f, 0.12f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameViewport.apply(batch, shapes);

        float width = GameViewport.WORLD_WIDTH;
        float height = GameViewport.WORLD_HEIGHT;

        batch.begin();
        batch.draw(background, 0, 0, width, height);
        batch.end();

        // Panel informativo temporal: despues puede ser el HUD del juego.
        shapes.begin(ShapeRenderer.ShapeType.Filled);
        shapes.setColor(0.04f, 0.07f, 0.15f, 0.92f);
        shapes.rect(25, height - 190, 330, 160);
        shapes.end();

        batch.begin();
        font.getData().setScale(1.5f);
        font.draw(batch, "MUNDO GENERAL", 50, height - 65);

        smallFont.draw(batch, "Nombre: " + jugador.getNombre(),
            50, height - 100);
        smallFont.draw(batch, "Raza: " + jugador.getRaza(),
            50, height - 125);
        smallFont.draw(batch, "Vida: " + jugador.getVidaActual()
            + " / " + jugador.getVidaMax(), 50, height - 150);
        smallFont.draw(batch, "Habilidades: "
            + jugador.getHabilidades().size(), 50, height - 175);

        smallFont.draw(batch, "El personaje ya fue creado y esta listo.",
            width / 2f - 120, height / 2f);
        smallFont.draw(batch, "ESC: cerrar el juego", 50, 35);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        // Atajo de desarrollo: recarga esta pantalla despues de recompilar.
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            game.setScreen(new WorldScreen(game, jugador));
        }
    }

    @Override
    public void resize(int width, int height) {
        gameViewport.resize(width, height);
    }

    @Override
    public void dispose() {
        batch.dispose();
        shapes.dispose();
        font.dispose();
        smallFont.dispose();
        background.dispose();
    }
}
