package kvmap;


import java.util.ArrayList;
import java.util.Comparator;





import tester.Tester;

/**
 * 
 * @author Justin
 * @version 6/2/14
 */
public class ExamplesKVMap3 {



    private Comparator<Integer> c = new IntegerComparator();
    private KVMap<Integer, String> mT2 = KVMap.emptyMap(c);
    private KVMap<Integer, String> n1 = mT2.assign(7, "g");
    private KVMap<Integer, String> n2 = n1.assign(5, "e");
    private KVMap<Integer, String> n3 = n2.assign(9, "i");
    private KVMap<Integer, String> n4 = n3.assign(7, "f");
    private KVMap<Integer, String> n5 = mT2.assign(7, "g");
    private KVMap<Integer, String> n10 = n4.assign(5, "lllll");
    private KVMap<Integer, String> n11 = n4.assign(5, "vvvvv");
    private KVMap<Integer, String> a1 = mT2.assign(3, "Carol");
    private KVMap<Integer, String> a2 = mT2.assign(3, "Carol");
    private KVMap<Integer, String> mTL = KVMap.emptyMap();
    private KVMap<Integer, String> l1 = mTL.assign(1, "Dave");
    private KVMap<Integer, String> b1 = mT2.assign(3, "Carol");
    private KVMap<Integer, String> b2 = b1.assign(7, "Anne");
    private KVMap<Integer, String> b3 = b2.assign(9, "Joy");
    private KVMap<Integer, String> b4 = b3.assign(6, "Dawn");
    private KVMap<Integer, String> b5 = b3.assign(6, "Ron");
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private BST<Integer, String> mTNew = (EmptyNode) mT2;
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private BST<Integer, String> n1New = (BST) n1;

    
    ///////////////////////////////////////////////////////////////////////////
    //newest
    ///////////////////////////////////////////////////////////////////////////
    
    /**
     * Test for getRest
     * @param t tester
     * @return boolean
     */
    boolean testRest3(Tester t) {
        return t.checkExpect(mT2.getRest(), null) &&
                t.checkExpect(n1New.getRest(), null);
    }
    /**
     * Test for makeBlack
     * @param t tester
     * @return boolean
     */
    boolean testMakeBlack(Tester t) {
        return t.checkExpect(mTNew.makeBlack(), mTNew);
    }

    /**
     * Test for isBlack
     * @param t tester
     * @return boolean
     */
    boolean testIsBlack(Tester t) {
        return t.checkExpect(mTNew.isBlack(), true);
    }
    

    
///////////////////////////////////////////////////////////////////////////
//middles
///////////////////////////////////////////////////////////////////////////
    
    /**
     * Test for size
     * @param t tester
     * @return boolean
     */
    boolean testSize(Tester t) {
        return t.checkExpect(n4.size(), 3) &&
                t.checkExpect(mT2.size(), 0); 
    }

    /**
     * Test for emptiness
     * @param t tester
     * @return boolean
     */
    boolean testIsEmpty(Tester t) {
        return t.checkExpect(n4.isEmpty(), false) &&
                t.checkExpect(mT2.isEmpty(), true); 
    }
    /**
     * Test for contains key
     * @param t tester
     * @return boolean
     */
    boolean testContainsKey(Tester t) {
        return t.checkExpect(n4.containsKey(7), true) &&
                t.checkExpect(n4.containsKey(9), true) &&
                t.checkExpect(n4.containsKey(5), true) &&
                t.checkExpect(mT2.containsKey(7), false); 
    }
    /**
     * Test for contains value
     * @param t tester
     * @return boolean
     */
    boolean testContainsValue(Tester t) {
        l1 = l1.assign(1, "Alice");
        return t.checkExpect(n4.containsValue("e"), true) &&
                t.checkExpect(n4.containsValue("f"), true) &&
                t.checkExpect(l1.containsValue("Dave"), false) &&
                t.checkExpect(l1.containsValue("Alice"), true) &&
                t.checkExpect(n4.containsValue("i"), true) &&
                t.checkExpect(mT2.containsValue("e"), false); 
    }
    /**
     * Test for get
     * @param t tester
     * @return boolean
     */
    boolean testGet(Tester t) {
        return t.checkExpect(n4.get(7), "f") &&
                t.checkExpect(n4.get(9), "i") &&
                t.checkExpect(n4.get(5), "e"); 
    }
    /**
     * Exception Tests for get
     * @param t tester
     * 
     */
    public void testGet2(Tester t) {
        try {
            t.checkExpect(KVMap.emptyMap().get(3), false);
            
        } 
        catch (Exception e) {
            System.out.println("Exception for testGet passed");

        }
        try {
            t.checkExpect(mT2.iterator().hasNext(), false);
        }
        catch (Exception e) {
            System.out.println("Exception for hasNext() passed");
        }
        try {
            mT2.iterator().remove();
        }
        catch (Exception e) {
            System.out.println("Exception for remove passed");
        }
        try {
            mT2.get(3);
        }
        catch (Exception e) {
            System.out.println("Key not in map");
        }
        try {
            mTNew.getLeft();
        }
        catch (Exception e) {
            System.out.println("is empty monsieur");
        }
        try {
            mTNew.getRight();
        }
        catch (Exception e) {
            System.out.println("is empty monsieur");
        }
        try {
            mTNew.getKey();
        }
        catch (Exception e) {
            System.out.println("is empty monsieur");
        }
        try {
            mTNew.getValue();
        }
        catch (Exception e) {
            System.out.println("is empty monsieur");
        }
        
    }
    /**
     * Tests for tostring
     * @param t tester
     * @return true if tests pass
     */
    boolean testToString(Tester t) {
        return t.checkExpect(n2.toString(), "{...[There are " + n2.size()
                + " unique key(s) mapped to value(s) in this KVMap]...}");
    }
    /**
     * Tests for equals
     * @param t tester
     * @return true if tests pass
     */
    boolean testEquals(Tester t) {
        n10 = n10.assign(10, "rrrrr");
        n10 = n10.assign(5, "xxxxx");
        n11 = n11.assign(10, "rrrrr");
        n11 = n11.assign(5, "xxxxx");
        a1 = a1.assign(2, "Bob");
        a1 = a1.assign(1, "Alice");
        a2 = a2.assign(2, "Bob");
        a2 = a2.assign(1, "Alice");
        
        return t.checkExpect(n1.equals(n1), true)
                && t.checkExpect(n1.assign(5, "e")
                        .equals(n5.assign(5, "e")), true)
                && t.checkExpect(n1.equals(n2.assign(99, "w")), false)
                && t.checkExpect(n1.equals("Meow"), false)
                && t.checkExpect(n1.equals(KVMap.emptyMap()), false) &&
                t.checkExpect(mTNew.equals(KVMap.emptyMap()), true) &&
                t.checkExpect(n3.equals(n4), false) &&
                t.checkExpect(n10.equals(n11), true) &&
                t.checkExpect(a1.equals(a2)) &&
                t.checkExpect(b4.equals(b5), false) &&
                t.checkExpect(mT2.equals(KVMap.emptyMap()));

    }

    
    /**
     * Tests for iterator
     * @param t tester
     * @return true if tests pass
     */
    boolean testIterator(Tester t) {

        return 
                   t.checkExpect(mT2.iterator(), new KVMapIterator<Integer>(
                           new ArrayList<Integer>())) &&
                   t.checkExpect(mT2.iterator(c), new KVMapIterator<Integer>(
                           new ArrayList<Integer>())) &&
                           t.checkExpect(n3.iterator().next(), 5) &&
                           t.checkExpect(n3.iterator(c).next(), 5) &&
                           t.checkExpect(n3.iterator().hasNext(), true);
    }

    /**
     * Tests for hashCode
     * @param t tester
     * @return true if tests pass
     */
    boolean testHashCode(Tester t) {
        return t.checkExpect(n1.hashCode(), 742) &&
                 t.checkExpect(n1.assign(4, "!").hashCode(), 990) &&
                 t.checkExpect(mT2.hashCode(), 1) &&
                 t.checkExpect(n1.assign(
                         4, "!").assign(4, "h").hashCode(), 1487);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //old tests
    ///////////////////////////////////////////////////////////////////////////

    private ArrayList<Integer> a = new ArrayList<Integer>();
    private ArrayList<Integer> b = new ArrayList<Integer>();
    private KVMap<Integer, String> m0 = new Assign<Integer, String>(3, "Hi",
            new EmptyMap<Integer, String>());
    private KVMap<Integer, String> m1 = new Assign<Integer, String>(5, "Help",
            new EmptyMap<Integer, String>());
    private KVMap<Integer, String> m2 = new Assign<Integer, String>(3, "Hi",
            new EmptyMap<Integer, String>());
    private KVMap<Integer, String> mT = KVMap.emptyMap();

    

    /**
     * Tests for emptyMap
     * @param t tester
     * @return true if tests pass
     */
    boolean testEmptyMap(Tester t) {
        return t.checkExpect(KVMap.emptyMap().isEmpty())
                && t.checkExpect(m0.isEmpty(), false) &&
                t.checkExpect(mT.assign(3, "Hi"), m0);
    }
    /**
     * Tests for size
     * @param t tester
     * @return true if tests pass
     */
    boolean testSizeOld(Tester t) {
        return t.checkExpect(KVMap.emptyMap().size() == 0)
                && t.checkExpect(m0.assign(4, "F").size() == m0.size() + 1)
                && t.checkExpect(m0.assign(3, "Hi").size() == m0.size());
    }
    /**
     * Tests for containskey
     * @param t tester
     * @return true if tests pass
     */
    boolean testContainsKeyOld(Tester t) {
        return t.checkExpect(KVMap.emptyMap().containsKey(3), false)
                && t.checkExpect(m0.containsKey(3))
                && t.checkExpect(m0.containsKey(7), false);
    }
    /**
     * Tests for containsvalue
     * @param t tester
     * @return true if tests pass
     */
    boolean testContainsValueOld(Tester t) {
        return t.checkExpect(KVMap.emptyMap().containsValue("Hi"), false)
                && t.checkExpect(m0.containsValue("Hi"))
                && t.checkExpect(m0.containsValue("Arf"), false);
    }
    /**
     * Exception Tests for get
     * @param t tester
     * 
     */
    public void testGet2Old(Tester t) {
        try {
            t.checkExpect(KVMap.emptyMap().get(3), false);
            
        } 
        catch (Exception e) {
            System.out.println("Exception for testGet passed");

        }
        try {
            t.checkExpect(mT.iterator().hasNext(), false);
        }
        catch (Exception e) {
            System.out.println("Exception for hasNext() passed");
        }
        try {
            mT.iterator().remove();
        }
        catch (Exception e) {
            System.out.println("Exception for remove passed");
        }
    }
    /**
     * Tests for get
     * @param t tester
     * @return true if tests pass
     */
    boolean testGetOld(Tester t) {
        return t.checkExpect(m0.assign(9, "a").get(9).equals("a"))
                && t.checkExpect(m0.assign(9, "a").get(3).equals(m0.get(3)));
    }
    /**
     * Tests for tostring
     * @param t tester
     * @return true if tests pass
     */
    boolean testToStringOld(Tester t) {
        return t.checkExpect(m0.toString(), "{...[There are " + m0.size()
                + " unique key(s) mapped to value(s) in this KVMap]...}");
    }
    /**
     * Tests for equals
     * @param t tester
     * @return true if tests pass
     */
    boolean testEqualsOld(Tester t) {
        return t.checkExpect(m1.equals(m1), true)
                && t.checkExpect(m1.assign(3, "Hi")
                        .equals(m2.assign(5, "Help")), true)
                && t.checkExpect(m0.equals(m1.assign(99, "w")), false)
                && t.checkExpect(m0.equals("Meow"), false)
                && t.checkExpect(m0.equals(KVMap.emptyMap()), false) &&
                t.checkExpect(mT.equals(mT2))
                && t.checkExpect(m1.equals(m2), false);

    }

    
    /**
     * Tests for iterator
     * @param t tester
     * @return true if tests pass
     */
    boolean testIteratorOld(Tester t) {

        return t.checkExpect(m0.iterator(),
                new KVMapIterator<Integer>(m0.doer(a))) &&
                 t.checkExpect(m0.iterator(c), new KVMapIterator<Integer>(c,
                        m0.doer(b))) &&
                   t.checkExpect(mT.iterator(), new KVMapIterator<Integer>(
                           new ArrayList<Integer>())) &&
                   t.checkExpect(mT.iterator(c), new KVMapIterator<Integer>(
                           new ArrayList<Integer>())) &&
                           t.checkExpect(m0.iterator().next(), 3) &&
                           t.checkExpect(m0.iterator().hasNext(), true);
    }
    /**
     * Tests for getrest
     * @param t tester
     * @return true if tests pass
     */
    boolean testGetRestOld(Tester t) {
        return t.checkExpect(m0.getRest(), new EmptyMap<String, Integer>()) &&
                 t.checkExpect(m0.assign(1, "!").getRest(), m0) &&
                 t.checkExpect(mT.getRest(), mT);
    }
    /**
     * Tests for hashCode
     * @param t tester
     * @return true if tests pass
     */
    boolean testHashCodeOld(Tester t) {
        return t.checkExpect(m0.hashCode(), 16376) &&
                 t.checkExpect(m0.assign(4, "!").hashCode(), 16624) &&
                 t.checkExpect(new EmptyMap<String, Integer>().hashCode(), 1) &&
                 t.checkExpect(m0.assign(
                         4, "!").assign(4, "h").hashCode(), 17121);
    }
    /**
     * Tests for doer
     * @param t tester
     * @return true if tests pass
     */
    boolean testDoerOld(Tester t) {
        return t.checkExpect(mT.doer(new ArrayList<Integer>()),
                new ArrayList<Integer>());
    }
}
