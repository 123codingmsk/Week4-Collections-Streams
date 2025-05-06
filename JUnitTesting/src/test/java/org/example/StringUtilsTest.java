package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    StringUtils str = new StringUtils();

    @Test
    public void testReverse(){
        assertEquals("jonam", str.reverse("manoj"));
    }

    @Test
    public void testPalindrome(){
        assertEquals(true, str.isPalindrome("bob"));
    }

    @Test
    public void testUppercase(){
        assertEquals("MANOJ", str.toUpperCase("manoj"));
    }
}