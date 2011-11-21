/**
 * Universidad del valle de Guatemala
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Hashtable;
import java.util.Hashtable.*;
import java.util.Scanner;
import java.util.*;
import java.lang.String;
import java.util.ArrayList;
/**
 *
 * @author Jose Pablo Castill Rodas, Kevin Concua, Ennio Guzman
 */
public class Lisp {
    static Hashtable<String, Funciones> ListaFunciones = new Hashtable<String, Funciones>();
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner (System.in);
        String def;
        
        String parentesis1="(";
        String parentesis2=")"; //   mistring + ")"
        double version= 6.1;
        int clasificado,verpos=0,space=0,rete=0,opcionmenu=9,nuevapos=0,cont=8,tamano,contador=0,counterlinedos=0;
        String nombre="", temporal;
        LinkedList gr = new LinkedList();
        LinkedList<String> gg = new LinkedList<String>();
        ArrayList<String> temp = new ArrayList<String>();
        NombreTipo nuevotemp;
        String descifrar[],trankilo[], arraystrings[];
        Funciones tempk;
        ObjetoFuncion funcionincial;
        boolean lispp,catatonico=false,bandera=true;

        
        menu();
        System.out.println("-Ingrese Comando- ");
        do{
            System.out.println(">CLisp uvg "+counterlinedos+" :");
            def=teclado.nextLine();
            def = def.toLowerCase();
            if(def.equals("exit")){
                break;
            }
            if(def.equals("author")){
                SUBmenu4();
                bandera=false;
            }
            if(def.equals("menu")){
                menu();
                bandera=false;
            }//SUBmenu1()
            if(def.equals("command")){
                SUBmenu1();
                bandera=false;
            }//SUBmenu2() 
            if(def.equals("help")){
                SUBmenu2();
                bandera=false;
            }//SUBmenu3()\n
            if(def.equals("examples")){
                SUBmenu3();
                bandera=false;
            }
            if(def.equals("clear")){
                for(int u=0;u<5;u++){
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                }
                bandera=false;
            }
            if(def.equals("version")){
                System.out.println("Sistema version: "+ version);
                bandera=false;
            }
            if(bandera){ //procesar comandos
                try{
                /*
                 * recordar comandos
                 * defun, +,*,-,/  por ahorita
                 * author
                 */
                //System.out.println(tamano);
               
                
               
                for (int i=0; i<gg.size(); i++){
                    if(def.contains((String)gg.get(i).toLowerCase().toLowerCase())){
                        String whichfuncionselected = gg.get(i);
                        //Se busca encontrar los parametros de la funcion
                        int xP = def.indexOf("(", def.indexOf(whichfuncionselected,0));
                        int xC = def.indexOf(")", def.indexOf(whichfuncionselected,0));
                        String parametrosin = def.substring(xP+1, xC).trim();
                        try{
                            arraystrings = parametrosin.split(" ");
                        }catch(Exception e){
                            arraystrings = new String[1];
                            arraystrings[0]=parametrosin ;
                        };
                        ArrayList<String> no_hace_nada =  new ArrayList<String>();
                            no_hace_nada.addAll(Arrays.asList(arraystrings));
                            tempk = ListaFunciones.get(whichfuncionselected);
                        String editado = tempk.ingreso(no_hace_nada);
                        //que_chinga trae un substring desde el inicio hasta el 
                        String que_chinga = def.substring(def.indexOf(whichfuncionselected,0), xC+1);
                        def = def.replace(que_chinga, editado ).trim();
                        //System.out.println("Nueva Funcion: "+def);
                        
                    }
                                        
                }
               
                
                descifrar= ObjetoFuncion.revelarOperandosOperadores(def);
                lispp= (descifrar.length==2? true: false);//true si tiene defun y false si no lo tiene
                //---aqui se ejecuta la instruccion principal
                if (lispp){
                    funcionincial = new ObjetoFuncion(def, ObjetoFuncion.contadorParentesis(def));
                    System.out.println("\t Resultado: "+ funcionincial.getValorRetorno());
                }
                // procedimiento para guardar funcion "defun "
                else{
                    temp = new ArrayList<String>();
                    String descartar = descifrar[2];                
                    gr = ObjetoFuncion.grado(descartar);
                    nuevotemp = (NombreTipo)gr.remove(0);
                    descartar = parentesisMethod(nuevotemp.getArgumento());
                    //( defun suma ( n ) ( + ( n ) ( 3 ) ) )
                    descartar = (String)ObjetoFuncion.QuitarParentesisAmbosLados(descartar) ;
                    try{
                        trankilo=descartar.split(" ");
                        temp.addAll(Arrays.asList(trankilo));
                    }catch(Exception e){
                        temp.add(descartar);
                    }
                    nuevotemp = (NombreTipo)gr.remove(0);
                    Funciones funcion = new Funciones(descifrar[1], nuevotemp.getArgumento(), temp);;
                    ListaFunciones.put(descifrar[1], funcion);
                    gg.add(descifrar[1]);
                    System.out.println("Listado de Funciones Memorizadas "+ gg);

                }
                
               
                
                }catch (StringIndexOutOfBoundsException e){
                    System.out.println(" - Ilegal Instruction - \n");
                };
                
            }
            bandera=true;
            counterlinedos++;
        }while(true);
         System.out.println(" Exit    Command    Line ");
         System.out.println(" Returning domain to SO");
        
        
    }

    
    /**
     * Solamente quita los parentesis y los deja en un string
     * @param aquitar
     * @return
     */
    public static String parentesisMethod(String aquitar){
        return aquitar.substring(aquitar.indexOf("("), aquitar.indexOf(")")+1).trim();
    }  
   /**
    * este Metodo lo que hace es buscar una cadena dentro de otra, retornando
     * asi la ubicacion del substring sobre el string principal. Este retornaba
     * si efectivamente habia o no una cadena o substring parecido dentro de un 
     * string principal
    * @param def
    * @param busqueda
    * @return
    */
   public static boolean rebicion (String def, String busqueda){
        int tamano=def.length();
        int tamano2=busqueda.length();
        int contador=0;
        boolean verificacion=false;
        
        while (tamano<0){
            if (def.regionMatches(true,contador, busqueda, 0, tamano2)){
                verificacion=true;
                
                
            }
            else{
                contador++;
            }   
        }
        
        return verificacion;
               
    }
   
   /**
    * Metodo suplementario de Rebecion. Su objetivo era no solo 
    * decir si efectivamente se encontraba, sino tambien dar la ubicacion
    * de la subcadena en la cadena principal
    * @param def
    * @param busqueda
    * @return
    */
   public static int rebicion2 (String def, String busqueda){
        int tamano=def.length();
        int tamano2=busqueda.length();
        int contador=0;
        int verificacion=0;
        
        while (tamano<0){
            if (def.regionMatches(true,contador, busqueda, 0, tamano2)){
                verificacion=contador;
                
                
            }
            else{
                contador++;
            }   
        }
        
        return verificacion;
               
    }
    /**
        * METODO CUYA UNICA FUNCION ES DESPLEGAR EL MENU DE FUNCIONES
        *
        * 
        */
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
            System.out.println("--------LISP PROGRAM-----------BY: JC,KC,EG-");
            System.out.println("--------------------------------------------");
    }
   /**
    * Muestra SUbmenu1
    */
   public static void SUBmenu1(){
            System.out.println("--------------------------------------------");
            System.out.println("-------------C O M M A N D S----------------");
            System.out.println("--------------------------------------------");
            System.out.println("----M E N U                          -------");
            System.out.println("----A U T H O R                      -------");
            System.out.println("----V E R S I O N                    -------");
            System.out.println("----C O M M A N D                    -------");
            System.out.println("----V E R S I O N                    -------");
            System.out.println("----H E L P                          -------");
            System.out.println("----E X A M P L E S                  -------");
            System.out.println("----C L E A R                        -------");
            System.out.println("----E X I T                          -------");
            System.out.println("--------------------------------------------");
            System.out.println("--------------------------------------------");
            System.out.println("--------------------------------------------\n");   
    }
    /**
     * Muestra Submenu2
     */
    public static void SUBmenu2(){
            System.out.println("--------------------------------------------");
            System.out.println("----------V E R  F U N C I O N E S----------");
            System.out.println("--------------------------------------------");
            System.out.println("-- OPERADORES:                        ------");
            System.out.println("---   - '*' = MULTIPLICAR             ------");
            System.out.println("---   - '+' = SUMAR                   ------");
            System.out.println("---   - '-' = RESTAR                  ------");
            System.out.println("---   - '/' = DIVIDIR                 ------");
            System.out.println("--------------------------------------------");
            System.out.println("---VALORES:                           ------");
            System.out.println("---   - '( 4 )' = ENTRE '()' Y SPACE  ------");
            System.out.println("--------------------------------------------\n");
    }
    /**
     * Muestra submenu3
     */
    public static void SUBmenu3(){
            System.out.println("--------------------------------------------");
            System.out.println("-----------V E R  E J E M P L O S-----------");
            System.out.println("--------------------------------------------");
            System.out.println("-1. ( * ( 2 ) ( 3 ) )                    ---");
            System.out.println("-       multiplica 2*3, resultado =6     ---");
            System.out.println("--------------------------------------------");
            System.out.println("-2. ( + ( 2 ) ( 2129 ) ( - ( 1 ) ( 6 ) ) ) -");
            System.out.println("-   Puede poner n cantidad de operandos  ---");
            System.out.println("-----------------Resultado = 2126        ---");
            System.out.println("--------------------------------------------");
            System.out.println("-4. Toda constante o variable debe de    ---");
            System.out.println("-   estar dentro de '()'. Asi mismo debe ---");
            System.out.println("-   de estar separado 1 espacio el valor ---");
            System.out.println("----del Parentesis Ejm:  ( n ) o ( 34 )  ---");
            System.out.println("--------------------------------------------");
            System.out.println("-3.( defun sumar ( n ) ( + ( n ) ( 3 ) ) ) -");
            System.out.println("-     Define una funcion llamada sumar   ---");
            System.out.println("-     que suma n + 3, resultado = n+3    ---");
            System.out.println("--------------------------------------------");
            System.out.println("--------------------------------------------\n");
    }
    /**
     * Muestra submenu4
     */
    public static void SUBmenu4(){
            System.out.println("--------------------------------------------");
            System.out.println("--------------- a u t o r e s---------------");
            System.out.println("--------------------------------------------");
            System.out.println("------     K E V I N  C O N C U A      -----");
            System.out.println("------     J O S E  C A S T I L L O    -----");
            System.out.println("------     E N N I O  G U Z M A N      -----");
            System.out.println("--------------------------------------------");
            System.out.println("--------------------------------------------\n");
    }
    
}
