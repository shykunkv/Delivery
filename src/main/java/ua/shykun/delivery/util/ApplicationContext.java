package ua.shykun.delivery.util;

public interface ApplicationContext  {
    Object getBean(String beanName) throws Exception;
}
