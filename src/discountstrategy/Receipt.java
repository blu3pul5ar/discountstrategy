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
public class Receipt {
    private LineItem li;
    private Customer cu;
    private LineItem [] items;
    private double total;

    public LineItem getLi() {
        return li;
    }

    public void setLi(LineItem li) {
        this.li = li;
    }

    public Customer getCu() {
        return cu;
    }

    public void setCu(Customer cu) {
        this.cu = cu;
    }

    public LineItem[] getItems() {
        return items;
    }

    public void setItems(LineItem[] items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
