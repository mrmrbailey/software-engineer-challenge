/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesco.challenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple String Calculator.
 */
public class StringCalculator {

    private static final String DEFAULT_DELIMITER = "[,\\n]";
    private static final String CUSTOM_DELIMITER_PATTERN = "^//(.)\\n(.*)$";
    private static final int CUSTOM_DELIMITER_DELIMITER_GROUP = 1;
    private static final int CUSTOM_DELIMITER_NUMBERS_GROUP = 2;

    /**
     * Calculates a sum of a delimited string of numbers.
     * <p>
     * @param input either "" or a delimited set of numbers.
     * @return 0 or the sum of the delimited numbers.
     */
    public int Add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] allNumbers = tokenise(input);

        int sum = 0;
        for (String number : allNumbers) {
            sum += getInt(number);
        }
        return sum;
    }

    private int getInt(String number) {
        return Integer.parseInt(number);
    }

    private String[] tokenise(String input) {
        String delimiter = DEFAULT_DELIMITER;
        String numbers = input;
        if (input.startsWith("//")) {
            Matcher delimiterMatcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
            if (!delimiterMatcher.matches()) {
                throw new IllegalArgumentException("Unable to parse input: " + input);
            }
            delimiter = delimiterMatcher.group(CUSTOM_DELIMITER_DELIMITER_GROUP);
            numbers = delimiterMatcher.group(CUSTOM_DELIMITER_NUMBERS_GROUP);
        }
        return numbers.split(delimiter);
    }
}
