package ua.shykun.delivery.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


public class BenchmarkBeanPostProccessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object proxy = BenchmarkProxy.checkForBenchmarkAndGetProxy(bean);
        return proxy;
    }
}
