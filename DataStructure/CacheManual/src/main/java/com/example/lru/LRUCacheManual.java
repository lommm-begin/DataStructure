package com.example.lru;

import java.util.HashMap;
import java.util.Map;


/**
 * LRU
 * @param <K>
 * @param <V>
 */
public class LRUCacheManual<K, V> {
    private final int capacity; // 容量大小
    // 值使用的是对象，让其list是存储是当前的引用，而无需遍历
    private final Map<K, Node<K, V>> cache;
    private final DoublyLinkList<K, V> list;

    public LRUCacheManual(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkList<>();
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        Node<K, V> node = cache.get(key);
        list.moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            node.value = value;
            list.moveToHead(node);
        } else {
            if (cache.size() >= capacity) {
                // 删除最末尾的最近最少使用元素
                Node<K, V> kvNode = list.removeTail();
                cache.remove(kvNode.key);
            }
            Node<K, V> node = new Node<>(key, value);
            cache.put(key, node);
            list.addToHead(node);
        }
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    static class DoublyLinkList<K, V> {
        private final Node<K, V> head;
        private final Node<K, V> tail;

        public DoublyLinkList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
        }

        void addToHead(Node<K, V> node) {
            node.prev = head;
            node.next = head.next;
            head.next = node;
            head.next.prev = node;
        }

        // 根据引用删除，无需遍历
        void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // 先根据引用删除，然后再将其添加到头部
        void moveToHead(Node<K, V> node) {
            removeNode(node);
            addToHead(node);
        }

        Node<K, V> removeTail() {
            Node<K, V> prev = tail.prev;
            removeNode(prev);

            return prev;
        }
    }

    public static void main(String[] args) {
        LRUCacheManual<Integer, Object> objectLRUCacheManual = new LRUCacheManual<>(3);

        objectLRUCacheManual.put(1, "A");
        objectLRUCacheManual.put(2, "B");
        objectLRUCacheManual.put(3, "C");

        System.out.println(objectLRUCacheManual.get(1));
        objectLRUCacheManual.put(4, "D");
        System.out.println("--------------");

        System.out.println(objectLRUCacheManual.get(1));
        System.out.println(objectLRUCacheManual.get(2));
    }
}
