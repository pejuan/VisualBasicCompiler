/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualbasiccompilador;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jose Alberto Pejuan
 */
public class Cuadruplo {
    private ArrayList<String> comandos;
    private ArrayList<String> dir1;
    private ArrayList<String> dir2;
    private ArrayList<String> dir3;

    public Cuadruplo() {
        comandos = new ArrayList();
        dir1 = new ArrayList();
        dir2 = new ArrayList();
        dir3 = new ArrayList();
    }
    public void print(){
        System.out.println("--------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < comandos.size(); i++) {
            System.out.format("%20s%20s%20s%20s", comandos.get(i),dir1.get(i),dir2.get(i),dir3.get(i));
            System.out.println("");
        }
    }
    public void generateCode(){
        try{
            ArrayList<String> logicos = new ArrayList(Arrays.asList("Or","And","Xor"));
            ArrayList<String> comp = new ArrayList(Arrays.asList(">","<","<=",">=","==","!="));
            ArrayList<String> operacion = new ArrayList(Arrays.asList("+","-","*","/"));
            PrintWriter writer = new PrintWriter("codigoIntermedio.txt","UTF-8");
        for (int i = 0; i < comandos.size(); i++) {
            
            if (logicos.contains(comandos.get(i))) {
                int aux = logicos.indexOf(comandos.get(i));
                writer.println(dir3.get(i)+"="+dir1.get(i)+" "+logicos.get(aux).toLowerCase()+" "+dir2.get(i));
            }else if(comp.contains(comandos.get(i))){
                int aux = comp.indexOf(comandos.get(i));
                writer.println("if "+dir1.get(i)+comp.get(aux)+dir2.get(i)+" GOTO "+dir3.get(i));
            }else if(comandos.get(i).equals("ETIQ")){
                writer.println(dir3.get(i));
            }else if(comandos.get(i).equals("GOTO")){
                writer.println("GOTO "+dir3.get(i));
            }else if(comandos.get(i).equals("=")){
                writer.println(dir3.get(i)+"="+dir1.get(i));
            }else if(operacion.contains(comandos.get(i))){
                int aux = operacion.indexOf(comandos.get(i));
                writer.println(dir3.get(i)+"="+dir1.get(i)+operacion.get(aux).toLowerCase()+dir2.get(i));
            }else if(comandos.get(i).equals("If")){
                writer.println("if "+dir1.get(i)+" GOTO "+dir3.get(i));
            }else if(comandos.get(i).equals("print")){
                writer.println("print "+dir3.get(i));
            }else if(comandos.get(i).equals("read")){
                writer.println("read "+dir3.get(i));
            }else if(comandos.get(i).equals("FINFUN")){
                writer.println("FINFUN");
            }else if(comandos.get(i).equals("RET")){
                writer.println("RET "+dir3.get(i));
            }
        }
        writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void addNode(String comando,String dir1, String dir2, String dir3){
        comandos.add(comando);
        this.dir1.add(dir1);
        this.dir2.add(dir2);
        this.dir3.add(dir3);
    
    }
    public void addNode(String comando, String dir3){
        comandos.add(comando);
        dir1.add("");
        dir2.add("");
        this.dir3.add(dir3);
    }

    public ArrayList<String> getComandos() {
        return comandos;
    }

    public void setComandos(ArrayList<String> comandos) {
        this.comandos = comandos;
    }
    public int getSize(){
        return comandos.size();
    }
    public ArrayList<String> getDir1() {
        return dir1;
    }

    public void setDir1(ArrayList<String> dir1) {
        this.dir1 = dir1;
    }

    public ArrayList<String> getDir2() {
        return dir2;
    }

    public void setDir2(ArrayList<String> dir2) {
        this.dir2 = dir2;
    }

    public ArrayList<String> getDir3() {
        return dir3;
    }

    public void setDir3(ArrayList<String> dir3) {
        this.dir3 = dir3;
    }
    
    public void complete(ArrayList<Integer> lista, String etiqueta){
        for (int i = 0; i < lista.size(); i++) {
            dir3.set(lista.get(i), etiqueta);
        }
    }
    
    
}
