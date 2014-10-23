/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PG
 */
public class BookTest {
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addAuthor method, of class Book.
     */
    @Test
    public void testAddAuthor() {
        System.out.println("addAuthor");
        String author = "";
        Book instance = new Book();
        
        //Test add with default constructor
        boolean expResult = true;
        instance.addAuthor("Patrick Rothfuss");
        assertEquals(expResult, instance.getAuthors().contains("Patrick Rothfuss"));
        
        //Test add with regular constructor
        expResult = true;
        Book instance2 = new Book(1, "Title", "Author", "ISBN");
        instance.addAuthor("Other Author");
        assertEquals(expResult, instance.getAuthors().contains("Other Author"));
        
    }
   
    /**
     * Test of removeAuthor method, of class Book.
     */
    @Test
    public void testRemoveAuthor() {
        System.out.println("removeAuthor");
        String author = "";
        Book instance = new Book();
        
        //Add author to remove
        instance.addAuthor("Remove me");
        
        //Test removing author
        instance.removeAuthor("Remove me");
        boolean expResult = true;
        assertEquals(expResult, !instance.getAuthors().contains("Remove me"));
        
        //Test removing an unlisted author
        expResult = false;
        assertEquals(expResult, instance.removeAuthor("Unlisted"));
        
    }

    /**
     * Test of isCheckedOut method, of class Book.
     */
    @Test
    public void testIsCheckedOut() {
        System.out.println("isCheckedOut");
        Book instance = new Book();
        //Test initial check out, should be false
        boolean expResult = false;
        boolean result = instance.isCheckedOut();
        assertEquals(expResult, result);
        //check out book and then test if true
        instance.checkOut(instance);
        expResult = true;
        result = instance.isCheckedOut();
        assertEquals(expResult, result);
    }


    /**
     * Test of equals method, of class Book.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Book instance = new Book();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        
        //Test against default book, instances should be equal
        Book instance2 = new Book();
        expResult = true;
        result = instance.equals(instance2);
        assertEquals(expResult, result);
        
        //Set new title instance and compare, should be false
        instance.setTitle("Where the Red Fern Grows");
        expResult = false;
        result = instance.equals(instance2);
        assertEquals(expResult, result);
        
        //Test same titles with different authors
        instance2.setTitle("Where the Red Fern Grows");
        instance.addAuthor("Bob");
        instance2.addAuthor("George");
        expResult = false;
        result = instance.equals(instance2);
        assertEquals(expResult, result);
        
        //Test same author and title
        instance2.addAuthor("Bob");
        instance.addAuthor("George");
        expResult = true;
        result = instance.equals(instance2);
        assertEquals(expResult, result);
        
        //Test same authors in different array indexes
        Book instance3 = new Book(2, "Title", "Author", "isbn");
        Book instance4 = new Book(3, "Title", "Author", "isbn");
        expResult = true;
        instance3.addAuthor("Bob");
        instance3.addAuthor("George");
        instance4.addAuthor("George");
        instance4.addAuthor("Bob");
        
    }

    /**
     * Test of validate method, of class Book.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Book instance = new Book();
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        //Test on valid instance
        Book validInstance = new Book(1, "Something", "Something else", "939-193-1837-183");
        expResult = true;
        result = validInstance.validate();
        assertEquals(expResult, result);
    }
    
}
