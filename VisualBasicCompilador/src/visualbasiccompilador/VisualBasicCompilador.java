/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualbasiccompilador;

import AST.*;
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
import java.io.File;
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
            InputFile file = new InputFile();
            file.run();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
            parser p = new parser(new VisualBasicLexer(new FileReader("./int2.txt")));
            p.parse();
            //System.out.println(p.FINALOBJECT.getDeclarations().size());
            mapper.writeValue(new File("./AST.json"), p.FINALOBJECT);
            file.finish();
            
            System.out.println("");
//            for (int i = 0; i < p.tableIds.getIdlist().size()-1; i++) {
//                IdNode nodo = p.tableIds.getIdlist().get(i);
//                System.out.println("");
//                System.out.format("%20s%20s%20s%20s%20s", nodo.getName(),nodo.getType(),nodo.getAmbito(),nodo.getType2(),nodo.getProcedureType());
//            }
            p.tableIds.print();
            System.out.println("");
            p.cuadruplo.print();
            p.cuadruplo.generateCode();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    
}
