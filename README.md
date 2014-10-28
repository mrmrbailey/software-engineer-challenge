#Tesco Software Engineer Challenge

This project is my steps through the Tesco Software Engineer Challenge, and this readme is documenting that challenge and the steps taken.

##Step 0

    Software Engineer Challenge

    **Try not to read ahead**

    ***Do one task at a time***

    Make sure you only test for correct inputs. There is no need to test for invalid inputs for this kata

    String Calculator

* Used netbeans to create a new maven project, and created a new unit test in the default package ready to go.

##Step 1 - Start with the simplest test case of an empty string

    1.	Create a simple String calculator with a method int Add(string numbers)
        1.	The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0) for example “” or “1” or “1,2”
        2.	Start with the simplest test case of an empty string and move to 1 and two numbers
        3.	Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
        4.	Remember to refactor after each passing test

* Move empty test to StringCalculatorTest in com.tesco.challenge
* Wrote a test testAddEmptyString which creates a new StringCalculator and asserts that Add("") returns 0;
* Made test compile by creating new class StringCalculator with an public int Add(numbers) which always returns 0;
