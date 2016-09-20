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
public class VariableDeclaration extends Statements{
    private VariableDeclarator variableDeclarator;
    private VariableDeclaration variableDeclaration;

    public VariableDeclaration(VariableDeclarator variableDeclarator, VariableDeclaration variableDeclaration) {
        this.variableDeclarator = variableDeclarator;
        this.variableDeclaration = variableDeclaration;
    }
    
    
    
    public VariableDeclarator getVariableDeclarator() {
        return variableDeclarator;
    }

    public void setVariableDeclarator(VariableDeclarator variableDeclarator) {
        this.variableDeclarator = variableDeclarator;
    }

    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }

    public void setVariableDeclaration(VariableDeclaration variableDeclaration) {
        this.variableDeclaration = variableDeclaration;
    }
}
