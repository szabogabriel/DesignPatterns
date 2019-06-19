package patterns.structural.proxy.impl;

import patterns.structural.proxy.BusinessObject;

public class BusinessObjectLoggingProxy implements BusinessObject {

    private BusinessObject target;

//    public BusinessObjectLoggingProxy(BusinessObject target){
//        this.target = target;
//    }

//    @Override
//    public void operation() {
//        System.out.println("Logging before real object call.");
//        target.operation();
//        System.out.println("Logging after real object call.");
//    }

    // lazy loading
    @Override
    public void operation() {
        if(target == null){
            target = new BusinessObjectImpl();
        }
        System.out.println("Logging before real object call.");
        target.operation();
        System.out.println("Logging after real object call.");
    }
}
