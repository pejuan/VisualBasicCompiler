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
public class Argument {
    private Expression expression;

    public Argument(Expression expression) {
        this.expression = expression;
    }
    
    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
