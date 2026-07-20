public class Fantasma extends Enemigo {
    public Fantasma(int x, int y, int dirX, int dirY) {
        super("Fantasma", 2, 4, 1, 0.0, x, y);
    }
   public void mover(int limiteAncho, int limiteAlto){
        this.posicionX += (int) this.velocidad;
        if (this.posicionX > limiteAncho){
            this.posicionX = 0;
    } else {
            (this.posicionX < 0){
                this.posicionX = limiteAncho;
            }
}
}
