package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplement {

    // Data gets stored in key-value pairs
    // All these operations achieved in O(1)

    // Methods of HashMap:
    //                  exists                          doesn't exist
    // put              update                          Insert
    // get              return value                    null
    // containsKey      true                            false
    // remove           removes and returns value       null
    // keySet
    // size


    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;  // n
        private LinkedList<Node>[] buckets;  // N = buckets.length

        public HashMap() {
            initBuckets(4);
            size = 0;
        }

        private void initBuckets(int N) {
            buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        // put
        public void put(K key, V value) throws Exception {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);

            if (dataIndex != -1) {
                Node node = buckets[dataIndex].get(dataIndex);
                node.value = value;
            } else {
                Node node = new Node(key, value);
                buckets[bucketIndex].add(node);
                size++;
            }

            double lambda = size * 1.0 / buckets.length;
            if (lambda > 2.0) {  // threshold is 2
                reHash();
            }

        }

        private int hashFunction(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % buckets.length;
        }

        private int getIndexWithinBucket(K key, int bucketIndex) {
            int dataIndex = 0;
            for (Node node : buckets[bucketIndex]) {
                if (node.key.equals(key)) {
                    return dataIndex;
                }
                dataIndex++;
            }
            return -1;
        }

        private void reHash() throws Exception {
            LinkedList<Node>[] oldBucketArray = buckets;

            initBuckets(oldBucketArray.length * 2);
            size = 0;

            for (LinkedList<Node> nodes : oldBucketArray) {
                for (Node node : nodes) {
                    put(node.key, node.value);
                }
            }
        }


        // get
        public V get(K key) throws Exception {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);

            if (dataIndex != -1) {
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            } else {
                return null;
            }
        }


        // containsKey
        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);

            return dataIndex != -1;
        }


        // remove
        public V remove(K key) throws Exception {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);

            if (dataIndex != -1) {
                Node node = buckets[bucketIndex].remove(dataIndex);
                size--;
                return node.value;
            } else {
                return null;
            }
        }


        // keySet
        public ArrayList<K> keySet() throws Exception {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> bucket : buckets) {
                for (Node node : bucket) {
                    keys.add(node.key);
                }
            }
            return keys;
        }


        // size
        public int size() {
            return size;
        }


        public void display() {
            for (int i = 0; i < buckets.length; i++) {
                System.out.print("Bucket" + i + ": ");
                for (Node node : buckets[i]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
        }
    }


    public static void main(String[] args) throws Exception {
        HashMap map = new HashMap();
        map.put("India", 200);
        map.put("Canada", 100);
        map.put("US", 50);
//      System.out.println(map.keySet());
        map.display();
    }


}
