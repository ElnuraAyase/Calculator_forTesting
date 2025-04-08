package Testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTests extends BaseTests{

    // this tests FAILS on purpose

    @Test(priority = 1)
    public void  testXFails(){
        System.out.println("This test is created to fail");
        Assert.fail("Successffuly failed");
    }

    // this test is SKIPPEd as it depends on the failed test
    @Test(priority = 2, dependsOnMethods = {"testXFails"}, alwaysRun = true)
    public void testAlwaysRuns(){
        System.out.println(" This tet always runs ,even if the dependency fails");
    }
}
