package zadTestNg;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Zad_3 {

   int result = 0;

    @Test
    public void addNumber(){
        result += 7;
            }

            @Test(dependsOnMethods = "addNumber")
    public void checkResult(){
                Assert.assertEquals(result,7);
            }
}
