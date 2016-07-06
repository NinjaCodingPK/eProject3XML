/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam3xml;

import controller.Controller;
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
import model.GreenhouseManager;
import model.MyParser;
import model.SaxParser;
import model.StaxParser;
import model.Xpath;
import org.xml.sax.SAXException;
import view.View;

/**
 *
 * @author wookie
 */
public class Epam3XML {
    public static final String FILE_NAME = "./src/xml/greenhouse.xml";
//    private static void runParsers(String fileName){
//        try {
//            new DomParser().parse( new FileInputStream(fileName) );
//            new SaxParser().parse( new FileInputStream(fileName) );
//        } catch (Exception ex) {
//            //Logger.getLogger(XML2015.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    
    public static void main(String[] args) 
            throws JAXBException, SAXException, ParserConfigurationException, IOException, XPathExpressionException, Exception {
        View view = new View();
        MyParser parser = new DomParser();
//        MyParser parser = new SaxParser();
//        MyParser parser = new StaxParser();
        
        Controller controller = new Controller(parser, view);
        controller.processUser();
        
        
//        GreenhouseManager manager = new GreenhouseManager();
//    
//        System.out.println("DOM");
//        DomParser dom = new DomParser();
//        dom.parse(new FileInputStream(FILE_NAME));
//        Greenhouse greenhouse = dom.getGreenhouse();
//        manager.setGreenhouse(greenhouse);
//        manager.sortByName();
//        view.printGreenHouse(manager.getGreenhouse());
//        
//        System.out.println("SAX");
//        SaxParser sax = new SaxParser();
//        sax.parse(new FileInputStream(FILE_NAME));
//        greenhouse = sax.getGreenhouse();
//        view.printGreenHouse(greenhouse);
//
//        System.out.println("STAX");
//        StaxParser stax = new StaxParser();
//        stax.parse(new FileInputStream(FILE_NAME));
//        greenhouse = stax.getGreenhouse();
//        view.printGreenHouse(greenhouse);
        
//        runParsers(filename);
//        JAXBContext context = JAXBContext.newInstance( Greenhouse.class );
//        Unmarshaller unm = context.createUnmarshaller();
//        Greenhouse greenhouse = (Greenhouse) unm.unmarshal(new File(FILE_NAME));
//        view.printGreenHouse(greenhouse);
//        
//        Xpath xpath = new Xpath();
//        xpath.initParser(FILE_NAME);
//        System.out.println("XPATH:" + xpath.getFlowerName(1));
    }
    
   
    
}
