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
public class FunctionDeclarations {//FunctionDeclarations
    private ArrayList<FunctionDeclaration> functionDeclarations;

    public FunctionDeclarations(ArrayList<FunctionDeclaration> functionDeclarations) {
        this.functionDeclarations = functionDeclarations;
    }
    
    public ArrayList<FunctionDeclaration> getFunctionDeclarations() {
        return functionDeclarations;
    }

    public void setFunctionDeclarations(ArrayList<FunctionDeclaration> functionDeclarations) {
        this.functionDeclarations = functionDeclarations;
    }
}
