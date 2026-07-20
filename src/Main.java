import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n============================");
            System.out.println("     MENU PRINCIPAL PAC-MAN  ");
            System.out.println("============================");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    Juego juego = new Juego();
                    juego.iniciarJuego();
                    break;
                case 2:
                    System.out.println("Saliendo de la aplicación. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 2);
        scanner.close();
    }
}
        tablero.mostrarTablero();
    }
}
