package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {

    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public FileStorageStrategy() {
        for (int i = 0; i < table.length; i++) {
            table[i] = new FileBucket();
        }
    }

    public int hash(Long k) {
        k ^= (k >>> 20) ^ (k >>> 12);
        return (int)(k ^ (k >>> 7) ^ (k >>> 4));
    }

    public int indexFor(int hash, int length) {
        return hash & (length-1);
    }

    public Entry getEntry(Long key) {
        int hash = (key == null) ? 0 : hash((long) key.hashCode());
        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    public void resize(int newCapacity) {
        FileBucket[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == (1 << 30)) {
            bucketSizeLimit = Integer.MAX_VALUE;
            return;
        }
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
        bucketSizeLimit = (int)(newCapacity * 2);
    }

    public void transfer(FileBucket[] newTable) {
        FileBucket[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j].getEntry();
            if (e != null) {
                src[j] = null;
                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i].getEntry();
                    newTable[i].putEntry(e);
                    e = next;
                } while (e != null);
            }
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        if (size++ >= bucketSizeLimit)
            resize(2 * table.length);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return containsNullValue();
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i].getEntry(); e != null ; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;
    }

    private boolean containsNullValue() {
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i].getEntry(); e != null ; e = e.next)
                if (e.value == null)
                    return true;
        return false;
    }

    @Override
    public void put(Long key, String value) {
        if (key == null) {
            putForNullKey(value);
        } else {
            int hash = hash((long) key.hashCode());
            int i = indexFor(hash, table.length);
            for (Entry e = table[i].getEntry(); e != null; e = e.next) {
                Object k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                    e.value = value;
                }
            }
            addEntry(hash, key, value, i);
        }
    }

    private void putForNullKey(String value) {
        for (Entry e = table[0].getEntry(); e != null; e = e.next) {
            if (e.key == null) {
                String oldValue = e.value;
                e.value = value;
            }
        }
        addEntry(0, null, value, 0);
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            for (Entry e = table[i].getEntry(); e != null; e = e.next) {
                if (e.value.equals(value))
                    return e.key;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (key == null)
            return getForNullValue();
        int hash = hash((long) key.hashCode());
        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                return e.value;
        }
        return null;
    }

    private String getForNullValue() {
        for (Entry e = table[0].getEntry(); e != null; e = e.next) {
            if (e.key == null)
                return e.value;
        }
        return null;
    }
}
