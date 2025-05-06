package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {
    ListManager manager = new ListManager();
    List<Integer> list = new ArrayList<>();

    @Test
    public void testAddElement(){
        manager.addElement(list, 5);
        assertTrue(list.contains(5));
    }

    @Test
    public void testRemoveElement(){
        list.add(10);
        manager.removeElement(list, 10);
        assertFalse(list.contains(10));
    }

    @Test
    public void testSize(){
        assertEquals(list.size(), manager.getSize(list));
    }
}