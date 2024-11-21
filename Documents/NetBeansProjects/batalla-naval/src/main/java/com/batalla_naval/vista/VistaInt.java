package com.batalla_naval.vista;
import com.batalla_naval.modelo.barcos.ModeloBarco;
import com.batalla_naval.modelo.jugador.Usuario;
import com.batalla_naval.modelo.recursos.ResultadoDisparo;

public interface VistaInt {
    public void bienvenida();
    public int mostrarMenu();
    public void opcionIncorrecta();
    public void mostrarTablero(ModeloBarco[][] tablero);
    public void mostrarTableroEnemigo(String[][] tablero);
    public void actualizarTableroEnemigo(ResultadoDisparo resultado, int x, int y, String[][] tablero);
    public int pedirBarcoAColocar(Usuario usuario);
    public void mostrarBarcosJugador(ModeloBarco[] barcos); //mostrar los barcos para colocarlos
    public int pedirX();
    public int pedirY();
    public boolean pedirVertical();
    public String pedirNombreJugador();
}
