/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg3;
import java.util.Scanner;
import java.util.*;
import java.lang.String;
import java.util.ArrayList;
/**
 *
 * @author KeslerTran
 */
public class Proyecto3 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner (System.in);
        String def;
        
        String parentesis1="(";
        String parentesis2=")"; //   mistring + ")"
        
        int tamano;
        int contador=0;
        int clasificado;
        int verpos=0;
        int space=0;
        String nombre="", temporal, entradain= "Quiero artar pizza hoy en la noche con zapatos azules";
        int nuevapos=0;
        LinkedList gg = new LinkedList();

        int cont=8;
        
        temporal=entradain.substring(0, 5);
        
        System.out.println(temporal);
        System.out.println("ingrese su codigo: ");
        def=teclado.nextLine();
        tamano=def.length();
        //System.out.println(tamano);
        
        
        identificador(def);
        //gg=grado(def);
        System.out.println("---------   Esto es gg ------------");
        //System.out.println(gg);
        System.out.println("-----------------------------------");
        

        
    }
    /*
     * Def es la variable que me indica lo que le usuario ingreso 
     */
    public static int identificador(String def){
        
        //---------------variables para comparar------------------------
        
        String listas[];
        String funciones[];
        String puta; 
        int opcion=0;
        int tamano=0;
        LinkedList mucho = new LinkedList();
        
        
        //--------------------------------------------------------------
        
       listas = revelarOperandosOperadores( def );
       /* recordar que te develve solamente en posicion [0] el operador y en posicion [1] los Operandos
        * tambien es necesario recordar que si es una definicion de una funcion asi como DEFUN, entonces
        * la funcion 
        */
       
        //funciones = puta.split(") (");
        //System.out.println(funciones);'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
        System.out.println("Argumento Completo: "+listas[1]+":"); //en Litas[2] se encuentra los OPERANDOS como conjunto
        switch(listas.length){
            case 2:
                mucho = grado(listas[1]);
                break;
            case 3: 
                mucho = grado(listas[2]); //significa que es una funcion
                break;
                
        }
        
        System.out.println("Mucho:"+ mucho);
       
        // ( * ( + 3 2 ) ( - 2 1 ) )
                  // ( * ( + (2) (3) ) ( - (2) (1) ) )
        //( * ( + (2) (3) ) ( - (2) (1) ) ( * ( + (2) (3) ) ( - (2) (1) ) ) )
        
        
        
        //p = listas[3].toCharArray();
        
        
        return opcion;
    
    }
    
    public static int posicion(int contador,int opcion){
        if(opcion==1){
            contador=contador+5;
        }
        
        else if(opcion==2){
            contador=contador+1;
        }
        
        else if(opcion==3){
            contador=contador+1;
        }
         
        else if(opcion==4){
            contador=contador+1;
        }
         
        else if(opcion==5){
            contador=contador+1;
        }
         
        else if(opcion==6){
            contador=contador+4;
        }
         
        else if(opcion==7){
            contador=contador+4;
        }
         
        else if(opcion==8){
            contador=contador+5;
        }
         
        else if(opcion==9){
            contador=contador+1;
        } 
        
        else if(opcion==10){
            contador=contador+1;
        }
                
         
        else if(opcion==11){
            contador=contador+2;   
        } 
                 
        else if(opcion==12){
            contador=contador+2;
        }
        
        else if(opcion==13){
            contador=contador+4;
        }
                
        else
            return contador;
        
        return contador; 
        
    }
    
    public static String[] retornoArreglo(String cualquier, int divisiones){
        String retorno[]= cualquier.split(" ",divisiones);
        return retorno;
        
    }
    
    public static LinkedList retornoArregloconFunciones(String adividir){
        int tamano=adividir.length(), contador=0, inicio=0 ,actual=0;
        String manuelito= ") (";
        String retorno[];
        String nuevo_asalir="";
        char encaracteres[]=adividir.toCharArray() ;
        LinkedList nombres = new LinkedList();
        LinkedList indice = new LinkedList();
        
         while(tamano>0){
            if(adividir.regionMatches(true,contador, manuelito, 0, 3)){
                indice.add(contador+1);
                tamano=tamano-1;
                contador+=1;
            }
            
            else 
                contador=contador+1;
                tamano=tamano-1;
        }
        System.out.println(indice);
        
        
        indice.add(encaracteres.length-1);
        actual= (Integer)indice.remove();
        for(int a=0;a<encaracteres.length;a++){
            
            if(a<(Integer)actual){
                nuevo_asalir+=""+encaracteres[a];
            }
            else{ // ( * ( + 3 2 ) ( - 2 1 ) )
                  // ( * ( + (2) (3) ) ( - (2) (1) ) )
                
                nombres.add(nuevo_asalir);
                nuevo_asalir = "";
                try{
                actual= (Integer)indice.remove();
                }catch(Exception w){};
                
            }
        }
        System.out.println();
        return nombres;
    }
    
    public static boolean espacios (int contador, String def){
        
        String espacio=" ";
        if (def.regionMatches(true,contador, espacio, 0, 1)){
            return true;
        }
        else
            return false;
        
    }
    
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
            System.out.println("lo que recibi fue: "+ entradain);
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
        System.out.println(nombre);
        System.out.println(nombre.size());
        tamano=nombre.size();
        
        while (contador3<tamano){
            System.out.println("vuelve? "+ contador3);
            temporal=(String)nombre.get(contador3);
            System.out.println(" Arumento Nuevo:"+temporal + "\t ....  "+ contador3);
            rata = new NombreTipo(temporal, contadorParentesis(temporal));
            
            nombreratas.add(rata);
            
             System.out.println("pas0?? ");
            contador3++;
            
        }

     
        return nombreratas;
    }
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
                
        }
        
        if (control>1)
            return false;
        else
            return true;
    
    }
    
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
        System.out.println(""+OperandoOperadores);
        return OperandoOperadores;
    }
    
    public static int evalarOperacion(String opera)
    {
        //---------------variables para comparar------------------------
            String funcion="defun";
            String suma="+";
            String resta="-";
            String multi="*";
            String div="/";
            String atom="atom";
            String lisp="lisp";
            String equal="equal";
            String menor="<";
            String mayor=">";
            String si="if";
            String manuelito=") (";
            String condicion="cond";
            int opcion=0;
            int contador=0;

            if (opera.regionMatches(true,contador, funcion, 0, 5)){

                System.out.println("funcion");
                opcion=1;


            }

            else if (opera.regionMatches(true,contador, suma, 0, 1)){
                System.out.println("suma");
                opcion=2; 
            }

            else if (opera.regionMatches(true,contador, resta, 0, 1)){
                System.out.println("resta");
                opcion=3; 
            }

            else if (opera.regionMatches(true,contador, multi, 0, 1)){
                System.out.println("multi");
                opcion=4; 
            }

            else if (opera.regionMatches(true,contador, div, 0, 1)){
                System.out.println("div");
                opcion=5; 
            }

            else if (opera.regionMatches(true,contador, atom, 0, 4)){
                System.out.println("atom");  
                opcion=6;
            }

            else if (opera.regionMatches(true, contador, lisp, 0,4)){
                System.out.println("lisp");
                opcion=7;
            }

            else if (opera.regionMatches(true, contador, equal, 0,5)){
                System.out.println("equal");
                opcion=8;
            }

            else if (opera.regionMatches(true, contador, menor, 0,1)){
                System.out.println("<");
                opcion=9;
            }

            else if (opera.regionMatches(true, contador, mayor, 0,1)){
                System.out.println(">");
                opcion=10;
            }

            else if (opera.regionMatches(true, contador, si, 0,2)){
                System.out.println("if");
                opcion=11;
            }

            else if (opera.regionMatches(true, contador, si, 0,2)){
                System.out.println("if");
                opcion=12;
            }

            else if (opera.regionMatches(true, contador, condicion, 0,4)){
                System.out.println("cond");
                opcion=13;
            }
            return opcion;
    }
    
    public static void menu(){
            System.out.println("--------------------------------------------");
            System.out.println("--------------------------------------------");
            System.out.println("-*****----*****-*****----*****----*****-----");
            System.out.println("-*****----*****-*****----*****--*********---");
            System.out.println("-*****----*****-*****----*****-*****-*****--");
            System.out.println("-*****----*****-*****----*****-****---****--");
            System.out.println("-*****----*****--****----****--****---------");
            System.out.println("-*****----*****--*****--*****--****-******--");
            System.out.println("-*****----*****---****--****---****-******--");
            System.out.println("-******--******---**********---****---****--");
            System.out.println("-**************----********----*****-*****--");
            System.out.println("--************------******------*********---");
            System.out.println("----****U*N*I-V-E-R-S*I*D-A-D-----*****-----");
            System.out.println("------------D-E-L---------------------------");
            System.out.println("----------------------V A L L E-------------");
            System.out.println("--------------------------------------------");
    }
}
