package ua.shykun.delivery.util;

import ua.shykun.delivery.annotations.AfterCreate;

import java.lang.reflect.Constructor;
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
        builder.createProxy();
        builder.afterConstruct();
        bean = builder.build();

        map.put(beanName, bean);
        return bean;
    }


    class BeanBuilder {

        Class<?> type;
        Object bean;
        Object proxy;

        public BeanBuilder(Class<?> type) {
            this.type = type;
        }

        public void construct() throws Exception {

            Constructor<?> constructor = type.getConstructors()[0];

            if (constructor.getParameters().length == 0) {
                bean = type.newInstance();
            } else {
                bean = constructWithParameters(constructor);
            }
        }

        public Object constructWithParameters(Constructor<?> constructor) throws Exception {
            Parameter[] parameters = constructor.getParameters();
            Object[] params = new Object[parameters.length];
            for (int i = 0; i <  params.length; i++) {
                Parameter param = parameters[i];
                String className = param.getType().getSimpleName();
                params[i] = getBean(Character.toLowerCase(className.charAt(0)) + className.substring(1));
            }
            return constructor.newInstance(params);
        }

        public void afterConstruct() {
            try {
                invokeInit();
            } catch (Exception ex) {}

            try {
                invokeAfterCreate();
            } catch (Exception ex) {}
        }

        public void invokeInit() throws Exception {
            Class<?> clazz = bean.getClass();
            Method init = clazz.getMethod("init");
            init.invoke(bean);
        }

        public void invokeAfterCreate() throws Exception {
            Class<?> clazz = bean.getClass();
            Method[] methods = clazz.getMethods();
            for (Method method: methods) {
                if (method.isAnnotationPresent(AfterCreate.class) && !method.getName().equals("init")) {
                    method.invoke(bean);
                }
            }
        }

        public void createProxy() {
            proxy = BenchmarkProxy.checkForBenchmarkAndGetProxy(bean);
        }

        public Object build() {
            return proxy;
        }
    }

}
