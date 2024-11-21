package com.batalla_naval.controlador;

import com.batalla_naval.modelo.partida.Juego;
import com.batalla_naval.vista.*;


public class Controlador {
    private Juego juego;
    private VistaInt vista;
    
    public Controlador(Juego juego, VistaInt vista){
        this.juego = juego;
        this.vista = vista;
    }
    
    public void partidaIA(){
        this.vista.bienvenida();
        boolean termino = false;
        while(termino){
            int opcion = this.vista.mostrarMenu();
            
            while(opcion != 1 && opcion != 2){
                vista.opcionIncorrecta();
                opcion = this.vista.mostrarMenu();
            }
            
            switch(opcion){
                case 1:
                    String nombre = this.vista.pedirNombreJugador();
                    juego.setPartidaIA(nombre);
                    
                    break;
                case 2:
                    System.out.println("salir");
                    termino = true;
                    break;
                default:
                    break;
            }
        }
       
    }
}

