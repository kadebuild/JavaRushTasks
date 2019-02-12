package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int Capacity = (int)Math.max(16, Math.ceil(collection.size()/.75f));
        map = new HashMap<>(Capacity);
        addAll(collection);
        for (Map.Entry<E, Object> pair : map.entrySet()) {
            map.replace(pair.getKey(),PRESENT);
        }
    }

    @Override
    public boolean add(Object e) {
        if (map.put((E)e,PRESENT) == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        if (map.remove(o) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet amigoSet = new AmigoSet<>();
            amigoSet.addAll(this);
            amigoSet.map.putAll((Map) this.map.clone());
            return amigoSet;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        s.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        if (map.size() > 0) {
            for (Map.Entry<E, Object> pair : map.entrySet()) {
                s.writeObject(pair.getKey());
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int capacity = s.readInt();
        float loadFactor = s.readFloat();
        map = new HashMap<>(capacity,loadFactor);
        for (int i = 0; i < capacity; i++) {
            map.put((E)s.readObject(),PRESENT);
        }
    }

}
