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
public class Start {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        Register cr = new Register();
        
        // Customer #1 sale
        cr.startNewSale("100", new FakeDatabase(), new ConsoleOutput());
        cr.addItemToSale("B205", 2);
        cr.addItemToSale("A101", 1);
        cr.endSaleAndOutputReceipt();
        
        // Customer #2 sale
        cr.startNewSale("200", new FakeDatabase(), new ConsoleOutput());
        cr.addItemToSale("C222", 4);
        cr.addItemToSale("B205", 6);
        cr.endSaleAndOutputReceipt();
    }
}
