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
public class InStoreCustomer implements Customer{
    private String custID;
    private String fName;
    private String lName;
    private char mInitial;

    @Override
    public String getfName() {
        return fName;
    }

    @Override
    public void setfName(String fName) {
        this.fName = fName;
    }

    @Override
    public String getlName() {
        return lName;
    }

    @Override
    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public char getmInitial() {
        return mInitial;
    }

    @Override
    public void setmInitial(char mInitial) {
        this.mInitial = mInitial;
    }
    //no setter as custID wont change
    @Override
    public String getCustID() {
        return custID;
    }

}
