package io.netty.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttributeKeyTest {

    @Test
    public void testExists() {
        String name = "test";
        assertFalse(AttributeKey.exists(name));
        AttributeKey<String> attributeKey = AttributeKey.valueOf(name);
        assertTrue(AttributeKey.exists(name));
        assertNotNull(attributeKey);
    }

    @Test
    public void testValueOf() {
        String name = "test1";
        assertFalse(AttributeKey.exists(name));
        AttributeKey<String> attr = AttributeKey.valueOf(name);
        AttributeKey<String> attr2 = AttributeKey.valueOf(name);
        assertSame(attr, attr2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewInstance() {
        String name = "test2";
        assertFalse(AttributeKey.exists(name));
        AttributeKey<String> attr = AttributeKey.newInstance(name);
        assertTrue(AttributeKey.exists(name));
        assertNotNull(attr);

        AttributeKey.newInstance(name);
    }
}