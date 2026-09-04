package dev.game;
import dev.game.modelo.criaturas.*;
import dev.game.datos.*;
import dev.game.modelo.habilities.Habilidad;

public class Main {
    public static void main(String[] args){

        System.out.println("Hello World!");
        Jugador player = new Jugador("Ikuro", Razas.Humano);
        player.mostrarEstadisticas();
    }
}