package rekindle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * CustomerTest class for testing customer-related endpoints
 */
public class CustomerTest extends BaseTest {

    // Override setup for specific base URI for this test class
    @BeforeClass
    public void setUp() {
        // Set up custom base URI for Customer API
        //  BaseTest.setUp("https://rekindle.example.com/api/customers");
    }

    @Test
    public void testGetCustomers() {
        given()
                .when()
                .get("/customers")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
}
