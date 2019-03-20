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
public class Cola2 implements CartItem2 {

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(100);
    }
    
    @Override
    public String toString() {
        return String.format("Cola : %s $", getPrice());
    }

}
