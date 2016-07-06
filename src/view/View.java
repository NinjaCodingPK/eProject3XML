/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import generated.Greenhouse;

/**
 *
 * @author wookie
 */
public class View {
    public static final String FILE_NAME = "./src/xml/greenhouse.xml";
    
    public void printGreenHouse(Greenhouse greenhouse) {
        for(Greenhouse.Flower flower : greenhouse.getFlower()) {
            System.out.println("Flower's name: " + flower.getName());
            System.out.println("Flower's id: " + flower.getId());
            System.out.println("Flower's origin: " + flower.getOrigin());
            System.out.println("Flower's leafs' color: " + flower.getVisualParameters().getLeafColor());
            System.out.println("Flower's growing temperature: " + flower.getGrowingTips().getTemperature());
            System.out.println();
        }
    }
}
