import java.util.Scanner;
import java.util.Random;
public class Juego {
    private Jugador jugador;
    private Tablero tablero;
    private ControladorEnemigos controladorEnemigos;
    private boolean juegoTerminado;
    public void iniciarJuego() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Ingrese número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese número de columnas: ");
        int columnas = sc.nextInt();
        tablero = new Tablero(filas, columnas);
        tablero.generarTablero();
        tablero.agregarMurosContorno();
        tablero.agregarPoderes();
        int filaJugador = rand.nextInt(filas - 2) + 1;
        int colJugador = rand.nextInt(columnas - 2) + 1;
        jugador = new Jugador("Daniel", filaJugador, colJugador);
        Enemigo[] listaEnemigos = new Enemigo[3];
        listaEnemigos[0] = new Fantasma(rand.nextInt(filas - 2) + 1, rand.nextInt(columnas - 2) + 1);
        listaEnemigos[1] = new Rapidin(rand.nextInt(filas - 2) + 1, rand.nextInt(columnas - 2) + 1);
        listaEnemigos[2] = new Tanque(rand.nextInt(filas - 2) + 1, rand.nextInt(columnas - 2) + 1);
        controladorEnemigos = new ControladorEnemigos(listaEnemigos);
        tablero.agregarMurosAleatorios(jugador, listaEnemigos);
        juegoTerminado = false;
        ejecutarTurno();
    }
    public void ejecutarTurno() {
        Scanner teclado = new Scanner(System.in);
        while (!juegoTerminado) {
            mostrarEstado();
            System.out.println();
            System.out.print("Mover (W/A/S/D, X para salir): ");
            String opcion = teclado.nextLine();
            if (opcion.equalsIgnoreCase("X")) {
                System.out.println("Juego terminado por el usuario.");
                juegoTerminado = true;
                break;
            }
            jugador.mover(opcion, tablero);
            jugador.actualizarTurnosPoder();
            controladorEnemigos.moverEnemigos(tablero, jugador);
            controladorEnemigos.verificarColisiones(jugador);
            verificarFinJuego();
            actualizarTablero();
        }
        System.out.println("\nJuego terminado.");
    }
    public void verificarFinJuego() {
        if (!jugador.estaVivo()) {
            juegoTerminado = true;
            System.out.println("¡Perdiste! Te quedaste sin salud.");
        } else if (tablero.todosPuntosRecolectados()) {
            juegoTerminado = true;
            System.out.println("¡Ganaste! Recolectaste todos los puntos.");
        }
    }
    public void mostrarEstado() {
        tablero.mostrarTablero();
        System.out.println();
        jugador.mostrarEstado();
        System.out.println();
        Enemigo[] enemigos = controladorEnemigos.getEnemigos();
        for (int i = 0; i < enemigos.length; i++) {
            if (enemigos[i] != null && enemigos[i].isActivo()) {
                enemigos[i].mostrarEstado();
            }
        }
    }
    public void actualizarTablero() {
        tablero.actualizarTablero(jugador, controladorEnemigos.getEnemigos());
    }
}
