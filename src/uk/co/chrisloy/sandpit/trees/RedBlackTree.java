package uk.co.chrisloy.sandpit.trees;

/**
 * Balanced binary search tree which uses a colouring system to ensure
 * a constant depth and hence maintain consistent search time.
 * 
 * @author Chris Loy
 *
 */
public class RedBlackTree<K extends Comparable<K>, V> extends BinarySearchTree<K, V>{
	
	private class Colour {}
	private final Colour red = new Colour();
	private final Colour black = new Colour();
	
	/**
	 * 
	 * @author Chris Loy
	 */
    private class ColouredNode extends Node {
        Colour colour;
        ColouredNode(K key, V value) {
            super(key, value);
            colour = black;
        }
        ColouredNode getLeft() {
            return (ColouredNode) left;
        }
        ColouredNode getRight() {
            return (ColouredNode) right;
        }
        ColouredNode getParent() {
            return (ColouredNode) parent;
        }
    }
    
    @Override
    protected ColouredNode createNode(K key, V value) {
        return new ColouredNode(key, value);
    }
    
    @Override
    public void insert(K key, V value) {
        ColouredNode z = createNode(key, value);
        Node y = null;
        Node x = root;
        while (x != null) {
            y = x;
            if (z.key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            root = z;
        } else if (z.key.compareTo(y.key) < 0) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = null;
        z.right = null;
        z.colour = red;
        insertFixUp(z);
    }
    
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }
    
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }
    
    private void insertFixUp(ColouredNode z) {
        while (z.getParent().colour == red) {
            if (z.parent == z.parent.parent.left) {
                ColouredNode y = (ColouredNode) z.parent.parent.right;
                if (y.colour == red) {
                    z.getParent().colour = black;
                    // TODO complete me
                }
            }
        }
        ((ColouredNode) root).colour = black;
    }
}
