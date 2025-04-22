package rekindle;

import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/**
 * BookstoreTest demonstrates:
 * Inheritance – it extends BaseTest and inherits common setup (token, baseURI).
 *  Code Reuse – test logic only focuses on the specific test scenario.
 */
public class BookstoreTest extends BaseTest {

    private static  String createdBookstoreId;  // added variable to hold ID for post put and delete

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

    @Test(dependsOnMethods = {"fetchAllBookStores"})
    public void createBookStore() {  // post 1
        String requestBody = """
            {
                "name": "New Bookstore",
                "location": "Prosta 3",
                "owner": "Theodore Dreiser",
                "isActive": true
            }
        """;

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
            Assert.assertEquals(response.getStatusCode(), 200); //checked


    }

    @Test(dependsOnMethods = {"updateBookStoreById"})
    public void deleteBookStoreId() { //delete 1

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .delete("/bookstores/" + createdBookstoreId);

        response.prettyPrint();
        Assert.assertTrue(
                response.getStatusCode() == 200 || response.getStatusCode() == 204
        );

    }
}
