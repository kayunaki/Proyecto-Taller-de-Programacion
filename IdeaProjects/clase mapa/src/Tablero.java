import java.util.Random;
public class Tablero {
    private int filas;
    private int columnas;
    private char[][] matriz;
    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = new char[filas][columnas];
    }
    public char[][] getMatriz() {
        return matriz;
    }
    public int getFilas() {
        return filas;
    }
    public int getColumnas() {
        return columnas;
    }
    public void generarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = '.';
            }
        }
    }
    public void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                char c = matriz[i][j];
                if (c == 'V' || c == 'S' || c == 'P') {
                    System.out.print("\u001B[1;35m" + c + "\u001B[0m "); 
                } else if (c == 'J') {
                    System.out.print("\u001B[1;32m" + c + "\u001B[0m "); 
                } else if (c == 'F' || c == 'R' || c == 'T') {
                    System.out.print("\u001B[1;31m" + c + "\u001B[0m ");
                } else {
                    System.out.print(c + " "); 
                }
            }
            System.out.println();
        }
    }
    public boolean esMovimientoValido(int f, int c) {
        return f >= 0 && f < filas && c >= 0 && c < columnas && matriz[f][c] != '#';
    }
    public void agregarMurosContorno() {
        for (int i = 0; i < filas; i++) {
            matriz[i][0] = '#';
            matriz[i][columnas - 1] = '#';
        }
        for (int j = 0; j < columnas; j++) {
            matriz[0][j] = '#';
            matriz[filas - 1][j] = '#';
        }
    }
    public void agregarMurosAleatorios(Jugador jugador, Enemigo[] enemigos) {
        Random rand = new Random();
        int cantidadMuros = (filas * columnas) / 8;
        for (int i = 0; i < cantidadMuros; i++) {
            int f, c;
            boolean ocupado;
            do {
                f = rand.nextInt(filas);
                c = rand.nextInt(columnas);
                ocupado = (f == 0 || f == filas - 1 || c == 0 || c == columnas - 1 ||
                        (f == jugador.fila && c == jugador.columna) ||
                        matriz[f][c] == 'V' || matriz[f][c] == 'S' || matriz[f][c] == 'P');
                for (int j = 0; j < enemigos.length; j++) {
                    if (enemigos[j] != null && f == enemigos[j].getFila() && c == enemigos[j].getColumna()) {
                        ocupado = true;
                    }
                }
                if (!ocupado) {
                    int salidasLibres = 0;
                    if (f > 0 && matriz[f - 1][c] != '#') salidasLibres++;
                    if (f < filas - 1 && matriz[f + 1][c] != '#') salidasLibres++;
                    if (c > 0 && matriz[f][c - 1] != '#') salidasLibres++;
                    if (c < columnas - 1 && matriz[f][c + 1] != '#') salidasLibres++;
                    if (salidasLibres < 2) {
                        ocupado = true;
                    }
                }
            } while (ocupado);
            matriz[f][c] = '#';
        }
    }
    public void agregarPoderes() {
        if (filas > 4 && columnas > 4) {
            matriz[1][1] = 'V';
            matriz[filas / 2][columnas / 2] = 'S';
            matriz[filas - 2][columnas - 2] = 'P';
        }
    }
    public void actualizarTablero(Jugador jugador, Enemigo[] enemigos) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] == 'J' || matriz[i][j] == 'F' || matriz[i][j] == 'R' || matriz[i][j] == 'T') {
                    matriz[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < enemigos.length; i++) {
            if (enemigos[i] != null && enemigos[i].isActivo()) {
                char letraEnemigo = 'F';
                if (enemigos[i].getTipo().equals("Rapidin")) letraEnemigo = 'R';
                if (enemigos[i].getTipo().equals("Tanque")) letraEnemigo = 'T';
                matriz[enemigos[i].getFila()][enemigos[i].getColumna()] = letraEnemigo;
            }
        }
        char celdaActual = matriz[jugador.fila][jugador.columna];
        if (celdaActual == '.') {
            jugador.recogerPunto(10);
        } else if (celdaActual == 'V' || celdaActual == 'P') {
            jugador.usarPoder();
        } else if (celdaActual == 'S') {
            jugador.salud++;
            System.out.println("¡Has recuperado 1 de salud! Salud actual: " + jugador.salud);
        }
        matriz[jugador.fila][jugador.columna] = 'J';
    }
    public boolean todosPuntosRecolectados() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
