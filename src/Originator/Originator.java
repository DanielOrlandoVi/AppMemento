
package Originator;
import Termometro.Termometro;
import Memento.Memento;
public class Originator {
    
    //Esta instancia de termometro maneja el estado de este, es decir su temperatura
    private Termometro estado;
    
    public void setEstado(Termometro estado){
        this.estado = estado;
    }
    
    public Termometro getEstado(){
        return estado;
    }
    
    //Al momento de guardar, lo que hacemos es que creamos un nuevo memento con la temperatura especifica
    public Memento guardar(){
        return new Memento(estado);
    }
    
    public void restaurarMemento(Memento memento){
        this.estado = memento.getEstado();
    }
    

}
