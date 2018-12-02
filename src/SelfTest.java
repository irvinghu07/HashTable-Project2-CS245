public class SelfTest {
    public static void main(String[] args) {
//        ArrayList<String> arr = new ArrayList<>(100);
//        arr.get(15);
        Hashtable hashtable = new Hashtable();
        String key = "Ethan";
        String value = "Irving";
        hashtable.put(key, value);
        System.out.println(hashtable.remove(key));
    }
}
