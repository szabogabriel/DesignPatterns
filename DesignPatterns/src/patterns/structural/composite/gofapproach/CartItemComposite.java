/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.structural.composite.gofapproach;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Many items
 * @author Martinka
 */
public class CartItemComposite implements CartItem {
    
    private final List<CartItem> children = new ArrayList<>();
    
    private final String name;

    public CartItemComposite(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return getChildren().stream().map(CartItem::getPrice).reduce(BigDecimal::add).get();
    }

    @Override
    public void add(CartItem item) {
        children.add(item);
    }

    @Override
    public void remove(CartItem item) {
        children.remove(item);
    }

    @Override
    public List<CartItem> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String toString() {
        String kids = getChildren().stream().map(Object::toString).collect(Collectors.joining(", "));
        return String.format("%s $ for %s { %s }" , getPrice(), name, kids);
    }
}
