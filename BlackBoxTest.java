import java.util.ArrayList;
import java.util.Comparator;

import tester.Tester;
import kvmap.KVMap;
import kvmap.IntegerComparator;


/**
 * 
 * @author Justin Bosma
 * @version 6/4
 * Good ol BLackBox nesting
 *
 */
public class BlackBoxTest {
    private Comparator<Integer> cI = new IntegerComparator();
    private KVMap<Integer, Integer> mTI = KVMap.emptyMap(cI);
    private KVMap<Integer, Integer> i1 = mTI.assign(2, 6);
    private KVMap<Integer, Integer> i2 = i1.assign(1, 5); 
    private KVMap<Integer, Integer> i3 = i2.assign(3, 7);
    private KVMap<Integer, Integer> i11 = mTI.assign(2, 2);
    private KVMap<Integer, Integer> i22 = i11.assign(1, 1); 
    private KVMap<Integer, Integer> i33 = i22.assign(3, 1);
    
    private KVMap<Integer, Integer> mTIL = KVMap.emptyMap();
    private KVMap<Integer, Integer> i1L = mTIL.assign(2, 6);
    private KVMap<Integer, Integer> i2L = i1L.assign(1, 5); 
    private KVMap<Integer, Integer> i3L = i2L.assign(3, 7);
    private KVMap<Integer, Integer> i11L = mTIL.assign(2, 2);
    private KVMap<Integer, Integer> i22L = i11L.assign(1, 1); 
    private KVMap<Integer, Integer> i33L = i22L.assign(3, 1);
    
    
    private KVMap<Integer, String> mTS = KVMap.emptyMap(cI);
    private KVMap<Integer, String> s1 = mTS.assign(2, "B");
    private KVMap<Integer, String> s2 = s1.assign(1, "A"); 
    private KVMap<Integer, String> s3 = s2.assign(3, "C");
    private KVMap<Integer, String> s11 = mTS.assign(2, "B 2");
    private KVMap<Integer, String> s22 = s11.assign(1, "A 1"); 
    private KVMap<Integer, String> s33 = s22.assign(3, "C 3");
    
    private KVMap<Integer, String> mTSL = KVMap.emptyMap();
    private KVMap<Integer, String> s1L = mTSL.assign(2, "B");
    private KVMap<Integer, String> s2L = s1L.assign(1, "A"); 
    private KVMap<Integer, String> s3L = s2L.assign(3, "C");
    private KVMap<Integer, String> s11L = mTSL.assign(2, "B 2");
    private KVMap<Integer, String> s22L = s11L.assign(1, "A 1"); 
    private KVMap<Integer, String> s33L = s22L.assign(3, "C 3");
    private ArrayList<Integer> a = new ArrayList<Integer>();
    private ArrayList<Integer> b = new ArrayList<Integer>();

    /**
     * test for thrown errors
     * @param t tester
     */
    public void testThrow(Tester t) {
        try {
            t.checkExpect(s1L.acceptRBT(new BlackHeight<Integer, String>()),
                    false);
            
        } 
        catch (Exception e) {
            System.out.println("Exception for testGet passed");

        }
        try {
            t.checkExpect(mTSL.acceptRBT(new BlackHeight<Integer, String>()),
                    false);
        }
        catch (Exception e) {
            System.out.println("Exception for hasNext() passed");
        }
    }
    /**
    * test GCD
    * @param t tester
    * @return true
    */
    boolean testGCD(Tester t) {
        return t.checkExpect(i3.accept(new GCD()).equals(i33), true) &&
                t.checkExpect(i3L.accept(new GCD()).equals(i33L), true);
    }
    /**
     * test StringWtihNumber
     * @param t tester
     * @return true
     */
      
     
    boolean testStringWithNumber(Tester t) {
        return t.checkExpect(s3.accept(
                    new StringWithNumber()).equals(s33), true) &&
                t.checkExpect(s3L.accept(
                    new StringWithNumber()).equals(s33L), true);
    }
    /**
     * test BlackHeight
     * @param t tester
     * @return true
     */
    boolean testBlackHeight(Tester t) {
        return t.checkExpect(s3.acceptRBT(
                new BlackHeight<Integer, String>()), 1) &&
                 t.checkExpect(mTS.acceptRBT(
                        new BlackHeight<Integer, String>()), 0);
    }
    /**
     * test PathLengths
     * @param t tester
     * @return true
     */
    boolean testPathLengths(Tester t) {
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        b.add(0);
        return t.checkExpect(s3.acceptRBT(
                new PathLengths<Integer, String>()), a) &&
                t.checkExpect(mTS.acceptRBT(
                        new PathLengths<Integer, String>()), b);
    }


}
