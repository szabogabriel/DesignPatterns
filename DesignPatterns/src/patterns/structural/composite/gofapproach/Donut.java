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
public class Donut implements CartItem {
    
    private final String name;

    public Donut(String name) {
        this.name = name;
    }
    
    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(80);
    }

    @Override
    public void add(CartItem item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(CartItem item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Donut %s : %s $", getName(), getPrice());
    }

}
