package io.netty.util;

/**
 * An attribute which allows to store a value reference. It may be updated atomically and so is
 * thread safe
 * @param <T> the type of the value it holds.
 * @author liuzhengyang
 */
public interface Attribute<T> {
    AttributeKey<T> key();

    T get();

    void set(T value);

    T getAndSet(T value);

    T setIfAbsent(T value);

    boolean compareAndSet(T oldValue, T newValue);
}
