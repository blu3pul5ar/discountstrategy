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
public class QuantityDiscount implements DiscountStrategy {
   
    private double discountRate;
    private int minQty;
    
    public QuantityDiscount(double discountRate, int minQty) {
        this.discountRate = discountRate;
        this.minQty = minQty;
    }
    
    @Override
    public double getDiscountedProductTotal(double unitPrice,int qty){
        if(qty >= minQty){
            return (unitPrice * qty)-getAmountSaved(unitPrice,qty);
        }
        return unitPrice * qty;
    }
    
    @Override
    public double getAmountSaved(double unitPrice, int qty){
        if(qty >= minQty){
             return (unitPrice * qty) * discountRate;
        }
        return 0;
    }
    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }
    
    
}
