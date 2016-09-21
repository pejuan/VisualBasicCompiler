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
public class NumericExpression extends Expression{
    private Expression expression1;
    private Expression expression2;
    private String operador;


    public NumericExpression(Expression expression1, Expression expression2, String operador, String Id) {
        super(Id);
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.operador = operador;
    }
    
    
    public Expression getExpression1() {
        return expression1;
    }

    public void setExpression1(Expression expression1) {
        this.expression1 = expression1;
    }

    public Expression getExpression2() {
        return expression2;
    }

    public void setExpression2(Expression expression2) {
        this.expression2 = expression2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
}
