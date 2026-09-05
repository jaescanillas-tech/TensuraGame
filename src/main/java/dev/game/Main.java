package dev.game;
import dev.game.gui.VentanaJuego;
import dev.game.modelo.entidades.*;
import dev.game.modelo.enums.Razas;
import dev.game.sistema.GenerarEnemigos;

import javax.swing.*;

public class Main {
    public static void main(String[] args){

        SwingUtilities.invokeLater(() -> {
            VentanaJuego ventana = new VentanaJuego();
            ventana.setVisible(true);
        });
    }
}