public abstract class Enemigo {
    protected String nombre;
    protected int vida;
    protected int velocidad;
    protected int posicionX;
    protected int posicionY;
    protected int daño;
    protected String estado;
    protected double rango;
    public Enemigo(String nombre, int vida, int velocidad, int daño, double rango, int x, int y) {
        this.nombre = nombre;
        this.vida = vida;
        this.velocidad = velocidad;
        this.daño = daño;
        this.rango = rango;
        this.posicionX = x;
        this.posicionY = y;
        this.estado = "Calmao";
    }
    public abstract void mover(int limiteAncho, int limiteAlto);
    public void calcularEstado(int jugadorX, int jugadorY) {
        double distancia = Math.sqrt(Math.pow(jugadorX - this.posicionX, 2) + Math.pow(jugadorY - this.posicionY, 2));
        if (distancia <= this.rango) {
            this.estado = "Enojao";
        } else {
            this.estado = "Calmao";
        }
    }
    public int realizarDaño(int jugadorX, int jugadorY) {
        if (this.posicionX == jugadorX && this.posicionY == jugadorY) {
            return this.daño;
        }
        return 0;
    }
    public void recibirDaño(int cantidad) {
        this.vida -= cantidad;
    }
    public void setPosicion(int x, int y) {
        this.posicionX = x;
        this.posicionY = y;
    }
    public String getEstado() { 
        return this.estado;
    }
    public int getVelocidad() { 
        return this.velocidad;
    }
    public int getVida() { 
        return this.vida;
    }
    public String getNombre() { 
        return this.nombre;
    }
}
