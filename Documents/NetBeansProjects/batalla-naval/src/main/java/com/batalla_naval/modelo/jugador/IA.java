package com.batalla_naval.modelo.jugador;

import com.batalla_naval.modelo.recursos.ResultadoDisparo;


public class IA extends Usuario {

    public IA() {
        super("IA");
    }
    
    
    
    @Override
    public boolean colocarBarcoJugador(int x, int y, boolean vertical, int numeroBarco){
        return false;
    }
    
    
    @Override
    public ResultadoDisparo disparar(int x, int y, Usuario destino){
        return ResultadoDisparo.AGUA;
    }
}
