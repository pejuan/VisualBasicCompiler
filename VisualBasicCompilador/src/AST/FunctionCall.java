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
public class FunctionCall extends Expression{
    //private String functionCall;
    private ArrayList<Argument> arguments;
    private String returns = "yupi";

    public FunctionCall(ArrayList<Argument> arguments, String Id) {
        super(Id);
        this.arguments = arguments;
    }

    public FunctionCall(ArrayList<Argument> arguments,String Id,String returns) {
        super(Id);
        this.arguments = arguments;
        this.returns = returns;
    }
    
    
    public ArrayList<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<Argument> arguments) {
        this.arguments = arguments;
    }
    @Override
    public String bringType(){
        return getReturns();
    }

    public String getReturns() {
        return returns;
    }

    public void setReturns(String returns) {
        this.returns = returns;
    }
}
