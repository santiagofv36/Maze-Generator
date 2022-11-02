/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laberinto;

/**
 *
 * @author Martin
 */
public class Casilla {
    
    private boolean visitado;
    private boolean pared;
    private boolean inicio;
    private boolean fin;
    private int x;
    private int y;
    private Casilla siguiente;
    private Casilla previo;
    private Recorrido vecinos = new Recorrido();


    public Casilla() {
        this.visitado = false;
        this.pared = true;
        this.inicio = false;
        this.fin = false;
        this.siguiente = null;
        this.previo = null;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public boolean isPared() {
        return pared;
    }

    public void setPared(boolean pared) {
        this.pared = pared;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public boolean isFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Casilla getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Casilla siguiente) {
        this.siguiente = siguiente;
    }

    public void addVecinos(Casilla[][] casillas) {
        int dimX = casillas.length;
        int dimY = casillas[0].length;
        int x = this.x;
        int y = this.y;
        
        if(x > 0){
            Casilla vecino = new Casilla();
            vecino.setPosicion(x-1, y);
            vecinos.add(vecino);
        }
        if(x < dimX-1){
            Casilla vecino = new Casilla();
            vecino.setPosicion(x+1, y);
            vecinos.add(vecino);
        }
        if(y > 0){
            Casilla vecino = new Casilla();
            vecino.setPosicion(x, y-1);
            vecinos.add(vecino);
        }
        if(y < dimY-1){
            Casilla vecino = new Casilla();
            vecino.setPosicion(x, y+1);
            vecinos.add(vecino);
        }
    }

    public Recorrido getVecinos() {
        return vecinos;
    }

    public boolean hasUnvisitedNeighbors() {
        for (int i = 0; i < vecinos.getSize(); i++) {
            if(!vecinos.getPrimero().isVisitado()){
                return true;
            }
        }
        return false;
    }

    public Casilla getRandomNeighbor() {
        return vecinos.getRandom();
    }

    public Casilla getPrevio() {
        return previo;
    }

    public void setPrevio(Casilla previo) {
        this.previo = previo;
    }

    
 
}
