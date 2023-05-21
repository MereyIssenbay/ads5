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

    }
    public V get(K key){
        return null;
    }
    public void delete(K key){

    }
    public Iterable<K> iterator(){
        return null;
    }
}
