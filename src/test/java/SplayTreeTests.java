import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplayTreeTests {
    private SplayTree<Integer> tree = new SplayTree<Integer>();

    @Test
    void size() {
        assertEquals(0, tree.size());
        tree.add(2);
        assertEquals(1, tree.size());
        tree.add(6);
        tree.add(12);
        tree.add(18);
        tree.add(98);
        assertEquals(5, tree.size());
        tree.remove(2);
        tree.remove(6);
        tree.remove(1);
        assertEquals(3, tree.size());
        tree.remove(18);
        tree.remove(12);
        assertEquals(1, tree.size());
    }

    @Test
    void contains() {
        tree.add(18);
        tree.add(36);
        assertTrue(tree.contains(18));
        assertFalse(tree.contains(0));
        assertTrue(tree.contains(36));
        tree.remove(36);
        assertFalse(tree.contains(36));

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
    }

    @Test
    void clear() {
        tree.add(8);
        tree.add(13);
        tree.clear();
        assertEquals(0, tree.size());
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
        Assert.assertArrayEquals(check, result);
    }
}
