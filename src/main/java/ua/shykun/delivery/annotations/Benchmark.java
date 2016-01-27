package ua.shykun.delivery.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Benchmark {

    public enum Measure {
        NANOS, MILLIS
    }

    Measure measure() default Measure.MILLIS;
}
