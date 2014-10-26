package kvmap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Justin Bosma Username: jbosma0
 * @version 5/20/14
 * @param <K>
 * 
 */
public class KVMapIterator<K> implements Iterator<K> {

    private ArrayList<K> list;
    /**
     * new instance of KVMap iterator
     * @param a Arraylist
     */
    public KVMapIterator(ArrayList<K> a) {      
        this.list = a;
    }
    /**
     *new instance of KVMap iterator
     * @param a Arraylist
     * @param c comparator
     */
    public KVMapIterator(Comparator<? super K> c, ArrayList<K> a) {
        Collections.sort(a, c);
        this.list = a;
    }
    /**
     * overridden hasNext
     * @return true if has next
     */
    public boolean hasNext() {
        return list.size() > 0;
    }
    /**
     * overridden next method
     * @return returns next key
     */
    public K next() {
        if (this.hasNext()) {
            return this.list.remove(0);
        }
        else {
            throw new NoSuchElementException("No next");
        }
    }
    /**
     * does nothing but throw exception
     */
    public void remove() {
        throw new UnsupportedOperationException("No removing");
    }
    
}
