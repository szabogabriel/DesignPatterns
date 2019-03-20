/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.structural.composite.gofapproach;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * Component interface
 * @author Martinka
 */
public interface CartItem {
    BigDecimal getPrice(); //operation
    
    void add(CartItem item);
    void remove(CartItem item);
    default List<CartItem> getChildren() {
        return Collections.emptyList();
    }
    
}
