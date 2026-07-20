import java.util.ArrayList;
import java.util.List;
public class ControladorEnemigos {
    private List<Enemigos> enemigos;
    private List<Enemigo> enemigosParaCrear;
    private Jugador jugador;
    public ControladorEnemigos(Jugador jugador) {
        this.enemigos = new ArrayList<>();
        this.enemigosParaCrear = new ArrayList<>();
        this.jugador = jugador;
    }
     public void generarEnemigosPorTamañoMapa(int anchoMapa, int altoMapa) {
        int areaTotal = anchoMapa * altoMapa;
        if (areaTotal > 400) { 
        enemigos.add(new Fantasma(1, altoMapa / 2, 1, 0));
        enemigos.add(new Rapidin(anchoMapa - 2, altoMapa - 2));
        enemigos.add(new Tanque(2, 2));
        enemigos.add(new Multiple(anchoMapa / 2, altoMapa - 2, 2));
    } else {
        enemigos.add(new Tanque(2, 2));
        enemigos.add(new Multiple(anchoMapa - 2, altoMapa - 2, 2));
    }
     }
    public void moverEnemigos(int anchoMapa, int altoMapa) {
        generarMovimientos();
        for (Enemigo e : enemigos) {
            e.mover(anchoMapa, altoMapa);
        }
    }
    if (!enemigosParaAgregar.isEmpty()) {
        enemigos.addAll(enemigosParaAgregar);
        enemigosParaAgregar.clear();
    }
    public void registrarDañoAEnemigo(Enemigo e, int cantidad) {
        if (e instanceof Multiple) {
            Multiple clon = ((Multiple) e).recibirDañoYDividir(cantidad);
            if (clon != null) {
                this.agregarEnemigo(clon); 
            }
        } else {
            e.recibirDaño(cantidad);
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
