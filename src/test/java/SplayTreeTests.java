import org.junit.jupiter.api.Test;

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
        assertTrue(tree.contains(18));
        assertFalse(tree.contains(0));
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




}
