public class Jugador {
    public String nombre;
    public int fila;
    public int columna;
    public int salud;
    public int puntaje;
    public int velocidad;
    public boolean poderActivo;
    private int turnosPoder;
    public Jugador(String nombre, int fila, int columna) {
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.salud = 3;
        this.puntaje = 0;
        this.velocidad = 1;
        this.poderActivo = false;
        this.turnosPoder = 0;
    }
    public void mover(String direccion, Tablero tablero) {
        int pasos = (poderActivo) ? 2 : 1;
        int nuevaFila = fila;
        int nuevaColumna = columna;
        switch (direccion.toUpperCase()) {
            case "W": nuevaFila -= pasos; break;
            case "S": nuevaFila += pasos; break;
            case "A": nuevaColumna -= pasos; break;
            case "D": nuevaColumna += pasos; break;
            default: System.out.println("Dirección no válida."); return;
        }
        if (poderActivo) {
            int filaIntermedia = (fila + nuevaFila) / 2;
            int colIntermedia = (columna + nuevaColumna) / 2;

            if (tablero.esMovimientoValido(filaIntermedia, colIntermedia) && tablero.esMovimientoValido(nuevaFila, nuevaColumna)) {
                fila = nuevaFila;
                columna = nuevaColumna;
            } else {
                System.out.println("Movimiento bloqueado por un muro en el camino.");
            }
        } else {
            if (tablero.esMovimientoValido(nuevaFila, nuevaColumna)) {
                fila = nuevaFila;
                columna = nuevaColumna;
            } else {
                System.out.println("Movimiento bloqueado por un muro.");
            }
        }
    }
    public void recogerPunto(int valor) {
        this.puntaje = this.puntaje + valor;
    }
    public void recibirDaño(int daño) {
        this.salud = this.salud - daño;
        if (this.salud <= 0) {
            this.salud = 0;
            System.out.println("GAME OVER!");
        } else {
            System.out.println("¡Cuidado! Vidas restantes de " + this.nombre + ": " + this.salud);
        }
    }
    public void usarPoder() {
        this.poderActivo = true;
        this.turnosPoder = 10;
        System.out.println("\n\u001B[1;33m¡PODER ACTIVADO! Velocidad x2 y capacidad de cazar enemigos durante 10 turnos.\u001B[0m");
    }
    public void actualizarTurnosPoder() {
        if (poderActivo) {
            turnosPoder--;
            if (turnosPoder <= 0) {
                poderActivo = false;
                System.out.println("\n\u001B[1;31m¡El poder ha expirado! Vuelves a la velocidad normal.\u001B[0m");
            } else {
                System.out.println("\u001B[1;33m[PODER ACTIVO] Turnos restantes: " + turnosPoder + "\u001B[0m");
            }
        }
    }
    public boolean estaVivo() {
        return this.salud > 0;
    }
    public void mostrarEstado() {
        System.out.println("--- ESTADO DE " + this.nombre + " ---");
        System.out.println("Vidas: " + this.salud + " | Puntaje: " + this.puntaje + " | Poder Activo: " + this.poderActivo);
        System.out.println("Posición: (" + this.fila + ", " + this.columna + ")");
        System.out.println("--------------------------------");
    }
    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public int getFila() { 
        return fila; 
    }
    public void setFila(int fila) {
         this.fila = fila; 
        }
    public int getColumna() { 
        return columna; 
    }
    public void setColumna(int columna) {
         this.columna = columna; 
    }
    public int getSalud() {
         return salud; 
    }
    public void setSalud(int salud) { 
        this.salud = salud; 
    }
    public int getPuntaje() { 
        return puntaje; 
    }
    public void setPuntaje(int puntaje) { 
        this.puntaje = puntaje; 
    }
    public int getVelocidad() { 
        return velocidad; 
    }
    public void setVelocidad(int velocidad) { 
        this.velocidad = velocidad; 
    }
    public boolean isPoderActivo() { 
        return poderActivo; 
    }
    public void setPoderActivo(boolean poderActivo) { 
        this.poderActivo = poderActivo; 
    }
}
