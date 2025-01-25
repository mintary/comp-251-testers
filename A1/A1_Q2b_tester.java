import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class A1_Q2b_tester {
    
    @Test
    public void testCase1() {
        DisjointSetsB ds = new DisjointSetsB(4);
        // {0}, {1}, {2}, {3}
        ds.union(3, 2);
        // {0}, {1}, {2, 3}
        ds.move(3, 2);
        // {0}, {1}, {2, 3}
        ds.move(1, 3);
        // {0}, {2, 3, 1}
        assertEquals(6, ds.sum_elements(3));
        ds.union(1, 2);
        // {0}, {2, 3, 1}
        assertEquals(6, ds.sum_elements(1));
        ds.move(1, 2);
        // {0}, {2, 3, 1}
        assertEquals(2, ds.find(1));
        assertEquals(2, ds.find(2));
        assertEquals(2, ds.find(3));
    }

    @Test
    public void testCase2() {
        DisjointSetsB ds = new DisjointSetsB(4);
        // {0}, {1}, {2}, {3}
        assertEquals(2, ds.sum_elements(2));
        assertEquals(3, ds.sum_elements(3));
        ds.union(2, 1);
        // {0}, {1, 2}, {3}
        ds.union(1, 3);
        // {0}, {1, 2, 3}
        assertEquals(1, ds.find(2));
        assertEquals(1, ds.find(3));
    }

    @Test
    public void testCase3() {
        DisjointSetsB ds = new DisjointSetsB(4);
        // {0}, {1}, {2}, {3}
        ds.move(2, 1);
        // {0}, {1, 2}, {3}
        ds.union(2, 1);
        // {0}, {1, 2}, {3}
        ds.move(1, 3);
        // {0}, {2}, {3, 1}
        assertEquals(4, ds.sum_elements(3));
        assertEquals(3, ds.find(1));
        assertEquals(2, ds.find(2));
    }

    @Test
    public void testCase4() {
        DisjointSetsB ds = new DisjointSetsB(6);
        // {0}, {1}, {2}, {3}, {4}, {5}
        ds.union(1, 2);
        // {0}, {1, 2}, {3}, {4}, {5}
        ds.move(3, 4);
        // {0}, {1, 2}, {4, 3}, {5}
        ds.union(3, 5);
        // {0}, {1, 2}, {4, 3, 5}
        assertEquals(12, ds.sum_elements(4));
        ds.move(4, 1);
        // {0}, {1, 2, 4}, {3, 5}
        assertEquals(7, ds.sum_elements(4));
        assertEquals(8, ds.sum_elements(3));
        assertTrue(1 == ds.find(4) || 2 == ds.find(4));
        assertTrue(5 == ds.find(3) || 3 == ds.find(3));
    }

    @Test
    public void testCase5() {
        DisjointSetsB ds = new DisjointSetsB(6);
        // {0}, {1}, {2}, {3}, {4}, {5}
        ds.move(2, 3);
        // {0}, {1}, {3, 2}, {4}, {5}
        ds.move(5, 3);
        // {0}, {1}, {3, 2, 5}, {4}
        ds.union(1, 2);
        // {0}, {1, 3, 2, 5}, {4}
        assertEquals(11, ds.sum_elements(5));
        assertEquals(4, ds.sum_elements(4));
        ds.move(3, 1);
        // {0}, {1, 3, 2, 5}, {4}
        assertEquals(11, ds.sum_elements(3));
    }

    /*
     * Extra test cases
     */

    @Test
    public void testCase6() {
        DisjointSetsB ds = new DisjointSetsB(10);
        // {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}
        ds.union(1, 2); // 2 is rep
        ds.union(3, 4); // 4 is rep
        ds.union(1, 3); // 4 is rep
        ds.union(6, 7);
        ds.union(8, 9);
        ds.union(6, 8); // 9 is rep
        // {0}, {1, 2, 3, 4}, {5}, {6, 7, 8, 9}
        ds.move(4, 7);
        // {0}, {1, 2, 3}, {5}, {4, 6, 7, 8, 9}
        assertEquals(34, ds.sum_elements(4));
    }

    @Test
    public void testCase8() {
        DisjointSetsB ds = new DisjointSetsB(10);
        // {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}
        ds.union(1, 2); // 2 is rep
        ds.union(3, 4); // 4 is rep
        ds.union(1, 3); // 4 is rep
        ds.union(6, 7);
        ds.union(8, 9);
        ds.union(6, 8); // 9 is rep
        ds.move(3, 8);
        // {0}, {1, 2, 4}, {5}, {3, 6, 7, 8, 9}
        assertEquals(33, ds.sum_elements(3));
    }
}
