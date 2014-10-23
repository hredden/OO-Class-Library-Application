/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managers;

import domain.Book;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author Max
 */
public class BookMgrTest {
    
    public BookMgrTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of storeBook method, of class BookMgr.
     */
    @Test
    public void testStoreandRetrieveBook() throws Exception {
        System.out.println("storeBook, retrieveBook");
        BookMgr instance = new BookMgr();
                
        //Test that stored book and retrieved book are same
        //Store new book
        Book storeBook = new Book(1, "Title", "Author", "ISBN");
                
        instance.storeBook(storeBook);
        
        //Retrieve stored book
        List<Book> retrievedBooks = instance.retrieve("isbn","ISBN");
            
        //Assert that they are equal
        Boolean expectedResult = true;
        
        Boolean result = storeBook.equals(retrievedBooks);
        //test
        assertEquals(expectedResult, result);
    }

}
