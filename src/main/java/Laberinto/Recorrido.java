package Laberinto;

public class Recorrido {
 
    private Casilla primero;
    private Casilla ultimo;
    private int size;

    public Recorrido() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    // add the next casilla and point to the previous one
    public void add(Casilla casilla){
        if(this.primero == null){
            primero = casilla;
            ultimo = casilla;
        }
        else{
            ultimo.setSiguiente(casilla);
            casilla.setPrevio(ultimo);
            ultimo = casilla;
        }
        size++;
    }


    public Casilla getPrimero() {
        return primero;
    }

    public void setPrimero(Casilla primero) {
        this.primero = primero;
    }

    public Casilla getUltimo() {
        return ultimo;
    }

    public void setUltimo(Casilla ultimo) {
        this.ultimo = ultimo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void print(){
        // int counter = 0;

        Casilla aux = this.primero;
        while (aux != null){
            System.out.println(aux.getX() + " " + aux.getY());
            aux = aux.getSiguiente();
        }
    }

    public boolean isEmpty(){
        return primero == null;
    }

    public Casilla getRandom() {;
        int random = (int) (Math.random() * this.size);
        int counter = 0;
        Casilla aux = this.primero;
        while ( aux != null && counter != random){
            counter++;
            aux = aux.getSiguiente();
        } 

        return aux;
    }

    public void remove(Casilla casilla){
        if(casilla == primero){
            primero = primero.getSiguiente();
            primero.setPrevio(null);
        }
        else if(casilla == ultimo){
            ultimo = ultimo.getPrevio();
            ultimo.setSiguiente(null);
        }
        else{
            //check if previo is null
            if(casilla.getPrevio() != null){
                casilla.getPrevio().setSiguiente(casilla.getSiguiente());
            }
            //check if siguiente is null
            if(casilla.getSiguiente() != null){
                casilla.getSiguiente().setPrevio(casilla.getPrevio());
            }

        }
        size--;
    }

    public Casilla pop(){
        Casilla aux = this.primero;
        this.primero = this.primero.getSiguiente();
        this.primero.setPrevio(null);
        size--;
        return aux;
    }



}
