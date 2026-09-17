package dev.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import dev.game.Main;

/**
 * Pantalla de titulo.
 *
 * Esta version usa dibujos simples para probar el flujo sin necesitar
 * todavia un paquete de interfaz grafica. El estilo es de RPG tactico:
 * fondo ilustrado, panel oscuro y botones grandes.
 */
public class TitleScreen extends ScreenAdapter {

    private final Main game;
    private SpriteBatch batch;
    private ShapeRenderer shapes;
    private BitmapFont font;
    private BitmapFont smallFont;
    private Texture background;
    private GameViewport gameViewport;

    public TitleScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        shapes = new ShapeRenderer();
        font = new BitmapFont();
        smallFont = new BitmapFont();
        gameViewport = new GameViewport();

        // La ruta se busca dentro de la carpeta assets.
        // Para cambiar el fondo, modifica solamente el nombre del archivo.
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

        // Cambia estos valores para mover el panel o modificar su tamano.
        float panelWidth = 530f;
        float panelHeight = 530f;
        float panelX = (width - panelWidth) / 2f;
        float panelY = (height - panelHeight) / 2f;

        shapes.begin(ShapeRenderer.ShapeType.Filled);
        shapes.setColor(0.04f, 0.07f, 0.15f, 0.90f);
        shapes.rect(panelX, panelY, panelWidth, panelHeight);
        drawButton(panelX + 65, panelY + 280, 400, 65);
        drawButton(panelX + 65, panelY + 185, 400, 65);
        drawButton(panelX + 65, panelY + 90, 400, 65);
        shapes.end();

        batch.begin();

        // Cambia el texto, tamano y posicion del titulo aqui.
        font.getData().setScale(2.4f);
        font.draw(batch, "TENSURA GAME", panelX + 70, panelY + 465);
        smallFont.draw(batch, "Versión Alpha 1.2", panelX + 70, panelY + 435);

        font.getData().setScale(1.3f);
        font.draw(batch, "NUEVA PARTIDA", panelX + 160, panelY + 320);
        font.draw(batch, "OPCIONES", panelX + 190, panelY + 225);
        font.draw(batch, "SALIR", panelX + 215, panelY + 130);
        smallFont.draw(batch, "RPG de exploracion y combate tactico",
            panelX + 95, panelY + 55);
        batch.end();

        // Se lee el clic una sola vez para poder revisar los tres botones.
        boolean clicked = Gdx.input.justTouched();
        Vector2 mouse = null;
        if (clicked) {
            mouse = gameViewport.screenToWorld(
                Gdx.input.getX(), Gdx.input.getY()
            );
        }

        // ENTER funciona como atajo para Nueva partida.
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)
            || isInside(mouse, panelX + 65, panelY + 280, 400, 65)) {
            game.setScreen(new CharacterCreationScreen(game));
        }

        if (isInside(mouse, panelX + 65, panelY + 185, 400, 65)) {
            game.setScreen(new OptionsScreen(game));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)
            || isInside(mouse, panelX + 65, panelY + 90, 400, 65)) {
            Gdx.app.exit();
        }

        // Atajo de desarrollo: vuelve a crear esta pantalla para probar cambios.
        // Primero guarda y recompila el proyecto; luego presiona R.
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            game.setScreen(new TitleScreen(game));
        }
    }

    private void drawButton(float x, float y, float width, float height) {
        // Cambia este color para personalizar los botones.
        shapes.setColor(0.12f, 0.28f, 0.42f, 1f);
        shapes.rect(x, y, width, height);
    }

    private boolean isInside(Vector2 point, float x, float y,
                             float width, float height) {
        if (point == null) {
            return false;
        }

        return point.x >= x
            && point.x <= x + width
            && point.y >= y
            && point.y <= y + height;
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
