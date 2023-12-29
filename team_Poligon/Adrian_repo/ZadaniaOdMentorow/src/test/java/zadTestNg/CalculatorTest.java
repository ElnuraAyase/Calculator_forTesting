package zadTestNg;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    public Calculator calculator;

    @BeforeClass(alwaysRun = true)
    void setUp() {
        calculator = new Calculator();
    }


    @Test(groups = {"Addition"})
    void test1() {
        int sumTest = calculator.sum(2, 2);
        Assert.assertEquals(sumTest, 4);
        System.out.println("Result 2 + 2 = " + sumTest);
    }

    @Test(groups = {"Subtraction"})
    void test2() {
        int subtractTest = calculator.subtract(10, 8);
        Assert.assertEquals(subtractTest, 2);
        System.out.println("Result 10 - 8 = " + subtractTest);
    }

    @Test(groups = {"Multiplication"})
    void test3() {
        int multiplyTest = calculator.multiply(2, 2);
        Assert.assertEquals(multiplyTest, 4);
        System.out.println("Result 2 * 2 = " + multiplyTest);
    }

    @Test(groups = {"Division"})
    void test4() {
        double divideTest = calculator.divide(12, 3);
        Assert.assertEquals(divideTest, 4);
        System.out.println("Result 12 / 3 = " + divideTest);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,groups = {"Division"})
    void test5() {
        double divideTestByZero = calculator.divide(12, 0);


    }

    @Test(groups = {"Division"})
    void test6() {
        double divideTest = calculator.divide(2, 12);
        double expectedResult = 0.16666667 ;
        double epsilon = 0.000001;
        Assert.assertEquals(divideTest,expectedResult,epsilon);
        System.out.println("Result 2 / 12 = " + divideTest);

    }
@Test(groups = {"Addition"})
    void test7(){
        int sumTest2 = calculator.sum(56,2);
        Assert.assertEquals(sumTest2,58);
    System.out.println("Result 56 + 2 = " + sumTest2);

}
@Test(groups = {"Subtraction"})
    void test8(){
        int subtractTest2 = calculator.subtract(56,16);
        Assert.assertEquals(subtractTest2,40);
    System.out.println("Result 56 - 16 = " + subtractTest2);
}
}
