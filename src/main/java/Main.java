import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SplayTree<Integer> splayTree = new SplayTree<Integer>();
        splayTree.add(18);
        splayTree.add(12);
        splayTree.add(5);
        splayTree.remove(5);
        System.out.println(Arrays.toString(splayTree.toArray()));
        SplayTreeIterator splayTreeIterator = new SplayTreeIterator(splayTree);
        while (splayTreeIterator.hasNext()) {
            System.out.println(splayTreeIterator.next());
        }
    }
}
