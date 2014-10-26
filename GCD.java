import kvmap.KVMapVisitor;

/**
 * 
 * @author Justin Bosma
 * @version 6/4
 * GCD visitor
 * 
 */
public class GCD implements KVMapVisitor<Integer, Integer> {

    @Override
    public Integer visit(Integer k, Integer v) {
        return gcd(k, v);
    }
    /**
     * Helper does GCD calculations
     * @param k integer
     * @param v integer
     * @return integer GCD
     */
    private Integer gcd(Integer k, Integer v) {
        if (v == 0) {
            return k;
        }
        else {
            return gcd(v, k % v);
        }
    }

}
