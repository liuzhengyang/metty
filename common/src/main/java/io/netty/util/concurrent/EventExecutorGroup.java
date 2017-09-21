package io.netty.util.concurrent;

import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author liuzhengyang
 */
public interface EventExecutorGroup extends ScheduledExecutorService, Iterable<EventExecutor> {

    boolean isShuttingDown();

    EventExecutor next();

    Iterator<EventExecutor> iterator();


}
