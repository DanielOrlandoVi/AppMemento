
package Caretaker;
import Memento.Memento;
import java.util.ArrayList;

public class Caretaker {
    private ArrayList<Memento> mementos= new ArrayList<>();
    
    //Anadimos el memento al arraylist
    public void addMemento(Memento memento){
        mementos.add(memento);
    }
    
    //retornamos el memento atraves del indice en el arraylist que es el dia en que se toma la temperatura
    //dia 0 es la primera temperatura tomada o temperatura actual
    
    public Memento getMemento(int dia){
        return mementos.get(dia);
    }
    
}
