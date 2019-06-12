/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcoms_package;

import java.io.Serializable;

/**
 *
 * @author acer
 */
public class Student implements java.io.Serializable{
    private String tp_no;
    private String name;
    private String password;
    private String date;
    private String course;
    private String intake;
    private String email;
    private String book;
    
    public Student(String tp_no, String name, String password, String date, String course, String intake, String email)
    {
        this.tp_no = tp_no;
        this.name = name;
        this.password = password;
        this.date = date;
        this.course = course;
        this.intake = intake;
        this.email = email;
    }
    
    public Student(String name, String book)
    {
        this.name = name;
        this.book = book;
    }
    
    public String get_tp()
    {
        return tp_no;
    }
    
    public String get_name() 
    {
        return name;
    }
    
    public String get_password()
    {
        return password;
    }
    
    public String get_date()
    {
        return date;
    }
    
    public String get_course()
    {
        return course;
    }
    
    public String get_intake()
    {
        return intake;
    }
    
    public String get_email()
    {
        return email;
    }
    
    public String get_book()
    {
       return book; 
    }
}
