/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import domain.Book;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Max
 */
public class BookSvcJDBCImplTest {
    
    public BookSvcJDBCImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of add method, of class BookSvcJDBCImpl.
     */
    @Test
    public void testAddandRetrieve() throws Exception {
        System.out.println("add and retrieve");
        BookSvcJDBCImpl instance = new BookSvcJDBCImpl();
        
        //create book to add
        Book addBook = new Book();
        addBook.setTitle("Test Book");
        addBook.setIsbn("Test ISBN");
        
        //Add book to DB
        instance.add(addBook);
        
        //Retrieve book and ensure it is in db
        List returnedBook = instance.retrieve("isbn", "Test ISBN");
        
        assertNotNull(returnedBook);
       
    }
    
}
