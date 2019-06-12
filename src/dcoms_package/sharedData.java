/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcoms_package;

/**
 *
 * @author acer
 */
public class sharedData {
    public static String loginname;
    
    public static void setLoginName(String loginname){
        sharedData.loginname = loginname;
    }
    
    public static String getLoginName(){
        return loginname;
    }
    
    
}
