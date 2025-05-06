package testing;

import calc.BasicOperations;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdditionTests extends BaseTests{

    BasicOperations calc = new BasicOperations();

    //PRiority and Group
    @Test(priority = 1, groups = {"int", "basic"})
    public void testAddIntegers(){
        double result = calc.add((double)2.0F,(double)3.0F);
        System.out.println( " Integer Addition: 2 + 3 = " + result );
        Assert.assertEquals(result, 5.0, "Addition of 2.0 and 3.0 should return 5.0");
    }

    //another priority
    @Test(priority = 2, groups = {"double", "basic"})
    public void testAddDoubles(){
        double result = calc.add(2, 3.3);
        System.out.println(" Double Addition: 2+ 3.3= " + result);
        Assert.assertEquals(result, 5.3, "Addition of 2.0 and 3.0 should return 5.3");
    }
}
