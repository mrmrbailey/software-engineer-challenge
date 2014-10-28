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

##Step 1 - and move to 1 [number]

* Add test testAddOneNumber() - Tests that adding one number returns that number.
* Fixed failing test

##Step 1 - and two numbers

* Added test testAddTwoNumbers - Tests that passing 2 numbers returns their sum.
* Realised I am going to be creating a new instance in every test so pulled that into a @before setup
* Refactored code to test for existance of a "," and returned 3 if it existed

##Step 1 - and two numbers again

* Clearly the above code is suspect so added a test to fail Added test testAddTwoNumbers1and3 - Tests that passing 2 numbers returns their sum.
* Refactored code to split the numbers if a "," is in the input.
* Looking at Add we now have 3 Integer.ParseInt(String) is going to be popular so pulled that out to a getInt(String).

##Step 1 Finished

* Looking at my tests does 1,2 really differ from 1,3. A more important test is two numbers the same. so refactored test deleted 1,3 and added test 2,2
* All tests passed so no need to refactor class.

##Step 2

    2.	Allow the Add method to handle an unknown amount of numbers

* Added test testAddThreeNumbers - Tests that passing 3 numbers returns their sum. that validates "1,2,3" returns 6.
* Fixed failing test by amending "getInt(bothNumbers[0]) + getInt(bothNumbers[1]);" to iterate the array adding to a total.
* Refactored now that the numbers.contains(",") is now redundant.
* Considered adding a test for 3 numbers the same but feel that it is not required.
* Feeling a bit worried that the input isn't being validated at all but continuing none the less, a NumberFormatException will protect us for now.

##Step 3 [Handle New Line Delimiter]

    3.	Allow the Add method to handle new lines between numbers (instead of commas).
        1.	the following input is ok:  “1\n2,3”  (will equal 6)
        2.	the following input is NOT ok:  “1,\n” (not need to prove it - just clarifying)

* Before adding test for newline delimited created a new test, exactly the same as testAddTwoDifferentNumbers called testAddTwoCommaDelimitedNumbers - Tests that passing 2 numbers comma delimited returns their sum.
* Test passed obviously.
* Debated deleting either add 2 numbers or add 3 numbers but left them alone for now. I will keep an eye on their value going forward.
* Added test testAddTwoNumbersOnNewLines - Tests that passing 2 numbers new line delimited returns their sum. that validates "1\n2" returns 3
* refactored code slightly to split on [,\\n] rather than ",".

##Step 3 [Handle Mixed New Line Delimiter]

* Renamed test testAddThreeNumbers to testAddMultipleDelimiters - Tests that passing numbers with a , and a new line returns their sum. that validates  "1,2\n3" returns 6.
* Test passed without refactoring.

##Step 4

    4.	Support different delimiters
        1.	to change a delimiter, the beginning of the string will contain a separate line that looks like this:   “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
        2.	the first line is optional. all existing scenarios should still be supported

* Add test testAddNumbersWithCustomDelimiter - Tests that numbers separated with with a custom delimiter returns their sum. that validates “//;\n1;2” returns 3;
* Simple refactoring to test for custom delimiter pattern. Only returns 3 to pass the test.

##Step 4 [Add parsing]

* Add test for testAdd3NumbersWithCustomDelimiter - Tests that 3 numbers separated with with a custom delimiter returns their sum. that validates "//:\n1;2;3" returns 6;
* The purpose of this test is to validate refactoring, I expect it will survive refactoring.
* Refactored code to create a tokeniser which will parse the input.

##Step 5

    5.	Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.if there are multiple negatives, show all of them in the exception message

* Looking at this new requirement I don't think a String array is now the best thing. So this is a good chance to take stock and reevalulate.
  * It seems that we have two things going on here, a Adder and Parser. Maybe it was a mistake to assume this was a calculator.
  * Decided to leave tests for now and refactor
  * Moving the tokeniser block to a new NumberParser which will parse the input into a List<Integer> and refactor existing tests to handle this.
* First things first lets refactor and keep the String[]
* Moved tokenise to new class NumberParser and added a String[] getNumbers(input).
* All tests still pass on the StringCalculator.
* Copied tests from StringCalculator to NumberParser refactoring as I go to have both classes covered correctly.
* Used tests in StringCalculator as basis for new tests in NumberParser.
* Deleted tests in the StringCalculatorTest and only test for "", one number, which isn't really a special case but still feels right, 2 different numbers and 2 the same.

##Step 5 [Move from String[] to List<Integer>]

* Refactored NumberParser tests to expect a List<Integer>
* Refactored code to reflect this.

##Step 5 [Test for negative numbers.]

* Added testParseNegativeNumbers to NumberParserTest - Tests that negative numbers parse correctly.
* Test passes so continue.
* Add testNegativeNumber to StringCalculatorTest Tests that passing a negative number throws an IllegalArgumentException.
* Refactor code to throw an exception for a negative number.

##Step 5 [Multiple negative numbers]

* Added testNegativeNumberErrorMessage2Numbers - Tests that the negative number appears in the exception message.
* Added Error Message builder. Not currently happy with the error message formation feel there is a better way to handle this, but in this instance it is passable.

##Step 6

    6.	Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2

* Added testBigNumberIsIgnored - Test that when passing a big number that number is ignored. that validates that 1001 is ignored.
* Added isNumberValid.
* Still not happy with the error messaging, but no reason to change.
* Added testBiggestNumberIsAdded - Test that when passing the biggest number allowed that number is added.

##Step 7

    7.	Delimiters can be of any length with the following format:  “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6

* Added testParseCustomDelimiter2Chars - Tests that numbers separated with a custom delimiter parses correctly. that validates "//[**]\n1**2".
* During refactoring noticed error with String.split on a ** so renamed that testParseCustomDelimiter2SpecialChars - Tests that numbers separated with a custom delimiter containing special characters parses correctly.
* Recreated testParseCustomDelimiter2Chars - Tests that numbers separated with a custom delimiter parses correctly. that validates "//[;;]\n1;;2".
* Amended regex and refactored to create a parseNumber method.

##Step 7 [Special Chars]

* Uncommented out testParseCustomDelimiter2SpecialChars
* Refactored code to replace any delimiter with a default one.

##Step 8

    8.	Allow multiple delimiters like this:  “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.

* Added test testParseMultipleCustomDelimiters -  Tests that numbers separated with a multiple custom delimiters parses correctly. validates "//[*][%]\\n1*2%3"
* Refactored parseNumbers to iterate through each delimiter.

