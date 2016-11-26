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
public class LiteralExpression extends Expression{
    private String stringval;
    private Integer number;


    public LiteralExpression(String stringval, Integer number, String Id) {
        super(Id);
        this.stringval = stringval;
        this.number = number;
    }
    
    
    public String getStringval() {
        return stringval;
    }

    public void setStringval(String stringval) {
        this.stringval = stringval;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public String bringType(){
        if (number == null) {
            return "String";
        }else{
            return "Integer";
        }
        
    }
//    @Override
//    public String getLugar(){
//        if (number == null) {
//            return stringval;
//        }else{
//            return number.toString();
//        }
// 
//    }
}
