public class Fantasma extends Enemigo {
    private int direccionX;
    private int direccionY;
    public Fantasma(int x, int y, int dirX, int dirY) {
        super("Fantasma", 2, 4, 1, 0.0, x, y);
    }
   public void mover(int limiteAncho, int limiteAlto){
        this.posicionX += this.velocidad;
        if (this.posicionX > limiteAncho){
            this.posicionX = 0;
    }
}
}
