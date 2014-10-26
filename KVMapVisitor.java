package kvmap;


/**
 * A visitor for KVMap
 * 
 * @author CS3500su14
 * @version CS3500su14
 * 
 * @param <K>
 *            the type of key stored in the KVMap
 * @param <V>
 *            the type of value stored in the KVMap
 */
public interface KVMapVisitor<K, V> {

    /**
     * @param k
     *            given key
     * @param v
     *            given value
     * @return a suitable new value
     */
    public V visit(K k, V v);
}
