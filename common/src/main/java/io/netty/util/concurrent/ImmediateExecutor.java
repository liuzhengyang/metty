package io.netty.util.concurrent;

import java.util.Objects;
import java.util.concurrent.Executor;

/**
 * {@link Executor} which execute tasks in the callers thread.
 * @author liuzhengyang
 */
public class ImmediateExecutor implements Executor {
    public static final ImmediateExecutor INSTANCE = new ImmediateExecutor();

    private ImmediateExecutor() {
        // use static instance
    }
    @Override
    public void execute(Runnable command) {
        command = Objects.requireNonNull(command, "command");
        command.run();
    }
}
