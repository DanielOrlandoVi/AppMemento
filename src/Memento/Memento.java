
package Memento;
import Termometro.Termometro;

public class Memento {
    
    private Termometro estado;
    
    //Recibe al objeto en analisis o en estudio, en este caso el termometro
    public Memento(Termometro estado){
        this.estado = estado;
    }
    
    public Termometro getEstado(){
        return estado;
    }
}
