package dev.game;
import dev.game.modelo.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println(("=== Bienvenidos a la beta de tensura game ==="));
        System.out.print("Ingrese el nombre de tu personaje: ");
        String nombre = scanner.nextLine();

        System.out.println("\nSelecciona tu origen");
        System.out.println(("1. Humano"));
        System.out.println(("2. Monstruo"));
        System.out.print(("Opcion: "));
        int opcion = scanner.nextInt();

        Personaje jugador = null;

        if (opcion == 1) {
            jugador = new Humano(nombre, 100.0, 1, 15.0, 50, 0, 5, 25);
        } else if (opcion == 2) {
            jugador = new Monstruo(nombre, 125, 1, 12.5, 80,  0, 3, 10, "goblin");
        }else {
            System.out.println(("Opcion no valida"));
            scanner.close();
            return;
        }

        System.out.println();
        jugador.mostrarEstadisticas();

        scanner.close();
    }
}