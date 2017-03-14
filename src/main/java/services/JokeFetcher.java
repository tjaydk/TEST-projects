package services;

import entity.*;
import exception.InvalidTimezoneException;
import factories.IJokeFactory;
import factories.IJokeFetcher;
import factories.JokeFactory;
import factories.JokeType;
import util.DateFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class JokeFetcher {

    private IJokeFactory factory;

    public JokeFetcher(IJokeFactory factory) {
        this.factory = factory;
    }

    public Jokes getJokes(JokeType.type[] jokeTypes, String timeZone, List<Joke> jokeList) throws InvalidTimezoneException {

        Joke joke;

        for (IJokeFetcher fetcher : factory.getJokeFetchers(jokeTypes)) {
            jokeList.add(fetcher.retrieveJoke());
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa");
        DateFormatter dateFormatter = new DateFormatter(new Date(), simpleDateFormat);

        return new Jokes(jokeList, dateFormatter.getFormattedDate(timeZone));
    }

    public static void main(String[] args) throws InvalidTimezoneException {

        IJokeFactory jokeFactory = new JokeFactory();
        JokeFetcher jokeFetcher = new JokeFetcher(jokeFactory);
        JokeType.type[] jokeTypes = {JokeType.type.CHUCKNORRIS, JokeType.type.YOMAMMA};

        Jokes jokes = jokeFetcher.getJokes(jokeTypes, "Europe/Copenhagen", new ArrayList<>());
        String lol = "";

    }
}
