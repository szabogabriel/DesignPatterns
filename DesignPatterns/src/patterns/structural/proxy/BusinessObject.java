package patterns.structural.proxy;

import patterns.structural.proxy.impl.BusinessObjectAuthProxy;
import patterns.structural.proxy.impl.BusinessObjectImpl;
import patterns.structural.proxy.impl.BusinessObjectLoggingProxy;

public interface BusinessObject {
    void operation();

    static BusinessObject createBusinessObject() {
//        return new BusinessObjectLoggingProxy(new BusinessObjectImpl());
//        return new BusinessObjectAuthProxy(new BusinessObjectLoggingProxy(new BusinessObjectImpl()));
        return new BusinessObjectAuthProxy(new BusinessObjectLoggingProxy());
    }
}
