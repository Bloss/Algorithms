package search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

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

    // 向上取整
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

    // 向下取整
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

    /**
     * 根据排名得出元素值
     * @param k start with 0
     * @return key 元素值
     */
    public Key select(int k) {
        if(k < 0 || k >= size())
            throw new IllegalArgumentException();
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if(x == null)
            return null;
        int t = size(x.left);
        if(k < t)
            return select(x.left, k);
        if(k > t)
            return select(x.right, k - t - 1);
        return x;
    }

    // 根据元素值找到它的排名
    public int rank(Key key) {
        if(key == null)
            throw new NullPointerException("argument to rank() is null");
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if(x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return rank(x.left, key);
        if(cmp > 0)
            return 1 + rank(x.right, key) + size(x.left);
        return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if(x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = delete(x.left, key);
        else if(cmp > 0)
            x.right = delete(x.right, key);
        else {
            if(x.left == null)
                return x.right;
            if(x.right == null)
                return x.left;
            // 暂存当前x节点
            Node t = x;
            // 找到大于t的最小节点, 赋值给x
            x = min(t.right);
            // 将上面找到的最小节点删除, 并将返回的树连接到x.right
            x.right = deleteMin(t.right);
            // 将t.left连接到x.left, 这样就完成了x替换t, 而此时没有任何节点连接到t, t会被删除
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if(x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public List<Key> keys() {
        return keys(min(), max());
    }

    public List<Key> keys(Key lo, Key hi) {
        if(lo == null)
            throw new NullPointerException("first argument to keys() is null");
        if(hi == null)
            throw new NullPointerException("second argument to keys() is null");
        List<Key> list = new ArrayList<>();
        keys(root, list, lo, hi);
        return list;
    }

    private void keys(Node x, List<Key> list, Key lo, Key hi) {
        if(x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo < 0)
            keys(x.left, list, lo, hi);
        if(cmplo <= 0 && cmphi >= 0)
            list.add(x.key);
        if(cmphi > 0)
            keys(x.right, list, lo, hi);
    }
}
