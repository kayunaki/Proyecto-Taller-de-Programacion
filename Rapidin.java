public class Rapidin extends Enemigo {
    public Rapidin(int fila, int columna) {
        super("Rapidin", fila, columna, 1);
    }
    @Override
    public void mover(Tablero tablero, Jugador jugador) {
        if (!activo) return;
        for (int i = 0; i < 2; i++) {
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
}
