package io.netty.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuzhengyang
 */
public abstract class ConstantPool<T extends Constant<T>> {

    private final ConcurrentMap<String, T> constants = new ConcurrentHashMap<>();

    private final AtomicInteger nextId = new AtomicInteger(1);


}
