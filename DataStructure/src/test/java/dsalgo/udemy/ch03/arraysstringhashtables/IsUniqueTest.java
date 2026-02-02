package dsalgo.udemy.ch03.arraysstringhashtables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsUniqueTest {

    @Test
    public void isUniqueTest(){
        Assertions.assertTrue(IsUnique.isUnique("abcde"));
        Assertions.assertTrue(IsUnique.isUnique("aAbBcCdDeE"));
        Assertions.assertFalse(IsUnique.isUnique("abcded"));
    }
}
