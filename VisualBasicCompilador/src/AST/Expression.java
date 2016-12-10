/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST;

import java.util.ArrayList;

/**
 *
 * @author Jose Alberto Pejuan
 */
public class Expression extends Statements{
    private String Id;
    private String lugar;
    private ArrayList<Integer> listaverdaderas = new ArrayList();
    private ArrayList<Integer> listafalsas = new ArrayList();
    private String lugarFor;
    public Expression(String Id) {
        this.Id = Id;
    }
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    public String bringType(){
        return "none";
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public ArrayList<Integer> getListaverdaderas() {
        return listaverdaderas;
    }

    public void setListaverdaderas(ArrayList<Integer> listaverdaderas) {
        this.listaverdaderas = listaverdaderas;
    }

    public ArrayList<Integer> getListafalsas() {
        return listafalsas;
    }

    public void setListafalsas(ArrayList<Integer> listafalsas) {
        this.listafalsas = listafalsas;
    }

    public String getLugarFor() {
        return lugarFor;
    }

    public void setLugarFor(String lugarFor) {
        this.lugarFor = lugarFor;
    }

    
    
}
