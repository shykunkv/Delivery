package ua.shykun.delivery.util;


public class ServiceLocator {
    
    private static final ServiceLocator instance = new ServiceLocator();
    private final Config config = new JavaConfig();
    
    private ServiceLocator() {}

    public static ServiceLocator getInstance() {
        return instance;
    }

    public Object createObject(String objectName) throws InstantiationException, IllegalAccessException {
        return config.getImpl(objectName).newInstance();
    }
}
