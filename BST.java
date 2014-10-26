package kvmap;


/**
 * 
 * @author Justin
 *
 * @param <K> key
 * @param <V> value
 * @version 6/2/14
 */
public abstract class BST<K, V> extends KVMap<K, V> {
    

    /**
     * is node black?
     * @return true if black
     */
    protected abstract boolean isBlack();
    /**
     * get left
     * @return left bst
     */
    protected abstract BST<K, V> getLeft();
    /**
     * get Right
     * @return right bst
     */
    protected abstract BST<K, V> getRight();
    /**
     * Does comparisons of Nodes
     * @param k key to be stored of type k
     * @param v value to be stored  
     * @return new KVMap
     */
    protected abstract Node<K, V> insert(K k, V v);
    /**
     * Makes node black
     * @return KVMap with black node
     */
    protected abstract BST<K, V> makeBlack();

    /**
     * get key
     * @return key
     */
    protected abstract K getKey();
    /**
     * get value
     * @return value
     */
    protected abstract V getValue();
    
}
