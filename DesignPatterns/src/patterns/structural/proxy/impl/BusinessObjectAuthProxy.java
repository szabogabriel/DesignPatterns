package patterns.structural.proxy.impl;

import patterns.structural.proxy.BusinessObject;

public class BusinessObjectAuthProxy implements BusinessObject {

    private BusinessObject target;

    public BusinessObjectAuthProxy(BusinessObject target) {
        this.target = target;
    }

    @Override
    public void operation() {
        System.out.println("Authentificate first!");
        target.operation();
    }
}
