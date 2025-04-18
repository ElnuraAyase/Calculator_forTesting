package rekindle;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * BaseTest provides shared setup for all test classes.
 */
public class BaseTest {

    protected String token = "eyJ0eXAiOiJKV1QiLCJub25jZSI6IkJXTEo2b0F3Tm1Vbk9pTFlDWWt5c18tU0dv..."; // (truncated for clarity)

    @BeforeClass
    public void setUp() {
        // Optional: Set base URI here to avoid repeating in every request
        RestAssured.baseURI = "http://localhost:8183/api/v1";

        // Optional: Accept self-signed certs (for HTTPS localhost)
        RestAssured.useRelaxedHTTPSValidation();
    }
}
