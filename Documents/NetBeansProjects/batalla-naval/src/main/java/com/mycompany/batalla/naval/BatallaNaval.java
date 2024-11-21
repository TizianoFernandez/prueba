package com.mycompany.batalla.naval;
import com.batalla_naval.controlador.Controlador;
import com.batalla_naval.modelo.jugador.Jugador;
import com.batalla_naval.modelo.partida.Juego;
import com.batalla_naval.modelo.tablero.Tablero;
import com.batalla_naval.modelo.recursos.ResultadoDisparo;
import com.batalla_naval.vista.VistaConsola;
import com.batalla_naval.vista.VistaInt;

public class BatallaNaval {

    public static void main(String[] args) {
//        player1.cargarBarcos();
//        player1.colocarBarcoJugador(1, 3, true, 4);
//        //player1.tablero();
//        
//        System.out.println("");
//        
//        player2.cargarBarcos();
//        player2.colocarBarcoJugador(2, 3, true, 3);
//        //player2.tablero();
//        
//        int x = 0;
//        ResultadoDisparo disparo;
//        while(x < 7){
//            disparo = player1.disparar(x, 3, player2);
//            switch(disparo){
//                case AGUA -> System.out.println("Agua");
//                case PIEZA_ROTA -> System.out.println("Pieza rota");
//                case TOCADO-> System.out.println("TOCADO");
//                case HUNDIDO-> System.out.println("Barco Hundido");
//                default -> System.out.println("Agua");
//            }
//            
//            System.out.println("");
//            //player2.tablero();
//            System.out.println("");
//            
//            ++x;
//        }
//
//        Jugador player1 = new Jugador("pepsi");
//        Jugador player2 = new Jugador("jorge");
//        VistaConsola vista = new VistaConsola();
//        
//        player1.cargarBarcos();
//        player1.getTablero().addObservador(vista);
//        
//        
//        player1.addObservador(vista);
//        player1.inicializarTableroEnemigo();
//        
//        vista.mostrarBarcosJugador(player1.getBarcos());



        Juego j = new Juego();
        VistaInt vista = new VistaConsola();
        Controlador c = new Controlador(j, vista);
        
        c.partidaIA();
   
    }
}
