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
public class arrayPractice {
    public static void main(String[] args) {
        String [] names = new String[0];
        String [] temp = new String[names.length + 1];
        System.arraycopy(names, 0, temp, 0, names.length);
        temp[temp.length-1] = "hello";
        names = temp;
        temp = null;
        
    }
}
