import org.testng.annotations.*;

public class TC1 {



    @BeforeMethod
    void beforeMethod(){
        System.out.println("Run before test methode");


    }
    @Test
    void test1() {
        System.out.println("Test 1 run");

    }

    @Test
    void test2(){
        System.out.println("Test 2 run");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("After test methode");
    }


@BeforeTest
        void beforeTest(){
    System.out.println("Before test");
}
@AfterTest
    void afterTest(){
    System.out.println("After test");
}
}
