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
public class LineItem {
    private Product product;
    private int qty;
    private Database db;

    public LineItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
   
    public double getSubtotal(){
       return product.getUnitPrice() * qty;
    }
    
    public double getAmountSaved(){
        return product.getAmountSaved(qty);
    }
    
    public double getDiscountProductTotal(int qty){
        return product.getDiscountProductTotal(qty);
    }
    public String getProdID(){
        return product.getProdID();
    }
    public String getName(){
        return product.getName();
    }
    public double getUnitPrice(){
        return product.getUnitPrice();
    }
    
  // 
    //LineItem item = new LineItem(new Product("A100", "hat", 31, new PercentOffDiscount(.1)),4);
     //   System.out.println(item.getProdID() +" " +  item.getName() + " " +item.getUnitPrice() +" "+ item.getQty() + " " +item.getSubtotal() +
          //     " " + item.getAmountSaved() +" "+ item.getDiscountProductTotal(4));
    //}

    
    
}
