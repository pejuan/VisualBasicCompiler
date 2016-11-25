/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST;

/**
 *
 * @author Jose Alberto Pejuan
 */
public class IdNode {
    private String name;
    private String type;
    private String ambito;
    private String type2 = new String(); //Si no los inicializo como new String, me tira un null pointer
    private String procedureType = new String(); //Si no los inicializo como new String, me tira un null pointer

    public IdNode(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public IdNode(String name, String type, String ambito) {
        this.name = name;
        this.type = type;
        this.ambito = ambito;
        this.type2 = "Variable";
        this.procedureType = "None";
    }
    
    public IdNode(String name, String type, String ambito, String type2, String procedureType){
        this.name = name;
        this.type = type;
        this.ambito = ambito;
        this.type2 = type2;
        this.procedureType = procedureType;
    }
 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }
    
    public String getProcedureType(){
        return this.procedureType;
    }
    
    public void setProcedureType(String procedureType){
        this.procedureType = procedureType;
    }
    
    public String getType2(){
        return this.type2;
    }
    
    public void setType2(String type2){
        this.type2 = type2;
    }

    @Override
    public String toString() {
        return "IdNode{" + "name=" + name + ", type=" + type + ", ambito=" + ambito + '}';
    }
    
}
