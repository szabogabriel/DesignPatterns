/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.structural.composite;

import patterns.structural.composite.alternate.CartItem2;
import patterns.structural.composite.alternate.CartItemComposite2;
import patterns.structural.composite.alternate.Cola2;
import patterns.structural.composite.alternate.Donut2;
import patterns.structural.composite.gofapproach.CartItem;
import patterns.structural.composite.gofapproach.CartItemComposite;
import patterns.structural.composite.gofapproach.Cola;
import patterns.structural.composite.gofapproach.Donut;

/**
 *
 * @author Martinka
 */
public class Main {
    public static void main(String[] args) {
        testGofStyleComposite();
        System.out.println("------------------------");
        testAlternativeComposite();
    }
    
    private static void testGofStyleComposite() {
        CartItem root = new CartItemComposite("total");
        
        CartItem donutCombo = new CartItemComposite("donutCombo");
        donutCombo.add(new Donut("Strawberry"));
        donutCombo.add(new Donut("Chocolate"));
        
        CartItem breakfast = new CartItemComposite("breakfast");
        breakfast.add(donutCombo);
        breakfast.add(new Cola());
        
        root.add(breakfast);
        
        root.add(new Donut("Snack"));

        System.out.println(root);
        System.out.println(breakfast);
        
        try {
            donutCombo.getChildren().get(0).add(new Cola()); //will fail - cannot add items to donut
        } catch (UnsupportedOperationException e) {
            e.printStackTrace(System.out);
        }
    }
    
    private static void testAlternativeComposite() {
        CartItem2 root = new CartItemComposite2("total");
        
        CartItem2 donutCombo = new CartItemComposite2("donutCombo");
        ((CartItemComposite2)donutCombo).add(new Donut2("Strawberry"));
        ((CartItemComposite2)donutCombo).add(new Donut2("Chocolate"));
        
        CartItem2 breakfast = new CartItemComposite2("breakfast");
        ((CartItemComposite2)breakfast).add(donutCombo);
        ((CartItemComposite2)breakfast).add(new Cola2());
        
        ((CartItemComposite2)root).add(breakfast);
        
        ((CartItemComposite2)root).add(new Donut2("Snack"));

        System.out.println(root);
        System.out.println(breakfast);
        
        try {
//            new Donut2("Chocolate").add(new Cola()); //does not compile
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }
}
