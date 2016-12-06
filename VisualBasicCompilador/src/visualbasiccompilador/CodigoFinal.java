package visualbasiccompilador;
import AST.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author joedhernandez95
 */
public class CodigoFinal {
    
    public final String $v0 = "$v0";
    public final String $v1 = "$v1";
    
    //Argumentos
    public final String $a0 = "$a0";
    public final String $a1 = "$a1";
    public final String $a2 = "$a2";
    public final String $a3 = "$a3";
    
    //Temporales, no se preservan en llamada
    public final String $t0 = "$t0";
    public final String $t1 = "$t1";
    public final String $t2 = "$t2";
    public final String $t3 = "$t3";
    public final String $t4 = "$t4";
    public final String $t5 = "$t5";
    public final String $t6 = "$t6";
    public final String $t7 = "$t7";
    public final String $t8 = "$t8";
    public final String $t9 = "$t9";
    
    //Temporales salvados, se preservan en llamada
    public final String $s0 = "$s0";
    public final String $s1 = "$s1";
    public final String $s2 = "$s2";
    public final String $s3 = "$s3";
    public final String $s4 = "$s4";
    public final String $s5 = "$s5";
    public final String $s6 = "$s6";
    public final String $s7 = "$s7";
    
    public final String $gp = "$gp";
    public final String $sp = "$sp";
    public final String $fp = "$fp";
    public final String $ra = "$ra";
    
    private Cuadruplo cuadruplo;
    private IdTable tabla_simbolos;
    
    private StringBuilder assembly_file = new StringBuilder();
    
    public CodigoFinal(Cuadruplo cuadruplo,IdTable tabla_simbolos){
        this.cuadruplo = cuadruplo;
        this.tabla_simbolos = tabla_simbolos;
    }
    
    public void generateASMFile(){
        try{
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("program.asm"),"utf-8"));
            writer.write(assembly_file.toString());
            writer.flush();
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void generateFinalCode(){
        IdNode main = this.tabla_simbolos.getNode("main"); //Agarramos el nodo main;
        String main_scope = main.getAmbito(); //Agarramos el scope del main
        
        //Agarramos todas las variables del main
        ArrayList<IdNode> main_variables = this.tabla_simbolos.getVariables(main_scope);
        
        
        //Comenzamos a general el texto para el ASM
        
        assembly_file.append(".data\n");
        
        ArrayList<String> comandos_intermedio = this.cuadruplo.getComandos();
        ArrayList<String> direccion1 = this.cuadruplo.getDir1();
        ArrayList<String> direccion2 = this.cuadruplo.getDir2();
        ArrayList<String> direccion3 = this.cuadruplo.getDir3();
        
        //Ponemos todas las variables del main primero
        for(int i = 0; i < direccion3.size(); i++){
            for(IdNode main_variable:main_variables){
                if(main_variable.getName().equals(direccion3.get(i))){
                    if(main_variable.getType().equals("Integer")){
                        assembly_file.append("_"+main_variable.getName()+": .word "+direccion1.get(i)+"\n");
                    }
                    if(main_variable.getType().equals("String")){
                        assembly_file.append("_"+main_variable.getName()+": .asciiz "+direccion1.get(i)+"\n");
                    }
                    if(main_variable.getType().equals("Boolean")){
                        //No se como se guarda boolean en MIPS
                        System.out.println("");
                    }
                }
            
            }
        }
        assembly_file.append("\n.text\n.globl main\n\nmain:\n\t");
    }
}
