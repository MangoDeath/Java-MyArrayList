package MyArrays;

import java.util.Iterator;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.KeyValue<K, V>> {

    private Node root;
    private int size;


    public static class KeyValue<K, V> {
        private K key;
        private V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }


    public void put(K key, V val) {
        Node newNode = new Node(key, val);

        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node current = root;
        while (true) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    size++;
                    return;
                }
                current = current.left;

            } else if (cmp > 0) {
                if (current.right == null) {
                    current.right = newNode;
                    size++;
                    return;
                }
                current = current.right;

            } else {

                current.val = val;
                return;
            }
        }
    }


    public V get(K key) {
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }
        return null;
    }


    public void delete(K key) {
        Node parent = null;
        Node current = root;
        boolean isLeftChild = false;


        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                parent = current;
                isLeftChild = true;
                current = current.left;
            } else if (cmp > 0) {
                parent = current;
                isLeftChild = false;
                current = current.right;
            } else {
                break;
            }
        }

        if (current == null) return;

        // Case 1: node has no children
        if (current.left == null && current.right == null) {
            if (parent == null) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }


        } else if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }


        } else if (current.right == null) {
            if (parent == null) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }


        } else {
            Node successorParent = current;
            Node successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }


            current.key = successor.key;
            current.val = successor.val;


            if (successorParent == current) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
        }

        size--;
    }

    public int size() {
        return size;
    }


    @Override
    public Iterator<KeyValue<K, V>> iterator() {
        return new Iterator<KeyValue<K, V>>() {
            private Stack<Node> stack = new Stack<>();


            {
                pushLeft(root);
            }

            private void pushLeft(Node node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public KeyValue<K, V> next() {
                Node node = stack.pop();
                pushLeft(node.right);
                return new KeyValue<>(node.key, node.val);
            }
        };
    }
}