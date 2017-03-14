package entity;

import static com.jayway.restassured.RestAssured.given;

public class YoMammaJoke extends Joke {

    public YoMammaJoke() {

    }

    public YoMammaJoke(String joke, String reference) {
        super(joke, reference);
    }

    @Override
    public Joke retrieveJoke() {
        try {
            String joke = given().get("http://api.yomomma.info/").andReturn().jsonPath().getString("joke");
            return new YoMammaJoke(joke, "http://api.yomomma.info/");
        } catch (Exception e) {
            return null;
        }
    }
}
