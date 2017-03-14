package services;

import entity.*;
import exception.InvalidTimezoneException;
import factories.IFetcherFactory;
import factories.IJokeFetcher;
import factories.FetcherFactory;
import factories.JokeType;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import util.DateFormatter;
import util.IDateFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class JokeService {

    private IFetcherFactory factory;
    private IDateFormatter dateFormatter;

    public JokeService(IFetcherFactory factory, IDateFormatter dateFormatter) {
        this.factory = factory;
        this.dateFormatter = dateFormatter;
    }

    public Jokes getJokes(JokeType[] jokeTypes, String timeZone, List<Joke> jokeList) throws InvalidTimezoneException {

        Joke joke;

        for (IJokeFetcher fetcher : factory.getJokeFetchers(jokeTypes)) {
            jokeList.add(fetcher.retrieveJoke());
        }

        return new Jokes(jokeList, dateFormatter.getFormattedDate(timeZone));
    }

    public static void main(String[] args) throws InvalidTimezoneException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa");
        DateFormatter dateFormatter = new DateFormatter(new Date(), simpleDateFormat);

        IFetcherFactory jokeFactory = new FetcherFactory();
        JokeService jokeService = new JokeService(jokeFactory, dateFormatter);
        JokeType[] jokeTypes = {JokeType.CHUCKNORRIS, JokeType.YOMAMMA, JokeType.EDUPROG, JokeType.TAMBAL};

        Jokes jokes = jokeService.getJokes(jokeTypes, "Europe/Copenhagen", new ArrayList<>());

        for (Joke joke : jokes.getJokes()) {
            System.out.println(joke.toString());
        }
    }
}
