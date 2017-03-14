package factories;

import entity.Joke;

import static com.jayway.restassured.RestAssured.given;

public class YoMammaFetcher implements IJokeFetcher {

    @Override
    public Joke retrieveJoke() {
        try{
            String joke = given().get("http://api.yomomma.info/").andReturn().jsonPath().getString("joke");
            return new Joke(joke,"http://api.yomomma.info/");
        }catch(Exception e){
            return null;
        }
    }

}
