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
public class Book implements java.io.Serializable {
    private int ISBN;
    private String name;
    private String author;
    private String publisher;
    private String date;
    private boolean availability;
    
    public Book(int ISBN, String name, String author, String publisher, String date, boolean availability)
    {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.date = date;
        this.publisher = publisher;
        this.availability = availability;
    }
    
    public int getisbn(){
        return ISBN;
    }
    
    public String getname(){
        return name;
    }
    
    public String getauthor(){
        return author;
    }
    
    public String getpublisher(){
        return publisher;
    }
    
    public String getdate(){
        return date;
    }
    
    public boolean getbool(){
        return availability;
    }
}
