

import java.util.ArrayList;
import java.util.Comparator;

import kvmap.KVMap;
import kvmap.RBTVisitor;
/**
 * 
 * @author Justin Bosma
 * @version 6/4
 * @param <K> type k
 * @param <V> type v
 * pathlength visitor
 * 
 */
public class PathLengths<K, V> implements RBTVisitor<K, V, ArrayList<Integer>> {

    @Override
    public ArrayList<Integer> visitEmpty(Comparator<? super K> comp,
            String color) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0);
        return a;
    }

    @Override
    public ArrayList<Integer> visitNode(Comparator<? super K> comp,
            String color, K k, V v, KVMap<K, V> left, KVMap<K, V> right) {
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = this.help(left.acceptRBT(this));
        ArrayList<Integer> c = this.help(right.acceptRBT(this));

        a.addAll(b);
        a.addAll(c);             
        
        return a;
    }
    /**
     * Helper method increments each element by one
     * @param a array list of pathlengths
     * @return incremented arraylist
     */
    private ArrayList<Integer> help(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i = i + 1) {
            Integer p = a.get(i);
            a.set(i, p + 1);
        }
        return a;
    }



}
