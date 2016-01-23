package ua.shykun.delivery.util;


public interface Config {
    public <T> Class<T> getImpl(String ifc);
}
