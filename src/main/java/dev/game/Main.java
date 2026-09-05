package dev.game;
import dev.game.modelo.entidades.*;
import dev.game.datos.*;
import dev.game.modelo.enums.Razas;

public class Main {
    public static void main(String[] args){

        System.out.println("Hello World!");
        Jugador player = new Jugador("Ikuro", Razas.Humano);
        player.mostrarEstadisticas();
        player.mostrarLibroHabilidades();
    }
}