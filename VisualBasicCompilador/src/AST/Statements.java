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
public class Statements {
    protected ArrayList<Integer> listanumbers;
    protected ArrayList<Integer> listanumbersFalse;
    protected ArrayList<Integer> listasig;

    public Statements() {
        listanumbers = new ArrayList();
        listanumbersFalse = new ArrayList();
        listasig = new ArrayList();
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
}
