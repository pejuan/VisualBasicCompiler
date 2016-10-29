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
public class BooleanExpression extends Expression{
    private Expression expression1;
    private String operador;
    private Expression expression2;


    public BooleanExpression(Expression expression1, String operador, Expression expression2, String Id) {
        super(Id);
        this.expression1 = expression1;
        this.operador = operador;
        this.expression2 = expression2;
    }
    
    
    public Expression getExpression1() {
        return expression1;
    }

    public void setExpression1(Expression expression1) {
        this.expression1 = expression1;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Expression getExpression2() {
        return expression2;
    }

    public void setExpression2(Expression expression2) {
        this.expression2 = expression2;
    }
    @Override
    public String bringType(){
        return "Boolean";
    }
}
