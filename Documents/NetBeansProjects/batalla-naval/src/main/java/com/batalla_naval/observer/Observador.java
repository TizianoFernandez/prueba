package com.batalla_naval.observer;
import com.batalla_naval.modelo.barcos.ModeloBarco;
import com.batalla_naval.modelo.recursos.ResultadoDisparo;
import com.batalla_naval.modelo.tablero.Tablero;

public interface Observador {
    public void actualizarTablero(ModeloBarco [][] tablero);
    public void actualizarDisparo(ResultadoDisparo resultado, int x, int y, String[][] tablero);
    public void actualizarDisparoRecibido(ResultadoDisparo ultimoRecibido, int xRecibido, int yRecibido, String[][] tableroDisparos);
}
