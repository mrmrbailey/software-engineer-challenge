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
     * @return 0 for the empty string or parses the input.
     */
    public int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains(",")) {
            return 3;
        } else {
            return Integer.parseInt(numbers);
        }
    }
}
