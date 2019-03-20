/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.structural.composite.alternate;

import java.math.BigDecimal;

import patterns.structural.composite.gofapproach.*;

/**
 *
 * @author Martinka
 */
public class Donut2 implements CartItem2 {
    
    private final String name;

    public Donut2(String name) {
        this.name = name;
    }
    
    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(80);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Donut %s : %s $", getName(), getPrice());
    }
    
    
    
}
