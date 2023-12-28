import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC2 {



    @BeforeMethod
    void beforeMethod(){
        System.out.println("Run before test");


    }
    @Test
    void test3() {
        System.out.println("Test 3 run");

    }

    @Test
    void test4(){
        System.out.println("Test 4 run");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("end");
    }

}
