package io.netty.util.concurrent;

/**
 * @author liuzhengyang
 */
public interface EventExecutor extends EventExecutorGroup {

    @Override
    EventExecutor next();

    EventExecutorGroup parent();

    boolean inEventLoop();

    /**
     * Return {@code true} if the given {@link Thread} is executed in the event loop,
     * {@code false} otherwise
     */
    boolean inEventLoop(Thread thread);

    <V> Promise<V> newPromise();
}
