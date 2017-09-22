package io.netty.util;

/**
 * Holds {@link Attribute}s which cank be accessed via {@link AttributeKey}.
 * @author liuzhengyang
 */
public interface AttributeMap {

    /**
     * Get the {@link Attribute} for the given {@link AttributeKey}. This method never return null,
     * but may return an {@link Attribute} which does not have a value set yet.
     */
    <T> Attribute<T> attr(AttributeKey<T> key);

    /**
     * Returns {@code true} if and only if the given {@link Attribute} exists in this
     * {@link AttributeMap}
     */
    <T> boolean hasAttr(AttributeKey<T> key);
}
