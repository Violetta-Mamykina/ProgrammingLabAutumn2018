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
        return size();
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
        /*if (root == null) {
            root = new Node<T>(t);
            size++;
            return true;
        }

        return false;*/
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
