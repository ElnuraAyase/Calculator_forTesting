package testing;

import calc.BasicOperations;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParameterizedAddition extends BaseTests {

    BasicOperations calc = new BasicOperations();

    @Test
    @Parameters({"a", "b"})
    public void testAddWithParameters(String a, String b) {
        // Convert  to doubles
        double valA = Double.parseDouble(a);
        double valB = Double.parseDouble(b);


        double result = calc.add(valA, valB);


        System.out.println("Parameters from XML: " + valA + " + " + valB + " = " + result);

        //  greater than 0
        Assert.assertTrue(result > 0, "Sum is not greater than zero. Got: " + result);
    }
}

