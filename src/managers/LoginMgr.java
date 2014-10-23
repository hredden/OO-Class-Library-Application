/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managers;

/**
 *
 * @author Max
 */

/**
 * The class
 * is a business manager level class that handles all the login operations
 */

import services.*;

public class LoginMgr {
    
    public Boolean login(String Credentials)throws Exception{
        
        Factory factory = new Factory();
        IAuthenticationSvc authenticate = 
                (IAuthenticationSvc)factory.getService("IAuthenticationSvc");
        
        return authenticate.login(Credentials);
        
    }//end login method
    
}//end LoginMgr class
