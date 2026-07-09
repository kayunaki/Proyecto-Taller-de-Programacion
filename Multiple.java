public class Multiple extends Enemigo {
    private int division;
    public Multiple(int X, int Y, int division) {
        super("Multiple", 4, 5, 1, 3.0, X, Y);
        this.division = division; 
    }
    public Multiple recibirDañoYDividir(int cantidad) {
        this.vida -= cantidad;
        if (this.vida > 0 && this.division > 0) {
            this.division--;
            return new Multiple(this.posicionX + 1, this.posicionY + 1, this.division);
        }
        return null;
    }
}
