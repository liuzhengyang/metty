package io.netty.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author liuzhengyang
 */
public abstract class AbstractConstant<T extends AbstractConstant<T>> implements Constant<T> {

    private static final AtomicLong uniqueIdGenerator = new AtomicLong();
    private final int id;
    private final String name;
    private final long uniquifier;

    public AbstractConstant(int id, String name) {
        this.id = id;
        this.name = name;
        uniquifier = uniqueIdGenerator.getAndIncrement();
    }

    @Override
    public final int id() {
        return id;
    }

    @Override
    public final String name() {
        return name;
    }

    @Override
    public final int compareTo(T o) {
        if (this == o) {
            return 0;
        }

        AbstractConstant<T> other = o;
        int returnCode;

        returnCode = hashCode() - other.hashCode();
        if (returnCode != 0) {
            return returnCode;
        }

        if (uniquifier < other.uniquifier) {
            return -1;
        }
        if (uniquifier > other.uniquifier) {
            return 1;
        }
        throw new Error("failed to compare two different constants");
    }
}
