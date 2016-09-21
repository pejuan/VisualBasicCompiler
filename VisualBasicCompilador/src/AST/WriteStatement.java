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
public class WriteStatement extends Statements{
    private String Write;
    private LiteralExpression literalExpression;
    private String Id;

    public WriteStatement(String Write, LiteralExpression literalExpression, String Id) {
        this.Write = Write;
        this.literalExpression = literalExpression;
        this.Id = Id;
    }
    
    
    public String getWrite() {
        return Write;
    }

    public void setWrite(String Write) {
        this.Write = Write;
    }

    public LiteralExpression getLiteralExpression() {
        return literalExpression;
    }

    public void setLiteralExpression(LiteralExpression literalExpression) {
        this.literalExpression = literalExpression;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
}
