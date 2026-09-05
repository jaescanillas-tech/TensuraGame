package dev.game.gui;

import dev.game.modelo.entidades.Jugador;
import dev.game.modelo.enums.Razas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PantallaCreacionPersonaje extends JPanel {
    private final VentanaJuego ventana;
    private final Razas[] razasDisponibles = {Razas.Humano, Razas.Goblin};
    private int indiceRaza = 0;
    private final StringBuilder nombreInput = new StringBuilder("Rimuru");

    public PantallaCreacionPersonaje(VentanaJuego ventana) {
        this.ventana = ventana;
        setBackground(new Color(12, 16, 26));
        setFocusable(true);

        configurarTeclado();
    }

    private void configurarTeclado(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int codigo = e.getKeyCode();
                if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A) {
                    indiceRaza = (indiceRaza - 1 + razasDisponibles.length) % razasDisponibles.length;
                    repaint();
                } else if (codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D) {
                    indiceRaza = (indiceRaza + 1) % razasDisponibles.length;
                    repaint();
                }else if (codigo == KeyEvent.VK_BACK_SPACE) {
                    if (nombreInput.length() > 0) {
                        nombreInput.deleteCharAt(nombreInput.length() - 1);
                        repaint();
                    }
                }else if (codigo == KeyEvent.VK_ENTER) {
                    if (nombreInput.length() > 0) {
                        finalizarCreacion();
                    }
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Acepta letras, números y espacios hasta 16 caracteres
                if ((Character.isLetterOrDigit(c) || c == ' ') && nombreInput.length() < 16) {
                    nombreInput.append(c);
                    repaint();
                }
            }
        });
    }
    private void finalizarCreacion() {
        Razas razaElegida = razasDisponibles[indiceRaza];
        String nombreFinal = nombreInput.toString().trim();
        if (nombreFinal.isEmpty()) nombreFinal = "Reencarnado";

        // 1. Instanciar al jugador con la raza elegida
        Jugador nuevoJugador = new Jugador(nombreFinal, razaElegida);

        // 2. Transición directa a la pantalla de estadísticas
        ventana.cambiarPantalla(new PantallaFichaPersonaje(ventana, nuevoJugador));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centroX = getWidth() / 2;

        // 1. Título de la pantalla
        g2.setFont(new Font("Serif", Font.BOLD, 36));
        g2.setColor(new Color(220, 235, 255));
        String titulo = "RITUAL DE REENCARNACIÓN";
        g2.drawString(titulo, centroX - (g2.getFontMetrics().stringWidth(titulo) / 2), 70);

        // 2. Campo de texto: Nombre
        g2.setFont(new Font("SansSerif", Font.PLAIN, 16));
        g2.setColor(new Color(140, 160, 190));
        g2.drawString("Asigna un nombre a tu alma (escribe directamente):", centroX - 180, 120);

        g2.setColor(new Color(25, 35, 55));
        g2.fillRoundRect(centroX - 180, 135, 360, 40, 8, 8);
        g2.setColor(new Color(70, 100, 150));
        g2.drawRoundRect(centroX - 180, 135, 360, 40, 8, 8);

        g2.setFont(new Font("SansSerif", Font.BOLD, 18));
        g2.setColor(Color.WHITE);
        g2.drawString(nombreInput.toString() + " |", centroX - 165, 161);

        // 3. Selector de Raza
        Razas razaActual = razasDisponibles[indiceRaza];
        g2.setFont(new Font("SansSerif", Font.PLAIN, 15));
        g2.setColor(new Color(140, 160, 190));
        g2.drawString("Elige tu recipiente material:", centroX - 100, 220);

        g2.setFont(new Font("Serif", Font.BOLD, 28));
        g2.setColor(new Color(255, 215, 80));
        String textoRaza = "<   " + razaActual.name() + "   >";
        g2.drawString(textoRaza, centroX - (g2.getFontMetrics().stringWidth(textoRaza) / 2), 260);

        // 4. Tarjeta informativa de la Raza seleccionada
        int panelInfoX = centroX - 220;
        int panelInfoY = 290;
        g2.setColor(new Color(18, 25, 40));
        g2.fillRoundRect(panelInfoX, panelInfoY, 440, 150, 10, 10);
        g2.setColor(new Color(50, 75, 115));
        g2.drawRoundRect(panelInfoX, panelInfoY, 440, 150, 10, 10);

        dibujarDetallesRaza(g2, razaActual, panelInfoX + 25, panelInfoY + 35);

        // 5. Controles inferiores
        g2.setFont(new Font("Monospaced", Font.PLAIN, 12));
        g2.setColor(new Color(90, 110, 140));
        String ayuda = "[A / D / Flechas] Cambiar Raza   |   [ENTER] Confirmar Reencarnación";
        g2.drawString(ayuda, centroX - (g2.getFontMetrics().stringWidth(ayuda) / 2), getHeight() - 30);
    }

    private void dibujarDetallesRaza(Graphics2D g2, Razas raza, int x, int y) {
        g2.setFont(new Font("SansSerif", Font.BOLD, 14));
        g2.setColor(new Color(100, 200, 255));
        switch (raza) {
            case Humano -> {
                g2.drawString("Atributos: Estadísticas equilibradas | Gran adaptabilidad", x, y);
                g2.setFont(new Font("SansSerif", Font.PLAIN, 13));
                g2.setColor(new Color(200, 215, 230));
                g2.drawString("• Habilidad Intrínseca: Manejo de Armas Comunes", x, y + 25);
                g2.drawString("• Ventaja: Capacidad de aprender técnicas variadas rápido.", x, y + 50);
                g2.drawString("• Desventaja: Fragilidad ante ataques mágicos pesados.", x, y + 75);
            }
            case Goblin -> {
                g2.drawString("Atributos: Gran agilidad | Instinto de supervivencia", x, y);
                g2.setFont(new Font("SansSerif", Font.PLAIN, 13));
                g2.setColor(new Color(200, 215, 230));
                g2.drawString("• Habilidad Intrínseca: Evasión Rápida", x, y + 25);
                g2.drawString("• Ventaja: Mayor probabilidad de botín y evasión.", x, y + 50);
                g2.drawString("• Desventaja: Contenedor de vida bajo.", x, y + 75);
            }
        }
    }
}
