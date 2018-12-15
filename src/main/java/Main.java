import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SplayTree<String> splayTree = new SplayTree<String>();
        splayTree.add("a");
        splayTree.add("bb");
        splayTree.add("ccc");
        System.out.println(Arrays.toString(splayTree.toArray()));
        SplayTreeIterator splayTreeIterator = new SplayTreeIterator(splayTree);
        System.out.println(splayTreeIterator.getStack().size());
        while (splayTreeIterator.hasNext()) {
            System.out.println(splayTreeIterator.next());
        }
    }
}
