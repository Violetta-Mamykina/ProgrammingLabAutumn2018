import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SplayTree<Integer> splayTree = new SplayTree<Integer>();
        splayTree.add(18);
        System.out.println(Arrays.toString(splayTree.toArray()));
        SplayTreeIterator splayTreeIterator = new SplayTreeIterator(splayTree);
        System.out.println(splayTreeIterator.getStack().size());
        while (splayTreeIterator.hasNext()) {
            System.out.println(splayTreeIterator.next());
        }
    }
}
