public class Enemigos {
class Multiple {
    private String nombre;
    private int vida;
    private int velocidad;
    private int division;
    private int posicionX;
    private int posicionY;
    private int daño;
    private String estado;
    private double rango;
    public Multiple (int X, int Y, int division){
        this.nombre = "Multiple";
        this.vida = 100;
        this.daño = 5;
        this.velocidad = 5;
        this.division = division;
        this.posicionX = X;
        this.posicionY = Y;
        this.estado = "Calmao";
        this.rango = 3.0;
    }
public void Estad0 (int jugadorX, int jugadorY){
    double distancia = Math.sqrt(Math.pow((jugadorX - this.posicionX), 2) + Math.pow((jugadorY - this.posicionY), 2));
    if (distancia <= this.rango){
        this.estado = "Enojao";
    } else {
        this.estado = "Calmao";
    }
}
public int realidaño(int jugadorX, int jugadorY){
    if (this.posicionX == jugadorX && this.posicionY == jugadorY) {
            return this.daño;
    } else {
        return 0;
    }
}
public Multiple recidaño(int cantidad){
    this.vida -= cantidad;
    if(this.vida > 0 && this.division > 0){
        this.division--;
        return new Multiple(this.posicionX + 1 , this.posicionY + 1, this.division);
    }
    return null;
}
public void posicion (int x, int y){
    this.posicionX = x;
    this.posicionY = y;
}
public String Estad0(){
    return this.estado;
}
public int velocidad (){
    return this.velocidad;
}
public int vida (){
    return this.vida;
}
class rapidin {
    private int vida;
    private int velocidad;
    private int posicionX;
    private int posicionY;
    private int daño;
    private String estado;
    private double rango;
    public rapidin (int X, int Y){
        this.vida = 25;
        this.daño = 2;
        this.velocidad = 9;
        this.posicionX = X;
        this.posicionY = Y;
        this.estado = "Calmao";
        this.rango = 4.5;
    }
public void Estad0(int jugadorX, int jugadorY) {
        double distancia = Math.sqrt(Math.pow(jugadorX - this.posicionX, 2) + Math.pow(jugadorY - this.posicionY, 2));
        if (distancia <= this.rango) {
            this.estado = "Enojao";
        } else {
            this.estado = "Calmao";
        }
    }
public int realidaño(int jugadorX, int jugadorY) {
        if (this.posicionX == jugadorX && this.posicionY == jugadorY) {
            return this.daño;
        }
        return 0;
    }
    public void recidaño(int cantidad) { 
        this.vida -= cantidad; 
    }
    public void posicion(int x, int y) { 
        this.posicionX = x; this.posicionY = y; 
    }
    public String Estad0() { 
        return estado; 
    }
    public int velocidad() { 
        return velocidad; 
    }   
    public int vida (){
    return this.vida;
}
class tanque {
    private String nombre;
    private int vida;
    private int velocidad;
    private int posicionX;
    private int posicionY;
    private int daño;
    private String estado;
    private double rango;
    public tanque (int X, int Y){
        this.nombre = "Tanque";
        this.vida = 200;
        this.daño = 10;
        this.velocidad = 2;
        this.posicionX = X;
        this.posicionY = Y;
        this.estado = "Calmao";
        this.rango = 2.0;
    }
    }
    public void Estad0(int jugadorX, int jugadorY) {
            double distancia = Math.sqrt(Math.pow((jugadorX - this.posicionX), 2) + Math.pow((jugadorY - this.posicionY), 2));
            if (distancia <= this.rango) {
                this.estado = "Enojao";
            } else {
                this.estado = "Calmao";
            }
        }
        public int realidaño(int jugadorX, int jugadorY) {
            if (this.posicionX == jugadorX && this.posicionY == jugadorY) {
                return this.daño;
            } else {
                return 0;
            }
        }
        public void recidaño(int cantidad) {
            this.vida -= cantidad;
        }

        public void posicion(int x, int y) {
            this.posicionX = x;
            this.posicionY = y;
        }
        public String Estad0() { 
            return this.estado; 
        }
        public int velocidad() { 
            return this.velocidad; 
        }
        public int vida (){
        return this.vida;
}
}
