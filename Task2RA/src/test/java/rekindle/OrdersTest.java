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
 * OrdersTest class for testing orders-related endpoints
 */
public class OrdersTest extends BaseTest {


    @BeforeClass
    void setUpURI(){
        RestAssured.baseURI = ordersEndpoint;
    }

    @Test
    public void createOrders() {  // post 1
        String requestBody = """
            {
              "customerId": "d215b5f8-0249-4dc5-89a3-51fd148cfb41",
              "bookstoreId": "d215b5f8-0249-4dc5-89a3-51fd148cfb45",
              "price": 50.00,
              "items": [
              {
                    "productId": "d215b5f8-0249-4dc5-89a3-51fd148cfb48",
                    "quantity": 1,
                    "price": 50.00,
                    "subTotal": 50.00
                    }
              ],
            "address": {
            "street": "Some-street",
            "postalCode": "23-345",
            "city": "Milan"
          }
        }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .body(requestBody)
                .when()
                .post("/orders");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 201 Created expected

        // storing the retunr id from response
        createdPurchaseId = response.jsonPath().getString("ordersId");


        System.out.println("Created order ID: " + createdPurchaseId); // printed for debuging
    }

    @Test(dependsOnMethods = {"createOrders"})
    public void fetchOrdersById() { // get 1

        System.out.println(createdPurchaseId);
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get("/orders/" + "6ec2d031-e557-4e18-9cc8-6d5d5208fc02");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 200 OK expected
    }
}
