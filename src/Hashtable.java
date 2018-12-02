public class Hashtable implements HashTableSignature {

    private static int DEFAULT_NUMBER_OF_BUCKETS = 2048;
    //    size of the table
    private int num_buckets;

    //    numebr of items in the Hashtable
    private int size;

    //    private ArrayList<HashNode> buckets;
    private HashNode[] buckets;

    public Hashtable() {
        this(DEFAULT_NUMBER_OF_BUCKETS);
    }

    public Hashtable(int num_buckets) {
        this.num_buckets = num_buckets;
        this.size = 0;
        this.buckets = new HashNode[num_buckets];
    }

    private int getBucket(String key) {
        return key.hashCode() % num_buckets;
    }


    @Override
    public boolean containsKey(String key) {
        int bucket_id = getBucket(key);
        if (this.buckets[bucket_id] != null) {
            HashNode head = this.buckets[bucket_id];
            while (null != head) {
                if (head.getKey() == key) {
                    return true;
                }
                head = head.getNext();
            }
        }
        return false;
    }

    @Override
    public String get(String key) {
        int bucket_id = getBucket(key);
        HashNode head = this.buckets[bucket_id];
        if (null == head) {
            return null;
        } else {
            while (null != head) {
                if (key == head.getKey()) {
                    return head.getValue();
                }
                head = head.getNext();
            }
        }
        return null;
    }

    @Override
    public void put(String key, String value) {
        int bucket_id = getBucket(key);
        HashNode node = buckets[bucket_id];
        while (null != node) {
            if (key == node.key) {
                node.value = value;
                return;
            }
            node = node.next;
        }

//        if reach this point, then the bucket is either empty or there is no match key related!! node == null now
        HashNode newNode = new HashNode(key, value);
        buckets[bucket_id] = newNode;
        this.size++;
    }

    @Override
    public String remove(String key) {
        int bucket_id = getBucket(key);
        HashNode node = buckets[bucket_id];
        if (this.buckets[bucket_id] == null) {
            throw new RuntimeException("removing a key not in designated bucket");
        }
        HashNode previousNode = null;
        while (null != node) {
            String returnVal;
            if (node.getKey() == key) {
                returnVal = node.getValue();
                // at this point we find the target;
                if (previousNode == null) {
                    // we find head as the target
                    buckets[bucket_id] = null;
                } else if (null != node.getNext()) {
                    // target have following node
                    previousNode.setNext(node.getNext());
                } else {
                    //target is the last element of this bucket
                    previousNode.setNext(null);
                }
                return returnVal;
            }
            previousNode = node;
            node = node.getNext();
        }
        throw new RuntimeException("removing a key not in designated bucket");
    }

    class HashNode {
        private String key;
        private String value;
        private HashNode next;

        public HashNode(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public HashNode getNext() {
            return next;
        }

        public void setNext(HashNode next) {
            this.next = next;
        }
    }
}
