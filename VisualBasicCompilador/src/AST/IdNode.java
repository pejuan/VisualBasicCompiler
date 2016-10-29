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
    private String ambito = "none";

    public IdNode(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public IdNode(String name, String type, String ambito) {
        this.name = name;
        this.type = type;
        this.ambito = ambito;
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

    @Override
    public String toString() {
        return "IdNode{" + "name=" + name + ", type=" + type + ", ambito=" + ambito + '}';
    }
    
}
