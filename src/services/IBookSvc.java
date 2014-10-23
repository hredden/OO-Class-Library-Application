/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;
import java.util.*;

/**
 *
 * @author Max
 */

/**
 * Class is an interface which contains the service methods provided by the 
 * library
 */

import domain.*;


public interface IBookSvc extends IService {
    
    public Book add(Book book) throws Exception;

    public List retrieve(String type, String identifier) throws Exception;

    //public Book update(Book book) throws Exception;

    //public Book remove(Book book) throws Exception;

}
