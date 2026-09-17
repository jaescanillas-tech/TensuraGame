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

/**
 * Pantalla inicial de opciones.
 *
 * En esta base solo se muestra un mensaje. Aqui puedes agregar despues
 * volumen, pantalla completa, idioma, controles y calidad grafica.
 */
public class OptionsScreen extends ScreenAdapter {

    private final Main game;
    private SpriteBatch batch;
    private ShapeRenderer shapes;
    private BitmapFont font;
    private Texture background;
    private GameViewport gameViewport;

    public OptionsScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        shapes = new ShapeRenderer();
        font = new BitmapFont();
        background = new Texture(Gdx.files.internal(
            "imagenes/fondo/FondoTensuraGame.jpg"
        ));
        gameViewport = new GameViewport();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.04f, 0.06f, 0.12f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameViewport.apply(batch, shapes);

        batch.begin();
        batch.draw(background, 0, 0,
            GameViewport.WORLD_WIDTH, GameViewport.WORLD_HEIGHT);
        batch.end();

        shapes.begin(ShapeRenderer.ShapeType.Filled);
        shapes.setColor(0.04f, 0.07f, 0.15f, 0.94f);
        shapes.rect(300, 100, 680, 520);
        shapes.end();

        batch.begin();
        font.getData().setScale(2f);
        font.draw(batch, "OPCIONES", 530, 540);

        font.getData().setScale(1.2f);
        font.draw(batch, "Volumen: pendiente", 450, 430);
        font.draw(batch, "Pantalla completa: pendiente", 450, 370);
        font.draw(batch, "Controles: pendiente", 450, 310);
        font.draw(batch, "Presiona ESC para volver", 470, 180);
        batch.end();

        // ESC vuelve al titulo para seguir probando el flujo.
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new TitleScreen(game));
        }

        // Atajo de desarrollo: recarga esta pantalla despues de recompilar.
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            game.setScreen(new OptionsScreen(game));
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
        background.dispose();
    }
}
