import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplayTreeTests {
    private SplayTree<Integer> tree = new SplayTree<Integer>();

    @Test
    void size() {
        tree.add(2);
        tree.add(6);
        tree.add(12);
        tree.add(18);
        tree.add(98);
        assertEquals(5, tree.size());
        tree.remove(2);
        tree.remove(6);
        assertEquals(3, tree.size());
    }

    @Test
    void isEmpty() {
        assertTrue(tree.isEmpty());
        tree.add(18);
        tree.add(98);
        assertFalse(tree.isEmpty());
        tree.remove(18);
        assertFalse(tree.isEmpty());
        tree.remove(98);
        assertTrue(tree.isEmpty());
    }




}
