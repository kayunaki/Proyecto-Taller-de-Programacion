public class ControladorEnemigos {
    private Enemigo[] enemigos;
    public ControladorEnemigos(Enemigo[] enemigos) {
        this.enemigos = enemigos;
    }
    public void moverEnemigos(Tablero tablero, Jugador jugador) {
        for (int i = 0; i < enemigos.length; i++) {
            if (enemigos[i] != null && enemigos[i].isActivo()) {
                enemigos[i].mover(tablero, jugador);
            }
        }
    }
    public void verificarColisiones(Jugador jugador) {
        for (int i = 0; i < enemigos.length; i++) {
            if (enemigos[i] != null && enemigos[i].isActivo()) {
                if (enemigos[i].verificarColision(jugador)) {
                    if (jugador.isPoderActivo()) {
                        enemigos[i].setActivo(false);
                        System.out.println("\n\u001B[1;32m¡Has cazado a un " + enemigos[i].getTipo() + " gracias a tu poder!\u001B[0m");
                        jugador.recogerPunto(50);
                    } else {
                        enemigos[i].atacar(jugador);
                    }
                }
            }
        }
    }
    public Enemigo[] getEnemigos() {
        return enemigos;
    }
}
