package com.batalla_naval.modelo.jugador;
import com.batalla_naval.modelo.barcos.ModeloBarco;
import com.batalla_naval.modelo.recursos.ResultadoDisparo;
import com.batalla_naval.observer.Observable;
import com.batalla_naval.observer.Observador;
import java.util.ArrayList;


public class Jugador extends Usuario implements Observable{
    private ArrayList<Observador> observador;
 
    
    public Jugador(String nombre){
        super(nombre);
        this.observador = new ArrayList<>();
    }
    
    @Override
    public void notificar(){
        for(Observador obs: observador){
            obs.actualizarDisparo(this.ultimoDisparo, this.xUltimo, this.yUltimo, this.tableroEnemigo);
        }
    }
    
    public void addObservador(Observador obs){
        this.observador.add(obs);
    }

    @Override
    //numeroBarco se corresponde al indice del array ModeloBarco[] barcos del jugador.
    public boolean colocarBarcoJugador(int x, int y, boolean vertical, int numeroBarco){
        if(this.barcos.length == 0) return false;
        
        ModeloBarco barco = this.barcos[numeroBarco];
        
        if(barco == null) return false;
        
        barco.setPosicion(x, y, vertical);
        
        boolean colocar = tablero.colocarBarco(barco);
        
        if(colocar) this.barcos[numeroBarco] = null;
        
        this.reorganizarBarcos();
        return colocar;
    }
    
    
    @Override
    public ResultadoDisparo disparar(int x, int y, Usuario destino){
        ResultadoDisparo resultado = destino.getTablero().disparo(x, y);
        this.ultimoDisparo = resultado;
        this.xUltimo = x;
        this.yUltimo = y;
        
        if(resultado == ResultadoDisparo.HUNDIDO){
            destino.barcoHundido();
        }
        
        this.notificar();
        return resultado;
    }
    
    
    /*
        GETTERS
    */
    
}
