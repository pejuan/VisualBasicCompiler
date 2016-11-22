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
    public boolean searchNode(IdNode nodo){//a esta busqueda habra que incluirle el ambito
        for (IdNode idlist1 : this.idlist) {
            if (idlist1.getName().equals(nodo.getName()) && nodo.getAmbito().contains(idlist1.getAmbito())) {
                return true;
            }
        }
        return false;
    }
    public String searchNodeType(String id,String ambito){//a esta busqueda habra que incluirle el ambito
        
        for (IdNode idlist1 : this.idlist) {
            if (idlist1.getName().equals(id) && ambito.contains(idlist1.getAmbito())) {
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
    
    public boolean addNode(IdNode nodo){
        if (!searchNode(nodo)) {
            this.idlist.add(nodo);
            return true;
        }else{
            return false;
        }
        
    }
    
    
}
