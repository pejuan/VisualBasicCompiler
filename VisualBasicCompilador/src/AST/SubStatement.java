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
public class SubStatement extends FunctionDeclaration{
    private String Sub;
    private String id;
    private ArrayList<Parameter> parameters;
    private ArrayList<Statements> statements;
    private String endSub;

    public SubStatement(String Sub, String id, ArrayList<Parameter> parameters, ArrayList<Statements> statements, String endSub) {
        this.Sub = Sub;
        this.id = id;
        this.parameters = parameters;
        this.statements = statements;
        this.endSub = endSub;
    }
    
    
    public String getSub() {
        return Sub;
    }

    public void setSub(String Sub) {
        this.Sub = Sub;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

    public ArrayList<Statements> getStatements() {
        return statements;
    }

    public void setStatements(ArrayList<Statements> statements) {
        this.statements = statements;
    }

    public String getEndSub() {
        return endSub;
    }

    public void setEndSub(String endSub) {
        this.endSub = endSub;
    }
}
