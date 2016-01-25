package ua.shykun.delivery.util;

import ua.shykun.delivery.annotations.AfterCreate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class JavaConfigApplicationContext implements ApplicationContext {

    private Config config;
    private Map<String, Object> map = new HashMap<>();

    public JavaConfigApplicationContext(Config config) {
        this.config = config;
    }

    @Override
    public Object getBean(String beanName) throws Exception {

        Object bean = map.get(beanName);
        Class<?> type = config.getImpl(beanName);


        if (bean != null) {
            return bean;
        }

        BeanBuilder builder = new BeanBuilder(type);
        builder.construct();
        builder.afterConstruct();
        builder.createProxy();
        bean = builder.build();

        map.put(beanName, bean);
        return bean;

    }


    class BeanBuilder {

        Class<?> type;
        Object bean;

        public BeanBuilder(Class<?> type) {
            this.type = type;
        }

        public void construct() throws Exception {
            Constructor<?> constructor = type.getConstructors()[0];
            Parameter[] parameters = constructor.getParameters();

            if (parameters.length == 0) {
                bean = type.newInstance();
            }

            Object[] params = new Object[parameters.length];
            for (int i = 0; i <  params.length; i++) {
               Parameter param = parameters[i];
               String className = param.getType().getSimpleName();
               params[i] = getBean(Character.toLowerCase(className.charAt(0)) + className.substring(1));
            }
            bean = constructor.newInstance(params);
        }

        public void afterConstruct() {
            Class<?> clazz = bean.getClass();

            try {
                Method init = clazz.getMethod("init");
                init.invoke(bean);
            } catch (Exception ex) {
                //Handle exception
            }

            try {
                Method[] methods = clazz.getMethods();
                for (Method method: methods) {
                    if (method.isAnnotationPresent(AfterCreate.class) && !method.getName().equals("init")) {
                        method.invoke(bean);
                    }
                }
            } catch (Exception ex) {
                //Handle exception
            }

        }

        public void createProxy() {

        }

        public Object build() {
            return bean;
        }
    }

}
