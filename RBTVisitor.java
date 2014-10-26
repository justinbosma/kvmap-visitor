package kvmap;

import java.util.Comparator;

/**
 * A visitor for KVMap that was created with KVMap.emptyMap(c) It is the
 * responsibility of the user of this interface to guarantee that it is only
 * used for Red-Black Trees
 * 
 * @author CS3500su14
 * @version CS3500su14
 * 
 * @param <K>
 *            the type of key stored in the KVMap
 * @param <V>
 *            the type of value stored in the KVMap
 * @param <R>
 *            the type of data produced by the visitor methods
 */
public interface RBTVisitor<K, V, R> {
    /**
     * The method for the empty tree
     * 
     * @param comp
     *            the Comparator for the whole tree
     * @param color
     *            the color of the node, which should be "RED" or "BLACK"
     * @return some value of the type R
     */
    public R visitEmpty(Comparator<? super K> comp, String color);

    /**
     * The method for the node of the tree
     * 
     * @param comp
     *            the Comparator for the whole tree
     * @param color
     *            the color of the node, which should be "RED" or "BLACK"
     * @param k
     *            the key for the node
     * @param v
     *            the value for the node
     * @param left
     *            the left subtree of the node
     * @param right
     *            the right subtree of the node
     * @return some value of the type R
     */
    public R visitNode(Comparator<? super K> comp, String color, K k,
            V v, KVMap<K, V> left, KVMap<K, V> right);
}
