package DataStructures.HashTables;

import java.util.LinkedList;
import java.util.List;

/**
 * Credit: Mahfuzur Rahman
 * Link to article: https://medium.com/swlh/hashmap-implementation-for-java-90a5f58d4a5b
 */
public class MyMapBucket {
    private List<MyKeyValueEntry> entries;

    public MyMapBucket() {
        if(entries == null) {
            entries = new LinkedList<>();
        }
    }

    public List<MyKeyValueEntry> getEntries() {
        return entries;
    }

    public void addEntry(MyKeyValueEntry entry) {
        this.entries.add(entry);
    }

    public void removeEntry(MyKeyValueEntry entry) {
        this.entries.remove(entry);
    }
}
