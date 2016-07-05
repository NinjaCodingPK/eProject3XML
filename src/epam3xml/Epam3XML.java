/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam3xml;

import generated.Greenhouse;
import java.io.File;
import model.DomParser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import model.SaxParser;
import model.StaxParser;
import model.Xpath;
import org.xml.sax.SAXException;

/**
 *
 * @author wookie
 */
public class Epam3XML {
    private static void runParsers(String fileName){
        try {
            new DomParser().parse( new FileInputStream(fileName) );
            new SaxParser().parse( new FileInputStream(fileName) );
        } catch (Exception ex) {
            //Logger.getLogger(XML2015.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args) 
            throws JAXBException, SAXException, ParserConfigurationException, IOException, XPathExpressionException, Exception {
        String filename = "./src/xml/greenhouse.xml";
        
        System.out.println("DOM");
        DomParser dom = new DomParser();
        dom.parse(new FileInputStream(filename));
        Greenhouse greenhouse = dom.getGreenhouse();
        System.out.println(greenhouse.getFlower().get(0).getGrowingTips().getLighting());
        
        System.out.println("SAX");
        SaxParser sax = new SaxParser();
        sax.parse(new FileInputStream(filename));
        greenhouse = sax.getGreenhouse();
        System.out.println(greenhouse.getFlower().get(0).getName());

        System.out.println("STAX");
        StaxParser stax = new StaxParser();
        stax.parse(new FileInputStream(filename));
        greenhouse = stax.getGreenhouse();
        System.out.println(greenhouse.getFlower().get(1).getName());   
        System.out.println(greenhouse.getFlower().get(0).getGrowingTips().getLighting());
            
        
//        runParsers(filename);
//        JAXBContext context = JAXBContext.newInstance( Greenhouse.class );
//        Unmarshaller unm = context.createUnmarshaller();
//        Greenhouse greenhouse = (Greenhouse) unm.unmarshal(new File(filename));
//        
//        System.out.println( greenhouse.getFlower().get(1).getName() );
//        
//        Xpath xpath = new Xpath();
//        xpath.initParser(filename);
//        System.out.println("XPATH:" + xpath.getFlowerName(1));
//        System.out.println("---------------------------------");
    
    }
    
   
    
}
