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
public class ForStatement extends Statements{
    private String For;
    private VariableDeclaration variableDeclaration;
    private String To;
    private Expression expression;
    private String Next;
    private ArrayList<Statements> listastatements = new ArrayList();

    public ForStatement(String For, VariableDeclaration variableDeclaration, String To, Expression expression,ArrayList<Statements> listastatements, String Next) {
        this.For = For;
        this.variableDeclaration = variableDeclaration;
        this.To = To;
        this.expression = expression;
        this.listastatements = listastatements;
        this.Next = Next;
    }
    
    
    public String getFor() {
        return For;
    }

    public void setFor(String For) {
        this.For = For;
    }

    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }

    public void setVariableDeclaration(VariableDeclaration variableDeclaration) {
        this.variableDeclaration = variableDeclaration;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String To) {
        this.To = To;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String getNext() {
        return Next;
    }

    public void setNext(String Next) {
        this.Next = Next;
    }

    public ArrayList<Statements> getListastatements() {
        return listastatements;
    }

    public void setListastatements(ArrayList<Statements> listastatements) {
        this.listastatements = listastatements;
    }
}
