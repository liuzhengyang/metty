package io.netty.util;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuzhengyang
 */
public abstract class ConstantPool<T extends Constant<T>> {

    private final ConcurrentMap<String, T> constants = new ConcurrentHashMap<>();

    private final AtomicInteger nextId = new AtomicInteger(1);

    public T valueOf(String name) {
        checkNotNullAndNotEmpty(name);
        return getOrCreate(name);
    }

    /**
     * Get existing constant by name or creates new one if not exist. Threadsafe
     * @param name the name of the {@link Constant}
     */
    private T getOrCreate(String name) {
        T constant = constants.get(name);
        if (constant == null) {
            final T tempConstant = newConstant(nextId(), name);
            constant = constants.putIfAbsent(name, tempConstant);
            if (constant == null) {
                return tempConstant;
            }
        }

        return constant;
    }

    /**
     * Returns {@code true} if a {@link AttributeKey} exists for the given {@code name}
     */
    public boolean exists(String name) {
        checkNotNullAndNotEmpty(name);
        return constants.containsKey(name);
    }

    public T newInstance(String name) {
        checkNotNullAndNotEmpty(name);
        return createOrThrow(name);
    }

    private T createOrThrow(String name) {
        T constant = constants.get(name);
        if (constant == null) {
            final T tempConstant = newConstant(nextId(), name);
            constant = constants.putIfAbsent(name, tempConstant);
            if (constant == null) {
                return tempConstant;
            }
        }

        throw new IllegalArgumentException(String.format("'%s' is already in use", name));
    }

    private static String checkNotNullAndNotEmpty(String name) {
        Objects.requireNonNull(name);

        if (name.isEmpty()) {
            throw new IllegalArgumentException("empty name");
        }

        return name;
    }

    protected abstract T newConstant(int id, String name);

    public final int nextId() {
        return nextId.getAndIncrement();
    }

}
