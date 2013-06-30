package uk.co.chrisloy.sandpit.trees;

public class BinarySearchTree<K extends Comparable<K>, V> {
    
    class Node {
        final K key;
        final V value;
        Node left;
        Node right;
        Node parent;
        
        Node(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }
    }
    
    protected Node root;
    
    /**
     * Creates a new node. This method can be overridden in subclasses
     * if it is necessary to use a subtype of Node.
     * 
     * @param key
     * @param value
     * @return
     */
    protected Node createNode(K key, V value) {
        return new Node(key, value);
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public V search(K key) {
        if(isEmpty()) {
            return null;
        }
        Node node = treeSearch(root, key);
        return node == null ? null : node.value;
    }
    
    public K getMaximum() {
        if(isEmpty()) {
            return null;
        }
        return treeMaximum(root).key;
    }
    
    public K getMinimum() {
        if(isEmpty()) {
            return null;
        }
        return treeMinimum(root).key;
    }
    
    private Node treeMinimum(Node x) {
        while(x.left != null) {
            x = x.left;
        }
        return x;
    }
    
    private Node treeMaximum(Node x) {
        while(x.right != null) {
            x = x.right;
        }
        return x;
    }
    
    public K getPredecessor(K key) {
        Node x = treeSearch(root, key);
        if (x == null) {
            return null;
        } else if (x.left != null) {
            return treeMaximum(x.left).key;
        } else {
            Node y = x.parent;
            while (y != null && x == y.left) {
                x = y;
                y = y.parent;
            }
            return y.key;
        }
    }
    
    public K getSuccessor(K key) {
        Node x = treeSearch(root, key);
        if (x == null) {
            return null;
        } else if (x.right != null) {
            return treeMinimum(x.right).key;
        } else {
            Node y = x.parent;
            while (y != null && x == y.right) {
                x = y;
                y = y.parent;
            }
            return y.key;
        }
    }
    
    public void insert(K key, V value) {
        Node z = createNode(key, value);
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
    }
    
    public V delete(K key) {
        final Node z = treeSearch(root, key);
        if (z == null) {
            return null;
        }
        if (z.left == null) {
            transplant(z, z.right);
        } else if (z.right == null) {
            transplant(z, z.left);
        } else {
            final Node y = treeMinimum(z.right);
            if(y.parent != z) {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
        }
        return z.value;
    }
    
    private Node treeSearch(Node x, K key) {
        if (x == null || key.equals(x.key)) {
            return x;
        } else if (key.compareTo(x.key) < 0) {
            return treeSearch(x.left, key);
        } else {
            return treeSearch(x.right, key);
        }
    }
    
    /**
     * Replaces the node at "u" with the one at "v", bringing
     * along all subtrees.
     * 
     * @param u
     * @param v
     */
    private void transplant(Node u, Node v) {
        if(u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if(v != null) {
            v.parent = u.parent;
        }
    }
}

