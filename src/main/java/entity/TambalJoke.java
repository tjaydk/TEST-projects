package entity;

import static com.jayway.restassured.RestAssured.given;

public class TambalJoke extends Joke {

    public TambalJoke() {

    }

    public TambalJoke(String joke, String reference) {
        super(joke, reference);
    }

    @Override
    public Joke retrieveJoke() {
        try {
            String joke = given().get("http://tambal.azurewebsites.net/joke/random").path("joke");
            return new TambalJoke(joke, "http://tambal.azurewebsites.net/joke/random");
        } catch (Exception e) {
            return null;
        }
    }
}
