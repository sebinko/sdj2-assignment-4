package utility;

import java.util.HashMap;
import java.util.Map;

public class Valuable {
    private static final Map<Type, Valuable> instances = new HashMap<>();
    private final int value;

    static {
        for (Type type : Type.values()) {
            instances.put(type, new Valuable(type.getValue()));
        }
    }

    private Valuable(int value) {
        this.value = value;
    }

    public enum Type {
        DIAMOND(250),
        EMERALD(100),
        RUBY(50),
        GOLD(25);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public int getValue() {
        return this.value;
    }

    public static Valuable getInstance(Type type) {
        return instances.get(type);
    }

    @Override
    public String toString() {
        return "Valuable{" +
                "value=" + value +
                '}';
    }
}