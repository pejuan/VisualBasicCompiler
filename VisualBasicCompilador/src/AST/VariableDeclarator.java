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
public class VariableDeclarator {
    private String Dim;
    private String Id;
    private String As;
    private String Equals;
    private Expression expression;
    private String dataType;

    public VariableDeclarator(String Dim, String Id, String As, String Equals, Expression expression, String dataType) {
        this.Dim = Dim;
        this.Id = Id;
        this.As = As;
        this.Equals = Equals;
        this.expression = expression;
        this.dataType = dataType;
    }

    
    public String getDim() {
        return Dim;
    }

    public void setDim(String Dim) {
        this.Dim = Dim;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getAs() {
        return As;
    }

    public void setAs(String As) {
        this.As = As;
    }

    public String getEquals() {
        return Equals;
    }

    public void setEquals(String Equals) {
        this.Equals = Equals;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    
}
