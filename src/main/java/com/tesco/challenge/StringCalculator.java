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
     * @param numbers either "", a single number or a comma separated pair of numbers.
     * @return the sum of the delimited numbers or if the empty string is passed 0.
     */
    public int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains(",")) {
            String[] bothNumbers = numbers.split(",");
            return getInt(bothNumbers[0]) + getInt(bothNumbers[1]);
        } else {
            return getInt(numbers);
        }
    }

    private int getInt(String number) {
        return Integer.parseInt(number);
    }
}
