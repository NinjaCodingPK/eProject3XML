/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import generated.Greenhouse;
import generated.ObjectFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.xml.sax.SAXException;

/**
 *
 * @author wookie
 */
public class StaxParser extends SaxParser{
    //private Greenhouse greenhouse;
    
//    class StaxHandler extends SaxParser.new SaxHandler() {
//        
//        
//    }
    
//    greenhouse.getFlower(); //new ArrayList<Greenhouse.Flower>()
//        XMLReader reader = XMLReaderFactory.createXMLReader();
//        SaxHandler contentHandler = new SaxHandler();
//        reader.setContentHandler(contentHandler);
//        reader.parse(new InputSource(in));
    @Override
    public void parse(InputStream input) throws XMLStreamException, SAXException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader r = factory.createXMLStreamReader(input);
        SaxHandler handler = new SaxHandler();
        //List<Greenhouse.Flower> flowers = new ArrayList<>();
        
        try {
            int event = r.getEventType();
            while (true) {
                switch (event) {
                case XMLStreamConstants.START_DOCUMENT:
                    handler.startDocument();
                    //greenhouse = new ObjectFactory().createGreenhouse();
//                    flowers.add(new ObjectFactory().createGreenhouseFlower());
//                    System.out.println("Start Document.");
                    break;
                case XMLStreamConstants.START_ELEMENT:
                    
                    handler.startElement(null, r.getName().toString(), null, null);
//                    System.out.println("Start Element: " + r.getName());
//                    for(int i = 0, n = r.getAttributeCount(); i < n; ++i)
//                        System.out.println("Attribute: " + r.getAttributeName(i) 
//                              + "=" + r.getAttributeValue(i));
                  
                    break;
            case XMLStreamConstants.CHARACTERS:
                  if (r.isWhiteSpace())
                        break;
                  else {
                      //System.out.println("CHARACTER "  + r.getText());
                      handler.characters(r.getText().toCharArray(), 0, r.getText().toCharArray().length);
                  }
                  
                  //System.out.println("Text: " + r.getText());
                  break;
            case XMLStreamConstants.END_ELEMENT:
                 handler.endElement(null, r.getName().toString(), null);
                  //System.out.println("End Element:" + r.getName());
                  break;
            case XMLStreamConstants.END_DOCUMENT:
                 // System.out.println("End Document.");
                  break;
            }
            
            if (!r.hasNext())
                  break;

            event = r.next();
      }
} finally {
      r.close();
}
    }
}
