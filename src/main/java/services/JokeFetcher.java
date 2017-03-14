package services;

import entity.*;
import exception.InvalidTimezoneException;
import util.DateFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class JokeFetcher {

    private enum JokeType {
        EDUPROG, CHUCKNORRIS, MAMMA, TAMBAL
    }

    public Jokes getJokes(JokeType[] jokeTypes, String timeZone) throws InvalidTimezoneException {

        List<Joke> jokeList = new ArrayList<>();
        Joke joke;

        for (JokeType type : jokeTypes) {
            switch (type) {
                case EDUPROG:
                    joke = new EduProgJoke();
                    jokeList.add(joke.retrieveJoke());
                    break;
                case CHUCKNORRIS:
                    joke = new ChuckNorrisJoke();
                    jokeList.add(joke.retrieveJoke());
                    break;
                case MAMMA:
                    joke = new YoMammaJoke();
                    jokeList.add(joke.retrieveJoke());
                    break;
                case TAMBAL:
                    joke = new TambalJoke();
                    jokeList.add(joke.retrieveJoke());
                    break;
            }
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa");
        DateFormatter dateFormatter = new DateFormatter(new Date(), simpleDateFormat);

        return new Jokes(jokeList, dateFormatter.getFormattedDate(timeZone));
    }

    public static void main(String[] args) {
        JokeType[] jokeTypes = {JokeType.EDUPROG, JokeType.MAMMA};

        JokeFetcher jokeFetcher = new JokeFetcher();
        try {
            Jokes jokes = jokeFetcher.getJokes(jokeTypes, "Europe/Copenhagen");
            String breakpoints = "";
        } catch (InvalidTimezoneException e) {
            e.printStackTrace();
        }
    }
}
