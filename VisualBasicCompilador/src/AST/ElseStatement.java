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
    private ArrayList<Integer> listanumbers;
    private ArrayList<Integer> listanumbersFalse;
    private ArrayList<Integer> listasig;
    private String etiqueteinicio;

    public ElseStatement(String Else, ArrayList<Statements> listastatements) {
        this.Else = Else;
        this.listastatements = listastatements;
        listanumbers = new ArrayList();
        listanumbersFalse = new ArrayList();
        listasig = new ArrayList();
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

    public ArrayList<Integer> getListanumbers() {
        return listanumbers;
    }

    public void setListanumbers(ArrayList<Integer> listanumbers) {
        this.listanumbers = listanumbers;
    }

    public ArrayList<Integer> getListanumbersFalse() {
        return listanumbersFalse;
    }

    public void setListanumbersFalse(ArrayList<Integer> listanumbersFalse) {
        this.listanumbersFalse = listanumbersFalse;
    }

    public ArrayList<Integer> getListasig() {
        return listasig;
    }

    public void setListasig(ArrayList<Integer> listasig) {
        this.listasig = listasig;
    }

    public String getEtiqueteinicio() {
        return etiqueteinicio;
    }

    public void setEtiqueteinicio(String etiqueteinicio) {
        this.etiqueteinicio = etiqueteinicio;
    }
}
