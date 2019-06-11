package com.cityu.app.cal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class CalTest {

    @Test
    // Cal-T01
    public void testCal_monthsAreEqual_ReturnsZero() {
        // expected output
        int expected = 0;

        // test data
        int month1 = 2;
        int day1 = 1;
        int month2 = 2;
        int day2 = 1;
        int year = 2019;
        int actual = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(expected, actual);
    }

    @Test
    // Cal-T02
    public void testCal_consecutiveMonths_NonleapYear_Returns28Days() {
        // expected output
        int expected = 28;

        // test data
        int month1 = 2;
        int day1 = 1;
        int month2 = 3;
        int day2 = 1;
        int year = 2019;
        int actual = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(expected, actual);
    }

    @Test
    // Cal-T03
    public void testCal_nonConsecutiveMonths_NonleapYear_Returns120Days() {
        // expected output
        int expected = 120;

        // test data
        int month1 = 2;
        int day1 = 1;
        int month2 = 6;
        int day2 = 1;
        int year = 2019;
        int actual = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(expected, actual);
    }

    @Test
    // Cal-T04
    public void testCal_consecutiveMonths_LeapYear_Returns29Days() {
        // expected output
        int expected = 29;

        // test data
        int month1 = 2;
        int day1 = 1;
        int month2 = 3;
        int day2 = 1;
        int year = 2020;
        int actual = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(expected, actual);
    }

    @Test
    // Cal-T05
    public void testCal_nonConsecutiveMonths_LeapYear_Returns121Days() {
        // expected output
        int expected = 121;

        // test data
        int month1 = 2;
        int day1 = 1;
        int month2 = 6;
        int day2 = 1;
        int year = 2020;
        int actual = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(expected, actual);
    }

    // @Test
    // //Fault
    // // Cal-T06
    // public void testCal_month1GreaterThanMonth2_ReturnsFaultCode() {
    //     // expected output
    //     int expected = -1;

    //     // test data
    //     int month1 = 2;
    //     int day1 = 1;
    //     int month2 = 1;
    //     int day2 = 1;
    //     int year = 2019;
    //     int actual = Cal.cal(month1, day1, month2, day2, year);

    //     assertEquals(expected, actual);
    // }

    // @Test
    // //Fault
    // // Cal-T07
    // public void testCal_negativeMonth1_ReturnsFaultCode() {
    //     // expected output
    //     int expected = -1;

    //     // test data
    //     int month1 = -2;
    //     int day1 = 1;
    //     int month2 = 3;
    //     int day2 = 1;
    //     int year = 2019;
    //     int actual = Cal.cal(month1, day1, month2, day2, year);

    //     assertEquals(expected, actual);
    // }

    // @Test
    // //Fault
    // // Cal-T08
    // public void testCal_negativeDay1_ReturnsFaultCode() {
    //     // expected output
    //     int expected = -1;

    //     // test data
    //     int month1 = 2;
    //     int day1 = -1;
    //     int month2 = 3;
    //     int day2 = 1;
    //     int year = 2019;
    //     int actual = Cal.cal(month1, day1, month2, day2, year);

    //     assertEquals(expected, actual);
    // }

    // @Test
    // //Fault
    // // Cal-T09
    // public void testCal_negativeMonth2_ReturnsFaultCode() {
    //     // expected output
    //     int expected = -1;

    //     // test data
    //     int month1 = 2;
    //     int day1 = 1;
    //     int month2 = -3;
    //     int day2 = 1;
    //     int year = 2019;
    //     int actual = Cal.cal(month1, day1, month2, day2, year);

    //     assertEquals(expected, actual);
    // }

    // @Test
    // //Fault
    // // Cal-T10
    // public void testCal_negativeDay2_ReturnsFaultCode() {
    //     // expected output
    //     int expected = -1;

    //     // test data
    //     int month1 = 2;
    //     int day1 = 1;
    //     int month2 = 3;
    //     int day2 = -1;
    //     int year = 2019;
    //     int actual = Cal.cal(month1, day1, month2, day2, year);

    //     assertEquals(expected, actual);
    // }

    // @Test
    // //Fault
    // // Cal-T11
    // public void testCal_invalidMonth1_ReturnsFaultCode() {
    //     // expected output
    //     int expected = -1;

    //     // test data
    //     int month1 = 20;
    //     int day1 = 1;
    //     int month2 = 3;
    //     int day2 = 1;
    //     int year = 2019;
    //     int actual = Cal.cal(month1, day1, month2, day2, year);

    //     assertEquals(expected, actual);
    // }

    // @Test
    // //Fault
    // // Cal-T12
    // public void testCal_invalidDay1_ReturnsFaultCode() {
    //     // expected output
    //     int expected = -1;

    //     // test data
    //     int month1 = 2;
    //     int day1 = 40;
    //     int month2 = 3;
    //     int day2 = 1;
    //     int year = 2019;
    //     int actual = Cal.cal(month1, day1, month2, day2, year);

    //     assertEquals(expected, actual);
    // }

    // @Test
    // //Fault
    // // Cal-T13
    // public void testCal_invalidMonth2_ReturnsFaultCode() {
    //     // expected output
    //     int expected = -1;

    //     // test data
    //     int month1 = 2;
    //     int day1 = 1;
    //     int month2 = 30;
    //     int day2 = 1;
    //     int year = 2019;
    //     int actual = Cal.cal(month1, day1, month2, day2, year);

    //     assertEquals(expected, actual);
    // }

    // @Test
    // //Fault
    // // Cal-T14
    // public void testCal_invalidDay2_ReturnsFaultCode() {
    //     // expected output
    //     int expected = -1;

    //     // test data
    //     int month1 = 2;
    //     int day1 = 1;
    //     int month2 = 3;
    //     int day2 = 40;
    //     int year = 2019;
    //     int actual = Cal.cal(month1, day1, month2, day2, year);

    //     assertEquals(expected, actual);
    // }
}
