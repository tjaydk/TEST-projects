package factories;

import com.jayway.restassured.response.ExtractableResponse;
import entity.Joke;

import static com.jayway.restassured.RestAssured.given;

public class EduProgFetcher implements IJokeFetcher {

    @Override
    public Joke retrieveJoke() {
        try {
            ExtractableResponse res = given().get("http://jokes-plaul.rhcloud.com/api/joke").then().extract();
            String joke = res.path("joke");
            String reference = res.path("reference");
            return new Joke(joke, reference);
        } catch (Exception e) {
            return null;
        }
    }


}
