/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

/**
 *
 * @author Max
 */

/**
 *  Class instantiates services provided by the library interface
 * 
 */

import java.io.*;
import java.util.*;

public class Factory {
    
    public IService getService (String serviceName) throws Exception{
        
        Class c = Class.forName(getImplName(serviceName));
        return (IService) c.newInstance();
        
    }//end getService
    
    private String getImplName(String serviceName) throws Exception{
        
        try{
            Properties props;
            try (FileInputStream fis = new FileInputStream("config/properties.txt")) {
                props = new Properties();
                props.load(fis);
            }
            return props.getProperty(serviceName);
        }catch(IOException ex){ //TODO get a better exception
            throw ex;
        }
        
    }//end getImplName
    
}//end Factory class
