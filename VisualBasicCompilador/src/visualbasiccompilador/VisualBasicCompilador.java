/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualbasiccompilador;

import java.io.FileReader;

/**
 *
 * @author Jose Alberto Pejuan
 */
public class VisualBasicCompilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            parser p = new parser(new VisualBasicLexer(new FileReader("./int2.txt")));
            p.parse();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
