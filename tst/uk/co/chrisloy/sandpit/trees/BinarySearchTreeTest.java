package uk.co.chrisloy.sandpit.trees;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
    
    BinarySearchTree<Integer, String> bst;
    
    @Before
    public void setup() {
        bst = new BinarySearchTree<Integer, String>();
        assertTrue(bst.isEmpty());
        bst.insert(6, "6");
        bst.insert(18, "18");
        bst.insert(1, "1");
        bst.insert(7, "7");
        bst.insert(43, "43");
        bst.insert(-1, "-1");
        bst.insert(2, "2");
        bst.insert(1, "1");
        bst.insert(13, "13");
        bst.insert(5, "5");
    }
    
    @Test
    public void testMax() {
        assertTrue(bst.getMaximum() == 43);
    }
    
    @Test
    public void testMin() {
        assertTrue(bst.getMinimum() == -1);
    }
    
    @Test
    public void testPre() {
        assertTrue(bst.getPredecessor(7) == 6);
    }
    
    @Test
    public void testPost() {
        assertTrue(bst.getSuccessor(5) == 6);
    }
    
    @Test
    public void testSearch() {
        assertTrue(bst.search(3) == null);
        assertTrue(bst.search(-1).equals("-1"));
        assertTrue(bst.search(1).equals("1"));
        assertTrue(bst.search(13).equals("13"));
        assertTrue(bst.search(43).equals("43"));
        assertTrue(bst.search(2).equals("2"));
    }
    
    @Test
    public void testDelete() {
        bst.delete(13);
        assertTrue(bst.search(3) == null);
        assertTrue(bst.search(-1).equals("-1"));
        assertTrue(bst.search(1).equals("1"));
        assertTrue(bst.search(13) == null);
        assertTrue(bst.search(43).equals("43"));
        assertTrue(bst.search(2).equals("2"));
    }
}
