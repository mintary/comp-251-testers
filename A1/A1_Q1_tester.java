import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class A1_Q1_tester {
    @Test
    public void testChain1() {
        Chaining chaining = new Chaining(10, 0, -1);
        assertEquals(30, chaining.chain(1));
    }

    @Test
    public void testChain2() {
        Chaining chaining = new Chaining(10, 0, -1);
        assertEquals(25, chaining.chain(4));
    }

    @Test
    public void testChain3() {
        Chaining chaining = new Chaining(10, 0, -1);
        assertEquals(19, chaining.chain(8));
    }

    // extra test, equal chains
    @Test
    public void testChain4() {
        Chaining chaining = new Chaining(4, 0, -1);
        assertEquals(1, chaining.chain(13));
    }

    /* 
     * CHAINING: EXTRA TESTS
     */

     // test that a key, when inserted, can be found inside the table
    @Test
    public void testInsertKey() {
        Chaining chaining = new Chaining(4, 0, -1);
        int key = 5;
        int collisions = chaining.insertKey(key);
        assertEquals(0, collisions);
        assertTrue(chaining.Table.get(chaining.chain(key)).contains(key));
    }

    // test a collision when inserting a key
    @Test
    public void testInsertKeyWithCollision() {
        Chaining chaining = new Chaining(4, 0, -1);
        int key1 = 5;
        int key2 = 13; // this should cause a collision with key1 (chain is 1)
        chaining.insertKey(key1);
        int collisions = chaining.insertKey(key2);
        assertEquals(1, collisions);
        assertTrue(chaining.Table.get(chaining.chain(key1)).contains(key1));
        assertFalse(chaining.Table.get(chaining.chain(key2)).contains(key2)); // failed insertion (chaining only)
    }

    @Test
    public void testInsertKeyArray() {
        Chaining chaining = new Chaining(4, 0, -1);
        int[] keys = {5, 13, 21}; // 13 and 21 should cause collisions
        int collisions = chaining.insertKeyArray(keys);
        assertEquals(3, collisions); // 0 collisions for 5, 1 collision for 13, 2 collisions for 21
        for (int key : keys) {
            assertTrue(chaining.Table.get(chaining.chain(key)).contains(key));
        }
    }

    @Test
    public void testInsertKeyArrayWithDuplicates() {
        Chaining chaining = new Chaining(10, 0, -1);
        int[] keys = {1, 1, 1};
        // 0 collisions with 1, 1 collision with 1 (failed insertion), 1 collision with 1 (failed insertion)
        assertEquals(2, chaining.insertKeyArray(keys));
    }


    @Test
    public void testProbe1() {
        Open_Addressing openAddressing = new Open_Addressing(10, 0, -1);
        assertEquals(30, openAddressing.probe(1, 0));
    }

    @Test
    public void testProbe2() {
        Open_Addressing openAddressing = new Open_Addressing(10, 0, -1);
        assertEquals(31, openAddressing.probe(1, 1));
    }

    @Test
    public void testProbe4() {
        Open_Addressing openAddressing = new Open_Addressing(10, 0, -1);
        assertEquals(1, openAddressing.probe(1, 3));
    }

    @Test
    public void testProbe5() {
        Open_Addressing openAddressing = new Open_Addressing(10, 0, -1);
        assertEquals(28, openAddressing.probe(2, 0));
    }

    @Test
    public void testRemoveKey6() {
        Open_Addressing openAddressing = new Open_Addressing(10, 0, -1);
        openAddressing.removeKey(0);
        assertNotEquals(0, openAddressing.Table[0]);
    }

    @Test
    public void testInsertRemoveKey7() {
        Open_Addressing openAddressing = new Open_Addressing(10, 0, -1);
        openAddressing.insertKey(32);
        openAddressing.insertKey(52);
        openAddressing.insertKey(72);
        openAddressing.removeKey(52);
        openAddressing.insertKey(92);
        assertEquals(32, openAddressing.Table[13]);
        assertEquals(92, openAddressing.Table[14]);
        assertEquals(72, openAddressing.Table[15]);
    }

    @Test
    public void testInsertRemoveKey9() {
        Open_Addressing openAddressing = new Open_Addressing(10, 0, -1);
        openAddressing.insertKey(69);
        openAddressing.insertKey(89);
        openAddressing.insertKey(109);
        openAddressing.insertKey(129);
        openAddressing.removeKey(109);
        assertEquals(2, openAddressing.Table[openAddressing.probe(109, 0)]);
    }
}

