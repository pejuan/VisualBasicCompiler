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
public class LogicalExpression extends Expression{
    private Boolean value;
    private String operador;
    private Expression expression1;
    private Expression expression2;

    public LogicalExpression(Boolean value, String operador, Expression expression1, Expression expression2, String Id) {
        super(Id);
        this.value = value;
        this.operador = operador;
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    public LogicalExpression(String operador, Expression expression1, Expression expression2, String Id) {
        super(Id);
        this.value = null;
        this.operador = operador;
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    public LogicalExpression(String operador, Expression expression1, String Id) {
        super(Id);
        this.value = null;
        this.operador = operador;
        this.expression1 = expression1;
        this.expression2 = null;
    }

    public LogicalExpression(Boolean value, String Id) {
        super(Id);
        this.value = value;
        this.expression1 = null;
        this.expression2 = null;
        this.operador = null;
    }
    
    

    
    public Boolean isValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
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
}
