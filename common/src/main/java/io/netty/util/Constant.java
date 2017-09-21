package io.netty.util;

/**
 * A singleton which is safe to compare via the {@code ==} operator. Created and managed by
 * {@link ConstantPool}
 * @author liuzhengyang
 */
public interface Constant<T extends Constant<T>> extends Comparable<T> {

    int id();

    String name();
}
