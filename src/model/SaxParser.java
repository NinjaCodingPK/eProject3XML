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
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author wookie
 */
public class SaxParser {
    private Greenhouse greenhouse;
    /**
     * temp value which handle current text value of XML tag.
     */
    private String temp; 
    
    /**
     * Class implements ContentHandler to use with XMLReader. 
     */
    class SaxHandler implements ContentHandler {

        @Override
        public void setDocumentLocator(Locator locator) {

        }

        @Override
        public void startDocument() throws SAXException {
            greenhouse = new ObjectFactory().createGreenhouse();
        }

        @Override
        public void endDocument() throws SAXException {

        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {

        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {

        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            switch (localName) {
                case Constants.FIELD_FLOWER:
                    Greenhouse.Flower flower = new Greenhouse.Flower();
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

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {        
            switch (localName) {
                case Constants.FIELD_NAME:
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).setName(temp);
                    break;
                case Constants.FIELD_SOIL:
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).setSoil(temp);
                    break;
                case Constants.FIELD_ORIGIN:
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).setOrigin(temp);
                    break;
                case Constants.FIELD_MULTIPLYING:
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).setMultiplying(temp);
                    break;
                case Constants.FIELD_STEM_COLOR:
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).getVisualParameters().setStemColor(temp);
                    break;
                case Constants.FIELD_LEAF_COLOR:
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).getVisualParameters().setLeafColor(temp);
                    break;
                case Constants.FIELD_SIZE:
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).getVisualParameters().setSize(temp);
                    break;  
                case Constants.FIELD_TEMPERATURE:
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).getGrowingTips().setTemperature(Integer.parseInt(temp));
                    break;
                case Constants.FIELD_LIGHTING:
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).getGrowingTips().setLighting(temp);
                    break;
                case Constants.FIELD_WATERING:
                    greenhouse.getFlower().get(greenhouse.getFlower().size()-1).getGrowingTips().setWatering(Integer.parseInt(temp));
                    break;
                default:
                    break;    
            }

        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            temp = new String(ch, start, length);
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

        }

        @Override
        public void processingInstruction(String target, String data) throws SAXException {

        }

        @Override
        public void skippedEntity(String name) throws SAXException {
            
        }
    }
    
    /**
     * Cast XML file into generated Java class using ContentHandler and XMLReader.
     * @param in InputStram of XML file.
     * @throws Exception 
     */
    public void parse( InputStream in ) throws Exception{
        XMLReader reader = XMLReaderFactory.createXMLReader();
        SaxHandler contentHandler = new SaxHandler();
        reader.setContentHandler(contentHandler);
        reader.parse(new InputSource(in));
    }

    public Greenhouse getGreenhouse() {
        return greenhouse;
    }
    
    
}
