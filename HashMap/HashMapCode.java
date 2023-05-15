package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {

    // HashMap internally implemented using Array of LinkedList in Java
    // Which node will go into which bucket(array index) is decided by the hashing algorithm
    // Example: "abc" -> 2654 (changing the form of data is hashing)
    // Example of several hashing algorithm are SHA-1, SHA-2

    // n = no. of nodes, N = no. of buckets
    // lambda = n/N (n nodes are divided into N buckets)
    // lambda <= K(constant)  (which is also called threshold value)
    // When the value of lambda increases and when it gets greater than threshold value, we will increase our bucket(array).

    // Rehashing:
    // when the load factor increases to more than its pre-defined value (default value of load factor is 0.75),
    // the complexity increases. So to overcome this, the size of the array is increased (doubled) and all the values are hashed again
    // and stored in the new double sized array to maintain a low load factor and low complexity.

    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;  // no. of nodes
        private int N;  // no. of buckets
        private LinkedList<Node>[] buckets;  // N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }


        // put
        // Average case TC - O(lambda) = O(1)
        // Worst case TC - O(n)
        // Worst case takes place when all the data(key, value) gets add on single bucket index(array index)
        // This can happen when: 1. our hash function is returning same bucket index on every key
        // or 2. our data is something like it coincidentally returns same bucket index for every key
        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if (dataIndex == -1) {  // key doesn't exist
                buckets[bucketIndex].add(new Node(key, value));
                n++;
            } else {  // key exists
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 1.75) {
                rehash();
            }
        }

        private int hashFunction(K key) {
            int bucketIndex = key.hashCode();
            return Math.abs(bucketIndex) % N;  // 0 to N-1
        }

        private int searchInLL(K key, int bucketIndex) {
            LinkedList<Node> list = buckets[bucketIndex];
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node>[] oldBucket = new LinkedList[N * 2];
            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> list = oldBucket[i];
                for (int j = 0; j < list.size(); j++) {
                    Node node = list.get(j);
                    put(node.key, node.value);
                }
            }
        }


        // containsKey
        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if (dataIndex == -1) {  // key doesn't exist
                return false;
            } else {  // key exists
                return true;
            }
        }


        // remove
        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if (dataIndex == -1) {  // key doesn't exist
                return null;
            } else {  // key exists
                Node node = buckets[bucketIndex].remove(dataIndex);
                n--;
                return node.value;
            }
        }


        // get
        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if (dataIndex == -1) {  // key doesn't exist
                return null;
            } else {  // key exists
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }
        }


        // keySet
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {  // bucket index
                LinkedList<Node> list = buckets[i];
                for (int j = 0; j < list.size(); j++) {  // data index
                    Node node = list.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }


        // isEmpty
        public boolean isEmpty() {
            return n == 0;
        }

    }


    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);

        ArrayList<String> keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }

        map.remove("China");
        System.out.println(map.get("China"));
    }

}
