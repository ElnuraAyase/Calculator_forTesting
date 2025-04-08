package Testing;

import calc.BasicOperations;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdditionTests extends BaseTests{

    BasicOperations calc = new BasicOperations();

    //PRiority and Group
    @Test(priority = 1, groups = {"int", "basic"})
    public void testAddIntegers(){
        double result = calc.add(2,3);
        System.out.println( " Integer Addition: 2 + 3 = " + result );
        Assert.assertEquals(result, 5.0);
    }

    //another priority
    @Test(priority = 2, groups = {"double", "basic"})
    public void testAddDoubles(){
        double result = calc.add(2, 3.3);
        System.out.println(" Double Addition: 2+ 3.3= " + result);
        Assert.assertEquals(result, 5.3);
    }
}
