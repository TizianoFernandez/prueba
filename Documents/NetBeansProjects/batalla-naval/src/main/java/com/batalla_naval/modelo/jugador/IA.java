package com.batalla_naval.modelo.jugador;

import com.batalla_naval.modelo.barcos.ModeloBarco;
import com.batalla_naval.modelo.recursos.ResultadoDisparo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class IA extends Usuario {

    private Random r;
    private List<int[]> puntos;
    
    public IA() {
        super("IA");
        this.r = new Random();
        this.puntos = new ArrayList<>();
    }
    
    
    @Override
    public boolean colocarBarcoJugador(int x, int y, boolean vertical, int numeroBarco){
        return this.colocarBarcoIA();
    }
    
    
    public boolean colocarBarcoIA(){
        boolean colocado;
        
        for(ModeloBarco barco : this.getBarcos()){
            if(barco != null){
                colocado = false;

                while(!colocado){
                    int x = r.nextInt(10);
                    int y = r.nextInt(10);
                    boolean vertical = r.nextBoolean();
                    barco.setPosicion(x, y, vertical);

                    colocado = this.getTablero().colocarBarco(barco);
                }
                
            }
        }
        return true;
    }
    

    @Override
    public ResultadoDisparo disparar(int x, int y, Usuario destino){
        return this.dispararIA(destino);
    }
    
    
    public ResultadoDisparo dispararIA(Usuario destino){
        int x, y;
        int[] puntosActuales;
        if(!puntos.isEmpty()){
            puntosActuales = puntos.remove(0);
            x = puntosActuales[0];
            y = puntosActuales[1];
        }
        else{
            do{
                x = r.nextInt(10);
                y = r.nextInt(10);
            }while(!" - ".equals(this.tableroEnemigo[x][y]));
        }
        
        
        ResultadoDisparo resultado = destino.getTablero().disparo(x, y);
        
        if(resultado == ResultadoDisparo.AGUA){
            this.tableroEnemigo[x][y] = " ~ ";
        }
        else{
            this.tableroEnemigo[x][y] = " X ";
        }
        
        this.ultimoDisparo = resultado;
        this.xUltimo = x;
        this.yUltimo = y;
        
        if (resultado == ResultadoDisparo.HUNDIDO) {
            destino.barcoHundido();
        }
          
        if(resultado == ResultadoDisparo.TOCADO){
            this.posiblesDisparos(x, y);
        }
        
        ((Jugador) destino).registrarDisparoRecibido(resultado, x, y);
        
        return resultado;
    }

    public void posiblesDisparos(int x, int y) {
        int[][] posiblesPuntos = { {x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1} };
        
        int xAux,yAux;
        
        for(int[] punto : posiblesPuntos){
            xAux = punto[0];
            yAux = punto[1];
            
            if(this.disparoValido(xAux, yAux) && !puntos.contains(punto)){
                this.puntos.add(punto);
            }
        }
    }
    
    
    public boolean disparoValido(int x, int y){
        return (x >= 0 && x < 10) && (y >= 0 && y < 10) && " - ".equals(this.tableroEnemigo[x][y]);
    }
    
    public void reiniciarIA(){
        this.tablero.reiniciarTablero();
    
        this.cargarBarcos();

        this.inicializarTableroEnemigo();

        this.puntos.clear();

        this.ultimoDisparo = null;
        this.xUltimo = -1;
        this.yUltimo = -1; 
    }
}
