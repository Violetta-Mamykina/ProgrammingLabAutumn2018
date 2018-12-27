import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SplayTreeTests {
    private SplayTree<Integer> tree = new SplayTree<Integer>();
    private SplayTree<String> stringTree = new SplayTree<>();

    @Test
    void contains() {
        tree.add(18);
        tree.add(36);
        assertTrue(tree.contains(18));
        assertFalse(tree.contains(0));
        assertTrue(tree.contains(36));
        tree.remove(36);
        assertFalse(tree.contains(36));

        stringTree.add("Emma");
        stringTree.add("Andrew");
        assertTrue(stringTree.contains("Emma"));
        assertFalse(stringTree.contains("Mag"));
        stringTree.remove("Emma");
        assertTrue(stringTree.contains("Andrew"));
        assertFalse(stringTree.contains("Emma"));
    }

    @Test
    void isEmpty() {
        assertTrue(tree.isEmpty());
        tree.add(18);
        tree.add(98);
        assertFalse(tree.isEmpty());
        tree.remove(18);
        tree.remove(0);
        assertFalse(tree.isEmpty());
        tree.remove(98);
        assertTrue(tree.isEmpty());

        assertTrue(stringTree.isEmpty());
        stringTree.add("20 лет");
        assertFalse(stringTree.isEmpty());
    }

    @Test
    void clear() {
        tree.add(8);
        tree.add(13);
        tree.clear();
        assertEquals(0, tree.size());
        assertFalse(tree.contains(8));
        assertFalse(tree.contains(13));
        //tree.forEach(System.out::println);

        stringTree.add("aaaaaa");
        stringTree.add("a");
        stringTree.add("aaa");
        stringTree.clear();
        assertFalse(tree.contains("a"));
        assertEquals(0, stringTree.size());
    }

    @Test
    void removeAll() {
        List<Integer> checkList = new ArrayList<Integer>();
        tree.add(5);
        tree.add(6);
        checkList.add(5);
        checkList.add(6);
        tree.removeAll(checkList);
        assertEquals(0, tree.size());

        tree.clear();
        checkList.clear();
        tree.add(0);
        tree.add(3);
        tree.add(6);
        checkList.add(0);
        tree.removeAll(checkList);
        assertEquals(2, tree.size());
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(6));
        assertFalse(tree.contains(0));
    }

    @Test
    void retainAll() {
        List<Integer> checkList = new ArrayList<Integer>();
        checkList.add(5);
        checkList.add(6);
        tree.add(5);
        tree.add(6);
        tree.add(8);
        tree.retainAll(checkList);
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(6));
        assertFalse(tree.contains(8));
        assertEquals(2, tree.size());
    }

    @Test
    void addAll() {
        List<Integer> checkList = new ArrayList<Integer>();
        checkList.add(14);
        checkList.add(18);
        checkList.add(98);
        tree.addAll(checkList);
        assertTrue(tree.contains(14));
        assertTrue(tree.contains(18));
        assertTrue(tree.contains(98));
        assertFalse(tree.contains(22));
        assertEquals(3, tree.size());
    }

    @Test
    void containsAll() {
        List<Integer> checkList = new ArrayList<Integer>();
        checkList.add(14);
        checkList.add(18);
        checkList.add(98);
        tree.add(14);
        tree.add(18);
        tree.add(98);
        assertTrue(tree.containsAll(checkList));
    }

    @Test
    void toArray() {
        Object[] check = {1, 2, 3};
        tree.add(1);
        tree.add(2);
        tree.add(3);
        Object[] result = tree.toArray();
        Arrays.sort(check);
        Arrays.sort(result);
        Assert.assertArrayEquals(check, result);
    }

    Random random = new Random();

    private Set<Integer> generate(int size) {
        Set<Integer> set = new HashSet<Integer>();
        IntStream.range(0, size).map(i -> random.nextInt()).forEach(set::add);
        return set;
    }

    private int getRandomValue(Set<Integer> set) {
        int value = random.nextInt();
        while (set.contains(value)) {
            value = random.nextInt();
        }
        return value;
    }

    private SplayTree createSplayTree(Set<Integer> values) {
        SplayTree<Integer> splayTreeInteger = new SplayTree<>();
        values.forEach(splayTreeInteger::add);
        return splayTreeInteger;
    }

    @Test
    void iteratorTest() {
        Set<Integer> values = generate(10000);
        SplayTree<Integer> splayTree = createSplayTree(values);
        splayTree.forEach(value -> assertTrue(values.contains(value)));
    }

    @Test
    void addTest() {
        Set<Integer> values = generate(100000);
        SplayTree<Integer> splayTree = createSplayTree(values);
        for (int i = 0; i < 10; i++) {
            int value = getRandomValue(values);
            assertFalse(splayTree.contains(value));
            splayTree.add(value);
            assertTrue(splayTree.contains(value));
        }
    }

    @Test
    void removeTest() {
        Set<Integer> values = generate(10000);
        SplayTree<Integer> splayTree = createSplayTree(values);
        values.forEach(value -> {
            splayTree.remove(value);
            assertFalse(splayTree.contains(value));
        });
    }
}
