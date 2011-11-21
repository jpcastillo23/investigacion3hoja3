/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ennio
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
/**
     * retorna un true si el argumento es 
     * una CONSTANTE;(un valor numerico)
     * retorna falso si es una funcion 
     * @return 
     */  
    public boolean getTipo(){
        return this.tipo;
    }
    /**
     * Metoro utilizado para que pormedio de iteradores mande a imprimir
     * el objeto y muestre s contenido Interno.
     * @return 
     */
    @Override
    public String toString(){
        String hola = "Objeto tipo "+argumento +" es del tipo :"+tipo+"\n";
        return hola;
    }
}