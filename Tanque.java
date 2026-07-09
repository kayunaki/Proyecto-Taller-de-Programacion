public class Tanque extends Enemigo {
    public Tanque(int x, int y) {
        super("Tanque", 6, 2, 1, 2.0, x, y);
    }
    public void mover(int limiteAncho, int limiteAlto) {
        this.posicionX += this.velocidad;
        if (this.posicionX >= limiteAncho) {
            this.posicionX = limiteAncho;
            this.velocidad = -Math.abs(this.velocidad); 
        } else (this.posicionX <= 0) {
            this.posicionX = 0;
            this.velocidad = Math.abs(this.velocidad);
        }
    }
}
