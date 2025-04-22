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
public class CustomerTest extends BaseTest {

    // Override setup for specific base URI for this test class
    @BeforeClass
    void setUpURI(){
        RestAssured.baseURI = customerEndpoint;
    }




    @Test()
    public void createCustomers() {  // post 1
        String requestBody = """
            {
                "username": "77author",
                "firstName": "Mark",
                "lastName": "Twain"
            }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .body(requestBody)
                .when()
                .post("/customers"); // Post request to create a new bookstore

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 201); // 201 Created expected

        // storing the retunr id from response
        createdCustomerId = response.jsonPath().getString("customerId");


        System.out.println("Created customer ID: " + createdCustomerId); // printed for debuging
    }

    @Test
    public void fetchAllCustomers() {  // get all
        // Using inherited token and base URI from BaseTest
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/customers"); // Relative endpoint

        // Assert response status code
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(dependsOnMethods = {"createCustomers"})
    public void fetchCustomersById() { // get 1

        System.out.println(createdCustomerId);
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get("/customers/" + createdCustomerId); // Fetch specific bookstore by ID

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 200 OK expected
    }

    // PUT (update) customers by ID

    @Test(dependsOnMethods = {"createCustomers"})
    public void updateCustomers() {  // post 1
        String requestBody = """
            {
                "username": "77author",
                "firstName": "Mark",
                "lastName": "Twain"
            }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .body(requestBody)
                .when()
                .put("/customers/" + createdCustomerId); // Post request to create a new bookstore

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 204); // 201 Created expected

        // storing the retunr id from response


        System.out.println("updated customer ID: " + createdCustomerId); // printed for debuging
    }
    // delete customers

    @Test(dependsOnMethods = {"createCustomers", "updateCustomers"})
    public void deleteProductById() {  // delete product 10
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/customers/" + createdCustomerId);

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
