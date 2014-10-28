package com.tesco.challenge;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hamcrest.core.StringContains;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * A Test for the simple String Calculator.
 */
public class StringCalculatorTest {

    private static final Logger logger = Logger.getLogger(StringCalculatorTest.class.getName());

    private StringCalculator instance;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void createCalculator() {
        instance = new StringCalculator();
    }

    /**
     * Tests that passing an empty string returns 0.
     */
    @Test
    public void testAddEmptyString() {
        logger.log(Level.FINER, "testAddEmptyStringZero");

        String numbers = "";
        int expResult = 0;

        int result = instance.Add(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that passing one number returns that number.
     */
    @Test
    public void testAddOneNumber() {
        logger.log(Level.FINER, "testAddOneNumber");

        String numbers = "1";
        int expResult = 1;

        int result = instance.Add(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that passing 2 numbers returns their sum.
     */
    @Test
    public void testAddTwoDifferentNumbers() {
        logger.log(Level.FINER, "testAddTwoDifferentNumbers");

        String numbers = "1,2";
        int expResult = 3;

        int result = instance.Add(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that passing 2 numbers the same returns their sum.
     */
    @Test
    public void testAddTwoNumbersTheSame() {
        logger.log(Level.FINER, "testAddTwoNumbersTheSame");

        String numbers = "2,2";
        int expResult = 4;

        int result = instance.Add(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that passing a negative number throws an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumber() {
        logger.log(Level.FINER, "testNegativeNumber");

        String numbers = "-1";
        instance.Add(numbers);
    }

    /**
     * Tests that the negative number appears in the exception message.
     */
    @Test
    public void testNegativeNumberErrorMessage() {
        logger.log(Level.FINER, "testNegativeNumberErrorMessage");

        String numbers = "-1";

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(StringContains.containsString("-1"));

        instance.Add(numbers);
    }
}
