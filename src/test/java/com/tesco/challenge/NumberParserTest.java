/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesco.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A Test for the simple Number Parser.
 */
public class NumberParserTest {

    private static final Logger logger = Logger.getLogger(NumberParserTest.class.getName());

    private NumberParser instance;

    @Before
    public void createNumberParser() {
        instance = new NumberParser();
    }

    /**
     * Tests that passing one number returns that number.
     */
    @Test
    public void testParseOneNumber() {
        logger.log(Level.FINER, "testParseOneNumber");

        String numbers = "1";
        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);

        List<Integer> result = instance.getNumbers(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that passing comma delimited parses correctly.
     */
    @Test
    public void testParseCommaDelimitedNumbers() {
        logger.log(Level.FINER, "testParseCommaDelimitedNumbers");

        String numbers = "1,2";
        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(2);

        List<Integer> result = instance.getNumbers(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that passing numbers new line delimited parses correctly.
     */
    @Test
    public void testParseNumbersOnNewLines() {
        logger.log(Level.FINER, "testParseNumbersOnNewLines");

        String numbers = "1\n2";
        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(2);

        List<Integer> result = instance.getNumbers(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that passing numbers with a , and a new line parses correctly.
     */
    @Test
    public void testParseMultipleDelimiters() {
        logger.log(Level.FINER, "testParseMultipleDelimiters");

        String numbers = "1,2\n3";
        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(2);
        expResult.add(3);

        List<Integer> result = instance.getNumbers(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that numbers separated with a custom delimiter parses correctly.
     */
    @Test
    public void testParseCustomDelimiter() {
        logger.log(Level.FINER, "testParseCustomDelimiter");

        String numbers = "//;\n1;2;3";
        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(2);
        expResult.add(3);

        List<Integer> result = instance.getNumbers(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that numbers separated with a custom delimiter parses correctly.
     */
    @Test
    public void testParseCustomDelimiter2Chars() {
        logger.log(Level.FINER, "testParseCustomDelimiter2Chars");

        String numbers = "//[;;]\n1;;2";
        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(2);

        List<Integer> result = instance.getNumbers(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that numbers separated with a custom delimiter containing special characters parses correctly.
     */
    @Test
    public void testParseCustomDelimiter2SpecialChars() {
        logger.log(Level.FINER, "testParseCustomDelimiter2SpecialChars");

        String numbers = "//[**]\n1**2";
        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(2);

        List<Integer> result = instance.getNumbers(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that numbers separated with a multiple custom delimiters parses correctly.
     */
    @Test
    public void testParseMultipleCustomDelimiters() {
        logger.log(Level.FINER, "testParseMultipleCustomDelimiters");

        String numbers = "//[*][%]\n1*2%3";
        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(2);
        expResult.add(3);

        List<Integer> result = instance.getNumbers(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that numbers separated with a multiple custom delimiters of 2 characters parses correctly.
     */
    @Test
    public void testParseMultipleCustomDelimiters2Chars() {
        logger.log(Level.FINER, "testParseMultipleCustomDelimiters");

        String numbers = "//[**][%;]\n1**2%;3";
        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(2);
        expResult.add(3);

        List<Integer> result = instance.getNumbers(numbers);

        assertEquals(expResult, result);
    }

    /**
     * Tests that negative numbers parse correctly.
     */
    @Test
    public void testParseNegativeNumbers() {
        logger.log(Level.FINER, "testParseNegativeNumbers");

        String numbers = "-1,2";
        List<Integer> expResult = new ArrayList<>();
        expResult.add(-1);
        expResult.add(2);

        List<Integer> result = instance.getNumbers(numbers);

        assertEquals(expResult, result);
    }
}
