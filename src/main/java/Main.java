import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SplayTree<String> splayTree = new SplayTree<String>();
        splayTree.add("candle");
        splayTree.add("bring");
        splayTree.add("arc");
        splayTree.add("math");
        splayTree.remove("math");
        System.out.println(Arrays.toString(splayTree.toArray()));
        SplayTreeIterator splayTreeIterator = new SplayTreeIterator(splayTree);
        while (splayTreeIterator.hasNext()) {
            System.out.println(splayTreeIterator.next());
        }
    }
}

