package rekindle;

import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class ProductTest extends BaseTest {

    private static String createdProductId;  // var to hold the ID for post,delete put
    // GET all products
    @Test
    public void fetchAllProducts() {  // get all products
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/products"); // Fetching all products

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 200 OK expected
    }

    // GET product by ID
    @Test(dependsOnMethods = {"fetchAllProducts"})
    public void fetchProductById() {  // get product by ID
        String productId = "12345";  // Some product ID for testing

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/products/" + productId); // Fetch spec product by ID

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 200 OK expected
    }

    // POST a new product
    @Test(dependsOnMethods = {"fetchAllProducts"})
    public void createProduct() {  // post - new product
        String requestBody = """
            {
                "name": "New Product",
                "category": "Books",
                "price": 19.99,
                "isActive": true
            }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .when()
                .post("/products"); // POST for new product

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 201); // 201 Created expected

        // Save the returned product ID for future updates and deletions
        createdProductId = response.jsonPath().getString("id");  // Storin the product ID
    }

    // PUT (update) product by ID
    @Test(dependsOnMethods = {"createProduct"})
    public void updateProductById() {  // put (update) product
        String updatedProductBody = """
            {
                "name": "Updated Product Name",
                "category": "Books",
                "price": 29.99,
                "isActive": false
            }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(updatedProductBody)
                .when()
                .put("/products/" + createdProductId); // PUT - update the product by ID

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 200 OK expected
    }


    @Test(dependsOnMethods = {"updateProductById"})
    public void deleteProductById() {  // delete product 10
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/products/" + createdProductId); // DELETE

        response.prettyPrint();
        Assert.assertTrue(
                response.getStatusCode() == 200 || response.getStatusCode() == 204
        ); // 200 OK or 204 No Content expected
    }
}
