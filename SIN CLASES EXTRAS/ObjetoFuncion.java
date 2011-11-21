/* Universidad del valle de guatemala
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jose Pablo Castillo, Kevin Concua, Ennio Guzman
 */

import java.util.Scanner;
import java.util.*;
import java.lang.String;
import java.util.ArrayList;

/**
 * ---------------------    UNIVERSIDAD DEL VALLE DE GUATEMALA   -------------------------
 * AUTOR: @author JayPiCastillo
 * 
 * -Estructura de Datos:  Ing. Douglas Barrios
 * -Carne: 10007
 * -Ing. Mecatronica
 * -HOJA DE TRABAJO: ( ObjetoFuncion )    
 */
public class ObjetoFuncion {

    private boolean tipo;
    private String key;
    private int quevoyahacerconellos;
    private int mi_valor_de_retorno;
    private LinkedList<String> funcionesatom= new LinkedList<String>();
    /**
     *  este me dice si efectivamente ya poseo o no un valor para retornar
     */
    private boolean yatengomivalorderetorno=false;
    /*
     * List que contiene todos los numeros a operar segun el 
     */
    private LinkedList<Integer> numeros_resultados; ;
    
    /**
     * Lo Unico que necesito saber es..que si el boolean es falso significa que es
     * una funcion.. y si es true, es un valor real
     * @param argumento
     * @param constanteofuncion 
     */
    public ObjetoFuncion(String argumento, boolean constanteofuncion){
        inicializarfunciones();         //solo inicializo mis acciones
        this.yatengomivalorderetorno=constanteofuncion;
        //this.key=QuitarParentesisAmbosLados(argumento);//QuitarParentesisAmbosLados
        this.key= argumento;
        //System.out.println("Recibi: "+ argumento);
        if(!yatengomivalorderetorno){
            mi_valor_de_retorno=identificador(key);
        }else{
            mi_valor_de_retorno=QuitarParentesisAmbosLados2(key);//tengo que quitarle los parentesis!!!!
        }
        
    }
    /**
     * Obtento el valor numerico correspondiente al ultimo nodo de la fila
     * @return 
     */
    public int getValorRetorno(){
        return mi_valor_de_retorno;
    }
    /**
    * 
    * Def es la variable que me indica lo que le usuario ingreso 
    * luego me lo separa y revela quienes son los que son CONSTANTES o 
    * quienes son FUNCIONES
    * @param def
    * @return 
    */
    private int identificador(String def){
        
        //---------------variables para comparar------------------------
        // listas es un arreglo donde en las diversas posiciones
        //se encuentra el operador, en el caso de "defun" el numobre de la funcion
        // y tambien los operadores como conjunto.
        String listas[];
        String funciones[];
        String puta; 
        int opcion=0;
        int tamano=0;
        NombreTipo temporal;
        ObjetoFuncion temporal2;
        //mucho es una lista de NOMBRETIPOS
        //QUE identifica a cada funcion con su nivel
        LinkedList mucho = new LinkedList();
        numeros_resultados= new LinkedList<Integer>();
        
        //--------------------------------------------------------------
        
       listas = revelarOperandosOperadores( def );
       /**
        * recordar que te develve solamente en posicion [0] el operador y en posicion [1] los Operandos
        * tambien es necesario recordar que si es una definicion de una funcion asi como DEFUN, entonces
        * la funcion 
        */
       

        mucho= (listas.length==2? grado(listas[1]): grado(listas[2]));
        opcion = evalarOperacion(listas[0]);
        
        //System.out.println("Mucho:"+ mucho+" \n Tamaño "+ mucho.size());
        tamano=mucho.size();
        for(int k=0;k<tamano;k++){ //DejarCorrectamenteParentesis
            temporal = (NombreTipo)mucho.remove();
            temporal2= temporal.getTipo()?new ObjetoFuncion(temporal.getArgumento(), temporal.getTipo()):new ObjetoFuncion(temporal.getArgumento().trim(), temporal.getTipo());
            //System.out.println("Valor de retorno: "+temporal2.getValorRetorno()+ "Indice de contador "+ k);       
            //System.out.println("Contador si hay ciclo infinito:"+i);
            numeros_resultados.add(new Integer(temporal2.getValorRetorno()));
        }
        //Descomentar para ver como se procesan resultados
        //System.out.println(numeros_resultados);
        
        //tengo que crear mis objetos para operar los operandos.
        // posibles funciones a provar
        // ( * ( + 3 2 ) ( - 2 1 ) )
        // ( * ( + (2) (3) ) ( - (2) (1) ) )
        //( * ( + (2) (3) ) ( - (2) (1) ) ( * ( + (2) (3) ) ( - (2) (1) ) ) )
       
        
        return posicion(opcion,numeros_resultados);
    
    }
    /**
     * Indica que hacer con cualquier operando
     * @param opcion
     * @param a_tomar 
     * @return  
     */
    public static int posicion(int opcion, LinkedList<Integer> a_tomar){
//        funcionesatom.add("defun");
//        funcionesatom.add("+");
//        funcionesatom.add("-");
//        funcionesatom.add("*");
//        funcionesatom.add("/");
//        funcionesatom.add("atom");
//        funcionesatom.add("lisp");
//        funcionesatom.add("list");
//        funcionesatom.add("equal");
//        funcionesatom.add("<");
//        funcionesatom.add(">");
//        funcionesatom.add("if");
//        funcionesatom.add("cond");
//        funcionesatom.add("lambda");
        int resultado_acumulado=0, size=a_tomar.size();
        switch(opcion){
            case 0://defun
                for(int r=0;r<size;r++){
                    resultado_acumulado+=(Integer)a_tomar.remove();
                    //System.out.println(resultado_acumulado+"");
                }
                break;
            case 1://sumar
                for(int r=0;r<size;r++){
                    resultado_acumulado+=(Integer)a_tomar.remove();
                    //System.out.println(resultado_acumulado+"");
                }
                break;
            case 2://restar
                resultado_acumulado=(Integer)a_tomar.remove();
                size=a_tomar.size();
                for(int r=0;r<size;r++){
                    resultado_acumulado-=(Integer)a_tomar.remove();
                    //System.out.println(resultado_acumulado+"");
                }
                break;
            case 3://multipicar
                resultado_acumulado=1;
                for(int r=0;r<size;r++){
                    resultado_acumulado*=(Integer)a_tomar.remove();
                }
                break;
            case 4://dividir
                resultado_acumulado=1;
                for(int r=0;r<size;r++){
                    resultado_acumulado/=(Integer)a_tomar.remove();
                }
                break;
            case 5://atom
                System.out.println(" - Funcion no Implementada Todavia - ");
                break;    
            case 6://lisp
                System.out.println(" - Funcion no Implementada Todavia - ");
                break;
            case 7://list
                System.out.println(" - Funcion no Implementada Todavia - ");
                break;
            case 8://equal
                System.out.println(" - Funcion no Implementada Todavia - ");
                break;    
            case 9://<
                System.out.println(" - Funcion no Implementada Todavia - ");
                break;
            case 10://>
                System.out.println(" - Funcion no Implementada Todavia - ");
                break;    
            case 11:
                System.out.println(" - Funcion no Implementada Todavia - ");
                break;
            case 12:
                System.out.println(" - Funcion no Implementada Todavia - ");
                break;    
            case 13:
                System.out.println(" - Funcion no Implementada Todavia - ");
                break;    
            case 14:
                System.out.println(" - Funcion no Implementada Todavia - ");
                break;    
            case 15:
                System.out.println(" - Funcion no Implementada Todavia - ");
                break;  
            default:
                System.out.println(" - Funcion que no ha sido Creada ,\n - Tiene que definirla previamente   ");
                break;
        }
        return resultado_acumulado; 
        
    }
    /**
     * Divide cualquier String en la cantidad necesarias de divisiones
     * de espacions " " para con ello evaluar la operacion
     * @param cualquier
     * @param divisiones 
     * @return  
     */
    public static String[] retornoArreglo(String cualquier, int divisiones){
        String retorno[]= cualquier.split(" ",divisiones);
        return retorno;
        
    }
    /**
     * Cuenta los espacios
     * @param contador
     * @param def 
     * @return  
     */
    public static boolean espacios (int contador, String def){
        
        String espacio=" ";
        if (def.regionMatches(true,contador, espacio, 0, 1)){
            return true;
        }
        else
            return false;
        
    }
    /**
     * Te indica el grado de la funcion de entrada (argumento)
     * haciendo uso del conteo de parentesis interno. "NombreTipo"
     * es un objeto que te indica cual es el argumento a tomar y tambien
     * si efectivamente te devuelve un boolean si es un ENTERO ya, o si es
     * una funcion
     * @param entradain
     * @return  
     */
    public static LinkedList grado (String entradain){
            
            int contador=0,posx =0;
            int contador2=0;
            int grado=0;
            int mal=-1;
            int contador3=0;
            NombreTipo rata;
           

            String parentesis="(";
            String parentesis2=")";
            String temporal ;
            LinkedList nombre = new LinkedList();
            LinkedList nombreratas = new LinkedList();
            int control=0;

            int tamano=entradain.length();
            //System.out.println("lo que recibi fue: "+ entradain);
        while(contador<entradain.length()){
            if(entradain.charAt(contador)=='('){
                control=control+1;
            }
            if(entradain.charAt(contador)==')'){
                control=control-1;
                
                if (control==0) {
                    contador+=1;
                    temporal=entradain.substring(posx, contador);
                    nombre.add(temporal);
                    posx=contador;
                    
                }
            }
            
            contador=contador+1;

        }
        // ( * ( + 3 2 ) ( - 2 1 ) )
                  // ( * ( + (2) (3) ) ( - (2) (1) ) )
        //( * ( + (2) (3) ) ( - (2) (1) ) ( * ( + (2) (3) ) ( - (2) (1) ) ) )
        //ahora la mision es reconocer funciones.
        //estamos aqui recorriento la linkedlist
        //System.out.println(nombre);
        //System.out.println(nombre.size());
        tamano=nombre.size();
        //System.out.println("Procesando Instruccion...");
        while (contador3<tamano){
            //System.out.println("vuelve? "+ contador3);
            temporal=(String)nombre.get(contador3);
            //System.out.println(" Arumento Nuevo:"+temporal + "\t ....  "+ contador3);
            rata = new NombreTipo(temporal, contadorParentesis(temporal));
            nombreratas.add(rata);            
            contador3++;
            
        }

     
        return nombreratas;
    }
    /**
     * Metoro que te indica cuantos parentesis posee un String
     * Nos sirve en "grado" para evaluar el grado del argumento
     * @param def 
     * @return 
     */
    public static boolean contadorParentesis(String def){
        
        int tamano=def.length();
        int contador = 0;
        int control=0;
        String parentesis="(";
        
        while(tamano>0){
            if(def.charAt(contador)=='('){
                control=control+1;
                contador=contador+1;
                tamano=tamano-1;
            }
            else{
                tamano=tamano-1;
                contador=contador+1;
            } 
            if(control>2)   
                break;
        }
        
        if (control>1)
            return false;
        else
            return true;
    }
    /**
     * Metodo que se encarga de tomar el argumento y con ello
     * sacar el Operador y por separado los Operadores
     * 
     * @param OperacionCompleta
     * @return  
     */
    public static String[] revelarOperandosOperadores(String OperacionCompleta){
        
        //evaluar si efectivamente es un DEFUN o si es un operando comun....... 
        //sintaxis de DEFUN  ( defun suma ( n m ) ( + 2 3 ) )
        String OperandoOperadores[];
        String temporal;
        String lista[] =  retornoArreglo(OperacionCompleta,3); //dividir 
        if(lista[1].equals("defun")){
            lista =  retornoArreglo(OperacionCompleta,4);
            temporal = lista[3].substring(0, lista[3].length()-1);   //Metodo que quieta el ultimo parentesis
            OperandoOperadores = new String[3];
            OperandoOperadores [0] = lista[1];   //aqu fijo dice "defun"
            OperandoOperadores [1] = lista[2];   //aqui el nombre de la Funcion
            OperandoOperadores [2] = temporal;   //aqui lleva los operadores del Defun, osea: ( variables) (metodos)
        }
        else{
            temporal = lista[2].substring(0, lista[2].length()-1);   //Metodo que quieta el ultimo parentesis
            OperandoOperadores = new String[2];
            OperandoOperadores [0] = lista[1];
            OperandoOperadores [1] = temporal;
        }
        //System.out.println(""+OperandoOperadores);
        return OperandoOperadores;
    }
    /**
     * Medoto que te indica que operacion he de realizar con 
     * los operandos
     * @param opera 
     * @return 
     */
    public  int evalarOperacion(String opera){
        
        String temp;
        int opcion=0;
        int contador=0;
        boolean r=false;

        for(int t=0;t<funcionesatom.size();t++){
            temp=funcionesatom.get(t);
            if (opera.regionMatches(true,0, temp, 0, temp.length())){
                //System.out.println("funcion:"+temp+":::");
                opcion=t;
                r=true;
                break;
            }else{
                r=false;
            }
            
        }
        //System.out.println(""+opcion);
        return r?opcion: -3;
    }
    /**
     * Este es un metodo que toma el String y le quita los parentesis de ambos lados
     * para que no sean evaluados y solo tenga el valor Numerico
     * @param aquitar
     * @return 
     */
    public static int QuitarParentesisAmbosLados2(String aquitar){
        int g = Integer.parseInt(QuitarParentesisAmbosLados(aquitar));
        return g;
    }
    /**
     * quita los parentesis y los espacios dejando solo los valoresn internos
     * @param aquitar
     * @return
     */
    public static String QuitarParentesisAmbosLados(String aquitar){
        return aquitar.substring(aquitar.indexOf("(")+1, aquitar.indexOf(")")-1).trim();
    }
    /**
     * Quita los espacios enblanco antes de llegar a los parentesis
     * @param aquitar
     * @return
     */
    public static String DejarCorrectamenteParentesis(String aquitar){
        return aquitar.substring(aquitar.indexOf("("), aquitar.indexOf(")")).trim();
    }
    
    /**
     * Metodo que originalmente fue diseñado para que el programado (usuario de Lisp) creara 
     * objetos de comparacion desde la interfaz donde nosotros lo 
     * comparariamos, sin embargo la abstracccion era muy grande. 
     */
    public void inicializarfunciones(){
        //---------------variables para comparar------------------------
        funcionesatom.add("defun");
        funcionesatom.add("+");
        funcionesatom.add("-");
        funcionesatom.add("*");
        funcionesatom.add("/");
        funcionesatom.add("atom");
        funcionesatom.add("lisp");
        funcionesatom.add("list");
        funcionesatom.add("equal");
        funcionesatom.add("<");
        funcionesatom.add(">");
        funcionesatom.add("if");
        funcionesatom.add("cond");
        funcionesatom.add("lambda");
    }
    //public void añadirfunciones(){}
    
}