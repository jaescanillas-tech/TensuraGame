package dev.game.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PantallaTitulo extends JPanel {
    private final VentanaJuego ventana;
    private final String[] opciones = {
            "Comenzar Juego",
            "Pruebas combate",
            "Salir"
    };
    private int seleccionActual = 0;

    public PantallaTitulo(VentanaJuego ventana) {
        this.ventana = ventana;
        setBackground(new Color(10, 14, 22));
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                    seleccionActual = (seleccionActual - 1 + opciones.length) % opciones.length;
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                    seleccionActual = (seleccionActual + 1) % opciones.length;
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    ejecutarAccion(seleccionActual);
                }
            }
        });
    }
    private void ejecutarAccion(int indice) {
        switch (indice) {
            case 0 -> {
                // Cambia a la creación de personaje
                ventana.cambiarPantalla(new PantallaCreacionPersonaje(ventana));
            }
            case 1 -> JOptionPane.showMessageDialog(this,
                    "«Voz del Mundo: Accediendo al espacio de prueba de combate.»",
                    "Simulador", JOptionPane.INFORMATION_MESSAGE);
            case 2 -> System.exit(0);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();
        int centroX = ancho / 2;

        // 1. TÍTULO PRINCIPAL
        g2.setFont(new Font("Serif", Font.BOLD, 48));
        g2.setColor(new Color(220, 235, 255));
        String titulo = "TENSURA RPG";
        int anchoTitulo = g2.getFontMetrics().stringWidth(titulo);
        g2.drawString(titulo, centroX - (anchoTitulo / 2), 160);

        // 2. SUBTÍTULO
        g2.setFont(new Font("SansSerif", Font.ITALIC, 16));
        g2.setColor(new Color(110, 160, 230));
        String subtitulo = "~ Alpha version: primeras pruebas en ventana! ~";
        int anchoSub = g2.getFontMetrics().stringWidth(subtitulo);
        g2.drawString(subtitulo, centroX - (anchoSub / 2), 200);

        // 3. OPCIONES DEL MENÚ
        g2.setFont(new Font("SansSerif", Font.BOLD, 20));
        int inicioY = 300;
        int separacion = 45;

        for (int i = 0; i < opciones.length; i++) {
            if (i == seleccionActual) {
                // Opción seleccionada: color dorado con indicador
                g2.setColor(new Color(255, 215, 80));
                String textoOpcion = ">  " + opciones[i] + "  <";
                int anchoOpcion = g2.getFontMetrics().stringWidth(textoOpcion);
                g2.drawString(textoOpcion, centroX - (anchoOpcion / 2), inicioY + (i * separacion));
            } else {
                // Opciones inactivas: gris azulado
                g2.setColor(new Color(140, 155, 180));
                String textoOpcion = opciones[i];
                int anchoOpcion = g2.getFontMetrics().stringWidth(textoOpcion);
                g2.drawString(textoOpcion, centroX - (anchoOpcion / 2), inicioY + (i * separacion));
            }
        }

        // 4. PIE DE PÁGINA CON INSTRUCCIONES
        g2.setFont(new Font("Monospaced", Font.PLAIN, 12));
        g2.setColor(new Color(80, 95, 120));
        String ayuda = "[W / S / Flechas] Navegar   |   [ENTER] Confirmar";
        int anchoAyuda = g2.getFontMetrics().stringWidth(ayuda);
        g2.drawString(ayuda, centroX - (anchoAyuda / 2), alto - 35);
    }
}
