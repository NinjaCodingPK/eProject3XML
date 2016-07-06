/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import generated.Greenhouse;
import java.io.InputStream;

/**
 * 
 * @author wookie
 */
public interface MyParser {
    /**
     * Method parse input XML file.
     * @param in XML file stream.
     * @throws Exception exception depends on used parser.
     */
    void parse(InputStream in) throws Exception;
    
    /**
     * Method return Greenhouse instance with parsed values.
     * @return Greenhouse instance.
     */
    Greenhouse getGreenhouse();
}
