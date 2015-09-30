/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Nicholas
 */
public interface Customer {

   
    String getCustID();

    String getfName();

    String getlName();

    char getmInitial();

    void setfName(String fName);

    void setlName(String lName);

    void setmInitial(char mInitial);
    
}
