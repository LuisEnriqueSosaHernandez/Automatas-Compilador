package javacc;


import java.util.Hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LESH
 */
public class VerificacionToken {
    private static Hashtable tabla=new Hashtable();

   
    public static void InsertarDeclaracion(String identificador,int tipo){
        tabla.put(identificador, tipo);
        
    }
    public static boolean Existencia(String token){
        if(tabla.isEmpty()){
            return true;
        }
        else if(tabla.get(token)!=null){
            return true;
        }
        return false;
    }
    public static void vaciar(){
        tabla.clear();
    }
    public static String mostrar(){
        return tabla.toString();
    }
    
}
