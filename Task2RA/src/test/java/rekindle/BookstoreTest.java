package rekindle;

import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/**
 * BookstoreTest demonstrates:
 * ✅ Inheritance – it extends BaseTest and inherits common setup (token, baseURI).
 * ✅ Code Reuse – test logic only focuses on the specific test scenario.
 */
public class BookstoreTest extends BaseTest {

    @Test
    public void fetchAllBookStores() {
        // ✅ Using inherited token and base URI from BaseTest
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
    public void fetchBookStoreById() {
        String bookstoreId = "d215b5f8-0249-4dc5-89a3-51fd148cfb45";

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/bookstores/" + bookstoreId); // Fetch specific bookstore by ID

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200); // 200 OK expected
    }

    @Test(dependsOnMethods = {"fetchAllBookStores"})
    public void createBookStore() {
        String requestBody = """
            {
                "name": "New Bookstore",
                "location": "123 Main Street",
                "owner": "John Doe",
                "isActive": true
            }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .when()
                .post("/bookstores"); // Post request to create a new bookstore

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 201); // 201 Created expected
    }
}
