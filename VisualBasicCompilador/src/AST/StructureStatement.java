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
public class StructureStatement extends FunctionDeclaration{
    private String structure;
    private String id;
    private String end_structure;
    private ArrayList<Statements> statements = new ArrayList();

    public StructureStatement(String structure, String id, String end_structure) {
        this.structure = structure;
        this.id = id;
        this.end_structure = end_structure;
    }

    public StructureStatement(String structure, String id, String end_structure, ArrayList<Statements> statements) {
        this.structure = structure;
        this.id = id;
        this.end_structure = end_structure;
        this.statements = statements;
    }

    
    public ArrayList<Statements> getStatements() {
        return statements;
    }

    public void setStatements(ArrayList<Statements> statements) {
        this.statements = statements;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnd_structure() {
        return end_structure;
    }

    public void setEnd_structure(String end_structure) {
        this.end_structure = end_structure;
    }
}
