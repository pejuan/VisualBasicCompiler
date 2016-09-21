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
public abstract class Expression extends Statements{
    private String Id;

    public Expression(String Id) {
        this.Id = Id;
    }
    
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    
}
