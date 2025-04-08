package Testing;
//for all tests
import org.testng.annotations.*; // import all testng annotations instead of 1 by 1

public class BaseTests {

    /*@BeforeTest

Runs once before a <test> tag in testng.xml

Not tied to individual classes (less OOP-aligned)

✅ Good for one-time global setup

❌ Not ideal for per-class test logic like in your BaseTest
     */



    //runs before other test methods run in this class  + only once
    // it's good for shared databases, connection,test,data etc.
    @BeforeClass
    public void setupClass(){
        System.out.println(">> starting test class: " + this.getClass().getSimpleName());

    // runs AFTER all  all tets methods done  in this class    + only once
    }
    @AfterClass
    public void teardownClass(){
        System.out.println("--Finising test clas:" + this.getClass().getSimpleName());
    }


    // runs BEFORE each method - like @test methods
    //used for clearing after every individual test

    @BeforeMethod
    public void setupMethod(){
        System.out.println("--Starting test methood --");
    }

    // runs AFTER each method - like @test methods
    //used for clearing after every individual test

    @AfterMethod
    public void teardownMethod(){
        System.out.println("-- [AfterMethod] Teardown test method(s) --");  //used [] as a tag or label ,like headline for styling , !!! it is not a java syntax
    }
}
