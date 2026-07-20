public class Tanque extends Enemigo {
    public Tanque(int fila, int columna) {
        super("Tanque", fila, columna, 2);
    }
    @Override
    public void mover(Tablero tablero, Jugador jugador) {
        if (!activo) return;
        int df = jugador.fila - fila;
        int dc = jugador.columna - columna;
        int nf = fila, nc = columna;
        if (Math.abs(df) > Math.abs(dc)) {
            if (df < 0) nf--; else if (df > 0) nf++;
        } else {
            if (dc < 0) nc--; else if (dc > 0) nc++;
        }
        if (tablero.esMovimientoValido(nf, nc)) {
            fila = nf;
            columna = nc;
        }
    }
}
