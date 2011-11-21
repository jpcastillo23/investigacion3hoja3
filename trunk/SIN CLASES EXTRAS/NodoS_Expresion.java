/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
/**
 *
 * @author ennio
 */
//Este tiene que tener un metodo para identificar y separarle
//los componentes... (+ 1 2) mandarle el componente de suma
//y ver si hay otro objeto, entonces mandarle el objeto 1 y 2 como hijos
public class NodoS_Expresion {
    private String nombre; //Todo el objeto echo un String
    private String valor;
    private int valorN;
    private boolean Bvalor; //indica si es un numero o un string...
    private String argumento; // lo que va a servir para crear a sus hijos...
    private ArrayList<NodoS_Expresion> Hijos;
    private NodoS_Expresion Padre;
    public NodoS_Expresion( String nombre, boolean Bvalor, String argumento ){
        this.argumento = argumento;
        this.setBvalorTRUE(Bvalor);
        this.nombre = nombre;
        this.setValor(this.getValor(nombre));
        
        if (!this.getBvalorTrue()){
            for(int d = 0; d < this.getArgumentos(nombre).size(); d++){
                NodoS_Expresion temp = new NodoS_Expresion(this.getArgumentos(nombre).get(d), this.getValorB(nombre).get(d), this.getArgumento_Individual(this.getArgumentos(nombre).get(d))    );
                this.Hijos.add(temp);
                 
            }
        }
        
        
    }
    public boolean getBvalorTrue(){
        return this.Bvalor;
    }
    public void setBvalorTRUE(boolean condicion){
        this.Bvalor = condicion;
    }
    //le mando el nombre de mi funcion... y me devuelve el valor...
    //Metodo de Kevin y Manuel...
    public String getValor(String nombre){
        String a= ObjetoFuncion.revelarOperandosOperadores(nombre)[0] ;
        return a;
    }
    //Este metodo te devuelve un array de valores booleanos
    //q revisa si los hijos son numeros...
    public ArrayList<Boolean> getValorB(String nombre){
        ArrayList<Boolean> a = new ArrayList<Boolean>();
        return a;
    }
    //Le mando el nombre del nodo... me devuleve un array con los
    //nodos de mi funcion... hijos... de ese nodo...
    public ArrayList<String> getArgumentos(String argumento){
        
        ArrayList<String> Ejemplo_No_borrar = new ArrayList<String>();
        
        return Ejemplo_No_borrar;
    }
    //El String individual...
    public String getArgumento_Individual(String nombre){
        return "";
    }
    
    //Este metodo todabia no tiene ninguna utilidad... =o..
    public void descendencia(NodoS_Expresion Padre){
        for(int xD = 0; xD < Padre.Hijos.size(); xD++){
            
        }
    }
    public void setValor(String valor){
        this.valor = valor;
    }
    
    //Le asigna un valor a la expresion tomando en cuenta 
    //a sus hijos...
    public int setValorN(){
        if(this.valor=="*"){
            int a = 1;
            for(int i = 0; i< Hijos.size(); i++){
                a *= Hijos.get(i).setValorN();
            }
            return a;
        }else if(this.valor == "/"){
            int a = 1;
            for(int i = 0; i< Hijos.size(); i++){
                a /= Hijos.get(i).setValorN();
            }
            return a;
        }else if(this.valor == "+"){
            int a = 0;
            for(int i = 0; i< Hijos.size(); i++){
                a += Hijos.get(i).setValorN();
            }
            return a;
        }else if(this.valor == "-"){
            int a = 0;
            for(int i = 0; i< Hijos.size(); i++){
                a -= Hijos.get(i).setValorN();
            }
            return a;
        }else {
            //entonces tiene un numero...
            //y no tiene hijos..
             this.valorN = Integer.parseInt(valor);
             return valorN;
        }
        
        
    }
    
    
    
}
