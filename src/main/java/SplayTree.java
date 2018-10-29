import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public class SplayTree<T extends Comparable<T>> implements SortedSet<T> {
    private Node<T> root, left, right;
    private int size = 0;

    private Node<T> rotateRight(Node<T> node) {
        Node<T> value = node.left;
        node.left = value.right;
        value.right = node;
        return value;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> value = node.left;
        node.right = value.left;
        value.right = node;
        return value;
    }

    private Node<T> splay(Node<T> node, T value) {
        int mainCompare = value.compareTo(node.value);

        switch (mainCompare) {
        case -1:
            if (node.left == null) return node;
            int compareWithLeft = value.compareTo(node.left.value);
            switch (compareWithLeft) {
                case -1:
                    node.left.left = splay(node.left.left, value);
                    node = rotateRight(node);
                case 1:
                    node.left.right = splay(node.left.right, value);
                    if (node.left.right != null) node.left = rotateLeft(node.left);
            }
            return node.left == null ? null : rotateRight(node);

            case 1:
            if (node.right == null) return node;
            int compareWithRight = value.compareTo(node.right.value);
            switch (compareWithRight) {
                case 1:
                    node.right.right = splay(node.right.right, value);
                    node = rotateLeft(node);
                case -1:
                    node.left.right = splay(node.right.left, value);
                    if (node.right.left != null) node.right = rotateRight(node.right);
            }
            return node.right == null ? node : rotateLeft(node);
        }
        return node;
    }


    @Override

    public Comparator<? super T> comparator() {
        return comparator();
    }

    public SortedSet<T> subSet(T fromElement, T toElement) {
        return null;
    }

    public SortedSet<T> headSet(T toElement) {
        return null;
    }

    public SortedSet<T> tailSet(T fromElement) {
        return null;
    }

    public T first() {
        return null;
    }

    public T last() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (root == null) {
            root = new Node<T>(t);
            size++;
            return true;
        }
        root = splay(root, t);
        Node<T> node = new Node<T>(t);
        int compare = t.compareTo(root.value);
        switch (compare) {
            case -1:
                node.left = root.left;
                node.right = root;
                root.left = null;
                root = node;
                size++;
                return true;
            case 1:
                node.right = root.right;
                node.left = root;
                root.right = null;
                root = node;
                size++;
                return true;
        }
        return false;
    }


    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }
}
