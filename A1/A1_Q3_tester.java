import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;

public class A1_Q3_tester {
    @Test
    public void testCase1() {
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
    public void testCase2() {
        String[] posts = {
            "Villain avast",
            "Scoundrel ahoy"
        };
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testCase3() {
        String[] posts = {
            "user1 chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp",
            "user2 chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp",
            "user3 chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp",
            "user1 chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp"
        };
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("chomp"));
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testCase5() {
        String[] posts = {
            "user1 doubledutch double double dutch",
            "user2 dutch doubledutch doubledutch double",
            "user3 not double dutch doubledutch"
        };
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("double", "doubledutch", "dutch"));
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }

    @Test
    public void testCase6() {
        String[] posts = {
            "James gobble de gook",
            "Bill gobble",
            "james de gook"
        };
        ArrayList<String> expected = new ArrayList<>();
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
    public void testLexicographicalSortingChallenge() {
        String[] posts = {
            "Alice abdomen agency apple",
            "Bob balance agency abdomen",
            "Charlie apple abdomen agendcy"
        };
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("abdomen", "agency", "apple"));
        assertEquals(expected, A1_Q3.Discussion_Board(posts));
    }
}
