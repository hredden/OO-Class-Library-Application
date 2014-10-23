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
 * Class implements the IO components of the library interface 
 *
 */

import domain.*;
import java.io.*;
import java.util.*;


public class BookSvcSerializedIOImpl implements IBookSvc {
    
    @Override
    public Book add (Book book) throws Exception{
        try{
        FileOutputStream fos = new FileOutputStream("Library.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(book);
        oos.flush();
        oos.close();
        }
        catch(IOException e){
            
            System.out.println("Error, IO exception on output");
        }
        return book;
    }//end add method
    
    @Override
    //TODO reimplement this service using new retrieve method to retrieve
    //list of all books matching description
    public List retrieve(String type, String identifier) throws Exception{
        //Will need to add search feature when we learn how to persist collections
        List<Book> book = new ArrayList<Book>();
        ObjectInputStream ois = null;
        FileInputStream fis;
        
        try{
        fis = new FileInputStream("Library.txt");
        ois = new ObjectInputStream(fis);
        
        //read in object from file, store those matching query in list
        while(true){
            Book readBook = (Book)ois.readObject();
            
            switch(type){
                case "Author":
                    if(readBook.getAuthors().contains(identifier))
                        book.add(readBook);
                case "Title":
                    if(readBook.getTitle().equals(identifier))
                        book.add(readBook);
                case "ISBN":
                    if (readBook.getIsbn().equals(identifier))
                        book.add(readBook);
            }//end switch
            
        }//end while
        
        }//end try
        catch(EOFException exc){
            return book;
        }
        catch(IOException e){
         
            System.out.println("Error, IO exception on input");
        }
        finally{
            ois.close();
        }
        return book;
        
    }//End retrieve method
        
}//End BookSvcSerializedIOImpl class
