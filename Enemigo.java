public abstract class Enemigo {
    protected String tipo;
    protected int fila;
    protected int columna;
    protected int daño;
    protected boolean activo;
    public Enemigo(String tipo, int fila, int columna, int daño) {
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        this.daño = daño;
        this.activo = true;
    }
    public abstract void mover(Tablero tablero, Jugador jugador);
    public void atacar(Jugador jugador) {
        jugador.recibirDaño(this.daño);
    }
    public boolean verificarColision(Jugador jugador) {
        return this.fila == jugador.fila && this.columna == jugador.columna;
    }
    public void mostrarEstado() {
        System.out.println(tipo + " en posición (" + fila + "," + columna + ")");
    }
    public int getFila() { 
        return fila; 
    }
    public int getColumna() { 
        return columna; 
    }
    public String getTipo() { 
        return tipo; 
    }
    public boolean isActivo() { 
        return activo; 
    }
    public void setActivo(boolean activo) { 
        this.activo = activo; 
    }
}
