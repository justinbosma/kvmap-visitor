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
public class Assign<K, V> extends KVMap<K, V> {
    private K key;
    private V value;
    private KVMap<K, V> next;


    /**
     * Creates new instance of Assign
     * 
     * @param k
     *            key to be stored of type k
     * @param v
     *            value to be stored
     * @param m
     *            rest of KVMap
     */
    Assign(K k, V v, KVMap<K, V> m) {
        this.key = k;
        this.value = v;
        this.next = m;
    }

    /**
     * Creates new instance of Assign
     * 
     * @param k
     *            key to be stored of type k
     * @param v
     *            value to be stored
     * @return new assign
     */
    public KVMap<K, V> assign(K k, V v) {

        return new Assign<K, V>(k, v, this);
        
    }

    /**
     * Is the map empty?
     * 
     * @return true if emptyMap
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Number of elements in map
     * 
     * @return number of elements
     */
    public int size() {
        if (this.next.containsKey(this.key)) {
            return this.next.size();
        } 
        else {
            return 1 + this.next.size();
        }
    }

    /**
     * Does map contain key?
     * 
     * @param k
     *            key
     * @return true if map contains key
     */
    public boolean containsKey(K k) {
        if (this.key.equals(k)) {
            return true;
        } 
        else {
            return this.next.containsKey(k);
        }
    }

    /**
     * Does map contain value?
     * 
     * @param v
     *            value
     * @return true if map contains value
     */
    public boolean containsValue(V v) {       
        boolean mark = false;
        for (K k : this) {
            if (v.equals(this.get(k))) {
                mark = true;
            }
        }
        return mark;
    }

    /**
     * retrieve value from map
     * 
     * @param k
     *            key
     * @return value associated with key. If non existent throws exception
     */
    public V get(K k) throws RuntimeException {
        if (this.key.equals(k)) {
            return this.value;
        } 
        else {
            return this.next.get(k);
        }
    }

    /**
     * overridden equals method
     * 
     * @param o
     *            object
     * @return true if objects are equal
     */
    public boolean equals(Object o) {
        boolean mark = true;
        if (o instanceof KVMap) {
            @SuppressWarnings("unchecked")
            KVMap<K, V> that = (KVMap<K, V>) o;
            if (this.size() == that.size()) {
                for (K k : this) {
                    if (!(that.containsKey(k) && (this.get(k).equals(that
                            .get(k))))) {
                        mark = false;
                    }
                }
                return mark;
            } 
            else {
                return false;
            }
        } 
        else {
            return false;
        }
    }



    /**
     * overridden hashCode method
     * 
     * @return hashcode
     */
    public int hashCode() {
        int code = 1;
        for (K k : this) {
            code = (13 + k.hashCode()) + (this.get(k).hashCode() * 7) + code;
        }
        return code;
    }

    /**
     * retrns rest of KVMap
     * 
     * @return rest of KVMap if any
     */
    protected KVMap<K, V> getRest() {

        return this.next;
    }

    /**
     * helper function for iterator makes arraylist of keys
     * 
     * @param a
     *            ArrayList
     * @return ArrayList
     */
    public ArrayList<K> doer(ArrayList<K> a) {
        if (a.contains(this.key)) {
            
            return this.next.doer(a);
        }
        else {
            a.add(this.key);
            return this.next.doer(a);
        }
    }
    
    /**
     * Creates new iterator over collection
     * @return new KVMapIterator
     */
    public Iterator<K> iterator() {
        return new KVMapIterator<K>(this.doer(new ArrayList<K>()));
    }
    /**
     * Creates new iterator over collection with comparator
     * @param c comparator
     * @return new KVMapIterator
     */
    public Iterator<K> iterator(Comparator<? super K> c) {
        return new KVMapIterator<K>(c, this.doer(new ArrayList<K>()));
    }
    /**
     *  Method that accepts a visitor for KVMap
     * @param visitor KVMap visitor
     * @return the results of calling the method
     */
    public KVMap<K, V> accept(KVMapVisitor<K, V> visitor) {
        return new Assign<K, V>(this.key, visitor.visit(this.key, this.value),
                next.accept(visitor));
    }
    /**
     *  Method that accepts a visitor for RBT trees
     * @param <R> type ARRRR...
     * @param visitor rbt visitor
     * @return the results of calling the method
     * @throws UnsupportedOperationException if is not RBT tree
     */
    public <R> R acceptRBT(RBTVisitor<K, V, R> visitor) {
        throw new UnsupportedOperationException(" aint no RBT in here");
    }


}
