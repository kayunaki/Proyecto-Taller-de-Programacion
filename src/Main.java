import java.util.Scanner;

public class Juego {

    private Jugador jugador;
    private Tablero tablero;
    private Enemigo[] enemigos;
    private boolean juegoTerminado;

    public Juego() {

        tablero = new Tablero(15, 20);
        juegoTerminado = false;

    }

    public void iniciarJuego() {

        tablero.generarTablero();
        tablero.agregarMuros();
        tablero.agregarPuntos();
        tablero.agregarPoderes();

        jugador = new Jugador("Jugador", 1, 1);

        generarEnemigos(3);

        actualizarTablero();

    }

    public void ejecutarTurno() {

        Scanner teclado = new Scanner(System.in);

        while (!juegoTerminado) {

            mostrarEstado();

            System.out.println();
            System.out.println("Mover (W A S D): ");

            String opcion = teclado.nextLine().toUpperCase();

            switch (opcion) {

                case "W":
                    jugador.mover("ARRIBA");
                    break;

                case "S":
                    jugador.mover("ABAJO");
                    break;

                case "A":
                    jugador.mover("IZQUIERDA");
                    break;

                case "D":
                    jugador.mover("DERECHA");
                    break;

                default:
                    System.out.println("Movimiento inválido.");
            }

            for (int i = 0; i < enemigos.length; i++) {

                if (enemigos[i] != null) {

                    enemigos[i].mover();

                    if (enemigos[i].verificarColision(jugador)) {

                        enemigos[i].atacar(jugador);

                    }

                }

            }

            verificarFinJuego();

            actualizarTablero();

        }

        System.out.println();
        System.out.println("Juego terminado.");

    }

    public void verificarFinJuego() {

        if (!jugador.estaVivo()) {

            juegoTerminado = true;

            System.out.println("Perdiste.");

        }

        boolean quedanPuntos = false;

        Punto[] lista = tablero.getPuntos();

        for (int i = 0; i < lista.length; i++) {

            if (lista[i] != null && !lista[i].fueRecolectado()) {

                quedanPuntos = true;
                break;

            }

        }

        if (!quedanPuntos) {

            juegoTerminado = true;

            System.out.println("¡Ganaste!");

        }

    }

    public void mostrarEstado() {

        tablero.mostrarTablero();

        System.out.println();

        jugador.mostrarEstado();

        System.out.println();

        for (int i = 0; i < enemigos.length; i++) {

            if (enemigos[i] != null) {

                enemigos[i].mostrarEstado();

            }

        }

    }

    public void generarEnemigos(int cantidad) {

        enemigos = new Enemigo[cantidad];

        for (int i = 0; i < cantidad; i++) {

            enemigos[i] = new Enemigo(
                    "Fantasma",
                    2 + i,
                    2 + i,
                    10
            );

        }

    }

    public void actualizarTablero() {

        tablero.mostrarTablero();

    }

}
