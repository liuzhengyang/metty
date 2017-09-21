package io.netty.util.concurrent;

import java.util.EventListener;

/**
 * Listends to the result of a {@link Future}. The result of the asynchronous operation is
 * notified once this listener is added by calling
 * {@link Future#addListener(GenericFutureListener)}
 * @author liuzhengyang
 */
public interface GenericFutureListener<F extends Future<?>> extends EventListener {

    /**
     * Invoked when the operation associated with the {@link Future} has beed completed.
     * @param future the souce {@link Future} which called this callback
     */
    void operationComplete(F future) throws Exception;
}
