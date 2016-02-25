package ua.shykun.delivery.util;

import ua.shykun.delivery.util.annotations.Benchmark;

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

                            long start = System.nanoTime();
                            Object res = method.invoke(o, args);
                            long end = System.nanoTime();

                            String time;

                            if (benchmark.measure() == Benchmark.Measure.MILLIS) {
                                time = ""  + (end - start) / 1e6 + " ms.";
                            } else {
                                time = "" + (end - start) + " ns.";
                            }
                            System.out.println("[" + method.getName() + "] time: " + time);

                            return res;
                        } else {
                            return method.invoke(o, args);
                       }
                    }

                });
    }

}
