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
public class IfStatement extends Statements{
    private String IF;
    private Expression expression;
    private String Then;
    private String Else;
    private ArrayList<Statements> statements;
    private ArrayList<ElseIfStatement> elseIfStatements;
    private ElseStatement elseStatements;   
    private String endIf;
    private ArrayList<Integer> listanumbers;
    private ArrayList<Integer> listanumbersFalse;
    private ArrayList<Integer> listasig;
    private String etiqueta;

    public IfStatement(String IF, Expression expression, String Then, String Else, ArrayList<Statements> statements, ArrayList<ElseIfStatement> elseIfStatements, ElseStatement elseStatements, String endIf) {
        this.IF = IF;
        this.expression = expression;
        this.Then = Then;
        this.Else = Else;
        this.statements = statements;
        this.elseIfStatements = elseIfStatements;
        this.elseStatements = elseStatements;
        this.endIf = endIf;
        listanumbers = new ArrayList();
        listanumbersFalse = new ArrayList();
        listasig = new ArrayList();
    }

    
    
    public String getIF() {
        return IF;
    }

    public void setIF(String IF) {
        this.IF = IF;
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

    public String getElse() {
        return Else;
    }

    public void setElse(String Else) {
        this.Else = Else;
    }

    public ArrayList<Statements> getStatements() {
        return statements;
    }

    public void setStatements(ArrayList<Statements> statements) {
        this.statements = statements;
    }


    public ArrayList<ElseIfStatement> getElseIfStatements() {
        return elseIfStatements;
    }

    public void setElseIfStatements(ArrayList<ElseIfStatement> elseIfStatements) {
        this.elseIfStatements = elseIfStatements;
    }

    public String getEndIf() {
        return endIf;
    }

    public void setEndIf(String endIf) {
        this.endIf = endIf;
    }

    public ElseStatement getElseStatements() {
        return elseStatements;
    }

    public void setElseStatements(ElseStatement elseStatements) {
        this.elseStatements = elseStatements;
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

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}
