package testing;
//for all tests
import org.testng.annotations.*; // import all testng annotations instead of 1 by 1

public class BaseTests {

    @BeforeClass
    public void setupClass(){
        System.out.println(">> starting test class: " + this.getClass().getSimpleName());

    }
    @AfterClass
    public void teardownClass(){
        System.out.println("--Finising test clas:" + this.getClass().getSimpleName());
    }



    @BeforeMethod
    public void setupMethod(){
        System.out.println("--Starting test methood --");
    }


    @AfterMethod
    public void teardownMethod(){
        System.out.println("-- Teardown test method--");
    }
}
