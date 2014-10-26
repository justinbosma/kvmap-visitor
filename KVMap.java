package kvmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;


/**
 * 
 * @author Justin Bosma Username: jbosma0
 * @version 5/20/14 
 * @param <K>
 * @param <V>
 */
public abstract class KVMap<K, V> implements Iterable<K> {

    
    /**
     *creates EmptyMap
     *@param <K> key type
     *@param <V> value type
     *@return new instance of EmptyMap
     */
    public static <K, V> KVMap<K, V> emptyMap() {
        return new EmptyMap<K, V>();
    }
    /**
     *creates EmptyMap with comparator
     *@param <K> key type
     *@param <V> value type
     *@param c comparator
     *@return new instance of EmptyMap
     */
    public static <K, V> KVMap<K, V> emptyMap(Comparator<? super K> c) {
        return new EmptyNode<K, V>(c);
    }
    /**
     * Creates new instance of Assign
     * @param k key to be stored of type k
     * @param v value to be stored  
     * @return new Assign object
     */
    public abstract KVMap<K, V> assign(K k, V v);     
    /**
     * Is the map empty?
     * @return true if empty
     */
    public abstract boolean isEmpty();
    /**
     * Number of elements in map
     * @return number of elements
     */
    public abstract int size();
    /**
     * Does map contain key?
     * @param k key
     * @return true if map contains key
     */
    public abstract boolean containsKey(K k);
    /**
     * Does map contain value?
     * @param v value
     * @return true if map contains value
     */
    public abstract boolean containsValue(V v);
    /**
     * retrieve value from map
     * @param k key
     * @return value associated with key. If non existent throws exception
     */
    public abstract V get(K k);
    /**
     * overridden toString method
     * @return string
     */
    public String toString() {
        return "{...[There are " + this.size() + " unique key(s) mapped to "
                + "value(s) in this KVMap]...}";
    }
    /**
     * overridden equals method
     * @param o object
     * @return true if equals
     */
    public abstract boolean equals(Object o);
    
    
    
    /**
     *new instance of KVMap iterator
     * @return iterator
     */
    public abstract Iterator<K> iterator();
    
    /**
     *new instance of KVMap iterator
     * @return iterator
     * @param c comparator
     */
    public abstract Iterator<K> iterator(Comparator<? super K> c);

    /**
     * overridden hashCode method
     * @return hashcode
     */
    public abstract int hashCode();
    /**
     * retrns rest of KVMap
     * @return rest of KVMap if any
     */
    protected abstract KVMap<K, V> getRest();
   
    /**
     * helper for iterator function. makes arraylist of keys
     * @param a HashSet
     * @return HashSet of keys
     */
    protected abstract ArrayList<K> doer(ArrayList<K> a);
    
    /**
     *  Method that accepts a visitor for KVMap
     * @param visitor KVMap visitor
     * @return the results of calling the method
     */
    public abstract KVMap<K, V> accept(KVMapVisitor<K, V> visitor);
    /**
     *  Method that accepts a visitor for RBT trees
     * @param visitor rbt visitor
     * @param <R> ARRRRR
     * @return the results of calling the method
     * @throws UnsupportedOperationException if is not RBT tree
     */
    public abstract <R> R acceptRBT(RBTVisitor<K, V, R> visitor);

}

