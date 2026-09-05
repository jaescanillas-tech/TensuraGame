package dev.game.gui;

import javax.swing.*;

public class VentanaJuego extends JFrame{
    public VentanaJuego() {
        super("That Time I Got Reincarnated as a Slime - RPG");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 560);
        setLocationRelativeTo(null); // Centra la ventana en el monitor
        setResizable(false);

        // Cargamos la pantalla de título
        PantallaTitulo pantallaTitulo = new PantallaTitulo(this);
        setContentPane(pantallaTitulo);
    }

    public void cambiarPantalla(JPanel nuevoPanel) {
        setContentPane(nuevoPanel);
        revalidate();
        repaint();
        nuevoPanel.requestFocusInWindow();
    }
}
