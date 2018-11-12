import java.util.*;

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
        Node<T> value = node.right;
        node.right = value.left;
        value.left = node;
        return value;
    }

    private Node<T> splay(Node<T> node, T value) {
        if (node == null) return null;
        int mainCompare = value.compareTo(node.value);
        switch (mainCompare) {
            case -1:
                if (node.left == null) return node;
                int compareWithLeft = value.compareTo(node.left.value);
                switch (compareWithLeft) {
                    case 1:
                        node.left.right = splay(node.left.right, value);
                        if (node.left.right != null) node.left = rotateLeft(node.left);
                    case -1:
                        node.left.left = splay(node.left.left, value);
                        node = rotateRight(node);
                }
                return node.left == null ? node : rotateRight(node);
            case 1:
                if (node.right == null) return node;
                int compareWithRight = value.compareTo(node.right.value);
                switch (compareWithRight) {
                    case 1:
                        node.right.right = splay(node.right.right, value);
                        node = rotateLeft(node);
                    case -1:
                        node.right.left = splay(node.right.left, value);
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

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public T get(T value) {
        root = splay(root, value);
        return value.compareTo(root.value) == 0 ? root.value : null;
    }

    @Override
    public boolean contains(Object o) {
        return get((T) o) != null;
    }

    public class SplayTreeIterator implements Iterator<T> {
        Node<T> node = root;
        Stack<Node<T>> stack = new Stack<Node<T>>();
        T value;


        public SplayTreeIterator() {
            if (node != null) stack.push(null);
            while (node.left != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (hasNext()) value = node.value;
            if (node.right != null) {
                node = node.right;
                while (node.left != null) {
                    stack.push(node);
                    node = node.left;
                }
            } else node = stack.pop();
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Invalid operation");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SplayTreeIterator();
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
        return false; //бросить исключение NodeImplementException
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
            }
            Node<T> node = root.right;
            root = root.left;
            splay(root, (T) o);
            root.right = node;
            size--;
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int currentSize = this.size;
        ArrayList list = new ArrayList();
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
        root = null;
        size = 0;
    }
}
