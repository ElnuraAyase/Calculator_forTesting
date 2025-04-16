package testing;

import calc.BasicOperations;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTests extends BaseTests{
    BasicOperations calc = new BasicOperations();

    // Provides multiple sets of  inputs
    @DataProvider(name = "multiplyData")
    public Object [] [] dataProviderExample() {
        /* [] [] used 4 2D array ,
         SO : if Object [] = 1 set of test values , if Object [] [] = a list of test sets (tavle)
        each row = one set of test data ,
        each column = a parameter passed to the test method
        a	b	expected
        2	3	6
        4	5	20
        1	0	0

         */
        return new Object[][]{
                {2, 3, 6},
                {4, 5, 20},
                {1, 0, 0}
        };

    }

    // uses the data provider

    @Test(dataProvider = "multiplyData", groups = {"data-driven"})
    public void  testMultiplication(double a, int b, double expected){
        double result = calc.multiply(a, b);
        System.out.println(" Multiplication: " + a + " * " + b+ "=" + result);
        Assert.assertEquals(result, expected);
    }
}
