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
public class WhileStatement extends Statements{
    private String While;
    private Expression expression;
    private ArrayList<Statements> statements; //igual tendré que hacer una clase listastatements para pasar el dato en cup
    private String endWhile;

    public WhileStatement(String While, Expression expression, ArrayList<Statements> statements, String endWhile) {
        this.While = While;
        this.expression = expression;
        this.statements = statements;
        this.endWhile = endWhile;
    }
    
    
    public String getWhile() {
        return While;
    }

    public void setWhile(String While) {
        this.While = While;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public ArrayList<Statements> getStatements() {
        return statements;
    }

    public void setStatements(ArrayList<Statements> statements) {
        this.statements = statements;
    }

    public String getEndWhile() {
        return endWhile;
    }

    public void setEndWhile(String endWhile) {
        this.endWhile = endWhile;
    }
}
