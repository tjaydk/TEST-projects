package entity;

import static com.jayway.restassured.RestAssured.given;

public class ChuckNorrisJoke extends Joke{

    public ChuckNorrisJoke() {

    }

    public ChuckNorrisJoke(String joke, String reference) {
        super(joke, reference);
    }

    @Override
    public Joke retrieveJoke() {
        try {
            String joke = given().get("http://api.icndb.com/jokes/random").path("value.joke");
            return new ChuckNorrisJoke(joke, "http://api.icndb.com/");
        } catch (Exception e) {
            return null;
        }
    }
}
