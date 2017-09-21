package io.netty.util;

/**
 * @author liuzhengyang
 */
public class AttributeKey<T> extends AbstractConstant<AttributeKey<T>> {

    private static final ConstantPool<AttributeKey<Object>> pool = new ConstantPool<AttributeKey<Object>>() {
        @Override
        protected AttributeKey<Object> newConstant(int id, String name) {
            return new AttributeKey<>(id, name);
        }
    };

    private AttributeKey(int id, String name) {
        super(id, name);
    }

    @SuppressWarnings("unchecked")
    public static <T> AttributeKey<T> valueOf(String name) {
        return (AttributeKey<T>) pool.valueOf(name);
    }

    public static boolean exists(String name) {
        return pool.exists(name);
    }

    public static <T> AttributeKey<T> newInstance(String name) {
        return (AttributeKey<T>) pool.newInstance(name);
    }
}
