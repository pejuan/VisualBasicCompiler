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
public class ExitStatement extends Statements{
    private String Exit;

    public ExitStatement(String Exit) {
        this.Exit = Exit;
    }
    
    
    public String getExit() {
        return Exit;
    }

    public void setExit(String Exit) {
        this.Exit = Exit;
    }
}
