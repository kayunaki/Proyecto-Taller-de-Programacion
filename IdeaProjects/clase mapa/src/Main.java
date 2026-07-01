public class Tablero {

    private int filas;
    private int columnas;
    private char[][] matriz;
    private Muro[] muros; otra clase
    private Punto[] puntos; otra clase
    //private Poder[] poderes; otra clase

    
    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new char[filas][columnas];
    }

    
    public void generarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = ' ';
            }
        }
    }

    public void agregarMuros() {
        for (int i = 0; i < filas; i++) {
            matriz[i][0] = '#';
            matriz[i][columnas - 1] = '#';
        }

        for (int j = 0; j < columnas; j++) {
            matriz[0][j] = '#';
            matriz[filas - 1][j] = '#';
        }
    }

    public void agregarPuntos() {
        for (int i = 1; i < filas - 1; i++) {
            for (int j = 1; j < columnas - 1; j++) {
                if (matriz[i][j] == ' ') {
                    matriz[i][j] = '.';
                }
            }
        }
    }

    public void agregarPoderes() {
        if (filas > 4 && columnas > 4) {
            matriz[1][1] = 'V';
            matriz[filas / 2][columnas / 2] = 'S';
            matriz[filas - 2][columnas - 2] = 'C';
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean esMovimientoValido(int fila, int columna) {
        if (fila < 0 || fila >= filas) {
            return false;
        }

        if (columna < 0 || columna >= columnas) {
            return false;
        }

        return matriz[fila][columna] != '#';
    }
}
