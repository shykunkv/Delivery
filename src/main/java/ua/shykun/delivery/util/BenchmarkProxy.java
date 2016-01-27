package ua.shykun.delivery.util;

import ua.shykun.delivery.annotations.Benchmark;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BenchmarkProxy {

    public static Object checkForBenchmarkAndGetProxy(Object o) {
        Method[] methods = o.getClass().getMethods();

        for (Method method: methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                return getBenchmarkProxy(o);
            }
        }

        return o;
    }


    public static Object getBenchmarkProxy(final Object o) {
        return Proxy.newProxyInstance(
                o.getClass().getClassLoader(),
                new Class[]{o.getClass().getInterfaces()[0]},
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        method = o.getClass().getMethod(method.getName(), method.getParameterTypes());
                        if (method.isAnnotationPresent(Benchmark.class)) {
                            Annotation annotation = method.getAnnotation(Benchmark.class);
                            Benchmark benchmark = (Benchmark) annotation;
                            Object res;
                            if (benchmark.measure() == Benchmark.Measure.MILLIS) {
                                long start = System.nanoTime();
                                res = method.invoke(o, args);
                                long end = System.nanoTime();
                                System.out.println("[" + method.getName() + "] time: " + ((end - start) / 1e6) + " ms.");
                            } else {
                                long start = System.nanoTime();
                                res = method.invoke(o, args);
                                long end = System.nanoTime();
                                System.out.println("[" + method.getName() + "] time: " + (end - start) + " ns.");
                            }

                            return res;
                        } else {
                            return method.invoke(o, args);
                       }
                    }

                });
    }

}
