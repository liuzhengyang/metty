package io.netty.util.concurrent;

import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author liuzhengyang
 */
public class DefaultPromise<V> extends AbstractFuture<V> implements Promise<V> {

    @SuppressWarnings("rawtypes")
    private static final AtomicReferenceFieldUpdater<DefaultPromise, Object> RESULT_UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(DefaultPromise.class, Object.class, "result");

    private volatile Object result;
    private final EventExecutor executor;

    public DefaultPromise(EventExecutor executor) {
        this.executor = requireNonNull(executor, "executor");
    }

    public Promise<V> setSuccess(V result) {
        return null;
    }

    public boolean trySuccess(V result) {
        return false;
    }

    public Promise<V> setFailure(Throwable cause) {
        return null;
    }

    public boolean tryFaiure(Throwable cause) {
        return false;
    }

    public boolean isSuccess() {
        return false;
    }

    public boolean isCancellable() {
        return false;
    }

    public Throwable cause() {
        return null;
    }

    public Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> listener) {
        return null;
    }

    public V getNow() {
        return null;
    }

    public Future<V> sync() throws InterruptedException {
        return null;
    }

    public Future<V> syncUninterruptibly() {
        return null;
    }

    public Future<V> await() {
        return null;
    }

    public boolean await(long timeout, TimeUnit timeUnit) throws InterruptedException {
        return false;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    private boolean setValue0(Object objResult) {
        if (RESULT_UPDATER.compareAndSet(this, null, objResult) || RESULT_UPDATER.compareAndSet
                (this, )) {

        }
    }
}
