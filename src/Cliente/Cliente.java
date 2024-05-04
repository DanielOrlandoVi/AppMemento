
package Cliente;
import Caretaker.Caretaker;
import Memento.Memento;
import Originator.Originator;
import Termometro.Termometro;
import javax.swing.JOptionPane;

public class Cliente {
    
public static void main(String[] args){
    //Programa que simula un control diario de temperatura  donde la temperatura de cada día es un memento
    //El patron memento permite guardar y restaurar el estado anterior de un objeto sin revelar los detalles de su implementación.
    //Aqui lo que hacemos es guardar nuestros estados de temperatura(mementos) del termostato(objeto) para poder verlos despues
    
    
    // Opciones de roles disponibles
        String opciones[] = {"Anadir temperatura del dia", "Consulta de temperaturas", "Salir"};

        
        String nombreTerm = "Termometro Steren";
        // Bucle infinito hasta que se seleccione la opción "Salir"
        
        Termometro term = new Termometro();
        
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        
        while (true) {

            // Solicita al usuario que seleccione un rol
            String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion:", "Gestor de temperaturas",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            // Si el usuario cierra el cuadro de diálogo o selecciona "Salir", se termina el programa
            if (opcion == null || opcion.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                break;
            }
                               
            // Dependiendo de la opcion seleccionada, se realizan diferentes acciones
            switch (opcion) {
                case "Anadir temperatura del dia":
                    int numTemp = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la temperatura(°C) del dia: "));
                    
                    term = new Termometro();
                    
                    term.setTemperatura(numTemp);
                    originator.setEstado(term);
                    //Creamos el memento con originator.guardar() y lo añadimos al arraylist de caretaker
                    caretaker.addMemento(originator.guardar());                    
                    
                    break;
                case "Consulta de temperaturas":
                    //le restamos -1 al dia para no tener problemas con las posiciones del arraylist
                    int dia = (Integer.parseInt(JOptionPane.showInputDialog("Introduzca el dia al que quiere "
                            + "consultar la temperatura: "))) - 1;
                    
                    //Obtenemos el memento y lo restauramos
                    
                    originator.restaurarMemento(caretaker.getMemento(dia));
                    
                    term = originator.getEstado();
                    
                    JOptionPane.showMessageDialog(null, "El termometro: "+ term.getNombre() +
                            "\nTuvo una temperatura de " + term.getTemperatura() + "°C el dia " + (dia + 1));
                    break;
                case "Salir":
                    // Termina el programa
                    System.exit(0);
                    break;

                default:
                    // Si se selecciona una opción no válida, se muestra un mensaje de error
                    JOptionPane.showMessageDialog(null, "Tipo de opcion no valida.");
                    return;
            }
        }

 }
}
