/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclasses;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Warehouse {
    private String whName;
    private ArrayList<BikePart> wareH;
    
    public Warehouse(String name, ArrayList<BikePart> partList){
        this.whName = name;
        this.wareH = partList;
    }
    public String getName(){
        return this.whName;
    }
    public ArrayList<BikePart> getWare(){
        return this.wareH;
    }
}
