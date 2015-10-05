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
    private String name;

    public InStoreCustomer(String custID, String name) {
        this.custID = custID;
        this.name = name;
    }

    
    
    @Override
    public String getCustID() {
        return custID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    


}
