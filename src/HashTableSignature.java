public interface HashTableSignature {
    boolean containsKey (String key);
    String get (String key);
    void put (String key, String value);
    String remove (String key);
}
