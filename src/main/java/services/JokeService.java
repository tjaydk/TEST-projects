package services;

import entity.*;
import exception.InvalidTimezoneException;
import factories.IFetcherFactory;
import factories.IJokeFetcher;
import factories.FetcherFactory;
import factories.JokeType;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import util.DateFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class JokeService {

    private IFetcherFactory factory;

    public JokeService(IFetcherFactory factory) {
        this.factory = factory;
    }

    public Jokes getJokes(JokeType[] jokeTypes, String timeZone, List<Joke> jokeList) throws InvalidTimezoneException {

        Joke joke;

        for (IJokeFetcher fetcher : factory.getJokeFetchers(jokeTypes)) {
            jokeList.add(fetcher.retrieveJoke());
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa");
        DateFormatter dateFormatter = new DateFormatter(new Date(), simpleDateFormat);

        return new Jokes(jokeList, dateFormatter.getFormattedDate(timeZone));
    }

    public static void main(String[] args) throws InvalidTimezoneException {

        IFetcherFactory jokeFactory = new FetcherFactory();
        JokeService jokeService = new JokeService(jokeFactory);
        JokeType[] jokeTypes = {JokeType.CHUCKNORRIS, JokeType.YOMAMMA, JokeType.EDUPROG, JokeType.TAMBAL};

        Jokes jokes = jokeService.getJokes(jokeTypes, "Europe/Copenhagen", new ArrayList<>());

        for (Joke joke : jokes.getJokes()) {
            System.out.println(joke.toString());
        }
    }
}
