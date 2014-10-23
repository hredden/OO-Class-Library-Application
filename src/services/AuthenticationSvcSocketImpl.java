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
 * 
 * Class implements the authentication server by creating a socket to pass user
 * login info to an authentication server
 */

import java.io.*;
import java.net.*;

public class AuthenticationSvcSocketImpl implements IAuthenticationSvc {
    
    @Override
    public boolean login(String credentials){
        Socket socket = null;
        ObjectInputStream iStream = null;
        ObjectOutputStream oStream = null;
        int portNum = 19999;
        Boolean response = false;
        
        try{
            //Set up socket
            socket = new Socket(InetAddress.getLocalHost(), portNum);
            oStream = new ObjectOutputStream(socket.getOutputStream());
            iStream = new ObjectInputStream(socket.getInputStream());
            
            
            //Send credentials to authentication server
            oStream.writeObject(credentials);
            
            //read in response
            response = (Boolean)iStream.readObject();
            //return response
            return response;
            
        }catch(IOException e){
            System.out.println("Exception" + e.getMessage());
            return response;
        } catch (ClassNotFoundException e) {
            System.out.println("Exception" + e.getMessage());
            return response;
        }
        
        finally{
            try{
                iStream.close();
                oStream.close();
                socket.close();
            }catch(IOException exc){
                System.out.println("Exception" + exc.getMessage());
            }
        }
        
    }//end login method  
    
}//end class
