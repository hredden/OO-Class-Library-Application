/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author Max
 */

/**
 * This creates the book class for use with a library application. The class
 * allows books to be added to a library by supplying the id, title, author
 * and isbn. The class allows the user to set the id, title, author, isbn, genre,
 * and number of pages the book has. The class also allows the book to be checked
 * out of and back into the library. The class provided methods for comparing
 * two books to see if they are equal and a method to validate if a book is valid.
 * Finally the class keeps track of the number of books that the library has.
 */

import java.util.*;
import java.io.*;

public class Book implements Serializable {
    
    private int id;
    private String title;
    private ArrayList<String> authors;  //Array list to hold authors
    private String isbn;
    private String genre;
    private boolean checkedOut;
    private int numPages;
    static private int numBookObjects = 0;
    
    
    
    //4 arugment Constructor for book basics
    public Book(int id, String title, String author, String isbn){
        this.id = id;
        this.title = title;
        authors = new ArrayList<>();
        this.authors.add(author);
        this.isbn = isbn; 
        genre = "Default";
        checkedOut = false;
        numPages = 0;
        numBookObjects++;
    }
    
    //Default constructor
    public Book(){
        
        this(0,"Default", "Default", "Default");
    }
    
    //Setters
    public void setID(int id){
        this.id = id;
    }
    
    public void setTitle (String title){
        this.title = title;
    }
    
    public void addAuthor (String author){
        if(!this.authors.contains(author)){  //Prevent duplicate authors
            this.authors.add(author);
        }
        else{
            System.out.print("This author is already listed for this book.");
        }
    }
    
    public boolean removeAuthor (String author){
        if(!authors.contains(author)){
            System.out.println("Author not listed.");
            return false;
        }
        else{
            authors.remove(author);
            return true;
        }
    }
    
    public void setIsbn (String isbn){
        this.isbn = isbn;
    }
    
    public void setGenre (String genre){
        this.genre = genre;
    }
    
    public void checkOut(Book book){
        checkedOut = true;
    }
    
    public void checkIn(Book book){
        checkedOut = false;
    }
    
    public void setNumPages (int numPages){
        this.numPages = numPages;
    }
    
    //Getters
    public int getID(){
        return id;
    }
    
    public String getTitle(){
        return title;
    }
    
    public ArrayList<String> getAuthors(){
        return authors;
    }
    
    public boolean isAuthor(String author){
        return authors.contains(author);  
    }
    
    public String getIsbn(){
        return isbn;
    }
    
    public String getGenre(){
        if ("Default".equals(genre))
            return "Genre has not been set for this book.";
        
        return genre;
        
    }
    
    public boolean isCheckedOut(){
        return checkedOut;
    }
    
    public int getNumPages(){
        if (numPages == 0){
            System.out.print("The number of pages has not been set for this book.");
            return 0;
        }//End if
        return numPages;   
    }
    
    static public int getNumBooks(){
        return numBookObjects;
    }
    
    //Override Object's equals() method for non list objects
    @Override 
    public boolean equals(Object obj){
        
        if(this == obj) //If objects are equal return true
            return true;
        
        //If object to compare isn't an instance of Book return false 
        if (!(obj instanceof Book)) 
            return false;
        
    
        //Cast obj as Book
        Book item = (Book)obj;
        
        //If title and author are not the same return false
        if (!this.title.equals(item.title))
            return false;
        
        //Compare authors
        if(this.authors.size() != item.authors.size())
            return false;
        
        //Check if authors are the same
        Iterator<String> iter = this.authors.iterator();
        
        while(iter.hasNext()){
            if(!item.authors.contains(iter.next()))
                return false;
        }//end while
        
        //Otherwise objects are same
        return true;
        
    }//end equals
    
    //Overrides equals for list objects
    public Boolean equals(List list){
        for(ListIterator iter = list.listIterator(); iter.hasNext();){
            Book book = (Book)iter.next();
           
            if(this == book) //If objects are equal return true
            return true;
            
            //If title and author are not the same return false
            if (!this.title.equals(book.title))
                return false;
        
            //Compare authors
            if(this.authors.size() != book.authors.size())
                return false;
        
            //Check if authors are the same
            Iterator<String> authorIter = this.authors.iterator();
        
            while(authorIter.hasNext()){
                if(!book.authors.contains(iter.next()))
                    return false;
            }//end while
        
        }//end for
        
        //Otherwise items are same
        return true;
        
    }//End list equals method
    
    //Validate method
    public boolean validate(){
        
        if (id <= 0)
            return false;
        if (title == null || "Default".equals(title))
            return false;
        if (authors.isEmpty() || (authors.size()==1 && "Default".equals(authors.get(0))))
            return false;
        if (isbn == null || "Default".equals(isbn))
            return false;
        return true;
        
    }//End validate
    
    //Override toString method
    @Override
    public String toString(){
        return title;
    }//end toString
    
}//End Book class
