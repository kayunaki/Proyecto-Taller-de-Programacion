import java.util.ArrayList;
import java.util.List;
public class ControladorEnemigos {
    private List<Enemigo> enemigos;
    private Jugador jugador;
    public ControladorEnemigos(Jugador jugador) {
        this.enemigos = new ArrayList<>();
        this.jugador = jugador;
    }
    public void generarEnemigosPorTamañoMapa(int anchoMapa, int altoMapa) {
        int areaTotal = anchoMapa * altoMapa;
        if (areaTotal > 400) { 
            enemigos.add(new Espectro(1, altoMapa / 2, 1, 0));
            enemigos.add(new Rapidin(anchoMapa - 2, altoMapa - 2));
        }
    }
    public void moverEnemigos(int anchoMapa, int altoMapa) {
        generarMovimientos();
        for (Enemigo e : enemigos) {
            if (e instanceof Espectro) {
                ((Espectro) e).moverEnLinaRecta(anchoMapa, altoMapa);
            } else {
            }
        }
    }
    public void verificarColisiones() {
        int jugadorX = jugador.getPosicionX();
        int jugadorY = jugador.getPosicionY();
        for (Enemigo e : enemigos) {
            int daño = e.realizarDaño(jugadorX, jugadorY);
            if (daño > 0) {
                jugador.recibirDaño(daño);
            }
        }
    }
    public void eliminarEnemigosInactivos() {
        enemigos.removeIf(e -> e.getVida() <= 0);
    }
    public void generarMovimientos() {
        int jugadorX = jugador.getPosicionX();
        int jugadorY = jugador.getPosicionY();

        for (Enemigo e : enemigos) {
            e.calcularEstado(jugadorX, jugadorY);
        }
    }
    public void agregarEnemigo(Enemigo e) {
        this.enemigos.add(e);
    }
    public List<Enemigo> getEnemigos() {
        return enemigos;
    }
}
