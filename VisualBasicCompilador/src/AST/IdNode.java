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
    private int size;
    private int offset;

    public IdNode(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public IdNode(String name, String type, String ambito, int size,int offset) {
        this.name = name;
        this.type = type;
        this.ambito = ambito;
        this.size = size;
        this.offset = offset;
        this.type2 = "Variable";
        this.procedureType = "None";
    }
    
    public IdNode(String name, String type, String ambito, String type2, String procedureType){
        this.name = name;
        this.type = type;
        this.ambito = ambito;
        this.type2 = type2;
        this.procedureType = procedureType;
        this.size = 0;
        this.offset = 0;
    }
    
    public IdNode(String name, String type, String ambito, String type2, String procedureType, int size, int offset){
        this.name = name;
        this.type = type;
        this.ambito = ambito;
        this.type2 = type2;
        this.procedureType = procedureType;
        this.size = size;
        this.offset = offset;
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
    
    public int getSize(){
        return this.size;
    }
    
    public void setSize(int size){
        this.size = size;
    }
    
    public int getOffset(){
        return this.offset;
    }
    
    public void setOffset(int offset){
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "IdNode{" + "name=" + name + ", type=" + type + ", ambito=" + ambito + '}';
    }
    
}
