/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Nicholas
 */
public class Receipt {
    private Database db;
    private Customer Customer;
    private LineItem [] Items;
    //private outputStrategy output; 
    private Date ReceiptDate;
    private static int receiptNo;

    public Receipt(Database db, String CustNo) {
        this.db = db;
        Items = new LineItem[0];
        this.Customer = db.findCustomer(CustNo);
        this.ReceiptDate = new Date();
        receiptNo++;
    }
    
    public Customer findCustomer(String CustNo){
        return db.findCustomer(CustNo);
    }
    
    public void addLineItem(String prodId, int qty){
        LineItem li = new LineItem(prodId, qty, db);
        addItemToArray(li);
    }
    
    public void addItemToArray(LineItem li){
        LineItem[] tempItems = new LineItem[Items.length + 1];
        System.arraycopy(Items, 0, tempItems, 0, Items.length);
        tempItems[Items.length] = li;
        Items = tempItems;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public double getTotalBeforeDiscount(){
        double total = 0.0;
        for(LineItem i: Items){
            total += i.getSubtotal();
        }
        return total;
    }
    
    public double getTotalSavings(){
        double totalSavings = 0.0;
        for(LineItem i: Items){
            totalSavings += i.getAmountSaved();
        }
        return totalSavings;
    }
    public double getTotal(){
        return getTotalBeforeDiscount() - getTotalSavings();
    }
    public static void main(String[] args) {
        Receipt r = new Receipt(new FakeDatabase(),"customer 1");
        r.addLineItem("A101",2);
        System.out.println(r.getTotalBeforeDiscount() + " " + r.getTotalSavings() + " " + r.getTotal());
    }
}
