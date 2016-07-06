/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import generated.Greenhouse;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class provides method to work with Greenhouse class.  
 * @author wookie
 */
public class GreenhouseManager {
    private Greenhouse greenhouse;

    /**
     * Method sorts flowers by name.
     */
    public void sortByName() {
        Collections.sort(greenhouse.getFlower(), 
                (Greenhouse.Flower o1, Greenhouse.Flower o2) -> o1.getName().compareTo(o2.getName()));
    }
    
    public Greenhouse getGreenhouse() {
        return greenhouse;
    }

    public void setGreenhouse(Greenhouse greenhouse) {
        this.greenhouse = greenhouse;
    }
   
}
