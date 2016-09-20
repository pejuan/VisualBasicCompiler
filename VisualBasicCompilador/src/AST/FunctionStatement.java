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
public class FunctionStatement {
    private String function;
    private String id;
    private ArrayList<Parameter> parameters;
    private ArrayList<Statements> statements;
    private String dataType;
    private String endFunction;

    public FunctionStatement(String function, String id, ArrayList<Parameter> parameters, ArrayList<Statements> statements, String dataType, String endFunction) {
        this.function = function;
        this.id = id;
        this.parameters = parameters;
        this.statements = statements;
        this.dataType = dataType;
        this.endFunction = endFunction;
    }
    
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getEndFunction() {
        return endFunction;
    }

    public void setEndFunction(String endFunction) {
        this.endFunction = endFunction;
    }
}
