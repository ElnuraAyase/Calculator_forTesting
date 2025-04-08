package Testing;//importing test classes for asssertation and annotATIONs

import calc.BasicOperations;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CalculatorTest_it extends BaseTests {
    BasicOperations basicCalc = new BasicOperations();
// Happy path test : for add method to check if it returns what is expected

    @Test               // @Test is the annotation that marks a method as a test case.

    public void  testAdd_HappyPath() { //for call method
    double result = basicCalc.add(2, 3);
    Assert.assertEquals(result, 5);  // Assert gives you methods like assertEquals() to check test result
    }

    // negative path test: invalid input
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAdd_InvalidInput(){
        // assuming that the add method has illegal argument exception
        basicCalc.add(Double.NaN, 3);
    }
}
