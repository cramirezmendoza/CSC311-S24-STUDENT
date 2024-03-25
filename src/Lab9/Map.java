package Lab9;
public interface Map {

    public void put(String key, String value);

    /**
     *
     * @param key
     * @return value or NULL if the key is not found
     */
    public String get(String key);

    /**
     *
     * @param key
     * @return value or NULL if the key is not found
     */

    public String remove(String key);

    public boolean containsKey(String key);
    public boolean containsValue(String value);
    public int size();
    public boolean isEmpty();
    public void clear();
    public String[] keys();
    public String[] values();


}
