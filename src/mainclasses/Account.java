/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclasses;

/**
 *
 * @author user
 */
public class Account {
    private String fname;
    private String lname;
    private String email;
    private String uname;
    private String pword;
    
    public Account(String first, String last, String addy, String user, String pass){
        this.fname = first;
        this.lname = last;
        this.email = addy;
        this.uname = user;
        this.pword = pass;
    }
    public String getFirst(){return this.fname;}
    public String getLast(){return this.lname;}
    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}
    public String getUser(){return this.uname;}
    public String getPass(){return this.pword;}
    public void setPass(String word){this.pword = word;}
    
}
