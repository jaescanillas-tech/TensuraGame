package dev.game.gui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Configuracion visual compartida por todas las pantallas.
 *
 * El juego se diseña como si siempre midiera 1280x720.
 * FitViewport adapta esa resolucion a ventanas mas grandes o pequenas
 * sin deformar los elementos. Si la proporcion cambia, agrega barras
 * negras en lugar de estirar la imagen.
 */
public class GameViewport {

    public static final float WORLD_WIDTH = 1280f;
    public static final float WORLD_HEIGHT = 720f;

    private final OrthographicCamera camera;
    private final Viewport viewport;

    public GameViewport() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
    }

    public void resize(int width, int height) {
        if (width <= 0 || height <= 0) {
            return;
        }

        // true centra la camara cada vez que cambia el tamano de ventana.
        viewport.update(width, height, true);
    }

    public void apply(SpriteBatch batch, ShapeRenderer shapes) {
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        shapes.setProjectionMatrix(camera.combined);
    }

    public Vector2 screenToWorld(float screenX, float screenY) {
        Vector2 point = new Vector2(screenX, screenY);
        viewport.unproject(point);
        return point;
    }
}
