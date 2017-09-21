package io.netty.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class ConstantPoolTest {
    static final class TestConstant extends AbstractConstant<TestConstant> {
        TestConstant(int id, String name) {
            super(id, name);
        }
    }

    private static final ConstantPool<TestConstant> pool = new ConstantPool<TestConstant>() {
        @Override
        protected TestConstant newConstant(int id, String name) {
            return new TestConstant(id, name);
        }
    };

    @Test(expected = NullPointerException.class)
    public void testCannotProvideNullName() {
        pool.valueOf(null);
    }

    @SuppressWarnings("RedundantStringConstructorCall")
    @Test
    public void testUniqueness() {
        TestConstant a = pool.valueOf(new String("lzy"));
        TestConstant b = pool.valueOf(new String("lzy"));
        assertThat(a, is(sameInstance(b)));
    }

    @Test
    public void testIdUniqueness() {
        TestConstant one = pool.valueOf("one");
        TestConstant two = pool.valueOf("two");
        assertThat(one.id(), is(not(two.id())));
    }

    @Test
    public void testCompare() {
        TestConstant a = pool.valueOf("a_");
        TestConstant b = pool.valueOf("b_");
        TestConstant c = pool.valueOf("c_");
        TestConstant d = pool.valueOf("d_");
        TestConstant e = pool.valueOf("e_");

        Set<TestConstant> set = new TreeSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        set.add(e);



    }
}