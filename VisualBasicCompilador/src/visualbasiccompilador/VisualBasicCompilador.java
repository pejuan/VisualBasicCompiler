/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualbasiccompilador;

import java.io.FileReader;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.corba.se.impl.orbutil.ObjectWriter;
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
            System.out.println(p.FINALOBJECT.getDeclarations().size());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
