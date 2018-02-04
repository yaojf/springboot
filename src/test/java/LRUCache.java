import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private Map<K, Node<K, V>> map = null;
    private Node<K, V> head = new Node<K, V>(null, null);
    private Node<K, V> tail = new Node<K, V>(null, null);
    private int size;

    public LRUCache(int size) {
        this.size = size;
        this.map = new HashMap<K, Node<K, V>>();
        head.next = tail;
        tail.pre = head;
    }

    public V put(K k, V v) {
        Node<K, V> node = null;
        V old = null;
        if (map.containsKey(k)) {
            node = map.get(k);
            old = node.v = v;
        } else {
            if (map.size() >= size) {
                map.remove(removeTail());
            }
            node = new Node<>(k, v);
            map.put(k, node);
        }
        addHead(node);
        return old;
    }

    private void addHead(Node<K, V> node) {
        if (node.pre != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        Node cur = head.next;
        head.next = node;
        node.next = cur;
        cur.pre = node;
        node.pre = head;
    }

    private K removeTail() {
        if (tail.pre != head) {
            Node<K, V> node = tail.pre;
            tail.pre = node.pre;
            node.pre.next = tail;
            return node.k;
        }
        return null;
    }

    public V get(K k) {
        if (map.containsKey(k)) {
            Node<K, V> node = map.get(k);
            addHead(node);
            return node.v;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head.next;
        while (node != tail) {
            if (sb.length() != 0) {
                sb.append(",");
            }
            sb.append(node.k + "=" + node.v);
            node = node.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(5);

        lruCache.put("1", "1");
        lruCache.put("2", "2");
        lruCache.put("3", "3");
        lruCache.put("4", "4");
        lruCache.put("5", "5");

        System.out.println(lruCache);

        lruCache.get("3");
        System.out.println(lruCache);
        lruCache.put("6", "6");
        System.out.println(lruCache);
    }

    private static class Node<K, V> {
        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
}
