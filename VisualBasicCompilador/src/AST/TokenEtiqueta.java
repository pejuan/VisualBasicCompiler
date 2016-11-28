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
public class TokenEtiqueta {
    private int arraynumber;
    private String etiqueta;

    public TokenEtiqueta() {
    }

    public TokenEtiqueta(int arraynumber, String etiqueta) {
        this.arraynumber = arraynumber;
        this.etiqueta = etiqueta;
    }

    
    public int getArraynumber() {
        return arraynumber;
    }

    public void setArraynumber(int arraynumber) {
        this.arraynumber = arraynumber;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
}
