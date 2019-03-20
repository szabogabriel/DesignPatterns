/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.structural.composite.gofapproach;

import java.math.BigDecimal;

/**
 *
 * @author Martinka
 */
public class Cola implements CartItem {

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(100);
    }

    @Override
    public void add(CartItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(CartItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return String.format("Cola : %s $", getPrice());
    }

}
