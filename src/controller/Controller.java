/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.InputStream;
import model.GreenhouseManager;
import model.MyParser;
import view.View;

/**
 *
 * @author wookie
 */
public class Controller {
    private MyParser parser;
    private View view;
    

    public Controller(MyParser parser, View view) {
        this.parser = parser;
        this.view = view;
    }
   
    public void processUser() throws Exception {
        GreenhouseManager manager = new GreenhouseManager();
        
        parser.parse(new FileInputStream(View.FILE_NAME));
        manager.setGreenhouse(parser.getGreenhouse());
        manager.sortByName();
        view.printGreenHouse(manager.getGreenhouse());
    }
}
