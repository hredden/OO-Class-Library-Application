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
public interface IAuthenticationSvc extends IService {
    
    public boolean login(String credentials);
    
}
