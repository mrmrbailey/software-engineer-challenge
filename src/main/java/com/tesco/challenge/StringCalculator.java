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
        String[] allNumbers = parser.getNumbers(input);

        int sum = 0;
        for (String number : allNumbers) {
            sum += getInt(number);
        }
        return sum;
    }

    private int getInt(String number) {
        return Integer.parseInt(number);
    }
}
