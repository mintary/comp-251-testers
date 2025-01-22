import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class A1_Q1_tester {
    /**
     * CHAINING: ED PUBLIC TESTS
     */
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
    /** 
     * CHAINING: EXTRA TESTS
     */
    @Test
    public void testChain4() {
        Chaining chaining = new Chaining(4, 0, -1);
        assertEquals(chaining.chain(5), chaining.chain(13));
    }

    @Test
    public void testInsertKey() {
        Chaining chaining = new Chaining(4, 0, -1);
        int key = 5;
        int collisions = chaining.insertKey(key);
        assertEquals(0, collisions);
        assertTrue(chaining.Table.get(chaining.chain(key)).contains(key));
    }

    @Test
    public void testInsertKeyWithCollision() {
        Chaining chaining = new Chaining(4, 0, -1);
        int key1 = 5;
        int key2 = 13; // this should cause a collision with key1 (chain is 1)
        chaining.insertKey(key1);
        int collisions = chaining.insertKey(key2);
        assertEquals(1, collisions);
        assertTrue(chaining.Table.get(chaining.chain(key1)).contains(key1));
        assertTrue(chaining.Table.get(chaining.chain(key2)).contains(key2)); // successful insertion
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

    // @Test
    // public void testChainingInsertKeyArrayWithDuplicates() {
    //     Chaining chaining = new Chaining(10, 0, -1);
    //     int[] keys = {1, 1, 1};
    //     // 0 collisions with 1, 1 collision with 1 (failed insertion), 1 collision with 1 (failed insertion)
    //     assertEquals(2, chaining.insertKeyArray(keys));
    // }

    /**
     * OPEN ADDRESSING: ED PUBLIC TESTS
     */
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
        int collisions = openAddressing.removeKey(109);
        assertEquals(2, collisions);
    }

    /**
     * OPEN ADDRESSING: EXTRA TESTS
     */
    @Test
    public void testInsertKey10() {
        Open_Addressing openAddressing = new Open_Addressing(4, 0, -1);
        int key = 5;
        int collisions = openAddressing.insertKey(key);
        assertEquals(0, collisions);
        assertEquals(key, openAddressing.Table[openAddressing.probe(key, 0)]);
    }

    @Test
    public void testInsertKeyCollision() {
        Open_Addressing openAddressing = new Open_Addressing(4, 0, -1);
        int key = 5;
        int key2 = 13;
        int collisions = openAddressing.insertKey(key);
        assertEquals(0, collisions);
        int collisions2 = openAddressing.insertKey(key2);
        assertEquals(1, collisions2);
        assertEquals(key, openAddressing.Table[openAddressing.probe(key, 0)]);
        assertEquals(key2, openAddressing.Table[openAddressing.probe(key2, 1)]);
    }

    // @Test
    // public void testOpenAddressingInsertKeyArrayWithDuplicates() {
    //     Open_Addressing openAddressing = new Open_Addressing(10, 0, -1);
    //     int[] keys = {1, 1, 1, 1};
    //     int collisions = 0;
    //     for (int key : keys) {
    //         collisions += openAddressing.insertKey(key);
    //         System.out.println(collisions);
    //     }
    //     assertEquals(6, collisions);
    // }

    @Test
    public void testInsertKeyNotFound() {
        Open_Addressing openAddressing = new Open_Addressing(4, 0, -1);
        int key = 5;
        int collisions = openAddressing.insertKey(key);
        assertEquals(0, collisions);
        // only needs to visit 1 slot, array is [-1, 5, -1, -1] but
        // once you increment once from first slot, find that
        // the next slot is empty
        int collisions2 = openAddressing.removeKey(13);
        assertEquals(1, collisions2);
    }

}

