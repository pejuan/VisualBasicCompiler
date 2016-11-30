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
    private ArrayList<Integer> listanumbers;
    private ArrayList<Integer> listanumbersFalse;
    private ArrayList<Integer> listasig;
    public ElseIfStatement(String ElseIf, Expression expression, String Then, ArrayList<Statements> listastatements) {
        this.ElseIf = ElseIf;
        this.expression = expression;
        this.Then = Then;
        this.listastatements = listastatements;
        listanumbers = new ArrayList();
        listanumbersFalse = new ArrayList();
        listasig = new ArrayList();
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

    public ArrayList<Integer> getListanumbers() {
        return listanumbers;
    }

    public void setListanumbers(ArrayList<Integer> listanumbers) {
        this.listanumbers = listanumbers;
    }

    public ArrayList<Integer> getListanumbersFalse() {
        return listanumbersFalse;
    }

    public void setListanumbersFalse(ArrayList<Integer> listanumbersFalse) {
        this.listanumbersFalse = listanumbersFalse;
    }

    public ArrayList<Integer> getListasig() {
        return listasig;
    }

    public void setListasig(ArrayList<Integer> listasig) {
        this.listasig = listasig;
    }
}
