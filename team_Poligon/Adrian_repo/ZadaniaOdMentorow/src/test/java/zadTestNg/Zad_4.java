package zadTestNg;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Zad_4 {


    @Parameters({"enterNumber_1"})
    @Test
    void testEven1(int enterNumber_1) {
        boolean isEven = enterNumber_1 % 2 == 0;
        Assert.assertTrue(isEven, "Number is not even");
        System.out.println("Enter number is: " + enterNumber_1);
    }

    @Parameters({"enterNumber_2"})
    @Test
    void testEven2(int enterNumber_2) {
        boolean isEven = enterNumber_2 % 2 == 0;
        System.out.println("Enter number is: " + enterNumber_2);
        Assert.assertTrue(isEven, "Number is not even");

    }

    @Parameters({"enterNumber_3"})
    @Test
    void testEven3(int enterNumber_3) {
        boolean isEven = enterNumber_3 % 2 == 0;
        Assert.assertTrue(isEven, "Number is not even");
        System.out.println("Enter nnumber is: " + enterNumber_3);

    }
}
