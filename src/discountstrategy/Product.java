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
public class Product {
    private String prodID;
    private String name;
    private double unitPrice;
    private DiscountStrategy discount;

    public Product(String prodID, String name, double unitPrice, DiscountStrategy discount) {
        this.prodID = prodID;
        this.name = name;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public String getProdID() {
        return prodID;
    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    
    public double getAmountSaved(int qty){
        return discount.getAmountSaved(unitPrice, qty);
    }
    
    public double getDiscountProductTotal(int qty){
        return discount.getDiscountedProductTotal(unitPrice, qty);
    }
    
    public static void main(String[] args) {
        Product product = new Product("A100", "Hat", 194.28, new PercentOffDiscount(.10));
        System.out.println(product.getAmountSaved(2));
    }
}
