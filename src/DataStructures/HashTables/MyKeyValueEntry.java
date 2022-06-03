package DataStructures.HashTables;

import java.util.Objects;

/**
 * Credit: Mahfuzur Rahman
 * Link to article: https://medium.com/swlh/hashmap-implementation-for-java-90a5f58d4a5b
 */
public class MyKeyValueEntry<K, V> {
    private K key;
    private V value;

    public MyKeyValueEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // getters & setters
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    // hashCode & equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyKeyValueEntry)) return false;
        MyKeyValueEntry<?, ?> that = (MyKeyValueEntry<?, ?>) o;
        return getKey().equals(that.getKey()) && getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }
}

