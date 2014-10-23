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
 * Creates login UI to read in user credentials
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import managers.LoginMgr;


public class LoginUI extends JFrame {
    private JTextField userNameField;
    private JTextField pWordField;
    private JButton loginButton;
    private JButton cancelButton;
    static final int screenWidth = 400;
    static final int screenHeight = 350;
    
    //Constructor
    public LoginUI(){
    
        //Create frame
        super("Login");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setBounds(((dim.width-screenWidth)/2),((dim.height - screenHeight)/2),
                screenWidth, screenHeight);
        
        JPanel textPanel = new JPanel();
        JLabel titleLabel = new JLabel("Username:  ");
        userNameField = new JTextField(10);
        textPanel.add(titleLabel);
        textPanel.add(userNameField);
        
        JLabel passwordLabel = new JLabel("Password: ");
        pWordField = new JTextField(10);
        textPanel.add(passwordLabel);
        textPanel.add(pWordField);
        
        //Add text to panel
        add(textPanel, BorderLayout.CENTER);
        
        //Add buttons to the frame
        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("Login");
        cancelButton = new JButton("Canecl");
        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);
        
        //add button panel to frame
        add(buttonPanel, BorderLayout.SOUTH);

        //Register listeners with buttons
        loginButton.addActionListener(new ButtonListener(this));
        cancelButton.addActionListener(new ButtonListener(this));
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        }//end loginui constructor method
        
        //Implement button actions
        private class ButtonListener implements ActionListener{
            
            private JFrame frame;
            
            //Constructor accepting jframe argument
            public ButtonListener(JFrame frame){
                this.frame = frame;
            }//end constructor
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                //exit if user presses cancel
                if (e.getSource() == cancelButton)
                    System.exit(0);
                else{
                    
                    try{
                        String userName = userNameField.getText();
                        String pWord = pWordField.getText();
                        
                        //Ensure user name supplied
                        if(userName.length() == 0 || pWord.length() == 0){
                            
                            Exception nullField = new Exception("Invalid input");
                            throw nullField;
                            
                        }//end user name if
                        
                        //Create credential string
                        String credentials = userName + "/" + pWord;
                        
                        //Call login manager to implement login service and 
                        //authenticate credentials
                        LoginMgr login = new LoginMgr();
                        Boolean isValid = login.login(credentials);
                        
                        if(isValid){
                           //Add dispose method
                            frame.dispose();
                            AddBook addBook = new AddBook();
                            
                        }//end if
                        else{
                          JOptionPane.showMessageDialog(null, 
                                  "Invalid username and password!", "Error",
                                  JOptionPane.ERROR_MESSAGE);  
                            
                        }//end else
                        
                        
                    }//end try
                    catch(Exception nullField){
                        JOptionPane.showMessageDialog(null, nullField.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }//end catch
                    
                }//end else
                
            }//end action performed
            
        }//end ButtonListener
        
        public static void main(String[] args) {
        LoginUI newlogin = new LoginUI();
        
    }//end main
    
}//End login ui class
