/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;
import java.sql.*;
import domain.*;
import java.util.*;

/**
 *
 * @author Max
 */
public class BookSvcJDBCImpl implements IBookSvc {
    
    //DB connection
    private String connString = 
		"jdbc:mysql://localhost/library?user=root&password=admin";
    
    private Connection getConnection() throws Exception{
        return DriverManager.getConnection(connString);
    }//end getConnection
    
    @Override
    public Book add(Book book) throws Exception {
        Connection conn = getConnection();
	try {
		Statement stmt = conn.createStatement();
		String sql = "Insert into book (title, author, isbn) "
                             + "Values ('" + book.getTitle() +"','" + book.getIsbn()
                             + "','" + book.getAuthors() + "')";
		stmt.executeUpdate(sql);
	} catch (SQLException e) {
	   throw e;
	} finally {
	  if (conn != null) conn.close();
	}
                
        return book;
        
    }//end add method
    
    @Override
    public List<Book> retrieve(String type, String identifier)throws Exception {
       
        Connection conn = getConnection();
        List<Book> book = new ArrayList<Book>();
        
        try{
            
          Statement stmt = conn.createStatement();
          String sql = "";
          
          if(type.equals("title"))
               sql = "Select * from book where title = '" + identifier + "'";
          else if (type.equals("author"))
              sql = "Select * from book where author = '" + identifier + "'";
          else
              sql = "Select * from book where isbn = '" + identifier + "'";
                   
           ResultSet rs = stmt.executeQuery(sql);
           Book nextBook = new Book();
           while(rs.next()){
               nextBook.setID(rs.getInt("id"));
               nextBook.setTitle(rs.getString("title"));
               nextBook.addAuthor(rs.getString("author"));
               nextBook.setIsbn(rs.getString("isbn"));
               nextBook.setGenre(rs.getString("genre"));
              //add ischeckedout here
               nextBook.setNumPages(rs.getInt("numPages"));
               book.add(nextBook);
                                             
            }//end while
            return book;
           
        }catch (SQLException exc){
            throw exc;
        }finally {
	  if (conn != null) conn.close();
	}
                
    }//end retrieve method
    
}//end BookSvcJDBCImpl class
