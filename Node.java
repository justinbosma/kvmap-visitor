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
public class Node<K, V> extends BST<K, V> {
    private K key;
    private V value;
    
    private BST<K, V> left;
    private BST<K, V> right;
    private Comparator<? super K> comparator;
    private int size;
    private Boolean black;


    
    /**
     * Constructor for Node
     * @param k key
     * @param v value
     * @param c comparator
     * @param bl boolean for blackness
     */
    Node(K k, V v, Comparator<? super K> c, Boolean bl) {
        this.key = k;
        this.value = v;
        this.comparator = c;
        this.left = new EmptyNode<K, V>(c);
        this.right = new EmptyNode<K, V>(c);
        this.size = 1 + this.right.size() + this.left.size();
        this.black = bl;
    }
    
    /**
     * Constructor for Node
     * @param k key
     * @param v value
     * @param c comparator
     * @param r right node
     * @param l left node
     * @param bl boolean for blackness
     */
    Node(K k, V v, Comparator<? super K> c, BST<K, V> l
            , BST<K, V> r, Boolean bl) {
        this.key = k;
        this.value = v;
        this.comparator = c;
        this.left = l;
        this.right = r;
        this.size = 1 + this.right.size() + this.left.size();
        this.black = bl;
    }
    
    /**
     * Is the map empty?
     * @return true if emptyMap
     */
    public boolean isEmpty() {
        return false;
    }
    /**
     * Creates new instance of Assign
     * @param k key to be stored of type k
     * @param v value to be stored  
     * @return new assign
     */
    public KVMap<K, V> assign(K k, V v) {
        return this.insert(k, v).makeBlack();          
    }
    /**
     * Number of elements in map
     * @return number of elements
     */
    public int size() {
        return this.size;
    }
    /**
     * Does map contain key?
     * @param k key
     * @return true if map contains key
     */
    public boolean containsKey(K k) {
        if (this.key.equals(k)) {
            return true;
        } 
        else {
            return (this.left.containsKey(k) || this.right.containsKey(k));
        }
    }
    /**
     * Does map contain value?
     * @param v value
     * @return true if map contains value
     */
    public boolean containsValue(V v) {

        return (this.value.equals(v) || 
                this.left.containsValue(v) ||
                this.right.containsValue(v));
        
    }
    /**
     * retrieve value from map
     * @param k key
     * @return value associated with key. If non existent throws exception
     */
    public V get(K k) throws RuntimeException {
        if (this.key.equals(k)) {
            return this.value;
        }
        else if (this.comparator.compare(k, this.key) <= 0) {
            return this.left.get(k);
        }
        else {
            return this.right.get(k);
        }
    }
    /**
     * overridden equals method
     * @param o object
     * @return true if maps contain same elements
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
     * @return hashCode
     */
    public int hashCode() {
        int code = 1;
        for (K k : this) {
            code = (13 + k.hashCode()) + (this.get(k).hashCode() * 7) + code;
        }
        return code;
    }
    /**
     * helper function for iterator
     * makes arraylist of keys
     * @param a ArrayList
     * @return ArrayList
     */
    protected ArrayList<K> doer(ArrayList<K> a) {
        this.left.doer(a);
        a.add(this.key);
        this.right.doer(a);
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
        return new Node<K, V>(this.key, this.value,
                this.comparator, this.left,
                this.right, true);
    }
    
    /**
     * Balance KVMap to red black bst specs
     * @return balanced KVMap
     */
    private Node<K, V> balance() {
        if (this.isBlack()) {
                       
            if (!this.getLeft().isEmpty() && !this.getLeft().isBlack()) {
                BST<K, V> l = this.getLeft();
                
                //Left Left case
                if (!l.getLeft().isEmpty() && !l.getLeft().isBlack()) {
                    return new Node<K, V>(l.getKey(), l.getValue(),
                            this.comparator, l.getLeft().makeBlack(),
                            new Node<K, V>(this.key, this.value,
                                    this.comparator,
                                    l.getRight(), this.getRight(), true),
                                    false);
                }
                //Left right case
                else if (!l.getRight().isEmpty() && !l.getRight().isBlack()) {
                    BST<K, V> lr = l.getRight();
                    return new Node<K, V>(lr.getKey(), lr.getValue(),
                            this.comparator, 
                            new Node<K, V>(l.getKey(), l.getValue(),
                            this.comparator, l.getLeft(), lr.getLeft(), true),
                            new Node<K, V>(this.key, this.value,
                                    this.comparator,
                                    lr.getRight(), this.right, true), false );
                }
            }
            else if (!this.getRight().isEmpty() && !this.getRight().isBlack()) {
                BST<K, V> r = this.getRight();
           
                //Right Left case
                if (!r.getLeft().isEmpty() && !r.getLeft().isBlack()) {
                    BST<K, V> rl = r.getLeft();
                    return new Node<K, V>(rl.getKey(), rl.getValue(),
                            this.comparator,
                            new Node<K, V>(this.key, this.value, 
                            this.comparator, this.left, rl.getLeft(), true),
                            new Node<K, V>(r.getKey(), r.getValue(), 
                                    this.comparator,
                                rl.getRight(), r.getRight(), true), false );
                }
                //right right case
                else if (!r.getRight().isEmpty() && !r.getRight().isBlack()) {
                    BST<K, V> rr = r.getRight();
                    return new Node<K, V>(r.getKey(), r.getValue(),
                            this.comparator,
                            new Node<K, V>(this.key, this.value, 
                            this.comparator, this.left, r.getLeft(), true),
                            rr.makeBlack(), false );
                }
            }
        }
        
        return this;
             
    }
    
    /**
     * Does comparisons of Nodes
     * @param k key to be stored of type k
     * @param v value to be stored  
     * @return new KVMap
     */
    protected Node<K, V> insert(K k, V v) {
        if (this.comparator.compare(k, this.key) == 0) {
            return new Node<K, V>(this.key, v,
                        this.comparator, this.left,
                        this.right, this.black);
        }
        else if (this.comparator.compare(k, this.key) > 0) {
            return new Node<K, V>(this.key, this.value,
                        this.comparator, this.left,
                        this.right.insert(k, v), this.black).balance();
        }
        else  {
            return new Node<K, V>(this.key, this.value,
                        this.comparator, this.left.insert(k, v),
                        this.right, this.black).balance();
        }
    }
    /**
     * is node black
     * @return true if black
     */
    protected boolean isBlack() {
        return this.black;
    }
    /**
     * get left
     * @return this.left
     */
    protected BST<K, V> getLeft() {
        return this.left;
    }
    /**
     * get Right
     * @return this.right
     */
    protected BST<K, V> getRight() {
        return this.right;
    }
    /**
     * get key
     * @return this.key
     */
    protected K getKey() {
        return this.key;
    }
    /**
     * get Right
     * @return this.value
     */
    protected V getValue() {
        return this.value;
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
        return new KVMapIterator<K>(this.comparator,
                this.doer(new ArrayList<K>()));
    }
    /**
     *  Method that accepts a visitor for KVMap
     * @param visitor KVMap visitor
     * @return the results of calling the method
     */
    public KVMap<K, V> accept(KVMapVisitor<K, V> visitor) {

        BST<K, V> a = (BST<K, V>) this.left.accept(visitor);
        BST<K, V> b = (BST<K, V>) this.right.accept(visitor);

        return new Node<K, V>(this.key, visitor.visit(this.key, this.value),
                this.comparator, a,
                b, this.black);
    }
    /**
     *  Method that accepts a visitor for RBT trees
     * @param <R> ARRRR
     * @param visitor rbt visitor
     * @return the results of calling the method
     * @throws UnsupportedOperationException if is not RBT tree
     */
    public <R> R acceptRBT(RBTVisitor<K, V, R> visitor) {
        String str = this.makeString();
        return visitor.visitNode(this.comparator, str, this.key, this.value,
                this.left, this.right);
    }
    /**
     * make boolean into string
     * @return string of color
     */
    private String makeString() {
        if (this.black) {
            return ("BLACK");
        }
        else {
            return "RED";
        }
    }




}
