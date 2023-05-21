import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size = 0;
    public class Node {
        private K key;
        private V val;
        private Node left, right;


        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
        @Override
        public String toString() {
            return "{key: " + this.key + " value: " + this.val + "}";
        }
    }
    public int getSize() {
        return size;
    }
    public void put(K key, V val){
        root = put(root, key, val);
    }
    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }

        return node;
    }

    public V get(K key) {
        return getRoot(root, key);
    }

    private V getRoot(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return getRoot(node.left, key);
        } else if (cmp > 0) {
            return getRoot(node.right, key);
        } else {
            return node.val;
        }
    }
    public void delete(K key) {
        root = deleteNode(root, key);
        if (root != null) {
            size--;
        }
    }

    private Node deleteNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = deleteNode(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node minimumNode = findMinimumNode(node.right);
                node.key = minimumNode.key;
                node.val = minimumNode.val;
                node.right = deleteNode(node.right, minimumNode.key);
            }
        }

        return node;
    }

    private Node findMinimumNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return findMinimumNode(node.left);
    }

    public Iterable<Node> iterator() {
        ArrayList<Node> nodes = new ArrayList<>();
        inOrderTraversal(nodes, root);
        return nodes;
    }

    private void inOrderTraversal(ArrayList<Node> list, Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(list, node.left);
        list.add(node);
        inOrderTraversal(list, node.right);
    }

}
