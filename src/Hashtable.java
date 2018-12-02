import java.util.ArrayList;

public class Hashtable implements HashTableSignature {

    //    size of the table
    private int num_buckets;

    //    numebr of items in the Hashtable
    private int size;

    private ArrayList<HashNode> buckets;

    public Hashtable() {
        this(0, 0);
    }

    public Hashtable(int num_buckets, int size) {
        this.num_buckets = num_buckets;
        this.size = size;
        this.buckets = new ArrayList<>();
    }

    public static void main(String[] args) {
        String a = "hello world";
        String b = "hello Irving";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    @Override
    public boolean containsKey(String key) {
        return false;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public void put(String key, String value) {

    }

    @Override
    public String remove(String key) {
        return null;
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
