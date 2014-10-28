/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesco.challenge;

/**
 * A simple String Calculator.
 */
public class StringCalculator {

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
        NumberParser parser = new NumberParser();

        int sum = 0;
        for (Integer number : parser.getNumbers(input)) {
            if (isNegativeNumber(number)) {
                throw new IllegalArgumentException("Negative numbers not allowed. Input contains: " + number);
            }
            sum += number;
        }
        return sum;
    }

    private boolean isNegativeNumber(Integer number) {
        return number < 0;
    }
}
