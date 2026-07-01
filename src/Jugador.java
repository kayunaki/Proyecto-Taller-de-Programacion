public class Jugador {
    public String nombre;
    public int fila;
    public int columna;
    public int salud;
    public int puntaje;
    public double velocidad;
    public boolean poderActivo;

    public Jugador(String nombre, int fila, int columna) {
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.salud = 3;
        this.puntaje = 0;
        this.velocidad = 2;
        this.poderActivo = false;
    }

    public void mover(String direccion) {
        switch (direccion.toUpperCase()) {
            case "W":
                this.fila = this.fila - 1;
                System.out.println(nombre + " se movió hacia arriba ");
                break;

            case "S":
                this.fila = this.fila + 1;
                System.out.println(nombre + " se movió hacia abajo ");
                break;

            case "A":
                this.columna = this.columna - 1;
                System.out.println(nombre + " se movió hacia la izquierda ");
                break;

            case "D":
                this.columna = this.columna + 1;
                System.out.println(nombre + " se movió hacia la derecha");
                break;

            default:
                System.out.println("Dirección no válida, usa W, A, S o D.");
                break;
        }
    }

    //puntos
    public void recogerPunto(int valor) {
        this.puntaje = this.puntaje + valor;
    }

    //daño
    public void recibirDaño(int daño) {
        this.salud = this.salud - daño;
        if (this.salud <= 0) {
            this.salud = 0;
            System.out.println("GAME OVER!");
        } else {
            System.out.println("Vidas restantes de " + this.nombre + ": " + this.salud);
        }
    }

    //poder
    public void usarPoder() {
        if (this.poderActivo) {
            System.out.println(this.nombre + " ya tiene el poder activo.");
        } else {
            this.poderActivo = true;
            System.out.println(this.nombre + " has activado tu poder especial! ¡Ahora puede ir por los fantasmas!");
        }
    }

    // si esta vivo
    public boolean estaVivo() {
        if (this.salud > 0) {
            return true;
        } else {
            return false;
        }
    }

    //estado
    public void mostrarEstado() {
        System.out.println("--- ESTADO DE " + this.nombre + " ---");
        System.out.println("Vidas: " + this.salud);
        System.out.println("Puntaje: " + this.puntaje);
        System.out.println("Posición: Fila " + this.fila + ", Columna " + this.columna);
        System.out.println("¿Poder Activo?: " + this.poderActivo);
        System.out.println("-------------------------");
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
