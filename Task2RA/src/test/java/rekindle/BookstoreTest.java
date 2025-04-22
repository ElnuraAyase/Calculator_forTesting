package rekindle;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/**
 * BookstoreTest demonstrates:
 * Inheritance – it extends BaseTest and inherits common setup (token, baseURI).
 *  Code Reuse – test logic only focuses on the specific test scenario.
 */
public class BookstoreTest extends BaseTest {

    @BeforeClass
    void setUpURI(){
        RestAssured.baseURI = bookstoreEndpoint;
    }


    @Test
    public void fetchAllBookStores() {  // get 3
        // Using inherited token and base URI from BaseTest
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token) // Token inherited from BaseTest
                .when()
                .get("/bookstores"); // Relative endpoint

        // Assert response status code
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 200 OK expected
    }

    @Test(dependsOnMethods = {"fetchAllBookStores"})
    public void fetchBookStoreById() { // get 1
        String bookstoreId = "d215b5f8-0249-4dc5-89a3-51fd148cfb45";  // static ID fpr t esting

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get("/bookstores/" + bookstoreId); // Fetch specific bookstore by ID

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 200 OK expected
    }

    @Test()
    public void createBookStore() {  // post 1
        String requestBody = """
            {
                "name": "New Bookstore",
                "location": "Prosta 3",
                "owner": "Theodore Dreiser",
                "isActive": true
            }
        """.formatted(createdBookstoreId); //ID is included in json body

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .body(requestBody)
                .when()
                .post("/bookstores"); // Post request to create a new bookstore

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 201); // 201 Created expected

        // storing the retunr id from response
        createdBookstoreId = response.getBody().asString().replaceAll("\"", "");  //reoving extra "" quots around  id


        System.out.println("Created bookstore ID: " + createdBookstoreId); // printed for debuging
    }

    @Test(dependsOnMethods = {"createBookStore"})
    public void updateBookStoreById(){ //  put 2

        // error was with this test, so need IF to check if the cretedBookstoreId is correct
        if (createdBookstoreId == null || createdBookstoreId.isEmpty()) {
            throw new RuntimeException("Created bookstore ID is null or empty! Please check createBookStore() method.");
        }
        String updatedBody = """
                {
                    "name": "Updated Bookstore Name",
                    "location": "Prosta 2",
                    "owner": "Maria Adam",
                    "isActive": false
                }
            """;
        // for debugging
        System.out.println("Updating bookstore with ID: " + createdBookstoreId); // checked
        System.out.println("Update Body: " + updatedBody); // checked


        Response response = given()
                    .contentType(ContentType.JSON)
                    .header("Authorization","Bearer " + token)
                    .body(updatedBody)
                    .when()
                    .put("/bookstores/" + createdBookstoreId);

            response.prettyPrint();
        Assert.assertTrue(
                 response.getStatusCode() == 204
        );
        // it was an error only with ==200 , so I added ==204

    }

    @Test(dependsOnMethods = {"updateBookStoreById", "deleteProductById"}) // can not delete product if the bookstore was deleted before , so  added "deleteProductId"
    public void deleteBookStoreId() { //delete 1

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .delete("/bookstores/" + createdBookstoreId);

        response.prettyPrint();
        Assert.assertTrue(
                response.getStatusCode() == 204
        );

    }


    private static String createdProductId;  // var to hold the ID for post,delete put
    // GET all products
    @Test
    public void fetchAllProducts() {  // get all products
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/bookstores/product"); // Fetching all products

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 200 OK expected
    }


    // POST a new product
    @Test(dependsOnMethods = {"createBookStore"})
    public void createProduct() {  // post - new product
        String requestBody = """
            {
                "name": "New Product",
                "category": "Books",
                "price": 19.99,
                "isActive": true,
                "available": true
            }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .when()
                .post("bookstores/"+ createdBookstoreId + "/product"); // POST for new product

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 201); // 201 Created expected

        // Save the returned product ID for future updates and deletions
        String rawId = response.asString();
        createdProductId = rawId.replace("\"", ""); // remove the surrounding quotes

        System.out.println(createdProductId);
    }


    // GET product by ID
    @Test(dependsOnMethods = {"fetchAllProducts"})
    public void fetchProductById() {  // get product by ID
        String productId = "d215b5f8-0249-4dc5-89a3-51fd148cfb47";  // Some product ID for testing

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("bookstores/product/" + productId); // Fetch spec product by ID

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 200 OK expected
    }

    //deleted the post from here to change

    // PUT (update) product by ID
    @Test(dependsOnMethods = {"createProduct"})
    public void updateProductById() {  // put (update) product
        String updatedProductBody = """
            {
                "name": "Updated Product Name",
                "price": 29.99,
                "available": true
            }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(updatedProductBody)
                .when()
                .put("/bookstores/product/" + createdProductId); // PUT - update the product by ID

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 204); // 200 OK expected
    }


    @Test(dependsOnMethods = {"createBookStore","createProduct", "updateProductById"})
    public void deleteProductById() {  // delete product 10
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/bookstores/" + createdBookstoreId + "/product/" + createdProductId); // DELETE

        response.prettyPrint();
        Assert.assertTrue(
                response.getStatusCode() == 204
        ); // 200 OK or 204 No Content expected
    }
}


