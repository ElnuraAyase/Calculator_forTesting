package rekindle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * CustomerTest class for testing customer-related endpoints
 */
public class PaymentsTest extends BaseTest {

    // Override setup for specific base URI for this test class
    @BeforeClass
    void setUpURI() {
        RestAssured.baseURI = paymentsEndpoint;

    }

    @Test()
    public void topUpBalance() {  // post 1
        String requestBody = """
                    {
                      "customerId": "d215b5f8-0249-4dc5-89a3-51fd148cfb41",
                      "totalPrice": 70
                    }
                """;

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .when()
                .post("/payments/credit"); // Post request to create a new bookstore

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 201); // 201 Created expected

        // storing the retunr id from response
        createdPaymentId = response.jsonPath().getString("creditEntryId");


        System.out.println("Created customer ID: " + createdPaymentId);
    }

    @Test
    public void getPaymentById() {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/payments/" + "6f483071-779b-46db-b4b9-174392e5bb80"); // get for payments order ID

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 201 Created expected

    }

    @Test
    public void getHisoryPaymentById() {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/payments/credit/history/" + "6f483071-779b-46db-b4b9-174392e5bb80"); // get for credit history info by customer ID

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 201 Created expected

    }
}