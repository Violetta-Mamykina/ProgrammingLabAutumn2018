import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SplayTreeIterator<T extends Comparable> implements Iterator<T> {

    private SplayTree splayTree;
    private ArrayDeque<Node<T>> visited;
    private boolean empty;
    private Node<T> next;

    public SplayTreeIterator(SplayTree splayTree) {

        this.splayTree = splayTree;
        visited = new ArrayDeque<>();
        next = splayTree.getRoot();
        empty = next == null;
    }

    @Override
    public boolean hasNext() {
        return !empty;
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        Node<T> res = next;
        if (next.left != null && !visited.contains(next.left)) {
            visited.addLast(next);
            next = next.left;
        } else if (next.right != null && !visited.contains(next.right)) {
            visited.addLast(next);
            if (next.left != null) {
                next = next.left;
            } else if (next.right != null) {
                next = next.right;
            } else if (visited.isEmpty()) {
                next = null;
            } else {
                next = visited.pollLast();
            }
        } else {
            empty = true;
        }
        return res.value;
    }

    @Override
    public void remove() {
        splayTree.remove(next());
    }

    private ArrayDeque<Node<T>> getDeque() {
        return visited;
    }
}