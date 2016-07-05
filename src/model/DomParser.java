/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import generated.Greenhouse;
import generated.Greenhouse.Flower;
import generated.Greenhouse.Flower.GrowingTips;
import generated.Greenhouse.Flower.VisualParameters;
import generated.ObjectFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author wookie
 */
public class DomParser {
    private Greenhouse greenhouse;
    
    public void parse( InputStream in) throws Exception {
        greenhouse = new ObjectFactory().createGreenhouse();
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document document = db.parse(in);
        Element root = document.getDocumentElement();
        
        System.out.println(root.getNodeName());
        
        NodeList rootChilds =  root.getChildNodes();
     
        
        for( int i = 0 ; i< rootChilds.getLength() ; i++) {
            Flower flowerInstance = new ObjectFactory().createGreenhouseFlower();
            Node node = rootChilds.item(i);

                if( node.getNodeType() == Node.ELEMENT_NODE ) {
                    Element flower = (Element) node;
                    
                    NodeList rootFlower = flower.getChildNodes();
                    for( int j = 0 ; j< rootFlower.getLength() ; j++) {
                        Node nodeFlower = rootFlower.item(j);
                        if( nodeFlower.getNodeType() == Node.ELEMENT_NODE ){
                            Element flowerElem = (Element) nodeFlower;
                            if(null != flowerElem.getNodeName()) 
                            switch (flowerElem.getNodeName()) {
                                case Constants.FIELD_NAME:
                                    flowerInstance.setName(flowerElem.getFirstChild().getNodeValue());
                                    break;
                                case Constants.FIELD_SOIL:
                                    flowerInstance.setSoil(flowerElem.getFirstChild().getNodeValue());
                                    break;
                                case Constants.FIELD_ORIGIN:
                                    flowerInstance.setOrigin(flowerElem.getFirstChild().getNodeValue());
                                    break;
                                case Constants.FIELD_MULTIPLYING:
                                    flowerInstance.setMultiplying(flowerElem.getFirstChild().getNodeValue());
                                    break;
                                case Constants.FIELD_VISUAL_PARAMETERS:
                                    flowerInstance.setVisualParameters(parseVisualParameters(flowerElem));
                                    break;
                                case Constants.FIELD_GROWING_TIPS:
                                    flowerInstance.setGrowingTips(parseGrowingTips(flowerElem));
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    
                   greenhouse.getFlower().add(flowerInstance);
                }  
      
        } 
    }

    private VisualParameters parseVisualParameters(Element el) {
        VisualParameters visualParam = new ObjectFactory().createGreenhouseFlowerVisualParameters();
           
        NodeList childs = el.getChildNodes();
        for( int i = 0; i< childs.getLength(); i++){
            Node item = childs.item(i);
            if( item.getNodeType() == Node.ELEMENT_NODE ){
                Element elem = (Element) item;
                if(null != elem.getNodeName()) switch (elem.getNodeName()) {
                    case Constants.FIELD_STEM_COLOR:
                        visualParam.setStemColor(elem.getFirstChild().getNodeValue());
                        break;
                    case Constants.FIELD_LEAF_COLOR:
                        visualParam.setLeafColor(elem.getFirstChild().getNodeValue());
                        break;
                    case Constants.FIELD_SIZE:
                        visualParam.setSize(elem.getFirstChild().getNodeValue());
                        break;
                    default:
                        break;
                }
            }
        }
        return visualParam;
    }
    
    private GrowingTips parseGrowingTips(Element el) {
         GrowingTips growingTips = new ObjectFactory().createGreenhouseFlowerGrowingTips();
           
        NodeList childs = el.getChildNodes();
        for( int i = 0; i< childs.getLength(); i++){
            Node item = childs.item(i);
            if( item.getNodeType() == Node.ELEMENT_NODE ){
                Element elem = (Element) item;
                if(null != elem.getNodeName()) switch (elem.getNodeName()) {
                    case Constants.FIELD_TEMPERATURE:
                        growingTips.setTemperature(Integer.parseInt(elem.getFirstChild().getNodeValue()));
                        break;
                    case Constants.FIELD_LIGHTING:
                        growingTips.setLighting(elem.getFirstChild().getNodeValue());
                        break;
                    case Constants.FIELD_WATERING:
                        growingTips.setWatering(Integer.parseInt(elem.getFirstChild().getNodeValue()));
                        break;
                    default:
                        break;
                }
            }
        }
        return growingTips;
    }

    public Greenhouse getGreenhouse() {
        return greenhouse;
    }
}
