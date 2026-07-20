public class Multiple extends Enemigo {
    private int division;
    private boolean seDividioEnEsteTurno = false; 
    public Multiple(int X, int Y, int division) {
        super("Multiple", 4, 5.0, 1, 3.0, X, Y);
        this.division = division; 
    }
    public Multiple recibirDañoYDividir(int cantidad) {
        super.recibirDaño(cantidad);
        if (this.vida < 0) {
            this.vida = 0;
        } 
        if (this.vida > 0 && this.division > 0) {
            this.division--;
            return new Multiple(this.posicionX + 15, this.posicionY + 15, this.division);
        }
        return null;
    }
    public void mover(int limiteAncho, int limiteAlto) {
        this.posicionX += (int)this.velocidad;
        this.posicionY += (int)this.velocidad;
        if (this.posicionX > limiteAncho) this.posicionX = 0;
        if (this.posicionY > limiteAlto) this.posicionY = 0;
    }
}
