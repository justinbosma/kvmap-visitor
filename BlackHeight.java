import java.util.Comparator;

import kvmap.KVMap;
import kvmap.RBTVisitor;

/**
 * 
 * @author Justin Bosma
 * @version 6/4
 * @param <K> type k
 * @param <V> type v
 * BlackHeight Visitor
 */
public class BlackHeight<K, V> implements RBTVisitor<K, V, Integer> {

    @Override
    public Integer visitEmpty(Comparator<? super K> comp, String color) {

        return 0;
    }

    @Override
    public Integer visitNode(Comparator<? super K> comp, String color, K k,
            V v, KVMap<K, V> left, KVMap<K, V> right) {
        Integer h = left.acceptRBT(this);
        
        if (color.equals("BLACK")) {
            return 1 + h;
        }
       
        else {
            return h;
        }
    }

}
