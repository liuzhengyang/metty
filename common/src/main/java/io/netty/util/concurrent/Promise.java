package io.netty.util.concurrent;

/**
 * Special {@link Future} which is writable.
 * @author liuzhengyang
 */
public interface Promise<V> extends Future<V> {

    Promise<V> setSuccess(V result);

    boolean trySuccess(V result);

    Promise<V> setFailure(Throwable cause);

    boolean tryFaiure(Throwable cause);

    Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> listener);
}
