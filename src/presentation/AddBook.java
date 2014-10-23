/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation;

/**
 *
 * @author Max
 */

/**
 * This creates the AddBook class for use with a library application. The class
 * creates a user interface for books to be added to a library by supplying the
 * id, title, author and isbn. The class allows the user to set the id, title, 
 * author, isbn, genre, and number of pages the book has. The class reads in the
 * information entered by the user, creates a Book object, passes book object
 * to BookMgr to store in library and prints book status back to user.
 */

import domain.Book;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.atomic.AtomicInteger;
import managers.*;



public class AddBook extends JFrame {

    private JTextField authorField;
    private JTextField titleField;
    private JTextField isbnField;
    private JTextField genreField;
    private JTextField numPagesField;
    private JButton addButton;
    private JButton finishButton;
    static final int screenWidth = 400;
    static final int screenHeight = 350;
    private static AtomicInteger seq = new AtomicInteger(); //Creates book ID
    private int id;
    
    //Constructor
    public AddBook(){
        
        //Create frame
        super("Add Book");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setBounds(((dim.width-screenWidth)/2),((dim.height - screenHeight)/2),
                screenWidth, screenHeight);
        
        //Create panel for labels and text fields
        add(new JLabel("* indicates mandatory field"), BorderLayout.NORTH);
                
        JPanel textPanel = new JPanel();
        JLabel titleLabel = new JLabel("*Title:  ");
        titleField = new JTextField(10);
        textPanel.add(titleLabel);
        textPanel.add(titleField);
        
        JLabel authorLabel = new JLabel("*Author: ");
        authorField = new JTextField(10);
        textPanel.add(authorLabel);
        textPanel.add(authorField);
        
        JLabel isbnLabel = new JLabel("*ISBN:  ");
        isbnField = new JTextField(10);
        textPanel.add(isbnLabel);
        textPanel.add(isbnField);
        
        JLabel genreLabel = new JLabel("Genre:  ");
        genreField = new JTextField(10);
        textPanel.add(genreLabel);
        textPanel.add(genreField);
        
        JLabel numPagesLabel = new JLabel("Number of pages: ");
        numPagesField = new JTextField(10);
        textPanel.add(numPagesLabel);
        textPanel.add(numPagesField);
        
        add(textPanel, BorderLayout.CENTER);
        
        //Add buttons to the frame
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add");
        finishButton = new JButton("Finish");
        buttonPanel.add(addButton);
        buttonPanel.add(finishButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        //Register listeners with buttons
        addButton.addActionListener(new ButtonListener());
        finishButton.addActionListener(new ButtonListener());
        
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }//end constructor
    
    //Create inner class to handle events
    private class ButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == finishButton)
                System.exit(0);
            else{
                
                try {
                    
                    //Read in text field input, if null issue exception
                    String title = titleField.getText();
                    String author = authorField.getText();
                    String isbn = isbnField.getText();
                    
                    if(title.length() == 0 || author.length() == 0 || isbn.length() == 0){
                        throw new Exception();
                    }//end if
                    
                    id = seq.getAndIncrement();     //Set ID for book
                    
                    //Instantiate Book object with user input
                    Book newBook = new Book(id, title, author, isbn);
                    
                    //Set genre and numPages (may be null if not supplied)
                    newBook.setGenre(genreField.getText());
                    
                    String textNum = numPagesField.getText();
                    
                    if(textNum.length() != 0){
                        int numPages = Integer.parseInt(textNum);
                        newBook.setNumPages(numPages);
                    }//end if
                    
                    //Pass new book to BookMgr for stora
                    BookMgr bookMgr = new BookMgr();
                    bookMgr.storeBook(newBook);
                    
                    //Display state of book using overridden string method
                    JOptionPane.showMessageDialog(null, newBook.toString() + " has been added", 
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                    
                    //Clear fields in frame for new input
                    titleField.setText("");
                    authorField.setText("");
                    isbnField.setText("");
                    genreField.setText("");
                    numPagesField.setText("");
                                     
                }//end try
                
                //Catch invalid page number error
                catch (NumberFormatException exc){
                    JOptionPane.showMessageDialog(null, "Invalid input in Number of Pages field", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                //Catch null in mando blocks error
                catch (Exception exc) {
                    
                    JOptionPane.showMessageDialog(null, "Fields marked * can not be blank", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    
                }//end try/catch
                
            }//end else
            
            
        }//end actionPerformed
        
    }//End ButtonListener class
    
    public static void main(String[] args) {
        AddBook newBook = new AddBook();
        
    }//end main
    
}//end AddBook Class
