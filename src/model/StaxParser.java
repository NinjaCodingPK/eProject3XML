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
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Class provides method for parse XML file using StAX parser.
 * @author wookie
 */
public class StaxParser extends SaxParser implements MyParser {

   class StaxHandler extends SaxHandler {
        /**
         * Override method from SaxHandler to work with XMLStreamReader.
         * @param localName name of tag.
         * @param atts attribute of tag.
         * @throws SAXException 
         */
        public void startElement(String localName, String atts) throws SAXException {
           switch (localName) {
                case Constants.FIELD_FLOWER:
                    Greenhouse.Flower flower = new ObjectFactory().createGreenhouseFlower();
                    flower.setId(Byte.parseByte(atts));
                    greenhouse.getFlower().add(flower);
                    break;
                case Constants.FIELD_VISUAL_PARAMETERS:
                    Greenhouse.Flower.VisualParameters visualParam = new Greenhouse.Flower.VisualParameters();
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).setVisualParameters(visualParam);
                    break;
                case Constants.FIELD_GROWING_TIPS:
                    Greenhouse.Flower.GrowingTips growingTips = new Greenhouse.Flower.GrowingTips();
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).setGrowingTips(growingTips);
                    break;
                default:
                    break;
            }
        }
   }
    /**
     * Cast XML file into generated Java class using ContentHandler and XMLStreamReader.
     * @param in InputStram of XML file. 
     * @throws javax.xml.stream.XMLStreamException 
     * @throws org.xml.sax.SAXException 
     */
    @Override
    public void parse(InputStream in) throws XMLStreamException, SAXException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader r = factory.createXMLStreamReader(in);
        StaxHandler handler = new StaxHandler();
        
        try {
            int event = r.getEventType();
            while (true) {
                switch (event) {
                case XMLStreamConstants.START_DOCUMENT:
                    handler.startDocument();
                    break;
                case XMLStreamConstants.START_ELEMENT: 
                    handler.startElement(r.getName().toString(), r.getAttributeValue(null, "id"));
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (!r.isWhiteSpace())
                        handler.characters(r.getText().toCharArray(), 0, r.getText().toCharArray().length);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    handler.endElement(null, r.getName().toString(), null);
                    break;
                case XMLStreamConstants.END_DOCUMENT:
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
