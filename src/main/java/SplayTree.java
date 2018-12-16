import java.util.*;

public class SplayTree<T extends Comparable<T>> implements Set<T>, Iterable<T> {
    private Node<T> root;
    private int size = 0;

    private Node<T> rotateRight(Node<T> node) {
        Node<T> value = node.left;
        node.left = value.right;
        value.right = node;
        return value;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> value = node.right;
        node.right = value.left;
        value.left = node;
        return value;
    }

    private Node splay(Node node, T value) {
        if (node == null) return null;
        if (value.compareTo((T) node.value) < 0) {
            if (node.left == null) return node;
            if (value.compareTo((T) node.left.value) < 0) {
                node.left.left = splay(node.left.left, value);
                node = rotateRight(node);
            } else if (value.compareTo((T) node.left.value) > 0) {
                node.left.right = splay(node.left.right, value);
                if (node.left.right != null) node.left = rotateLeft(node.left);
            }
            return node.left == null ? node : rotateRight(node);
        } else if (value.compareTo((T) node.value) > 0) {

            if (node.right == null) return node;

            if (value.compareTo((T) node.right.value) < 0) {
                node.right.left = splay(node.right.left, value);
                if (node.right.left != null) node.right = rotateRight(node.right);
            } else if (value.compareTo((T) node.right.value) > 0) {
                node.right.right = splay(node.right.right, value);
                node = rotateLeft(node);
            }
            return node.right == null ? node : rotateLeft(node);
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public T get(T value) {
        if (root == null) return null;
        else {
            root = splay(root, value);
            return value.compareTo(root.value) == 0 ? root.value : null;
        }
    }

    @Override
    public boolean contains(Object o) {
        return get((T) o) != null;
    }

    @Override
    public Iterator<T> iterator() {
        return new SplayTreeIterator<T>(this);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (T it : this) {
            array[i] = it;
            i++;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) this.toArray();
    }

    @Override
    public boolean add(T t) {
        if (root == null) {
            root = new Node<T>(t);
            size++;
            return true;
        }
        root = splay(root, t);
        int compare = t.compareTo(root.value);
        Node<T> node = new Node<T>(t);
        node.left = compare < 0 ? root.left : root;
        node.right = compare < 0 ? root : root.right;
        root = node;
        if (compare < 0) {
            root.left = null;
            size++;
            return true;
        } else if (compare > 0) {
            root.right = null;
            size++;
            return true;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean remove(Object o) {
        if (root == null) return false;
        root = splay(root, (T) o);
        if (o.equals(root.value)) {
            if (root.left == null) {
                root = root.right;
                size--;
                return true;
            } else {
                Node<T> node = root.right;
                root = root.left;
                splay(root, (T) o);
                root.right = node;
                size--;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c)
            if (!contains(o)) return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int currentSize = this.size;
        for (Object o : c) add((T) o);
        return this.size > currentSize;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int currentSize = this.size;
        for (Object o : this) {
            if (!c.contains(o)) this.remove(o);
        }
        return this.size < currentSize;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int currentSize = this.size;
        for (Object o : c) {
            if (contains(o)) remove(o);
        }
        return this.size < currentSize;
    }

    @Override
    public void clear() {
        for (Object it : this)
            remove((T) it);
        size = 0;
    }

    public Node<T> getRoot() {
        return root;
    }
}
