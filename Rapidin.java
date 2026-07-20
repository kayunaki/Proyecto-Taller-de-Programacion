public class Rapidin extends Enemigo {
    public Rapidin(int x, int y) {
        super("Rapidin", 2, 9.0, 1, 4.5, x, y);
    }
    public void mover(int limiteAncho, int limiteAlto) {
        this.posicionX += (int)this.velocidad;
        if (this.posicionX > limiteAncho) {
            this.posicionX = 0;
        }
}
}
