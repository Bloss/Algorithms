package sort;

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

    public Value get(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return get(x.left, key);
        if(cmp > 0)
            return get(x.right, key);
        return x.val;
    }
}
