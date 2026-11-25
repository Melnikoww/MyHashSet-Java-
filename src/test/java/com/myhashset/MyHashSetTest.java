package com.myhashset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MyHashSetTest {

    private MyHashSet<Integer> mySet;


    @Before
    public void setUp() {
        mySet = new MyHashSet<>();
    }


    @Test
    public void whenAddElementIntoSet() {
        mySet.add(10);
        mySet.add(20);
        mySet.add(30);

        assertEquals(3, mySet.getSize());
        assertTrue(mySet.contains(10));
        assertTrue(mySet.contains(20));
        assertTrue(mySet.contains(30));
    }

    @Test
    public void whenAddDuplicateElementIntoSet() {
        mySet.add(10);
        mySet.add(20);
        mySet.add(30);
        boolean addedDuplicate = mySet.add(10); 

        assertEquals(3, mySet.getSize());        
        assertTrue(addedDuplicate == false);      
        assertTrue(mySet.contains(10));           
        assertTrue(mySet.contains(20));
        assertTrue(mySet.contains(30));
    }


    @Test
    public void getSizeTest() {
        mySet.add(2020);
        mySet.add(20121);

        assertEquals(2, mySet.getSize());
    }

    @Test
    public void whenSetHave5ElementsThenClear() {
        mySet.add(-100);
        mySet.add(0);
        mySet.add(17);
        mySet.add(1000);
        mySet.add(-12129);

        mySet.clear();

        assertEquals(0, mySet.getSize());
        assertTrue(mySet.isEmpty());
        assertFalse(mySet.contains(1000));

        mySet.add(5);
        assertEquals(1, mySet.getSize());
        assertTrue(mySet.contains(5));
    }

        @Test
    public void whenRemoveExistingElementThenReturnsTrue() {
        mySet.add(10);
        mySet.add(20);

        assertTrue(mySet.remove(10));
        assertEquals(1, mySet.getSize());
        assertFalse(mySet.contains(10));
        assertTrue(mySet.contains(20));
    }

    @Test
    public void whenRemoveNonExistingElementThenReturnsFalse() {
        mySet.add(10);

        assertFalse(mySet.remove(99));
        assertEquals(1, mySet.getSize());
    }

    @Test
    public void whenRemoveFromEmptySetThenReturnsFalse() {
        assertFalse(mySet.remove(10));
    }

    @Test
    public void whenRemoveLastRemainingElementThenSetIsEmpty() {
        mySet.add(10);

        assertTrue(mySet.remove(10));
        assertTrue(mySet.isEmpty());
    }

    @Test
    public void whenResizeHappensThenAllElementsRemain() {
        for (int i = 0; i < 50; i++) {   // 50 > 16 * 0.75  resize сработает
            assertTrue(mySet.add(i));
        }
        assertEquals(50, mySet.getSize());

        assertTrue(mySet.remove(25));
        assertEquals(49, mySet.getSize());
        assertFalse(mySet.contains(25));
        assertTrue(mySet.contains(0));    // ранние элементы живы после resize
        assertTrue(mySet.contains(49));   // и поздние тоже
    }


    @Test
    public void whenValue10ContainsInTheSetThenReturnsTrue() {
        mySet.add(10);
        mySet.add(20);

        assertEquals(2, mySet.getSize());
        assertTrue(mySet.contains(20));
    }

    @Test
    public void whenValueNotContainsInTheSetThenReturnsFalse() {
        mySet.add(10);
        mySet.add(20);

        assertEquals(2, mySet.getSize());
        assertFalse(mySet.contains(30));
    }

    @Test
    public void whenSetIsEmptyReturnsTrue() {
        assertTrue(mySet.isEmpty());
    }

    @Test
    public void whenSetIsNotEmptyReturnsFalse() {
        mySet.add(10);

        assertFalse(mySet.isEmpty());
    }

    @Test
    public void SetToArray_Test() {
        mySet.add(0);
        mySet.add(10);
        mySet.add(-1021);
        mySet.add(1000);

        Object[] array = mySet.toArray();
        assertEquals(4, array.length);

        assertTrue(containsElement(array, 0));
        assertTrue(containsElement(array, 10));
        assertTrue(containsElement(array, -1021));
        assertTrue(containsElement(array, 1000));
        
    }

    private static boolean containsElement(Object[] array, int value) {
        for(Object o : array){
            if (o instanceof Integer && (Integer) o == value){
                return true;
            }
        }

        return false;
    }


}
