package io.netty.util;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author liuzhengyang
 */
public class DefaultAttributeMap implements AttributeMap {

    private static final AtomicReferenceFieldUpdater<DefaultAttributeMap, AtomicReferenceArray>
            updater = AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class,
            AtomicReferenceArray.class, "attributes");

    private static final int BUCKET_SIZE = 4;
    private static final int MASK = BUCKET_SIZE - 1;

    private volatile AtomicReferenceArray<DefaultAttribute<?>> attributes;
    @Override
    public <T> Attribute<T> attr(AttributeKey<T> key) {
        return null;
    }

    @Override
    public <T> boolean hasAttr(AttributeKey<T> key) {
        return false;
    }

    private static final class DefaultAttribute<T> extends AtomicReference<T> implements
            Attribute<T> {
        private final DefaultAttribute<?> head;
        private final AttributeKey<T> key;

        private DefaultAttribute<?> prev;
        private DefaultAttribute<?> next;

        private volatile boolean removed;

        DefaultAttribute() {
            head = this;
            key = null;
        }

        @Override
        public AttributeKey<T> key() {
            return key;
        }

        @Override
        public T setIfAbsent(T value) {
            while (!compareAndSet(null, value)) {
                T old = get();
                if (old != null) {
                    return old;
                }
            }
            return null;
        }

    }
}
