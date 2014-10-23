/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

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
public class BookSvcSerializedIOImplTest {
    
    public BookSvcSerializedIOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of add method, of class BookSvcSerializedIOImpl.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add, retrieve");
        BookSvcSerializedIOImpl instance = new BookSvcSerializedIOImpl();
        
        //Test that stored book and retrieved book are same
        //Store new book
        Book storeBook = new Book(1, "Title", "Author", "ISBN");
        instance.add(storeBook);
        
        //Retrieve stored book
        List matchingBooks = instance.retrieve("Title", "Title");
        
        assertEquals(matchingBooks.get(0), storeBook);
        
        //Assert that they are equal
        //assertEquals(storeBook, retrievedBook);
    }
    
}
