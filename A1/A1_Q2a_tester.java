import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class A1_Q2a_tester {
    @Test
    public void testInitialSet() {
        DisjointSetsA ds = new DisjointSetsA(10);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            result.append("#").append(ds.find(i));
        }
        assertEquals("#0#1#2#3#4#5#6#7#8#9", result.toString());
    }

    @Test
    public void testFindRoot() {
        DisjointSetsA ds = new DisjointSetsA(10);
        int root = ds.find(0);
        assertEquals(0, root);
    }

    @Test
    public void testFindThree() {
        DisjointSetsA ds = new DisjointSetsA(10);
        int root3 = ds.find(3);
        assertEquals(3, root3);
    }

    @Test
    public void testUnion() {
        DisjointSetsA ds = new DisjointSetsA(10);
        int unionRoot = ds.union(0, 1);
        int root0 = ds.find(0);
        int root1 = ds.find(1);
        assertEquals(unionRoot, 1);
        assertTrue(root0 == 0 || root0 == 1);
        assertTrue(root1 == 0 || root1 == 1);
        assertEquals(root0, root1);
    }


    @Test
    public void testUnionDifferentRanks() {
        DisjointSetsA ds = new DisjointSetsA(10);
        int unionRoot = ds.union(0, 1);
        int root0 = ds.find(0);
        int root1 = ds.find(1);
        assertEquals(unionRoot, 1);
        assertTrue(root0 == 0 || root0 == 1);
        assertTrue(root1 == 0 || root1 == 1);
        assertEquals(root0, root1);

        int unionRootDifferent = ds.union(1, 2);
        int root2 = ds.find(2);
        assertEquals(unionRootDifferent, 1);
        assertEquals(root2, 1);
    }

    @Test
    public void testUnionTwice() {
        DisjointSetsA ds = new DisjointSetsA(10);
        int unionRootFirst = ds.union(0, 1);
        boolean firstUnion = ds.find(0) == ds.find(1);
        int unionRootSecond = ds.union(0, 1);
        boolean secondUnion = ds.find(0) == ds.find(1);
        assertEquals(unionRootFirst, 1);
        assertEquals(unionRootSecond, 1);
        assertTrue(firstUnion);
        assertTrue(secondUnion);
    }

    @Test
    public void testUnionWithPathCompression() {
        DisjointSetsA ds = new DisjointSetsA(10);
        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(3, 4);
        ds.union(4, 5);
        ds.union(5, 6);
        ds.union(6, 7);
        ds.union(7, 8);
        ds.union(8, 9);

        for (int i = 0; i < 10; i++) {
            assertEquals(ds.find(0), ds.find(i));
        }
    }

    @Test
    public void testUnionWithEqualRanks() {
        DisjointSetsA ds = new DisjointSetsA(10);
        ds.union(0, 1);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(8, 9);
        ds.union(0, 2);
        ds.union(4, 6);
        ds.union(8, 0);
        ds.union(4, 8);

        for (int i = 0; i < 10; i++) {
            assertEquals(ds.find(0), ds.find(i));
        }
    }

}
