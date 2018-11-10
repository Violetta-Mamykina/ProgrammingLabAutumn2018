import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        ArrayList checkList = new ArrayList();
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
    }
}
