package dev.game.gui;
import dev.game.modelo.entidades.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PantallaFichaPersonaje extends JPanel{
    private final VentanaJuego ventana;
    private final Jugador jugador;

    public PantallaFichaPersonaje(VentanaJuego ventana, Jugador jugador) {
        this.ventana = ventana;
        this.jugador = jugador;
        setBackground(new Color(10, 14, 24));
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    // Vuelve a la pantalla de título por ahora
                    ventana.cambiarPantalla(new PantallaTitulo(ventana));
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();
        int centroX = ancho / 2;

        // 1. Título superior
        g2.setFont(new Font("Serif", Font.BOLD, 32));
        g2.setColor(new Color(230, 240, 255));
        String titulo = "ESTADO DEL REENCARNADO";
        g2.drawString(titulo, centroX - (g2.getFontMetrics().stringWidth(titulo) / 2), 65);

        // 2. Marco contenedor central
        int anchoPanel = 520;
        int altoPanel = 360;
        int xPanel = centroX - (anchoPanel / 2);
        int yPanel = 95;

        g2.setColor(new Color(18, 25, 42));
        g2.fillRoundRect(xPanel, yPanel, anchoPanel, altoPanel, 12, 12);
        g2.setColor(new Color(60, 95, 150));
        g2.drawRoundRect(xPanel, yPanel, anchoPanel, altoPanel, 12, 12);

        // 3. Encabezado de identidad
        g2.setFont(new Font("SansSerif", Font.BOLD, 22));
        g2.setColor(new Color(255, 215, 80));
        g2.drawString(jugador.getNombre(), xPanel + 30, yPanel + 45);

        g2.setFont(new Font("SansSerif", Font.ITALIC, 15));
        g2.setColor(new Color(120, 180, 255));
        g2.drawString("Raza: " + jugador.getRaza().name(), xPanel + 30, yPanel + 70);

        // Línea divisoria horizontal
        g2.setColor(new Color(40, 60, 95));
        g2.drawLine(xPanel + 30, yPanel + 85, xPanel + anchoPanel - 30, yPanel + 85);

        // 4. Lista de Atributos / Stats
        int inicioStatsY = yPanel + 120;
        int saltoLinea = 32;

        g2.setFont(new Font("SansSerif", Font.BOLD, 15));

        dibujarStat(g2, "Vitalidad (HP Máximo):", String.valueOf(Math.round(jugador.getVidaMax())), xPanel + 40, inicioStatsY, new Color(240, 100, 100));
        dibujarStat(g2, "Ataque Físico:", String.valueOf(Math.round(jugador.getAtaqueFisico())), xPanel + 40, inicioStatsY + saltoLinea, new Color(255, 160, 80));
        dibujarStat(g2, "Defensa Física:", String.valueOf(Math.round(jugador.getDefensaFisica())), xPanel + 40, inicioStatsY + (saltoLinea * 2), new Color(100, 180, 255));
        dibujarStat(g2, "Suerte:", String.valueOf(jugador.getSuerte()), xPanel + 40, inicioStatsY + (saltoLinea * 3), new Color(130, 235, 130));

        // 5. Nota / Instrucción al pie
        g2.setFont(new Font("Monospaced", Font.PLAIN, 12));
        g2.setColor(new Color(120, 140, 170));
        String ayuda = "[ENTER / ESC] Volver al Menú Principal";
        g2.drawString(ayuda, centroX - (g2.getFontMetrics().stringWidth(ayuda) / 2), alto - 25);
    }

    private void dibujarStat(Graphics2D g2, String etiqueta, String valor, int x, int y, Color colorValor) {
        g2.setColor(new Color(200, 210, 225));
        g2.drawString(etiqueta, x, y);

        g2.setColor(colorValor);
        g2.drawString(valor, x + 280, y);
    }

}
