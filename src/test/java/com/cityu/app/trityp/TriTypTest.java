package com.cityu.app.trityp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TriTypTest {
    @Test
    public void testNegativeSide() {
        int expected = 4;
        int actual = TriTyp.triang(-1, 1, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllZeros() {
        int expected = 4;
        int actual = TriTyp.triang(0, 0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSide1eqSide2() {
        int expected = 2;
        int actual = TriTyp.triang(2, 2, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testSide1eqSide3() {
        int expected = 2;
        int actual = TriTyp.triang(2, 3, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSide2eqSide3() {
        int expected = 2;
        int actual = TriTyp.triang(3, 2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testNoEqSidesWhileInvalid() {
        int expected = 4;
        int actual = TriTyp.triang(2, 3, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void testNoEqSides() {
        int expected = 1;
        int actual = TriTyp.triang(2, 3, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void testNotATri() {
        int expected = 4;
        int actual = TriTyp.triang(2, 2, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllEqual() {
        int expected = 3;
        int actual = TriTyp.triang(2, 2, 2);
        assertEquals(expected, actual);
    }
}