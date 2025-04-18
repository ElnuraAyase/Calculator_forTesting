package rekindle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * PaymentTest class for testing payment-related endpoints
 */
public class PaymentsTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        // Set up custom base URI for Payments API
      //  BaseTest.setUp("https://rekindle.example.com/api/payments");
    }

    @Test
    public void testGetPayments() {
        given()
                .when()
                .get("/payments")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
}
