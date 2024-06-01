import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static  org.hamcrest.Matchers.containsString;

@QuarkusTest
public class FilmRecourseTest {

    @Test
    public void test(){
        given()
                .when().get("/film/17")
                .then()
                .statusCode(200)
                .body(containsString("ALONE TRIP"));
    }

}
