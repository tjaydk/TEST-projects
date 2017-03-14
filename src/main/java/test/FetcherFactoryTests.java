package test;

import factories.*;
import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class FetcherFactoryTests {

    // I see no reason to mock anything here.

    @Test
    public void testGetFetcherList() {
        JokeType[] jokeTypes = {JokeType.EDUPROG, JokeType.TAMBAL, JokeType.CHUCKNORRIS, JokeType.YOMAMMA};

        IFetcherFactory fetcherFactory = new FetcherFactory();
        List<IJokeFetcher> jokeFetcherList = fetcherFactory.getJokeFetchers(jokeTypes);

        assertThat(jokeFetcherList.size(), is(4));
        assertThat(jokeFetcherList.get(0), instanceOf(JokeFetcherEduProg.class));
        assertThat(jokeFetcherList.get(1), instanceOf(JokeFetcherTambal.class));
        assertThat(jokeFetcherList.get(2), instanceOf(JokeFetcherChuckNorris.class));
        assertThat(jokeFetcherList.get(3), instanceOf(JokeFetcherYoMamma.class));
    }
}
