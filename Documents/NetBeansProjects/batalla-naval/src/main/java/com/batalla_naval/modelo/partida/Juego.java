package com.batalla_naval.modelo.partida;
import com.batalla_naval.modelo.jugador.*;
import com.batalla_naval.modelo.recursos.ResultadoDisparo;
//import com.batalla_naval.tablero.Tablero;

//clase que debe comunicarse con el controlador y asi levantar las vistas

public class Juego {
    private Usuario jugador1;
    private Usuario jugador2;
    private Usuario turnoActual;
    
    
    public Juego(){
        this.jugador1 = null;
        this.jugador2 = null; // IA / posible jugador2
        this.turnoActual = null;
    }
    
    
    public void setPartidaIA(String nombre){
        this.jugador1 = new Jugador(nombre);
        this.jugador2 = new IA();
        this.turnoActual = this.jugador1;
        this.cargarBarcosJugadores();
    }
    
    
    public void cargarBarcosJugadores(){
        this.jugador1.cargarBarcos();
        this.jugador2.cargarBarcos();
    }
    
    public Usuario determinarGanador(){
        if(this.jugador1.getCantidadBarcos() == 0){
            return this.jugador2;
        }
        else{
            return this.jugador1;
        }
    }
    
    
    public void determinarTurno(){
        if(this.turnoActual.getUltimoDisparo() == ResultadoDisparo.AGUA){
            if(this.turnoActual == this.jugador1){
                this.turnoActual = jugador2;
            }
            else{
                this.turnoActual = jugador2;
            }
        }
    }
    
    
    public boolean verificarCoordenandas(int x, int y){
        return x < 0 || x >= 10 || y < 0 || y >= 10;
    }
    
    
    
    public Usuario getJugador1(){
        return this.jugador1;
    }
    
    public Usuario getJugador2(){
        return this.jugador2;
    }
    
    public Usuario getTurnoActual(){
        return this.turnoActual;
    }
}
