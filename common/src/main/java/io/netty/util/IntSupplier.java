package io.netty.util;

/**
 * Represents a supplier of {@code int}-valued results.
 * @author liuzhengyang
 */
public interface IntSupplier {

    int get() throws Exception;
}
