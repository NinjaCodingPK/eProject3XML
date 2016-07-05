/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author wookie
 */
public class Xpath {
    private Document document;
    
    public void initParser(String filename) throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        document = db.parse( new File(filename) );
        //Element root = document.getDocumentElement();
    }
    
    public Xpath() {
//         XPathFactory xPathFactory = XPathFactory.newInstance();
//	 XPath xpath = xPathFactory.newXPath(); 
//         //XPathExpression expr = xpath.compile("/people/human[2]/name/text()");         
//         XPathExpression expr = xpath.compile("/brazier/skewers/skewer[@id=1]/meet");
//         String result = (String) expr.evaluate(document , XPathConstants.STRING);
//         System.out.println(result);
//         expr = xpath.compile("/brazier/skewers/skewer[2]/meet");
//         result = (String) expr.evaluate(document , XPathConstants.STRING);
//         System.out.println(result);
//         expr = xpath.compile("/brazier/skewers/skewer");
//         NodeList nl = (NodeList) expr.evaluate(document , XPathConstants.NODESET);
//         for( int i =0 ; i <nl.getLength(); i++){
//              System.out.println(
//             ((Element)nl.item(i)).getAttribute("id") );
//              System.out.println( nl.item(i).getChildNodes().item(1).getFirstChild().getNodeValue() ); 
//         }
    }
    
    public String getFlowerName(int flowerId) throws XPathExpressionException {
        XPathFactory xPathFactory = XPathFactory.newInstance();
	XPath xpath = xPathFactory.newXPath(); 
        XPathExpression expr = xpath.compile("/greenhouse/flower[@id=" + flowerId + "]/name");
        String result = (String) expr.evaluate(document , XPathConstants.STRING);
         
        return result; 
    }
}






