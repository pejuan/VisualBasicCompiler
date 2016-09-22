/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST;

import java.util.ArrayList;

/**
 *
 * @author Jose Alberto Pejuan
 */
public class ElseStatement {
    private String Else;
    private ArrayList<Statements> listastatements;

    public ElseStatement(String Else, ArrayList<Statements> listastatements) {
        this.Else = Else;
        this.listastatements = listastatements;
    }
    
    public String getElse() {
        return Else;
    }

    public void setElse(String Else) {
        this.Else = Else;
    }

    public ArrayList<Statements> getListastatements() {
        return listastatements;
    }

    public void setListastatements(ArrayList<Statements> listastatements) {
        this.listastatements = listastatements;
    }
}
