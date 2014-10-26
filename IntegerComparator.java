package kvmap;
import java.util.Comparator;

/**
 * 
 * @author Justin
 *@version 5/22
 */
public class IntegerComparator implements Comparator<Integer> {

    /**
    * Compare method outputs -1 for 1st arg less than 2nd
    * @return int
    * @param o1 first object
    * @param o2 2nd object
    */
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2) {
            return -1;
        }
        else if (o1 > o2) {
            return 1;
        }
        else {
            return 0;
        }
    }
        
    
}
