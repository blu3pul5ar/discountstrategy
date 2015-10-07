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
public class Register {
    private Receipt r;
    
     public final void endSaleAndOutputReceipt() {
        r.outputReceipt();
    }
    
    /**
     * Delegates job of adding a line item to the receipt. If parameters do not
     * validate, sends error message to designated output.
     * 
     * @param prodId - product id
     * @param qty - quantity of product ordered
     */
    public final void addItemToSale(String prodId, int qty) {
            // Validation needed
            if(prodId ==  null || prodId.length() == 0 || qty < 1) {
                System.out.println("Error");
                return; // premature exit
            }
            r.addLineItem(prodId, qty);
    }
    
    /**
     * Creates a blank receipt object and delegates job of finding a
     * customer matching an id to the Receipt object. If parameters do not
     * validate, sends error message to designated output.
     * 
     * @param custId - customer id
     * @param db - data source strategy
     * @param output - output strategy
     */
    public final void startNewSale(String custId, Database db, OutputStrategy output) {
        // Validation needed.
        if(custId == null || custId.length() == 0
                || db == null || output == null) {
            System.out.println("Error");
            return; // end prematurely 
        }
        
        r = new Receipt(db, custId, output);
    }
    
   
}
