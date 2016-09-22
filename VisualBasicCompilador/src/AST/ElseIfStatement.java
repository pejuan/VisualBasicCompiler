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
public class ElseIfStatement {
    private String ElseIf;
    private Expression expression;
    private String Then;
    private ArrayList<Statements> listastatements;
    public ElseIfStatement(String ElseIf, Expression expression, String Then, ArrayList<Statements> listastatements) {
        this.ElseIf = ElseIf;
        this.expression = expression;
        this.Then = Then;
        this.listastatements = listastatements;
    }
    
    
    public String getElseIf() {
        return ElseIf;
    }

    public void setElseIf(String ElseIf) {
        this.ElseIf = ElseIf;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String getThen() {
        return Then;
    }

    public void setThen(String Then) {
        this.Then = Then;
    }

    public ArrayList<Statements> getListastatements() {
        return listastatements;
    }

    public void setListastatements(ArrayList<Statements> listastatements) {
        this.listastatements = listastatements;
    }
}
