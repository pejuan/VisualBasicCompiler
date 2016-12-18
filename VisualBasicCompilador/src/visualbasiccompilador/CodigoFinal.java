package visualbasiccompilador;
import AST.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author joedhernandez95
 */

class PrintMethod{
    private String variable_name;
    private String message;
    
    public PrintMethod(String variable_name,String message){
        this.variable_name = variable_name;
        this.message = message;
    }
    
    public void setVariableName(String variable_name){
        this.variable_name = variable_name;
    }
    
    public String getVariableName(){
        return this.variable_name;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
}

class MainVariables{
    private String variable_name;
    private int amount_found;
    private String variable_type;
    
    public MainVariables(String variable_name, int amount_found){
        this.variable_name = variable_name;
        this.amount_found = amount_found;
    }
    
    public MainVariables(String variable_name, String variable_type){
        this.variable_name = variable_name;
        this.variable_type = variable_type;
        this.amount_found = 0;
    }
    
    public int getAmountFound(){
        return this.amount_found;
    }
    
    public void setAmountFound(int amount_found){
        this.amount_found = amount_found;
    }
    
    public void setVariableName(String variable_name){
        this.variable_name = variable_name;
    }
    
    public String getVariableName(){
        return this.variable_name;
    }
    
    public void setVariableType(String variable_type){
        this.variable_type = variable_type;
    }
    
    public String getVariableType(){
        return this.variable_type;
    }
}


public class CodigoFinal {
    
    private enum OperationType{
        INTEGER_OPERATION
    }
    
    private class Info{
        public String reg;
        public OperationType type;
        
        public Info(String reg, OperationType type){
            this.reg = reg;
            this.type = type;
        }
    }
    
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
    
    private HashMap<String, Boolean> availableTemps = new HashMap<String, Boolean>();
    private HashMap<String, Info> finalTemps = new HashMap<String, Info>();
    
    private StringBuilder assembly_file = new StringBuilder();
    
    public CodigoFinal(Cuadruplo cuadruplo,IdTable tabla_simbolos){
        this.cuadruplo = cuadruplo;
        this.tabla_simbolos = tabla_simbolos;
        
        availableTemps.put($t0, true);
        availableTemps.put($t1, true);
        availableTemps.put($t2, true);
        availableTemps.put($t3, true);
        availableTemps.put($t4, true);
        availableTemps.put($t5, true);
        availableTemps.put($t6, true);
        availableTemps.put($t7, true);
        
    }
    
    public String getAvailableTemp(){
        for(int i = 0; i < 8; i++){
            if(availableTemps.get("$t"+i)){
                availableTemps.put("$t"+i, false);
                return "$t"+i;
            }
        }
        return null;
    }
    
    public void setAvailableTemp(String temp){
        availableTemps.put(temp, true);
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
        ArrayList<IdNode> variables = this.tabla_simbolos.getVariables(main_scope);
        ArrayList<MainVariables> main_variables = new ArrayList<MainVariables>();
        for(int i = 0; i < variables.size(); i++){
            main_variables.add(new MainVariables(variables.get(i).getName(), variables.get(i).getType()));
        }
        
       
        
        //Comenzamos a general el texto para el ASM
        
        assembly_file.append(".data\n");
        
        ArrayList<String> comandos_intermedio = this.cuadruplo.getComandos();
        ArrayList<String> direccion1 = this.cuadruplo.getDir1();
        ArrayList<String> direccion2 = this.cuadruplo.getDir2();
        ArrayList<String> direccion3 = this.cuadruplo.getDir3();
        ArrayList<PrintMethod> imprimir = new ArrayList<PrintMethod>();
        
        //Ponemos todas las variables del main primero
        
        for(int i = 0; i < comandos_intermedio.size(); i++){
            for(MainVariables main_variable:main_variables){
             
                if(main_variable.getVariableName().equals(direccion3.get(i))){
                    if(main_variable.getVariableType().equals("Integer") && comandos_intermedio.get(i).equals("=") ){
                        if(main_variable.getAmountFound() == 0){ //Esto es para que solo las inicialize al principio del .asm
                           assembly_file.append("_"+main_variable.getVariableName()+": .word "+direccion1.get(i)+"\n");
                           main_variable.setAmountFound(1);
                        }
                    }
                    if(main_variable.getVariableType().equals("String") && comandos_intermedio.get(i).equals("=")){
                        assembly_file.append("_"+main_variable.getVariableName()+": .asciiz "+direccion1.get(i)+"\n");
                        main_variable.setAmountFound(1);
                    }
                    if(main_variable.getVariableType().equals("Boolean") && comandos_intermedio.get(i).equals("=")){
                        //No se como se guarda boolean en MIPS
                        System.out.println("");
                    }
                }
            
            }
        }
        
       
         int k = 1;
        //Guardamos los mensajes en bruto en una variable de MIPS
        for(int i = 0; i < comandos_intermedio.size(); i++){
            if(comandos_intermedio.get(i).equals("print")){
                if(direccion3.get(i).matches("[0-9]+")){
                    assembly_file.append("_msg"+k+": .word "+direccion3.get(i)+"\n");
                    imprimir.add(new PrintMethod("_msg"+k,direccion3.get(i)));
                    k++;
                }
                if(direccion3.get(i).matches("[\\\"][\\w\\W]*[\\\"]")){
                    assembly_file.append("_msg"+k+": .asciiz "+direccion3.get(i)+"\n");
                    imprimir.add(new PrintMethod("_msg"+k,direccion3.get(i)));
                    k++;
                }
            }
            
        }
        
        
        assembly_file.append("\n.text\n.globl main\n\nmain:\n");
        
        
        
        //Todas las operaciones se hacen aqui
        for(int i = 0; i < comandos_intermedio.size(); i++){
            String comando = comandos_intermedio.get(i);
            
            
            switch(comando){
                //Imprimir
                case "print":{
                    if(direccion3.get(i).matches("[0-9]+")){ //Si el mensaje es un entero
                        assembly_file.append("\tli "+$v0+", 1\n");
                        assembly_file.append("\tlw "+$a0+",");
                    }
                    
                    if(direccion3.get(i).matches("[\\\"][\\w\\W]*[\\\"]")){ //Si el mensaje es alfanumerico o variable
                        
                        assembly_file.append("\tli "+$v0+", 4\n");
                        assembly_file.append("\tla "+$a0+","); 
                    }else{
                       for(MainVariables main_variable:main_variables){
                            if(main_variable.getVariableName().equals(direccion3.get(i)) && main_variable.getVariableType().equals("Integer")){
                                assembly_file.append("\tli "+$v0+", 1\n");
                                assembly_file.append("\tlw "+$a0+",");
                                assembly_file.append("_"+main_variable.getVariableName()+"\n");
                            }else if (main_variable.getVariableName().equals(direccion3.get(i)) && main_variable.getVariableType().equals("String")){
                                assembly_file.append("\tli "+$v0+", 4\n");
                                assembly_file.append("\tla "+$a0+",");
                                assembly_file.append("_"+main_variable.getVariableName()+"\n");
                            }
                        } 
                    }
                    
                    for(PrintMethod print:imprimir){
                        if(print.getMessage().equals(direccion3.get(i))){
                            assembly_file.append(print.getVariableName()+"\n");
                        }
                    }
                    assembly_file.append("\tsyscall\n\n");
                    break;
                }
                    //Leer (solo enteros)
                case "read":{
                    for(MainVariables main_variable: main_variables){
                        
                        if(main_variable.getVariableName().equals(direccion3.get(i))){
                            assembly_file.append("\tli "+$v0+", 5");
                            assembly_file.append("\n\tsyscall\n");
                            assembly_file.append("\tsw "+$v0+",_"+main_variable.getVariableName()+"\n\n");
                        }
                    }
                    break;
                }
                case "+":{
                    String t3 = null;
                    OperationType type = null;
                    String t1 = null;
                    if(finalTemps.get(direccion1.get(i)) != null){
                        t1 = finalTemps.get(direccion1.get(i)).reg;
                        type = finalTemps.get(direccion1.get(i)).type;
                    }else{
                        if(direccion1.get(i).matches("[0-9]+")){
                            t1 = getAvailableTemp();
                            assembly_file.append("\tli "+t1+", "+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            t1 = getAvailableTemp();
                            assembly_file.append("\tlw "+t1+", _"+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }
                    }
                    
                    String t2 = null;
                    if(finalTemps.get(direccion2.get(i)) != null){
                        t2 = finalTemps.get(direccion2.get(i)).reg;
                        type = finalTemps.get(direccion2.get(i)).type;
                    }else{
                        if(direccion2.get(i).matches("[0-9]+")){
                            t2 = getAvailableTemp();
                            assembly_file.append("\tli "+t2+", "+direccion2.get(i)+"\n");
                            
                        }else{
                            t2 = getAvailableTemp();
                            assembly_file.append("\tlw "+t2+",_"+direccion2.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }
                    }
                    
                    if(type == OperationType.INTEGER_OPERATION){
                        t3 = getAvailableTemp();
                        assembly_file.append("\tadd "+t3+", "+t1+", "+t2+"\n");
                        if(this.tabla_simbolos.getNode(direccion3.get(i)) != null){
                            
                            assembly_file.append("\tsw "+t3+",_"+direccion3.get(i)+"\n");
                            setAvailableTemp(t3);
                        }else{
                            
                            finalTemps.put(direccion3.get(i), new Info(t3,type));
                            if(finalTemps.get(direccion1.get(i)) != null){
                                finalTemps.remove(direccion1.get(i));
                            }
                            
                            if(finalTemps.get(direccion2.get(i)) != null){
                                finalTemps.remove(direccion2.get(i));
                            }
                        }
                    }
                    setAvailableTemp(t1);
                    setAvailableTemp(t2);
                    
                    break;
                }
                case "-":{
                    String t3 = null;
                    OperationType type = null;
                    String t1 = null;
                    if(finalTemps.get(direccion1.get(i)) != null){
                        t1 = finalTemps.get(direccion1.get(i)).reg;
                        type = finalTemps.get(direccion1.get(i)).type;
                    }else{
                        if(direccion1.get(i).matches("[0-9]+")){
                            t1 = getAvailableTemp();
                            assembly_file.append("\tli "+t1+", "+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            t1 = getAvailableTemp();
                            assembly_file.append("\tlw "+t1+", _"+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }
                    }
                    
                    String t2 = null;
                    if(finalTemps.get(direccion2.get(i)) != null){
                        t2 = finalTemps.get(direccion2.get(i)).reg;
                        type = finalTemps.get(direccion2.get(i)).type;
                    }else{
                        if(direccion2.get(i).matches("[0-9]+")){
                            t2 = getAvailableTemp();
                            assembly_file.append("\tli "+t2+", "+direccion2.get(i)+"\n");
                            
                        }else{
                            t2 = getAvailableTemp();
                            assembly_file.append("\tlw "+t2+",_"+direccion2.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }
                    }
                    
                    if(type == OperationType.INTEGER_OPERATION){
                        t3 = getAvailableTemp();
                        assembly_file.append("\tsub "+t3+", "+t1+", "+t2+"\n");
                        if(this.tabla_simbolos.getNode(direccion3.get(i)) != null){
                            
                            assembly_file.append("\tsw "+t3+",_"+direccion3.get(i)+"\n");
                            setAvailableTemp(t3);
                        }else{
                            
                            finalTemps.put(direccion3.get(i), new Info(t3,type));
                            if(finalTemps.get(direccion1.get(i)) != null){
                                finalTemps.remove(direccion1.get(i));
                            }
                            
                            if(finalTemps.get(direccion2.get(i)) != null){
                                finalTemps.remove(direccion2.get(i));
                            }
                        }
                    }
                    setAvailableTemp(t1);
                    setAvailableTemp(t2);
                    break;
                }
                case "*":{
                    String t3 = null;
                    OperationType type = null;
                    String t1 = null;
                    if(finalTemps.get(direccion1.get(i)) != null){
                        t1 = finalTemps.get(direccion1.get(i)).reg;
                        type = finalTemps.get(direccion1.get(i)).type;
                    }else{
                        if(direccion1.get(i).matches("[0-9]+")){
                            t1 = getAvailableTemp();
                            assembly_file.append("\tli "+t1+", "+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            t1 = getAvailableTemp();
                            assembly_file.append("\tlw "+t1+", _"+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }
                    }
                    
                    String t2 = null;
                    if(finalTemps.get(direccion2.get(i)) != null){
                        t2 = finalTemps.get(direccion2.get(i)).reg;
                        type = finalTemps.get(direccion2.get(i)).type;
                    }else{
                        if(direccion2.get(i).matches("[0-9]+")){
                            t2 = getAvailableTemp();
                            assembly_file.append("\tli "+t2+", "+direccion2.get(i)+"\n");
                            
                        }else{
                            t2 = getAvailableTemp();
                            assembly_file.append("\tlw "+t2+",_"+direccion2.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }
                    }
                    
                    if(type == OperationType.INTEGER_OPERATION){
                        t3 = getAvailableTemp();
                        assembly_file.append("\tmul "+t3+", "+t1+", "+t2+"\n");
                        if(this.tabla_simbolos.getNode(direccion3.get(i)) != null){
                            
                            assembly_file.append("\tsw "+t3+",_"+direccion3.get(i)+"\n");
                            setAvailableTemp(t3);
                        }else{
                            
                            finalTemps.put(direccion3.get(i), new Info(t3,type));
                            if(finalTemps.get(direccion1.get(i)) != null){
                                finalTemps.remove(direccion1.get(i));
                            }
                            
                            if(finalTemps.get(direccion2.get(i)) != null){
                                finalTemps.remove(direccion2.get(i));
                            }
                        }
                    }
                    setAvailableTemp(t1);
                    setAvailableTemp(t2);
                    break;
                }
                case "/":{
                    String t3 = null;
                    OperationType type = null;
                    String t1 = null;
                    if(finalTemps.get(direccion1.get(i)) != null){
                        t1 = finalTemps.get(direccion1.get(i)).reg;
                        type = finalTemps.get(direccion1.get(i)).type;
                    }else{
                        if(direccion1.get(i).matches("[0-9]+")){
                            t1 = getAvailableTemp();
                            assembly_file.append("\tli "+t1+", "+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            t1 = getAvailableTemp();
                            assembly_file.append("\tlw "+t1+", _"+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }
                    }
                    
                    String t2 = null;
                    if(finalTemps.get(direccion2.get(i)) != null){
                        t2 = finalTemps.get(direccion2.get(i)).reg;
                        type = finalTemps.get(direccion2.get(i)).type;
                    }else{
                        if(direccion2.get(i).matches("[0-9]+")){
                            t2 = getAvailableTemp();
                            assembly_file.append("\tli "+t2+", "+direccion2.get(i)+"\n");
                            
                        }else{
                            t2 = getAvailableTemp();
                            assembly_file.append("\tlw "+t2+",_"+direccion2.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }
                    }
                    
                    if(type == OperationType.INTEGER_OPERATION){
                        t3 = getAvailableTemp();
                        assembly_file.append("\tdiv "+t3+", "+t1+", "+t2+"\n");
                        if(this.tabla_simbolos.getNode(direccion3.get(i)) != null){
                            assembly_file.append("\tsw "+t3+",_"+direccion3.get(i)+"\n");
                            setAvailableTemp(t3);
                        }else{
                            
                            finalTemps.put(direccion3.get(i), new Info(t3,type));
                            if(finalTemps.get(direccion1.get(i)) != null){
                                finalTemps.remove(direccion1.get(i));
                            }
                            
                            if(finalTemps.get(direccion2.get(i)) != null){
                                finalTemps.remove(direccion2.get(i));
                            }
                        }
                    }
                    setAvailableTemp(t1);
                    setAvailableTemp(t2);
                    break;
                }
                
                case "=":{
                    
                    OperationType type = null;
                    
                    if(direccion1.get(i).matches("[0-9]+")){
                        for(MainVariables main_variable:main_variables){
                            if(direccion3.get(i).equals(main_variable.getVariableName())){
                                if(main_variable.getAmountFound() < 0){
                                    String t1 = null;
                                    if(finalTemps.get(direccion1.get(i)) != null){
                                        t1 = finalTemps.get(direccion1.get(i)).reg;
                                        type = finalTemps.get(direccion1.get(i)).type;
                                    }else{
                                        t1 = getAvailableTemp();
                                        assembly_file.append("\tli " + t1 + "," + direccion1.get(i) + "\n");
                                    }
                                    assembly_file.append("\tsw " + t1 + ",_" + direccion3.get(i)+"\n");

                                    setAvailableTemp(t1);
                                    if (finalTemps.get(direccion1.get(i)) != null) {
                                        finalTemps.remove(direccion1.get(i));
                                    }
                                }
                            }
                        }
                        
                    }else{
                        if(this.tabla_simbolos.getNode(direccion1.get(i)) != null){
                            for(MainVariables main_variable:main_variables){
                                if(main_variable.getAmountFound() < 0){
                                    if(main_variable.getVariableType().equals("Integer")){
                                        String t1 = getAvailableTemp();
                                        assembly_file.append("\tlw " + t1 + ", " + direccion1.get(i) + "\n");
                                        assembly_file.append("\tsw " + t1 + ",_" + direccion3.get(i) + "\n");
                                
                                        setAvailableTemp(t1);
                                    }
                                }
                            }
                        }else{
                            String t1 = finalTemps.get(direccion1.get(i)).reg;
                            type = finalTemps.get(direccion1.get(i)).type;

                            if (type == OperationType.INTEGER_OPERATION) {
                                assembly_file.append("\tsw " + t1 + ",_" + direccion3.get(i)+"\n");
                            }
                            setAvailableTemp(t1);
                        }
                    }
                    break;
                }
                case "GOTO":{
                    assembly_file.append("\tb _"+direccion3.get(i)+"\n\n");
                    break;
                }
                
                case "ETIQ":{
                    assembly_file.append("_"+direccion3.get(i)+":\n\n");
                    break;
                }
                case "If<":{
                    String t1 = null;
                    String t2 = null;
                    OperationType type = null;
                    
                    //Operando1
                    if(finalTemps.get(direccion1.get(i)) != null){
                        t1 = finalTemps.get(direccion1.get(i)).reg;
                        type = finalTemps.get(direccion1.get(i)).type;
                    }else{
                        if(direccion1.get(i).matches("[0-9]+")){
                            t1 = getAvailableTemp();
                            assembly_file.append("li "+t1+", "+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t1 = getAvailableTemp();
                                assembly_file.append("\tlw "+t1+", _"+direccion1.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    //Operando2
                    if(finalTemps.get(direccion2.get(i)) != null){
                        t2 = finalTemps.get(direccion2.get(i)).reg;
                        type = finalTemps.get(direccion2.get(i)).type;
                    }else{
                        if(direccion2.get(i).matches("[0-9]+")){
                            t2 = getAvailableTemp();
                            assembly_file.append("li "+t2+", "+direccion2.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t2 = getAvailableTemp();
                                assembly_file.append("\tlw "+t2+", _"+direccion2.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    if(type == OperationType.INTEGER_OPERATION){
                        assembly_file.append("\tblt "+t1+", "+t2+", _"+direccion3.get(i)+"\n");
                    }
                    setAvailableTemp(t1);
                    setAvailableTemp(t2);
                    break;
                }
                case "If>":{
                    String t1 = null;
                    String t2 = null;
                    OperationType type = null;
                    
                    //Operando1
                    if(finalTemps.get(direccion1.get(i)) != null){
                        t1 = finalTemps.get(direccion1.get(i)).reg;
                        type = finalTemps.get(direccion1.get(i)).type;
                    }else{
                        if(direccion1.get(i).matches("[0-9]+")){
                            t1 = getAvailableTemp();
                            assembly_file.append("li "+t1+", "+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t1 = getAvailableTemp();
                                assembly_file.append("\tlw "+t1+", _"+direccion1.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    //Operando2
                    if(finalTemps.get(direccion2.get(i)) != null){
                        t2 = finalTemps.get(direccion2.get(i)).reg;
                        type = finalTemps.get(direccion2.get(i)).type;
                    }else{
                        if(direccion2.get(i).matches("[0-9]+")){
                            t2 = getAvailableTemp();
                            assembly_file.append("li "+t2+", "+direccion2.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t2 = getAvailableTemp();
                                assembly_file.append("\tlw "+t2+", _"+direccion2.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    if(type == OperationType.INTEGER_OPERATION){
                        assembly_file.append("\tbgt "+t1+", "+t2+", _"+direccion3.get(i)+"\n");
                    }
                    setAvailableTemp(t1);
                    setAvailableTemp(t2);
                    break;
                }
                case "If<=":{
                    String t1 = null;
                    String t2 = null;
                    OperationType type = null;
                    
                    //Operando1
                    if(finalTemps.get(direccion1.get(i)) != null){
                        t1 = finalTemps.get(direccion1.get(i)).reg;
                        type = finalTemps.get(direccion1.get(i)).type;
                    }else{
                        if(direccion1.get(i).matches("[0-9]+")){
                            t1 = getAvailableTemp();
                            assembly_file.append("li "+t1+", "+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t1 = getAvailableTemp();
                                assembly_file.append("\tlw "+t1+", _"+direccion1.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    //Operando2
                    if(finalTemps.get(direccion2.get(i)) != null){
                        t2 = finalTemps.get(direccion2.get(i)).reg;
                        type = finalTemps.get(direccion2.get(i)).type;
                    }else{
                        if(direccion2.get(i).matches("[0-9]+")){
                            t2 = getAvailableTemp();
                            assembly_file.append("li "+t2+", "+direccion2.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t2 = getAvailableTemp();
                                assembly_file.append("\tlw "+t2+", _"+direccion2.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    if(type == OperationType.INTEGER_OPERATION){
                        assembly_file.append("\tble "+t1+", "+t2+", _"+direccion3.get(i)+"\n");
                    }
                    setAvailableTemp(t1);
                    setAvailableTemp(t2);
                    break;
                }
                case "If>=":{
                    String t1 = null;
                    String t2 = null;
                    OperationType type = null;
                    
                    //Operando1
                    if(finalTemps.get(direccion1.get(i)) != null){
                        t1 = finalTemps.get(direccion1.get(i)).reg;
                        type = finalTemps.get(direccion1.get(i)).type;
                    }else{
                        if(direccion1.get(i).matches("[0-9]+")){
                            t1 = getAvailableTemp();
                            assembly_file.append("li "+t1+", "+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t1 = getAvailableTemp();
                                assembly_file.append("\tlw "+t1+", _"+direccion1.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    //Operando2
                    if(finalTemps.get(direccion2.get(i)) != null){
                        t2 = finalTemps.get(direccion2.get(i)).reg;
                        type = finalTemps.get(direccion2.get(i)).type;
                    }else{
                        if(direccion2.get(i).matches("[0-9]+")){
                            t2 = getAvailableTemp();
                            assembly_file.append("li "+t2+", "+direccion2.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t2 = getAvailableTemp();
                                assembly_file.append("\tlw "+t2+", _"+direccion2.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    if(type == OperationType.INTEGER_OPERATION){
                        assembly_file.append("\tbge "+t1+", "+t2+", _"+direccion3.get(i)+"\n");
                    }
                    setAvailableTemp(t1);
                    setAvailableTemp(t2);
                    break;
                }
                case "If!=":{
                    String t1 = null;
                    String t2 = null;
                    OperationType type = null;
                    
                    //Operando1
                    if(finalTemps.get(direccion1.get(i)) != null){
                        t1 = finalTemps.get(direccion1.get(i)).reg;
                        type = finalTemps.get(direccion1.get(i)).type;
                    }else{
                        if(direccion1.get(i).matches("[0-9]+")){
                            t1 = getAvailableTemp();
                            assembly_file.append("li "+t1+", "+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t1 = getAvailableTemp();
                                assembly_file.append("\tlw "+t1+", _"+direccion1.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    //Operando2
                    if(finalTemps.get(direccion2.get(i)) != null){
                        t2 = finalTemps.get(direccion2.get(i)).reg;
                        type = finalTemps.get(direccion2.get(i)).type;
                    }else{
                        if(direccion2.get(i).matches("[0-9]+")){
                            t2 = getAvailableTemp();
                            assembly_file.append("li "+t2+", "+direccion2.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t2 = getAvailableTemp();
                                assembly_file.append("\tlw "+t2+", _"+direccion2.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    if(type == OperationType.INTEGER_OPERATION){
                        assembly_file.append("\tbne "+t1+", "+t2+", _"+direccion3.get(i)+"\n");
                    }
                    setAvailableTemp(t1);
                    setAvailableTemp(t2);
                    break;
                }
                case "If=":{
                    String t1 = null;
                    String t2 = null;
                    OperationType type = null;
                    
                    //Operando1
                    if(finalTemps.get(direccion1.get(i)) != null){
                        t1 = finalTemps.get(direccion1.get(i)).reg;
                        type = finalTemps.get(direccion1.get(i)).type;
                    }else{
                        if(direccion1.get(i).matches("[0-9]+")){
                            t1 = getAvailableTemp();
                            assembly_file.append("li "+t1+", "+direccion1.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t1 = getAvailableTemp();
                                assembly_file.append("\tlw "+t1+", _"+direccion1.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    //Operando2
                    if(finalTemps.get(direccion2.get(i)) != null){
                        t2 = finalTemps.get(direccion2.get(i)).reg;
                        type = finalTemps.get(direccion2.get(i)).type;
                    }else{
                        if(direccion2.get(i).matches("[0-9]+")){
                            t2 = getAvailableTemp();
                            assembly_file.append("li "+t2+", "+direccion2.get(i)+"\n");
                            type = OperationType.INTEGER_OPERATION;
                        }else{
                            if(this.tabla_simbolos.getNode(direccion1.get(i)).getType().equals("Integer")){
                                t2 = getAvailableTemp();
                                assembly_file.append("\tlw "+t2+", _"+direccion2.get(i)+"\n");
                                type = OperationType.INTEGER_OPERATION;
                            }
                        }
                    }
                    
                    if(type == OperationType.INTEGER_OPERATION){
                        assembly_file.append("\tbeq "+t1+", "+t2+", _"+direccion3.get(i)+"\n");
                    }
                    setAvailableTemp(t1);
                    setAvailableTemp(t2);
                    break;
                }
            }
        }
        
        assembly_file.append("\n\tli "+$v0+",10\n\tsyscall\n");
    }
   
}
