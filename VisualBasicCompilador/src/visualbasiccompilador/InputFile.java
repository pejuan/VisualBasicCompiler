package visualbasiccompilador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class InputFile {
    
    private String appendToEOF = "\nSub algo() \nEnd Sub";
    private String content = null;
    
    private BufferedReader reader = null;
    private FileReader filereader = null;
    
    private BufferedWriter writer = null;
    private FileWriter filewrite = null;
    
    public InputFile(){
        try{
            filereader = new FileReader("./int2.txt");
            reader = new BufferedReader(filereader);
            
            filewrite = new FileWriter("./int2.txt",true);
            writer = new BufferedWriter(filewrite);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void run(){
        try{
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                builder.append("\n");
                line = reader.readLine();
            }
            
            filereader.close();
            reader.close();
            
            content = builder.toString();
            writer.append(appendToEOF);
            writer.flush();
            
            filewrite.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void finish(){
        
        try{
            FileWriter filewrite2 = new FileWriter("./int2.txt");
            BufferedWriter writer2 = new BufferedWriter(filewrite2);
            writer2.append(content);
            writer2.flush();
            filewrite2.close();
            content = null;
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
}
