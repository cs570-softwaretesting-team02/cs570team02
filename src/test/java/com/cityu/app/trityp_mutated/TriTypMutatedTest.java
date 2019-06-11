package com.cityu.app.trityp_mutated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TriTypMutatedTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inContent;
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    public void setOutputContent() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    private void setInputContent(String data) {
        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);
    }

    @Test
    public void testInput(){
        String expected = "Result is: isosceles";
        // String testData = "3" + System.lineSeparator() + "3" + System.lineSeparator() + "1";
        String testData = "3\n3\n1";
        setInputContent(testData);
        TriTypMutated.main(null);

        assertTrue(outContent.toString().contains(expected));
    }

    @Test
    public void testTriang_Isosceles(){
        int expected = 2; //isosceles
        int actual = TriTypMutated.triang(3, 3, 1);

        assertEquals(expected, actual);
    }
}