package Testing;

import calc.BasicOperations;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParameterizedAddition extends BaseTests {

    BasicOperations calc = new BasicOperations();

    // Accepts parameters, and if they are not passed, default values will be used
    @Test
    @Parameters({"a", "b"})
    public void testAddWithParameters(@Optional("10") String a, @Optional("5") String b) {
        // Convert parameters to doubles
        double valA = Double.parseDouble(a);
        double valB = Double.parseDouble(b);

        // Perform the addition
        double result = calc.add(valA, valB);

        // Print result for debugging
        System.out.println("Parameters from XML: " + valA + " + " + valB + " = " + result);

        // Assert that the result is greater than 0
        Assert.assertTrue(result > 0, "Sum is not greater than zero. Got: " + result);
    }
}

