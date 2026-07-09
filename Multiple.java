public class Multiple extends Enemigo {
    private int division;
    private boolean seDividio EnEsteTurno = false; 
    public Multiple(int X, int Y, int division) {
        super("Multiple", 4, 5, 1, 3.0, X, Y);
        this.division = division; 
    }
    public void recibirDaño(int cantidad) {
        this.vida -= cantidad;
        if (this.vida < 0) {
            this.vida = 0;
        }
        if (this.vida > 0 && this.division > 0) {
            this.seDividioEnEsteTurno = true;
        }
    }
    public Multiple obtenerDivision() {
        if (this.seDividioEnEsteTurno) {
            this.seDividioEnEsteTurno = false;
            this.division--;
            return new Multiple(this.posicionX + 15, this.posicionY + 15, this.division);
        }
        return null;
    }
    public void mover(int limiteAncho, int limiteAlto) {
        this.posicionX += this.velocidad;
        this.posicionY += this.velocidad;
        if (this.posicionX > limiteAncho) this.posicionX = 0;
        if (this.posicionY > limiteAlto) this.posicionY = 0;
    }
}
