package visualbasiccompilador;
public class OBJID {
    
    private String name;
    private Object valex = null;
    
    public OBJID(){
        
    }

    public OBJID(String name) {
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Object getValex(){
        return this.valex;
    }
    
    public void setValex(Object valex){
        this.valex = valex;
    }
}
