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
public class PercentOffDiscount implements DiscountStrategy {
   // public static void main(String[] args) {
     //   DiscountStrategy discount = new QuantityDiscount(.10,5);
      //  System.out.println(discount.getAmountSaved(10.00,2));
      //  System.out.println(discount.getDiscountedProductTotal(10.00, 2));
   // }
    private double discountRate;

    public PercentOffDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
    
    @Override
    public double getDiscountedProductTotal(double unitPrice,int qty){
        return (unitPrice * qty)-getAmountSaved(unitPrice,qty);
    }
    
    @Override
    public double getAmountSaved(double unitPrice, int qty){
        return (unitPrice * qty) * discountRate;
    }
    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    
}
