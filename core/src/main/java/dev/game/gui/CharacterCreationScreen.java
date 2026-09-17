package dev.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import dev.game.Main;
import dev.game.modelo.entidades.Jugador;
import dev.game.modelo.enums.Razas;

/**
 * Pantalla de creacion de personaje.
 *
 * Distribucion:
 * - Izquierda: vista animada del personaje seleccionado.
 * - Derecha: nombre, raza, genero, color, resumen y estadisticas.
 *
 * Controles temporales para probar:
 * - Flechas izquierda/derecha: cambiar raza.
 * - N: escribir nombre.
 * - G: cambiar genero. No aparece para Slime.
 * - C: cambiar color. La primera prueba usa colores de Slime.
 * - ENTER: crear personaje.
 * - R: recargar esta pantalla durante el desarrollo.
 *
 * Para crear los sprites de las otras razas, agrega sus rutas en
 * loadCharacterAnimation(). El modelo de datos todavia no tiene color,
 * genero ni habilidades de raza, por eso esta pantalla los guarda
 * temporalmente como datos de interfaz.
 */
public class CharacterCreationScreen extends ScreenAdapter {

    private final Main game;

    private SpriteBatch batch;
    private ShapeRenderer shapes;
    private BitmapFont font;
    private BitmapFont smallFont;
    private Texture background;
    private GameViewport gameViewport;

    private Texture characterSheet;
    private Animation<TextureRegion> characterAnimation;
    private float animationTime;

    private final Razas[] razasDisponibles = {
        Razas.Humano,
        Razas.Goblin,
        Razas.Orco,
        Razas.Elfo,
        Razas.Slime
    };

    private int razaSeleccionada = 0;
    private String nombre = "Aventurero";
    private String genero = "No definido";
    private int colorSeleccionado = 0;
    private boolean nameEditing;

    private final String[] coloresSlime = {
        "Azul", "Verde", "Rojo", "Violeta"
    };

    public CharacterCreationScreen(Main game) {
        this.game = game;
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

        // Permite escribir directamente dentro del campo de nombre.
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY,
                                     int pointer, int button) {
                Vector2 point = gameViewport.screenToWorld(screenX, screenY);
                nameEditing = isInside(point, 625, 535, 570, 40);
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                if (!nameEditing) {
                    return false;
                }

                // Acepta letras, numeros y espacios hasta 18 caracteres.
                if (Character.isLetterOrDigit(character)
                    || character == ' ') {
                    if (nombre.length() < 18) {
                        nombre += character;
                    }
                }
                return true;
            }

            @Override
            public boolean keyDown(int keycode) {
                if (!nameEditing) {
                    return false;
                }

                if (keycode == Input.Keys.BACKSPACE && !nombre.isEmpty()) {
                    nombre = nombre.substring(0, nombre.length() - 1);
                    return true;
                }

                if (keycode == Input.Keys.ENTER) {
                    nameEditing = false;
                    return true;
                }

                return false;
            }
        });

        loadCharacterAnimation();
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

        // Panel izquierdo: personaje y resumen corto.
        float characterPanelX = 40f;
        float characterPanelY = 55f;
        float characterPanelWidth = 510f;
        float characterPanelHeight = 610f;

        // Panel derecho: datos editables y estadisticas.
        float menuPanelX = 580f;
        float menuPanelY = 35f;
        float menuPanelWidth = 660f;
        float menuPanelHeight = 650f;

        shapes.begin(ShapeRenderer.ShapeType.Filled);
        drawPanel(characterPanelX, characterPanelY,
            characterPanelWidth, characterPanelHeight);
        drawPanel(menuPanelX, menuPanelY, menuPanelWidth, menuPanelHeight);
        shapes.end();

        animationTime += delta;

        batch.begin();
        drawCharacterPanel(characterPanelX, characterPanelY);
        drawMenuPanel(menuPanelX, menuPanelY);
        batch.end();

        updateInput(menuPanelX, menuPanelY);
    }

    private void drawPanel(float x, float y, float width, float height) {
        // Cambia este color para cambiar todos los paneles de esta pantalla.
        shapes.setColor(0.04f, 0.07f, 0.15f, 0.94f);
        shapes.rect(x, y, width, height);
    }

    private void drawCharacterPanel(float panelX, float panelY) {
        font.getData().setScale(1.7f);
        font.draw(batch, "VISTA DEL PERSONAJE", panelX + 70, panelY + 565);

        if (characterAnimation != null) {
            TextureRegion frame = characterAnimation.getKeyFrame(
                animationTime, true
            );

            // Cambia estas medidas para hacer el personaje mas grande o pequeno.
            batch.draw(frame, panelX + 105, panelY + 220, 300, 300);
        } else {
            smallFont.draw(batch, "Sprite pendiente para esta raza",
                panelX + 135, panelY + 365);
        }

        font.getData().setScale(1.4f);
        font.draw(batch, nombre, panelX + 205, panelY + 170);
        smallFont.draw(batch, "ENTER para crear el personaje",
            panelX + 150, panelY + 70);
    }

    private void drawMenuPanel(float panelX, float panelY) {
        Razas raza = razaActual();

        font.getData().setScale(1.7f);
        font.draw(batch, "CONFIGURACION", panelX + 190, panelY + 605);

        font.getData().setScale(1.2f);
        font.draw(batch, "Nombre: " + nombre, panelX + 45, panelY + 550);
        if (nameEditing) {
            smallFont.draw(batch, "Escribiendo... Enter para terminar",
                panelX + 45, panelY + 525);
        } else {
            smallFont.draw(batch, "Haz clic aqui para editar el nombre",
                panelX + 45, panelY + 525);
        }
        font.draw(batch, "Raza: " + raza, panelX + 45, panelY + 515);

        // Slime no muestra genero porque esa raza no lo necesita.
        if (raza == Razas.Slime) {
            font.draw(batch, "Genero: No aplica", panelX + 45, panelY + 480);
            font.draw(batch, "Color: " + coloresSlime[colorSeleccionado],
                panelX + 45, panelY + 445);
        } else {
            font.draw(batch, "Genero: " + genero, panelX + 45, panelY + 480);
            font.draw(batch, "Color: Predeterminado",
                panelX + 45, panelY + 445);
        }

        font.getData().setScale(1.25f);
        font.draw(batch, "RESUMEN DE LA RAZA", panelX + 45, panelY + 390);

        smallFont.draw(batch, raceDescription(raza), panelX + 45, panelY + 355);
        smallFont.draw(batch, "Vida inicial: " + raza.getVidaBase(),
            panelX + 45, panelY + 315);
        smallFont.draw(batch, "Magicura inicial: " + raza.getMagicuraBase(),
            panelX + 45, panelY + 290);
        smallFont.draw(batch, "Estamina inicial: " + raza.getEstaminaBase(),
            panelX + 45, panelY + 265);
        smallFont.draw(batch, "Dano general: " + generalDamage(raza),
            panelX + 45, panelY + 240);
        smallFont.draw(batch, "Defensa fisica: " + raza.getDefFisicaBase(),
            panelX + 45, panelY + 215);
        smallFont.draw(batch, "Defensa magica: " + raza.getDefMagicaBase(),
            panelX + 45, panelY + 190);

        font.getData().setScale(1.25f);
        font.draw(batch, "HABILIDADES DE RAZA", panelX + 350, panelY + 390);
        smallFont.draw(batch, "Pendiente de programar",
            panelX + 350, panelY + 350);
        smallFont.draw(batch, "Aqui apareceran las habilidades",
            panelX + 350, panelY + 325);
        smallFont.draw(batch, "exclusivas de cada raza.",
            panelX + 350, panelY + 300);

        font.getData().setScale(1.2f);
        font.draw(batch, "CREAR PERSONAJE", panelX + 210, panelY + 85);

        smallFont.draw(batch, "Clic en nombre | G: genero | C: color",
            panelX + 190, panelY + 45);
    }

    private void updateInput(float panelX, float panelY) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            razaSeleccionada--;
            if (razaSeleccionada < 0) {
                razaSeleccionada = razasDisponibles.length - 1;
            }
            loadCharacterAnimation();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            razaSeleccionada++;
            if (razaSeleccionada >= razasDisponibles.length) {
                razaSeleccionada = 0;
            }
            loadCharacterAnimation();
        }

        // Mientras se escribe, ENTER solo termina el campo y no crea.
        if (nameEditing) {
            return;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.G)
            && razaActual() != Razas.Slime) {
            genero = genero.equals("Masculino") ? "Femenino" : "Masculino";
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.C)
            && razaActual() == Razas.Slime) {
            colorSeleccionado++;
            if (colorSeleccionado >= coloresSlime.length) {
                colorSeleccionado = 0;
            }
        }

        boolean crearConTeclado = Gdx.input.isKeyJustPressed(Input.Keys.ENTER);
        boolean crearConMouse = false;

        if (Gdx.input.justTouched()) {
            Vector2 mouse = gameViewport.screenToWorld(
                Gdx.input.getX(), Gdx.input.getY()
            );

            crearConMouse = isInside(mouse, panelX + 150, panelY + 55, 360, 70);
        }

        if (crearConTeclado || crearConMouse) {
            // El modelo Jugador actualmente recibe nombre y raza.
            // Cuando agregues genero y color al modelo, pasalos aqui tambien.
            Jugador jugador = new Jugador(nombre, razaActual());
            game.setScreen(new WorldScreen(game, jugador));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            game.setScreen(new CharacterCreationScreen(game));
        }
    }

    private boolean isInside(Vector2 point, float x, float y,
                             float width, float height) {
        return point != null
            && point.x >= x
            && point.x <= x + width
            && point.y >= y
            && point.y <= y + height;
    }

    private Razas razaActual() {
        return razasDisponibles[razaSeleccionada];
    }

    private double generalDamage(Razas raza) {
        return raza.getAtcFisicoBase()
            + raza.getAtcMagicoBase();
    }

    private String raceDescription(Razas raza) {
        return switch (raza) {
            case Slime -> "Criatura adaptable, resistente y sin genero.";
            case Humano -> "Raza equilibrada, ideal para comenzar.";
            case Goblin -> "Raza agil con buenas capacidades fisicas.";
            case Orco -> "Raza fuerte con gran vida y defensa.";
            case Elfo -> "Raza con gran afinidad magica.";
            default -> "Descripcion de raza pendiente.";
        };
    }

    /**
     * Carga el spritesheet de la raza seleccionada.
     *
     * PRIMERA PRUEBA: Slime
     * Ruta actual:
     * assets/imagenes/fondo/Sprite/Slime/SlimeSprite.jpg
     *
     * La imagen actual no es una cuadrilla regular y es JPG, por eso se
     * recortan seis regiones manualmente usando porcentajes de la imagen.
     * El fondo de cuadros grises forma parte del JPG: para quitarlo,
     * convierte la imagen a PNG y deja transparente ese fondo.
     *
     * Para otros personajes:
     * 1. Agrega el spritesheet en assets.
     * 2. Agrega un case para su raza.
     * 3. Crea sus TextureRegion con las posiciones correctas.
     * 4. Si el spritesheet tiene cuadros iguales, puedes usar
     *    TextureRegion.split(texture, ancho, alto) en vez de recortes manuales.
     */
    private void loadCharacterAnimation() {
        if (characterSheet != null) {
            characterSheet.dispose();
            characterSheet = null;
        }

        characterAnimation = null;
        animationTime = 0f;

        if (razaActual() != Razas.Slime) {
            return;
        }

        String path = "imagenes/fondo/Sprite/Slime/SlimeSprite.jpg";
        if (!Gdx.files.internal(path).exists()) {
            return;
        }

        characterSheet = new Texture(Gdx.files.internal(path));
        int width = characterSheet.getWidth();
        int height = characterSheet.getHeight();

        TextureRegion[] frames = {
            region(0.03f, 0.30f, 0.16f, 0.40f, width, height),
            region(0.19f, 0.28f, 0.16f, 0.42f, width, height),
            region(0.36f, 0.25f, 0.18f, 0.50f, width, height),
            region(0.52f, 0.34f, 0.17f, 0.45f, width, height),
            region(0.69f, 0.30f, 0.16f, 0.43f, width, height),
            region(0.84f, 0.27f, 0.15f, 0.43f, width, height)
        };

        characterAnimation = new Animation<>(0.16f, frames);
    }

    private TextureRegion region(float xPercent, float yPercent,
                                 float widthPercent, float heightPercent,
                                 int imageWidth, int imageHeight) {
        int x = (int) (imageWidth * xPercent);
        int y = (int) (imageHeight * yPercent);
        int width = (int) (imageWidth * widthPercent);
        int height = (int) (imageHeight * heightPercent);

        return new TextureRegion(characterSheet, x, y, width, height);
    }

    @Override
    public void resize(int width, int height) {
        gameViewport.resize(width, height);
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        batch.dispose();
        shapes.dispose();
        font.dispose();
        smallFont.dispose();
        background.dispose();

        if (characterSheet != null) {
            characterSheet.dispose();
        }
    }
}
