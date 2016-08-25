package search;

/**
 * Created by stickmy
 * on 16-8-24.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;
        public Node(Key key, Value val,int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST(){
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if(x == null)
            return 0;
        else
            return x.size;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return get(x.left, key);
        if(cmp > 0)
            return get(x.right, key);
        return x.val;
    }

    public void put(Key key, Value val) {
        if(key == null)
            throw new NullPointerException("first argument to put() is null");
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if(x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = put(x.left, key, val);
        else if(cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if(x.left == null)
            return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if(x.right == null)
            return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        if(key == null)
            throw new NullPointerException("argument to floor() is null");
        Node x = floor(root, key);
        if(x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;
        if(cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if(t == null)
            return x;
        return t;
    }

    public Key ceil(Key key) {
        if(key == null)
            throw new NullPointerException("argument to floor() is null");
        Node x = ceil(root, key);
        if(x == null)
            return null;
        return x.key;
    }

    private Node ceil(Node x, Key key) {
        if( x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;
        if(cmp > 0)
            return ceil(x.right, key);
        Node t = ceil(x.left, key);
        if(t == null)
            return x;
        return t;
    }
}
