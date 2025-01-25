import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class A1_Q3_tester {
    @Test
    public void testBasicExample() {
        String[] posts = {
            "David no no no no nobody never",
            "Alexia why ever not",
            "Parham no not never nobody",
            "Brian no never know nobody",
            "Jeremy why no nobody",
            "Jeremy nobody never know why nobody",
            "David never no nobody",
            "Alexia never never nobody no"
        };
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("no", "nobody", "never"));
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testEmptyPosts() {
        String[] posts = {};
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testSinglePost() {
        String[] posts = { "David singleword" };
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("singleword"));
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testLexicographicalSorting() {
        String[] posts = {
            "Alice apple banana cherry",
            "Bob banana cherry apple",
            "Charlie cherry banana apple"
        };
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testWordsWithSameFrequency() {
        String[] posts = {
            "User1 aaa bbb ccc",
            "User2 ccc aaa bbb",
            "User3 bbb aaa ccc"
        };
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc"));
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testNoCommonWords() {
        String[] posts = {
            "David apples oranges",
            "Alexia bananas grapes",
            "Parham mangoes pineapples"
        };
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testAllWordsUsedOnce() {
        String[] posts = {
            "Alice x",
            "Bob x",
            "Charlie x"
        };
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("x"));
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testRepeatedPostsBySameUser() {
        String[] posts = {
            "David hello hello hello",
            "Alexia hello hello hello",
            "Parham hello hello hello"
        };
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("hello"));
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testEmptyContentAfterUserName() {
        String[] posts = {
            "David",
            "Alexia",
            "Parham"
        };
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testDuplicateWordsAcrossUsers() {
        String[] posts = {
            "David duplicate duplicate",
            "Alexia duplicate duplicate",
            "Parham duplicate duplicate"
        };
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("duplicate"));
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }
}
