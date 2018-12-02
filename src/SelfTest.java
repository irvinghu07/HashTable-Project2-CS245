public class SelfTest {
    public static void main(String[] args) {
        int a = -8;
        a &= 0x7fffffff;
        System.out.println(a);
        Hashtable hashtable = new Hashtable();
        String key = "Ethan";
        String value = "Irving";
        hashtable.put(key, value);
        System.out.println(hashtable.remove(key));

    }
}
