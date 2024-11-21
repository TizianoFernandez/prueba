package com.batalla_naval.modelo.jugador;
import com.batalla_naval.modelo.barcos.Lancha;
import com.batalla_naval.modelo.barcos.ModeloBarco;
import com.batalla_naval.modelo.barcos.Crucero;
import com.batalla_naval.modelo.barcos.Submarino;
import com.batalla_naval.modelo.barcos.Portaaviones;
import com.batalla_naval.modelo.barcos.Buque;
import com.batalla_naval.modelo.recursos.ResultadoDisparo;
import com.batalla_naval.modelo.tablero.Tablero;


public abstract class Usuario {
    protected String nombre;
    protected int puntaje;
    protected int partidasGanadas;
    protected ModeloBarco[] barcos; //Barcos que tiene el jugador
    protected int cantidadBarcos; //Cantidad de barcos restantes del jugador en el tablero
    protected Tablero tablero; 
    protected String[][] tableroEnemigo;
    
    protected ResultadoDisparo ultimoDisparo;
    protected int xUltimo;
    protected int yUltimo;
    
    
    public Usuario(String nombre){
        this.nombre = nombre;
        this.puntaje = 0;
        this.partidasGanadas = 0;
        this.barcos = null;
        this.cantidadBarcos = 0;
        this.tablero = new Tablero();
        this.tableroEnemigo = new String[10][10];
    }
    
    
    /*
        GETTERS
    */
    
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getPuntaje(){
        return this.puntaje;
    }
    
    public int getPartidasGanadas(){
        return this.partidasGanadas;
    }
    
    public int getCantidadBarcos(){
        return this.cantidadBarcos;
    }
    
    public ModeloBarco getBarcoIndice(int i){
        return this.barcos[i];
    }
    
    public ModeloBarco[] getBarcos(){
        return this.barcos;
    }
    
    public Tablero getTablero(){
        return this.tablero;
    }
    
    public ResultadoDisparo getUltimoDisparo(){
        return this.ultimoDisparo;
    }
      
    /*
        FUNCIONES
    */
    
    public void cargarBarcos(){
        this.barcos = new ModeloBarco[5];
        this.barcos[0] = new Lancha();
        this.barcos[1] = new Crucero();
        this.barcos[2] = new Submarino();
        this.barcos[3] = new Buque();
        this.barcos[4] = new Portaaviones();
        this.cantidadBarcos = 5;
    }
    
    public void barcoHundido(){
        --this.cantidadBarcos;
    }
    
    public boolean perdio(){
        return this.getCantidadBarcos() == 0;
    }
    
    public void crearTablero(){
        this.tablero = new Tablero();
    }
    
    public void inicializarTableroEnemigo() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableroEnemigo[i][j] = " - ";
            }
        }
    }
    
    public boolean reorganizarBarcos(){
        if(this.barcos.length == 0) return false;
        int ind;
        ModeloBarco aux;
        
        for(int i = 0; i < this.barcos.length-1; i++){
            if(this.barcos[i] == null){
                ind = i+1;
                if(this.barcos[ind] == null) ++ind;
                else{
                    aux = this.barcos[ind];
                    this.barcos[ind] = null;
                    this.barcos[i] = aux;
                }
            }
        }
        
        return true;
    }
    
    public int cuantosBarcos(){
        int barcosRestantes = 0;
        for(ModeloBarco barco : barcos){
            if(barco != null) ++barcosRestantes;
        }
        return barcosRestantes;
    }
    
    public abstract boolean colocarBarcoJugador(int x, int y, boolean vertical, int numeroBarco);
    public abstract ResultadoDisparo disparar(int x, int y, Usuario destino);
}
