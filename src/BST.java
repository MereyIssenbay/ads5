public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size = 0;
    public class Node {
        private K key;
        private V val;
        private Node left, right;


        public Node(K key, V value) {
            this.key = key;
            this.val = val;
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
        this.root = deleteNode(root, key);
        size--;
    }

    private Node deleteNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 1) {
            node.left = deleteNode(node.left, key);
        } else if (key.compareTo(node.key) == -1) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null && node.right == null){
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node minimum_node = findMinimumNode(node);
                node.key = minimum_node.key;
                node.val = minimum_node.val;
                node.right = deleteNode(node.right, minimum_node.key);
            }
        }

        return node;
    }

    private Node findMinimumNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public Iterable<K> iterator(){
        return null;
    }
}
