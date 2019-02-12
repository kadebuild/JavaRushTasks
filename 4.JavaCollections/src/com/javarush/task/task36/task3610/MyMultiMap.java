package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int sizeOfMultiMap = 0;
        for (List<V> list : map.values()) {
            sizeOfMultiMap += list.size();
        }
        return sizeOfMultiMap;
    }

    @Override
    public V put(K key, V value) {
        if (map.containsKey(key)) {
            if (map.get(key).size() == repeatCount) {
                map.get(key).remove(0);
            }
            map.get(key).add(value);
            return map.get(key).get(map.get(key).size()-2);
        } else {
            List<V> arrayList = new ArrayList<>();
            arrayList.add(value);
            map.put(key, arrayList);
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        V element = null;
        if (map.containsKey(key)) {
            element = map.get(key).get(0);
            map.get(key).remove(0);
            if (map.get(key).size() == 0) {
                map.remove(key);
            }
        }
        return element;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> arrayList = new ArrayList<>();
        for (List<V> list : map.values()) {
            for (V element : list) {
                arrayList.add(element);
            }
        }
        return arrayList;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}