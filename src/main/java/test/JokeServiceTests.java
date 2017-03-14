package test;

import entity.Joke;
import entity.Jokes;
import exception.InvalidTimezoneException;
import factories.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import services.JokeService;
import util.IDateFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JokeServiceTests {

    private JokeService jokeService;

    private JokeType[] jokeTypes;

    @Mock
    private IDateFormatter dateFormatter;
    @Mock
    private IFetcherFactory fetcherFactory;
    @Mock
    private JokeFetcherChuckNorris jokeFetcherChuckNorris;
    @Mock
    private JokeFetcherYoMamma jokeFetcherYoMamma;
    @Mock
    private JokeFetcherEduProg jokeFetcherEduProg;
    @Mock
    private JokeFetcherTambal jokeFetcherTambal;

    @Before
    public void setup() {
        List<IJokeFetcher> fetchers = Arrays.asList(jokeFetcherChuckNorris, jokeFetcherEduProg, jokeFetcherTambal, jokeFetcherYoMamma);
        jokeTypes = new JokeType[]{JokeType.CHUCKNORRIS, JokeType.EDUPROG, JokeType.TAMBAL, JokeType.YOMAMMA};
        when(fetcherFactory.getJokeFetchers(jokeTypes)).thenReturn(fetchers);
        jokeService = new JokeService(fetcherFactory, dateFormatter);
    }

    @Test
    public void testGetJokes() throws InvalidTimezoneException {

        // Given
        when(jokeFetcherChuckNorris.retrieveJoke())
                .thenReturn(new Joke("QWER", "1234"));
        when(jokeFetcherEduProg.retrieveJoke())
                .thenReturn(new Joke("ASDF", "4321"));
        when(jokeFetcherTambal.retrieveJoke())
                .thenReturn(new Joke("ZXCV", "3412"));
        when(jokeFetcherYoMamma.retrieveJoke())
                .thenReturn(new Joke("TYUI", "2341"));

        // Then
        Jokes jokes = jokeService.getJokes(jokeTypes, "Europe/Copenhagen", new ArrayList<>());

        assertThat(jokes.getJokes().get(0).getJoke(), is("QWER"));
        assertThat(jokes.getJokes().get(0).getReference(), is("1234"));
        assertThat(jokes.getJokes().get(1).getJoke(), is("ASDF"));
        assertThat(jokes.getJokes().get(1).getReference(), is("4321"));
        assertThat(jokes.getJokes().get(2).getJoke(), is("ZXCV"));
        assertThat(jokes.getJokes().get(2).getReference(), is("3412"));
        assertThat(jokes.getJokes().get(3).getJoke(), is("TYUI"));
        assertThat(jokes.getJokes().get(3).getReference(), is("2341"));

        verify(dateFormatter, times(1)).getFormattedDate("Europe/Copenhagen");
        verify(jokeFetcherChuckNorris, times(1)).retrieveJoke();
        verify(jokeFetcherEduProg, times(1)).retrieveJoke();
        verify(jokeFetcherTambal, times(1)).retrieveJoke();
        verify(jokeFetcherYoMamma, times(1)).retrieveJoke();
    }
}
