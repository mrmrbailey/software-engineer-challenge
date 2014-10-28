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

        StringBuilder negativeNumbersErrorMessage = new StringBuilder();
        int sum = 0;
        for (Integer number : parser.getNumbers(input)) {
            if (isNegativeNumber(number)) {
                if (negativeNumbersErrorMessage.length() == 0) {
                    negativeNumbersErrorMessage.append("Negative numbers not allowed. Input contains: ");
                }
                negativeNumbersErrorMessage.append(number);
                negativeNumbersErrorMessage.append(", ");
            }
            sum += number;
        }
        if (negativeNumbersErrorMessage.length() != 0) {
            negativeNumbersErrorMessage.setLength(negativeNumbersErrorMessage.length() - 2);
            throw new IllegalArgumentException(negativeNumbersErrorMessage.toString());
        }
        return sum;
    }

    private boolean isNegativeNumber(Integer number) {
        return number < 0;
    }
}
