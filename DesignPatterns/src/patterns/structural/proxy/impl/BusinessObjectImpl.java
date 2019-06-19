package patterns.structural.proxy.impl;

import patterns.structural.proxy.BusinessObject;

public class BusinessObjectImpl implements BusinessObject {

    @Override
    public void operation() {
        System.out.println("Basic business obj. implementation");
    }
}
