/**
 * HashMap 相关操作
 * @author bingxl<bingxl@outlook.com>
 * @date 2021/08/26
 * 
 * ---------- hashmap method ----------
 * boolean containsKey(Object Key)   hashMap中是否含有k
 * boolean containsValue(Object Value)   hashMap中是否含有v
 * V get(Object key)
 * boolean isEmpty()
 * void put(K key, V value);
 * V remove(Obkect key) 
 * int size()
 * Collection<V> values()
 * String toString()
 * Set entrySet()
 * Set keySet()
 * V merge(K key, V value)
 * void clear()
 * Object clone()
 * 
 * more @see devdocs.io/openjdk~15/java.base/java/util/hashmap
 */

package cn.bingxl.example;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // 初始化 HashMap， 参数为预分配的K，v对。
        HashMap<String, String> map = new HashMap<String, String>(10);

        String[] keys = { "name", "age", "school", "home", "phone" };
        String[] values = { "bingxl", "24", "xdu", "云南", "124" };

        for (int i = 0; i < keys.length; i++) {
            if (map.containsKey(keys[i])) {
                System.out.println(keys[i] + " has exists");
                map.remove(keys[i]);
            }
            map.put(keys[i], values[i]);

        }
        print("map.size: " + map.size());
        print("map.isEmpty: " + map.isEmpty());
        print("map.get(" + keys[1] + "):" + map.get(keys[1]));
        print("map.containsValue: " + map.containsValue(values[2]));
        print(map.keySet());
        print(map.entrySet());
        print(map.values());
        print("map.toString: " + map.toString());

        map.clear();
    }

    public static void print(Object msg) {
        System.out.println(msg);
    }
}