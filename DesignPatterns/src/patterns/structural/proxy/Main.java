package patterns.structural.proxy;

import patterns.structural.proxy.impl.BusinessObjectImpl;
import patterns.structural.proxy.impl.BusinessObjectLoggingProxy;

public class Main {

    public static void main(String[] args) {
//        BusinessObjectImpl obj = new BusinessObjectImpl();
//        BusinessObject obj = new BusinessObjectImpl();
//        BusinessObject obj = new BusinessObjectLoggingProxy(new BusinessObjectImpl());
        BusinessObject obj = BusinessObject.createBusinessObject();
        obj.operation();
    }
}
