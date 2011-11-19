/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg3;

/**
 *
 * @author KeslerTran
 */
public class NombreTipo {
    private String argumento;
    private boolean tipo;
    /**
     * Argumento es el nombre de la funciona realizar y 
     * tipo nos sirve para diferenciar cual 
     * @param argumento
     * @param tipo True si es una funcion o false si es una constante
     */
    public NombreTipo(String argumentoin, boolean tipo){
        this.argumento=argumentoin;
        this.tipo=tipo;
    }
    public String getArgumento(){
        return this.argumento;
    }
    public boolean getTipo(){
        return this.tipo;
    }
    public String toString(){
        String hola = "Objeto tipo "+argumento +" es del tipo :"+tipo;
        return hola;
    }
}
