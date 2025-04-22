package rekindle;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * BaseTest provides shared setup for all test classes.
 */
public class BaseTest {

    protected String token = "eyJ0eXAiOiJKV1QiLCJub25jZSI6IkJXTEo2b0F3Tm1Vbk9pTFlDWWt5c18tU0dv..."; // (truncated for clarity)

    protected String bookstoreEndpoint = "http://localhost:8183/api/v1";
    protected String customerEndpoint = "http://localhost:8184/api/v1";
    protected String ordersEndpoint = "http://localhost:8181/api/v1";
    protected String paymentsEndpoint = "http://localhost:8182/api/v1";


    protected static  String createdBookstoreId;
    protected static  String createdCustomerId;
    protected static  String createdPurchaseId;
    protected static  String createdPaymentId;
}