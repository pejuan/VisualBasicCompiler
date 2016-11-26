/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualbasiccompilador;

import java.util.ArrayList;

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
    
    
}