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
public class DoStatement extends Statements{
    private String Do;
    private String While;
    private ArrayList<Statements> statements;
    private String Loop;
    private String Until;
    private Expression expression;

    public DoStatement(String Do, String While, ArrayList<Statements> statements, String Loop, String Until, Expression expression) {
        this.Do = Do;
        this.While = While;
        this.statements = statements;
        this.Loop = Loop;
        this.Until = Until;
        this.expression = expression;
    }

    
    
    public String getDo() {
        return Do;
    }

    public void setDo(String Do) {
        this.Do = Do;
    }

    public String getWhile() {
        return While;
    }

    public void setWhile(String While) {
        this.While = While;
    }



    public String getLoop() {
        return Loop;
    }

    public void setLoop(String Loop) {
        this.Loop = Loop;
    }

    public String getUntil() {
        return Until;
    }

    public void setUntil(String Until) {
        this.Until = Until;
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
    
}
