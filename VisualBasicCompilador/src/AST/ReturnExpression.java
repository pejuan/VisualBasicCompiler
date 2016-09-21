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
public class ReturnExpression extends Statements{
    private String Return;
    private Expression expression;

    public ReturnExpression(String Return, Expression expression) {
        this.Return = Return;
        this.expression = expression;
    }
    
    public String getReturn() {
        return Return;
    }

    public void setReturn(String Return) {
        this.Return = Return;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
