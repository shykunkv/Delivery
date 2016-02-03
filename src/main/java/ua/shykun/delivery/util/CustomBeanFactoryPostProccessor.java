package ua.shykun.delivery.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;

public class CustomBeanFactoryPostProccessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("newCustomer");
        ConstructorArgumentValues argumentValues = bd.getConstructorArgumentValues();

        argumentValues.getArgumentValue(0, null).setValue("HAHAHAHAH");

    }
}
