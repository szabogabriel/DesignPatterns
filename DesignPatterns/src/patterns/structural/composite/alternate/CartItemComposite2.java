/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.structural.composite.alternate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import patterns.structural.composite.gofapproach.*;

/**
 * Many items
 * @author Martinka
 */
public class CartItemComposite2 implements CartItem2 {
    
    private final List<CartItem2> children = new ArrayList<>();
    
    private final String name;

    public CartItemComposite2(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return getChildren().stream().map(CartItem2::getPrice).reduce(BigDecimal::add).get();
    }

    public void add(CartItem2 item) {
        children.add(item);
    }

    public void remove(CartItem2 item) {
        children.remove(item);
    }

    public List<CartItem2> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String toString() {
        String kids = getChildren().stream().map(Object::toString).collect(Collectors.joining(", "));
        return String.format("%s $ for %s { %s }" , getPrice(), name, kids);
    }
}
