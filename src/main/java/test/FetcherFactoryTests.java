package test;

import factories.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

@RunWith(MockitoJUnitRunner.class)
public class FetcherFactoryTests {

    @Mock
    EduProgFetcher eduProgFetcher;

    @Mock
    ChuckNorrisFetcher chuckNorrisFetcher;

    @Mock
    YoMammaFetcher yoMammaFetcher;

    @Mock
    TambalFetcher tambalFetcher;

    @Test
    public void testGetFetchers() {
        JokeType[] jokeTypes = {JokeType.EDUPROG, JokeType.TAMBAL, JokeType.CHUCKNORRIS, JokeType.YOMAMMA};

        IFetcherFactory fetcherFactory = new FetcherFactory();
        List<IJokeFetcher> jokeFetcherList = fetcherFactory.getJokeFetchers(jokeTypes);

        assertThat(jokeFetcherList.size(), is(4));
        assertThat(jokeFetcherList.get(0), instanceOf(EduProgFetcher.class));
        assertThat(jokeFetcherList.get(1), instanceOf(TambalFetcher.class));
        assertThat(jokeFetcherList.get(2), instanceOf(ChuckNorrisFetcher.class));
        assertThat(jokeFetcherList.get(3), instanceOf(YoMammaFetcher.class));
    }
}
