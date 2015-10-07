/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;
import java.text.NumberFormat;
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
    private OutputStrategy output;
    
    public Receipt(Database db, String CustNo, OutputStrategy o) {
        this.db = db;
        Items = new LineItem[0];
        this.Customer = db.findCustomer(CustNo);
        this.ReceiptDate = new Date();
        receiptNo++;
        this.output = o;
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
        return ((int)(totalSavings * 100))/100.0;
    }
    public double getTotal(){
        return (int)((getTotalBeforeDiscount() - getTotalSavings())*100)/100.0;
    }
    public final void outputReceipt() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        final String CRLF = "\n";
        final String CRLF2 = "\n\n";
        
        // Build header
        StringBuilder receiptData = new StringBuilder("Thank you for shopping at CostCo!\n\n");
        receiptData.append("Sold to: ").append(Customer.getName()).append(CRLF);
        receiptData.append("Receipt No.: " ).append(Receipt.receiptNo).append(CRLF2);
        
        // Now process line items
        receiptData.append("ID\tItem\t\t\tPrice\tQty\tSubtotal\tDiscount").append(CRLF);
        receiptData.append("------------------------------------------------------------------------").append(CRLF);
        for(LineItem item : Items) {
            receiptData.append(item.getProduct().getProdID()).append("\t");
            receiptData.append(item.getProduct().getName()).append("\t");
            receiptData.append(nf.format(item.getProduct().getUnitPrice())).append("\t");
            receiptData.append(item.getQty()).append("\t");
            receiptData.append(nf.format(item.getSubtotal())).append("\t\t");
            receiptData.append(nf.format(item.getAmountSaved())).append(CRLF);
        }
        
        // Now process totals
        receiptData.append(CRLF);
        receiptData.append("\t\t\t\t\t\t\t\t--------").append(CRLF);
        double totalNet = getTotalBeforeDiscount();
        receiptData.append("\t\t\t\t\t\tNet Total: \t").append(nf.format(totalNet)).append(CRLF);
        double totalDiscount = getTotalSavings();
        receiptData.append("\t\t\t\t\t\tTotal Saved: \t-").append(nf.format(totalDiscount)).append(CRLF);
        double totalDue = totalNet - totalDiscount;
        receiptData.append("\t\t\t\t\t\tTotal Due: \t").append(nf.format(totalDue)).append(CRLF);
        
        // Now generate data string...
        // Notice that the format is hardcoded into this method. We could do
        // better by using a format strategy in the future.
        output.outputReciept(receiptData.toString());
    }

   // public static void main(String[] args){
    //   Receipt r = new Receipt(new FakeDatabase(),"customer 1");
     //   r.addLineItem("A101",160);
     //   r.addLineItem("C222", 1000);
       // System.out.println(r.getTotalBeforeDiscount() + " " + r.getTotalSavings() + " " + r.getTotal());
    //}
}
