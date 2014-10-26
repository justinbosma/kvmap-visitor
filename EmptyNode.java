package kvmap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 
 * @author Justin Bosma
 *@version 5/22
 * @param <K> key
 * @param <V> value
 */
public class EmptyNode<K, V> extends BST<K, V> {
    private Comparator<? super K> comparator;
    
    /**
     * New emptyNode with comparator c
     * @param c comparator
     * 
     */
    EmptyNode(Comparator<? super K> c) {
        this.comparator = c;
    }
    
    /**
     * Is the map empty?
     * @return true if emptyMap
     */
    public boolean isEmpty() {
        return true;
    }
    /**
     * Creates new instance of Assign
     * @param k key to be stored of type k
     * @param v value to be stored  
     * @return new assign
     */
    public KVMap<K, V> assign(K k, V v) {
        return this.insert(k, v);
    }
    /**
     * Number of elements in map
     * @return number of elements
     */
    public int size() {
        return 0;
    }
    /**
     * Does map contain key?
     * @param k key
     * @return true if map contains key
     */
    public boolean containsKey(K k) {
        return false;
    }
    /**
     * Does map contain value?
     * @param v value
     * @return true if map contains value
     */
    public boolean containsValue(V v) {
        return false;
    }
    /**
     * retrieve value from map
     * @param k key
     * @return value associated with key. If non existent throws exception
     */
    public V get(K k) throws RuntimeException {
        throw new RuntimeException("Key not in map");
    }
    /**
     * overridden equals method
     * @param o object
     * @return true if maps contain same elements
     */
    public boolean equals(Object o) {
        return (o instanceof EmptyMap || o instanceof EmptyNode);
    }


    /**
     * overridden hashCode method
     * @return 1
     */
    public int hashCode() {
        return 1;
    }
    /**
     * helper function for iterator
     * makes arraylist of keys
     * @param a ArrayList
     * @return ArrayList
     */
    protected ArrayList<K> doer(ArrayList<K> a) {
        return a;
    }

    /**
     * returns rest of KVMap
     * @return rest of KVMap if any
     */
    protected KVMap<K, V> getRest() {
  
        return null;
    }
    /**
     * Makes node black
     * @return KVMap with black node
     */
    protected BST<K, V> makeBlack() {
        return this;
    }

    /**
     * is node black
     * @return true if black
     */
    protected boolean isBlack() {
        return true;
    }
    /**
     * returns new node with k v pair
     * @param k key
     * @param v value
     * @return new node
     */
    protected Node<K, V> insert(K k, V v) {
        return new Node<K, V>(k, v, this.comparator, false);
    }

    /**
     * get left
     * @throw Runtime Exception
     * @return runtime exception
     */
    protected BST<K, V> getLeft() {
        throw new RuntimeException("is empty monsieur");
    }
    /**
     * get Right
     * @throw Runtime Exception
     * @return runtime exception
     */
    protected BST<K, V> getRight() {
        throw new RuntimeException("is empty monsieur");
    }
    /**
     * get key
     * @throw Runtime Exception
     * @return runtime exception
     */
    protected K getKey() {
        throw new RuntimeException("is empty monsieur");
    }
    /**
     * get value
     * @throw Runtime Exception
     * @return runtime exception
     */
    protected V getValue() {
        throw new RuntimeException("is empty monsieur");
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
     * Creates new iterator over collection
     * @return new KVMapIterator
     */
    public Iterator<K> iterator() {
        return new KVMapIterator<K>(this.doer(new ArrayList<K>()));
    }
    /**
     *  Method that accepts a visitor for KVMap
     * @param visitor KVMap visitor
     * @return the results of calling the method
     */
    public KVMap<K, V> accept(KVMapVisitor<K, V> visitor) {
        return this;
    }
    /**
     *  Method that accepts a visitor for RBT trees
     * @param <R> ARRRRR
     * @param visitor rbt visitor
     * @return the results of calling the method
     * @throws UnsupportedOperationException if is not RBT tree
     */
    public <R> R acceptRBT(RBTVisitor<K, V, R> visitor) {
        return visitor.visitEmpty(this.comparator, "BLACK");
    }

}
