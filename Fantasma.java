public class Fantasma extends Enemigo {
    public Fantasma(int fila, int columna) {
        super("Fantasma", fila, columna, 1);
    }
    @Override
    public void mover(Tablero tablero, Jugador jugador) {
        if (!activo) return;
        int nuevaFila = fila;
        int nuevaColumna = columna;
        int diferenciaFila = jugador.fila - fila;
        int diferenciaColumna = jugador.columna - columna;
        if (Math.abs(diferenciaFila) > Math.abs(diferenciaColumna)) {
            if (diferenciaFila < 0) {
                nuevaFila--;
            } else if (diferenciaFila > 0) {
                nuevaFila++;
            }
        } else {
            if (diferenciaColumna < 0) {
                nuevaColumna--;
            } else if (diferenciaColumna > 0) {
                nuevaColumna++;
            }
        }
        if (tablero.esMovimientoValido(nuevaFila, nuevaColumna)) {
            fila = nuevaFila;
            columna = nuevaColumna;
        }
    }
}
