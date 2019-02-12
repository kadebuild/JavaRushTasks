package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Абв",1000);
        map.put("Бвг",100);
        map.put("Вгд",250);
        map.put("Где",750);
        map.put("Деё",500);
        map.put("Еёж",1500);
        map.put("Ёжз",1785);
        map.put("Жзи",350);
        map.put("Зик",175);
        map.put("Икл",550);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> newMap = new HashMap<>(map);
        for (Map.Entry<String,Integer> pair : newMap.entrySet()) {
            if (pair.getValue() < 500) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}