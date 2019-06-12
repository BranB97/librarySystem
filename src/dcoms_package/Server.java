/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcoms_package;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author acer
 */
public class Server extends UnicastRemoteObject implements AddInterface{
    
    boolean check;
    boolean check2;
    boolean check3;
    public Server()throws RemoteException
    {
        super();
    }
    
    @Override
    public boolean login(String username,String password) throws RemoteException
    {
        if(!username.isEmpty() && !password.isEmpty())
        {
            check = true;
        }
        else
        {
            check = false;
        }
        return check;
    }
    
    @Override
    public boolean register(String tp, String name, String password, String date, String course, String year, String email) 
            throws RemoteException
    {
        if(!tp.isEmpty() && !name.isEmpty() && !password.isEmpty() && !date.isEmpty() && !course.isEmpty() && !year.isEmpty() 
                && !email.isEmpty())
        {
            check = true;
        }
        else
        {
            check = false;
        }
        return check;
    }
    
    @Override
    public ArrayList<Book> displayBooks() throws SQLException, RemoteException  
    {
        ArrayList<Book> books = new ArrayList<Book>();
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/apulibrary_db","bran", "bran");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from books");
        while(rs.next())
        {
            books.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getBoolean(6)));
        }
        return books;
    }
    
    @Override
    public ArrayList<Student> displaylist() throws SQLException, RemoteException
    {
        ArrayList<Student> list = new ArrayList<Student>();
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/apulibrary_db","bran", "bran");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from borrowlist");
        while(rs.next())
        {
            list.add(new Student(rs.getString(1),rs.getString(2)));
        }
        return list;
    }
    
    @Override
    public boolean addbook(int isbn, String name, String author, String publisher, String date, boolean available)
    {
        if(isbn != 0 && !name.isEmpty() && !author.isEmpty() && !publisher.isEmpty() && !date.isEmpty())
        {
            check3 = true;
        }
        else
        {
            check3 = false;
        }
        return check3;
    }
    
}
