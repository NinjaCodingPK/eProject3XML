/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam3xml;

import generated.Greenhouse;
import model.DomParser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wookie
 */
public class Epam3XML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DomParser parser = new DomParser();
        
        try {
            parser.parse(new FileInputStream("./src/xml/greenhouse"));
        } catch (Exception ex) {
            Logger.getLogger(Epam3XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Greenhouse greenhouse = parser.getGreenhouse();
        
        System.out.println(greenhouse.getFlower().get(0).getOrigin());
    }
    
   
    
}
