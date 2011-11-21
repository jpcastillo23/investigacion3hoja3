/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author ennio
 */
public class Funciones {
    //Esta clase tiene la funcion de tomar los parametros y devolver
    //un string que solo sea de sumar o restar...
    private String nombreFuncion;//suma
    private ArrayList<String> variables;
    private String nombre; //toda la expresion de la funcion... ç( + 1 n )
    public Funciones(String nombreFuncion, String nombre, ArrayList<String> variable ){
        this.nombre = nombre;
        this.nombreFuncion = nombreFuncion;
        this.variables=variable;
    }
    public String ingreso (ArrayList<String> valores){
        String editada  = nombre;
        for(int x =0; x <valores.size(); x++){
            editada= editada.replaceAll(""+variables.get(x), ""+valores.get(x));
        }
        return editada;
    }
    public String getNombreFunc(){
        return this.nombreFuncion;
    }
    //devuelve un booleano si se identifica que esta llamando a 
    public ArrayList<String> getArreglo(){
        return variables;
    }
    public String getArreglado(){
        return this.nombre;
    }
    
    public String toString(){
        return "Mi Nombre: "+nombreFuncion+"\nmi funcion: "+nombre+"\nMis variables: "+variables+"";
    }
}
