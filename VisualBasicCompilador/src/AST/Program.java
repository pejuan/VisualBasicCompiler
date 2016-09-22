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
public class Program {

    private ArrayList<FunctionDeclaration> declarations = new ArrayList();
    


    public ArrayList<FunctionDeclaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(ArrayList<FunctionDeclaration> declarations) {
        this.declarations = declarations;
    }
    
}
