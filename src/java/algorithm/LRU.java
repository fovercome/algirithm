package java.algorithm;

import java.util.HashMap;

public class LRU<K, V>{
    private class Node{
        Node pre;
        Node next;
        K key;
        V value;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;

    public LRU(int maxSize) {
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
        this.maxSize = maxSize;
        map = new HashMap<>(maxSize * 4 / 3);
    }

    private void unlink(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return;
    }

    private Node appendHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
        return node;
    }

    private Node removaTail() {
        Node node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
        return node;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }
        Node node = new Node(key, value);
        appendHead(node);
        map.put(key, node);
        if (maxSize < map.size()) {
            Node remove = removaTail();
            map.remove(remove.key);
        }
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        unlink(node);
        appendHead(node);
        return node.value;

    }
}
