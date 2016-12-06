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
public class IdTable {
    private ArrayList<IdNode> idlist = new ArrayList();

    public ArrayList<IdNode> getIdlist() {
        return idlist;
    }

    public void setIdlist(ArrayList<IdNode> idlist) {
        this.idlist = idlist;
    }
    
    public IdTable() {
        
    }
    
    public IdNode getNode(String id){
        for(IdNode idlist1:this.idlist){
            if(idlist1.getName().equals(id)){
                return idlist1;
            }
        }
        return null;
    }
    
    
    public boolean searchNode(IdNode nodo){//a esta busqueda habra que incluirle el ambito
        for (IdNode idlist1 : this.idlist) {
            if (idlist1.getName().equals(nodo.getName()) && nodo.getAmbito().contains(idlist1.getAmbito())) {
                return true;
            }
        }
        return false;
    }
    
    public int getNodeSize(String id, String ambito){
        for(IdNode idlist1 : this.idlist){
            if(idlist1.getName().equals(id) && ambito.contains(idlist1.getAmbito())){
                return idlist1.getSize();
            }
        }
        return 0;
    }
    
    public int getRecordSize(String id){
        for(IdNode idlist1 : this.idlist){
            if(idlist1.getName().equals(id) && idlist1.getType().equals("Record")){
                return idlist1.getSize();
            }
        }
        return 0;
    }
    
    public String searchFunctionType(String id){
        for(IdNode idlist1:this.idlist){
            if(idlist1.getName().equals(id) && (idlist1.getProcedureType().equals("Function") || idlist1.getProcedureType().equals("Sub"))){
                return idlist1.getType2();
            }
        }
        return "none";
    }
    
    public String searchNodeType(String id,String ambito){//a esta busqueda habra que incluirle el ambito
        
        for (IdNode idlist1 : this.idlist) {
            if(idlist1.getName().equals(id) && idlist1.getProcedureType().equals("Function")){
                return idlist1.getType();
            }else if(idlist1.getName().equals(id) && ambito.contains(idlist1.getAmbito())){
                return idlist1.getType();
            }
        }
        return "none";
    }
    
    public boolean searchScope(String id, String ambito){
        for(IdNode idlist1:this.idlist){
            if(idlist1.getName().equals(id) && ambito.contains(idlist1.getAmbito())){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<IdNode> getVariables(String ambito){
        ArrayList<IdNode> variables = new ArrayList<IdNode>();
        for(IdNode idlist1:this.idlist){
            if(idlist1.getType2().equals("Variable") && idlist1.getAmbito().contains(ambito)){
                variables.add(idlist1);
            }
        }
        return variables;
    }
    
    public boolean searchRecord(String id){
        for(IdNode idlist1:this.idlist){
            if(idlist1.getName().equals(id) && idlist1.getType().equals("Record")){
                return true;
            }
        }
        return false;
    }
    
    public boolean addNode(IdNode nodo){
        if (!searchNode(nodo)) {
            this.idlist.add(nodo);
            return true;
        }else{
            return false;
        }

    }
    public void print(){
        System.out.format("%20s%20s%20s%20s%20s%10s%10s", "Symbol ID","Data Type","Scope","Type","Procedure Type","Size","Offset");
        for (int i = 0; i < getIdlist().size()-1; i++) {
            IdNode nodo = getIdlist().get(i);
            System.out.println("");
            System.out.format("%20s%20s%20s%20s%20s%10d%10d", nodo.getName(),nodo.getType(),nodo.getAmbito(),nodo.getType2(),nodo.getProcedureType(),nodo.getSize(),nodo.getOffset());
        }
    }
    
}
