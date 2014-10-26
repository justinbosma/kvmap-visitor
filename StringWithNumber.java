import kvmap.KVMapVisitor;

/**
 * 
 * @author Justin Bosma
 * @version 6/4
 * String with number visitor
 */
public class StringWithNumber implements KVMapVisitor<Integer, String> {

    @Override
    public String visit(Integer k, String v) {

        return (v + " " + k);
    }

}
