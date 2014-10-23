/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managers;

/**
 *
 * @author Max
 */

/**
 * This creates the BookMgr class for use with a library application. The class
 * is a business manager level class that handles all the library operations
 * on book objects such as adding books to library, searching books in library,
 * and deleting books from library.
 */

import domain.*;
import services.*;
import java.util.*;

public class BookMgr {
    
    public Book storeBook(Book book) throws Exception{
        Factory factory = new Factory();
        IBookSvc bookSvc = (IBookSvc)factory.getService("IBookSvc");
        return bookSvc.add(book);
        
    }// end addBook method
    
    public List retrieve(String type, String identifier) throws Exception{
        Factory factory = new Factory();
        IBookSvc bookSvc = (IBookSvc)factory.getService("IBookSvc");
        return bookSvc.retrieve(type, identifier);
    }//End getBook method
    
}//End BookMgr class
