import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class SplayTreeIterator<T extends Comparable> implements Iterator<T> {

    private SplayTree splayTree;
    private Stack<Node<T>> stack;
    private Node<T> root;

    public SplayTreeIterator(SplayTree splayTree) {

        this.splayTree = splayTree;

        stack = new Stack<Node<T>>();
        Node<T> root = this.splayTree.getRoot();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();

        Node<T> smallest = stack.pop();
        if (smallest.right != null) {
            Node<T> node = smallest.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return smallest.value;
    }

    @Override
    public void remove() {
        splayTree.remove(next());
    }

    public Stack<Node<T>> getStack() {
        return stack;
    }
}
