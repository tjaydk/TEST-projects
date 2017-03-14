package entity;

import com.jayway.restassured.response.ExtractableResponse;

import static com.jayway.restassured.RestAssured.given;

public class EduProgJoke extends Joke {

    public EduProgJoke() {

    }

    public EduProgJoke(String joke, String reference) {
        super(joke, reference);
    }

    @Override
    public Joke retrieveJoke() {
        try {
            ExtractableResponse res = given().get("http://jokes-plaul.rhcloud.com/api/joke").then().extract();
            String joke = res.path("joke");
            String reference = res.path("reference");
            return new EduProgJoke(joke, reference);
        } catch (Exception e) {
            return null;
        }
    }
}
