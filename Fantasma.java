public class Fantasma extends Enemigo {
    private int direccionX;
    private int direccionY;
    public Fantasma(int x, int y, int dirX, int dirY) {
        super("Fantasma", 2, 4, 1, 0.0, x, y);
        this.direccionX = dirX;
        this.direccionY = dirY;
    }
    public void moverEnLinaRecta(int limiteAncho, int limiteAlto) {
        this.posicionX += this.direccionX * this.velocidad;
        this.posicionY += this.direccionY * this.velocidad;
        if (this.posicionX < 0) this.posicionX = limiteAncho;
        if (this.posicionX > limiteAncho) this.posicionX = 0;
        if (this.posicionY < 0) this.posicionY = limiteAlto;
        if (this.posicionY > limiteAlto) this.posicionY = 0;
    }
}
