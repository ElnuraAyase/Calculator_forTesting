import org.testng.annotations.Test;

public class SecondTestCase {

    @Test(priority = 1)
    void  setUp(){
        System.out.println("This is set up");

    }
    @Test(priority = 3)
    void searchCustomer(){
        System.out.println("Search Customer test");

    }
    @Test(priority = 2)
    void addCustomer() {
        System.out.println("Add customer test");
    }
    @Test(priority = 4)
    void tearDown(){
        System.out.println("Close ");
    }
}
