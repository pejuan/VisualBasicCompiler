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
public class ReadStatement extends Statements{
    private String Read;
    private String Id;

    public ReadStatement(String Read, String Id) {
        this.Read = Read;
        this.Id = Id;
    }
    
    
    public String getRead() {
        return Read;
    }

    public void setRead(String Read) {
        this.Read = Read;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
}
