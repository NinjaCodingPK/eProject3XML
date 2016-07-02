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
    private Greenhouse greenhouse = new Greenhouse();
    
    public void parse( InputStream in) throws Exception {
        //braiser = new ObjectFactory().createBrazier();
        greenhouse = new ObjectFactory().createGreenhouse();
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document document = db.parse(in);
        Element root = document.getDocumentElement();
        
        System.out.println(root.getNodeName());
        
        NodeList rootChilds =  root.getChildNodes();
     
        //NodeList flowers = root.getElementsByTagName("flower");
        
        for( int i = 0 ; i< rootChilds.getLength() ; i++) {
            Flower flowerInstance = new Flower();
            Node node = rootChilds.item(i);

                if( node.getNodeType() == Node.ELEMENT_NODE ) {
                    Element flower = (Element) node;
                    String name = flower.getNodeName();
                    //System.out.println("Name:" + name);
                    
                    NodeList rootFlower = flower.getChildNodes();
                    for( int j = 0 ; j< rootFlower.getLength() ; j++) {
                        Node nodeFlower = rootFlower.item(j);
                        if( nodeFlower.getNodeType() == Node.ELEMENT_NODE ){
                            Element flowerElem = (Element) nodeFlower;
                            //System.out.println("Name2:" + flowerElem.getNodeName());
                            //System.out.println("Name3:" + flowerElem.getTextContent());
                            if("name".equals(flowerElem.getNodeName())) {
                                flowerInstance.setName(flowerElem.getFirstChild().getNodeValue());
                            } 
                            else if("soil".equals(flowerElem.getNodeName())) {
                                flowerInstance.setSoil(flowerElem.getFirstChild().getNodeValue());
                            }
                            else if("origin".equals(flowerElem.getNodeName())) {
                                flowerInstance.setOrigin(flowerElem.getFirstChild().getNodeValue());
                            }
                            else if("multiplying".equals(flowerElem.getNodeName())) {
                                flowerInstance.setMultiplying(flowerElem.getFirstChild().getNodeValue());
                            }
                            else if("visualParameters".equals(flowerElem.getNodeName())) {
                                flowerInstance.setVisualParameters(parseVisualParameters(flowerElem));
                            }
                            else if("growingTips".equals(flowerElem.getNodeName())) {
                                flowerInstance.setGrowingTips(parseGrowingTips(flowerElem));
                            }
                        }
                    }
                    
                   greenhouse.addFlower(flowerInstance);
                }  
      
        } 
    }

    private VisualParameters parseVisualParameters(Element el) {
        VisualParameters visualParam = new VisualParameters();
           
        NodeList childs = el.getChildNodes();
        for( int i = 0; i< childs.getLength(); i++){
            Node item = childs.item(i);
            if( item.getNodeType() == Node.ELEMENT_NODE ){
                Element elem = (Element) item;
                if("stemColor".equals(elem.getNodeName( )) ){
                    visualParam.setStemColor(elem.getFirstChild().getNodeValue());
                }
                else if("leafColor".equals(elem.getNodeName())) {
                    visualParam.setLeafColor(elem.getFirstChild().getNodeValue());
                }
                else if("size".equals(elem.getNodeName())) {
                    visualParam.setSize(elem.getFirstChild().getNodeValue());
                }
            }
        }
        return visualParam;
    }
    
    private GrowingTips parseGrowingTips(Element el) {
         GrowingTips growingTips = new GrowingTips();
           
        NodeList childs = el.getChildNodes();
        for( int i = 0; i< childs.getLength(); i++){
            Node item = childs.item(i);
            if( item.getNodeType() == Node.ELEMENT_NODE ){
                Element elem = (Element) item;
                if("temperature".equals(elem.getNodeName( )) ){
                    growingTips.setTemperature(Integer.parseInt(elem.getFirstChild().getNodeValue()));
                }
                else if("lighting".equals(elem.getNodeName())) {
                    growingTips.setLighting(elem.getFirstChild().getNodeValue());
                }
                else if("watering".equals(elem.getNodeName())) {
                    growingTips.setWatering(Integer.parseInt(elem.getFirstChild().getNodeValue()));
                }
            }
        }
        return growingTips;
    }
    
    
//    private Fuel parseFuel(Element el) {
//        Fuel fuel = new Brazier.Fuel();
//        NodeList childs = el.getChildNodes();
//        for( int i = 0; i< childs.getLength(); i++){
//            Node item = childs.item(i);
//            if( item.getNodeType() == Node.ELEMENT_NODE ){
//                Element elem = (Element) item;
//                if( "type".equals(elem.getNodeName( )) ){
//                    fuel.setType(elem.getFirstChild().getNodeValue());
//                }else if("weigth".equals(elem.getNodeName())) {
//                    fuel.setWeigth( Float.parseFloat(elem.getFirstChild().getNodeValue()) );
//                }
//            }
//        }
//        return fuel;
//    }
//
//    private List<Skewer> parseSkewers(Element el) {
//        List<Skewer> list = new ArrayList<>();
//        NodeList skewers = el.getElementsByTagName("skewer");
//        for( int i=0; i<skewers.getLength(); i++ ){
//            Element skewerEl = (Element) skewers.item(i);
//            Skewer skewer = new Skewer();
//            skewer.setId( Integer.parseInt(skewerEl.getAttribute("id")) );
//            skewer.setMeet( skewerEl.getElementsByTagName("meet").item(0).getTextContent() );
//            skewer.setWeight( 
//                    Integer.parseInt( skewerEl.getElementsByTagName("weight").item(0).getTextContent()) );
//            list.add(skewer);
//        }
//        return list;
//    }

    public Greenhouse getGreenhouse() {
        return greenhouse;
    }
}
