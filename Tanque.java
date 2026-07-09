public class Tanque extends Enemigo {
 public Tanque(int x, int y) {
        super("Tanque", 6, 2, 1, 2.0, x, y);
    }
 public void mover(int limiteAncho, int limiteAlto) {
        this.posicionX += this.velocidad;
        if (this.posicionX >= limiteAncho || this.posicionX <= 0) {
            this.velocidad = -this.velocidad;
        }
}
