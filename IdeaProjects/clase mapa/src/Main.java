public class Tablero {

    private int filas;
    private int columnas;
    private char[][] matriz;

    private Muro[] muros;
    private Punto[] puntos;
    private Poder[] poderes;

    public Tablero(int filas, int columnas) {

        this.filas = filas;
        this.columnas = columnas;

        matriz = new char[filas][columnas];

        muros = new Muro[(filas * 2) + (columnas * 2)];
        puntos = new Punto[(filas - 2) * (columnas - 2)];
        poderes = new Poder[3];
    }

    public void generarTablero() {

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                matriz[i][j] = ' ';

            }

        }

    }

    public void agregarMuros() {

        int indice = 0;

        for (int i = 0; i < filas; i++) {

            matriz[i][0] = '#';
            muros[indice++] = new Muro(i,0);

            matriz[i][columnas-1] = '#';
            muros[indice++] = new Muro(i,columnas-1);

        }

        for (int j = 1; j < columnas-1; j++) {

            matriz[0][j] = '#';
            muros[indice++] = new Muro(0,j);

            matriz[filas-1][j] = '#';
            muros[indice++] = new Muro(filas-1,j);

        }

    }

    public void agregarPuntos() {

        int indice = 0;

        for (int i = 1; i < filas-1; i++) {

            for (int j = 1; j < columnas-1; j++) {

                if(matriz[i][j]==' ') {

                    matriz[i][j]='.';

                    puntos[indice++] = new Punto(i,j,10);

                }

            }

        }

    }

    public void agregarPoderes() {

        if(filas>4 && columnas>4){

            matriz[1][1]='V';
            matriz[filas/2][columnas/2]='S';
            matriz[filas-2][columnas-2]='C';

        }

    }

    public boolean esMovimientoValido(int fila,int columna){

        if(fila<0 || fila>=filas)
            return false;

        if(columna<0 || columna>=columnas)
            return false;

        return matriz[fila][columna]!='#';

    }

    public void mostrarTablero(){

        for(int i=0;i<filas;i++){

            for(int j=0;j<columnas;j++){

                System.out.print(matriz[i][j]+" ");

            }

            System.out.println();

        }

    }

    public char[][] getMatriz() {
        return matriz;
    }

    public Punto[] getPuntos() {
        return puntos;
    }

    public Poder[] getPoderes() {
        return poderes;
    }

    public Muro[] getMuros() {
        return muros;
    }

}
