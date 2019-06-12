/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcoms_package;

import java.rmi.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public interface AddInterface extends Remote {
    //login interface
    public boolean login(String x, String y) throws RemoteException;
    //register interface
    public boolean register(String a,String b, String c, String d, String e, String f, String h) throws RemoteException;
    //displayBooks interface
    public ArrayList<Book> displayBooks() throws RemoteException, SQLException;
    //display borrow list interface
    public ArrayList<Student> displaylist() throws RemoteException, SQLException;
    //add book interface
    public boolean addbook(int a, String b, String c, String d, String e, boolean f) throws RemoteException;
}
