package io.netty.util.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * The result of an asynchronous operation.
 * @param <V>
 */
public interface Future<V> extends java.util.concurrent.Future<V> {

    /**
     * Returns {@code true} if and only if the I/O operation was completed
     * successfully
     */
    boolean isSuccess();

    /**
     * returns {@code true} if and only if the opreration can be cancelled
     * via {@link #cancel(boolean)}.
     */
    boolean isCancellable();

    /**
     * Retusn the cause of the failed I/O operation if the I/O operation has failed.
     *
     * @return the cause of the failure.
     *  {@code null} if succeeded or this future is not completed yet.
     */
    Throwable cause();

    Future<V> addListener(GenericFutureListener<? extends Future<? super V>> listener);

    /**
     * Return the reuslt without blocking. If the future is not done yet this will return {@code
     * null}.
     *
     * As it is possible that a {@code null} value is used to mark the future as successful you
     * also need to check if the future is really done with {@link #isDone()}} and not relay on
     * the returned {@code null} value.
     * @return
     */
    V getNow();

    /**
     * Waits for this future until it is done, and rethrows the cause of the failure if this future
     * failed.
     */
    Future<V> sync() throws InterruptedException;

    /**
     * Waits for this future until it is done, and rethrows the cause of the failure if this future
     * failed.
     */
    Future<V> syncUninterruptibly();

    Future<V> await();

    /**
     * Waits for this future to be completed within the
     * specified time limit.
     * @return {@code true} if and only if the future was completed within
     *      the specified time unit
     * @throws InterruptedException
     *      if the current thread was interrupted
     */
    boolean await(long timeout, TimeUnit timeUnit) throws InterruptedException;


}
